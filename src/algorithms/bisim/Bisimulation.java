/** Implementation of the main algorithms */

package algorithms.bisim;

import invariants.TemporalInvariant;
import invariants.TemporalInvariantSet;
import invariants.TemporalInvariantSet.RelationPath;

import java.util.*;

import algorithms.graph.Operation;
import algorithms.graph.PartitionMerge;
import algorithms.graph.PartitionMultiSplit;
import algorithms.graph.PartitionSplit;
import algorithms.ktail.StateUtil;

import model.MessageEvent;
import model.Partition;
import model.PartitionGraph;
import model.export.GraphVizExporter;
import model.interfaces.IGraph;
import model.interfaces.ITransition;

/**
 * This class implements the algorithm BisimH ({@code
 * Bisimulation.refinePartitions}), and a modified version of the algorithm
 * kTail ({@code Bisimulation.mergePartitions}) that considers state labels
 * instead of state transitions.
 * 
 * It is based on the code from Clemens Hammacher's implementation of a
 * partition refinement algorithm for bisimulation minimization. Source:
 * https://ccs.hammacher.name Licence: Eclipse Public License v1.0.
 */
public abstract class Bisimulation {
	/**
	 * Essential status output
	 */
	private static final boolean ESSENTIAL = true;
	/**
	 * Set output to verbose
	 */
	private static boolean VERBOSE = false;
	/**
	 * Export a graph in every round
	 */
	private static boolean DEBUG = false;
	/**
	 * Consider incoming edges for splitting
	 */
	private static boolean incommingEdgeSplit = true;
	/**
	 * Coarsen the representation after each successful split (i.e. each split
	 * that caused a previously unsatisfied invariant to become satisfied. This
	 * may or may not speed up operation.
	 */
	private static boolean interleavedMerging = false;
	/**
	 * Number of steps done in refinePartitionsSmart
	 */
	public static int steps;
	/**
	 * Number of merges done in coarsenPartitions
	 */
	public static int merge;

	private Bisimulation() throws InstantiationException {
		throw new InstantiationException(this.getClass().getCanonicalName()
				+ " is supposed to be used as static class only.");
	}

	/**
	 * Construct a partition graph from {@code graph} (by partitioning by
	 * label), call refine partitions on it, and return the refined graph.
	 * 
	 * @param graph
	 *            the graph from which should be used as initial graph
	 * @return
	 * @throws InterruptedException
	 */
	public static PartitionGraph computePartitions(IGraph<MessageEvent> graph)
			throws InterruptedException {
		PartitionGraph g = new PartitionGraph(graph, true);
		refinePartitions(g);
		return g;
	}

	/**
	 * Refines the partitions in {@code partitionGraph} until all invariants
	 * returned by {@code partitionGraph.getInvariants()} are satisfied.
	 * 
	 * @param partitionGraph
	 *            - the partition graph to refine
	 */
	public static void refinePartitions(PartitionGraph partitionGraph) {
		int outer = 1;
		if (DEBUG) {
			GraphVizExporter.quickExport("output/rounds/0.dot", partitionGraph);
		}
		steps = 0;
		// These invariants will be satisfied
		TemporalInvariantSet invariants = partitionGraph.getInvariants();

		Set<TemporalInvariant> unsatisfiedInvariants = new LinkedHashSet<TemporalInvariant>();
		unsatisfiedInvariants.addAll(partitionGraph.getInvariants().getSet());
		Set<TemporalInvariant> satisfiedInvariants = new LinkedHashSet<TemporalInvariant>();

		List<RelationPath<Partition>> counterexampleTraces = null;
		while (unsatisfiedInvariants.size() > 0) {
			/**
			 * Stores all splits that cause an invariant to be satisfied,
			 * indexed by partition to which they are applied.
			 */
			LinkedHashMap<Partition, PartitionMultiSplit> splitsToDoByPartition = new LinkedHashMap<Partition, PartitionMultiSplit>();
			/**
			 * Stores all invariants for which we have a split that satisfies
			 * it.
			 */
			ArrayList<TemporalInvariant> newlySatisfiedInvariants = new ArrayList<TemporalInvariant>();

			// retrieve the counterexamples.
			counterexampleTraces = new TemporalInvariantSet(
					unsatisfiedInvariants).getViolations(partitionGraph);

			// if we have no counterexamples, we are done
			if (counterexampleTraces == null
					|| counterexampleTraces.size() == 0) {
				if (VERBOSE)
					System.out.println("Invariants statisfied. Stopping.");
				break;
			} else if (ESSENTIAL) {
				System.out.println("" + counterexampleTraces.size()
						+ " unsatisfied invariants: " + counterexampleTraces);
			}
			// Update the sets with satisfied and unsatisfied invariants.
			unsatisfiedInvariants.clear();
			for (RelationPath<Partition> relPath : counterexampleTraces) {
				unsatisfiedInvariants.add(relPath.invariant);
			}
			satisfiedInvariants.clear();
			satisfiedInvariants.addAll(partitionGraph.getInvariants().getSet());
			satisfiedInvariants.removeAll(unsatisfiedInvariants);

			/**
			 * Stores the first valid split. This split will be performed if no
			 * other split (that would resolve an invariant) is available.
			 */
			PartitionSplit arbitrarySplit = null;
			for (RelationPath<Partition> counterexampleTrace : counterexampleTraces) {
				// Get the possible splits to resolve this invariant.
				List<PartitionSplit> candidateSplits = getSplits(
						counterexampleTrace, partitionGraph);
				for (PartitionSplit candidateSplit : candidateSplits) {
					// See if the split is valid
					if (candidateSplit == null || !candidateSplit.isValid()) {
						if (VERBOSE)
							System.out.println("  -- invalid: "
									+ candidateSplit);
						continue;
					}
					// store away an arbitrary split
					if (arbitrarySplit == null)
						arbitrarySplit = candidateSplit;
					// Perform the split
					Operation rewindOperation = partitionGraph
							.apply(candidateSplit);
					if (DEBUG) {
						GraphVizExporter.quickExport("output/rounds/" + outer
								+ ".dot", partitionGraph);
					}

					// see if splitting resolved the violation
					RelationPath<Partition> violation = invariants
							.getViolation(counterexampleTrace.invariant,
									partitionGraph);

					// if the invariant has no further violation, we made
					// progress, so the split as marked as useful.
					if (violation == null) {
						// If we already have a split for that partition, we
						// incorporate the new split into it
						if (splitsToDoByPartition.containsKey(candidateSplit
								.getPartition())) {
							splitsToDoByPartition.get(
									candidateSplit.getPartition()).incorporate(
									candidateSplit);
						} else
							splitsToDoByPartition.put(candidateSplit
									.getPartition(), new PartitionMultiSplit(
									candidateSplit));
						// Remember that we resolved this invariant violation
						newlySatisfiedInvariants
								.add(counterexampleTrace.invariant);
					}

					// rewind for now
					partitionGraph.apply(rewindOperation);
				}
			}
			if (splitsToDoByPartition.size() == 0) {
				// we have no splits that make progress. See if we have an arbitrary split.
				if (arbitrarySplit == null)
					continue;
				partitionGraph.apply(arbitrarySplit);
				if (ESSENTIAL)
					System.out.println("1 arbitrary split, "
							+ partitionGraph.getNodes().size()
							+ " nodes in graph.");
			} else {
				// we have splits to do, perform them
				for (PartitionMultiSplit currentSplit : splitsToDoByPartition
						.values()) {
					partitionGraph.apply(currentSplit);
				}
				// update invariants
				satisfiedInvariants.addAll(newlySatisfiedInvariants);
				unsatisfiedInvariants.removeAll(newlySatisfiedInvariants);

				// handle interleaved merging
				if (interleavedMerging) {
					if (VERBOSE)
						System.out.println("recompressing...");
					Bisimulation.mergePartitions(partitionGraph,
							new TemporalInvariantSet(satisfiedInvariants));
				}
				if (ESSENTIAL)
					System.out.println(newlySatisfiedInvariants.size()
							+ " splits done, "
							+ partitionGraph.getNodes().size()
							+ " nodes in graph, "

							+ unsatisfiedInvariants.size()
							+ " unsatisfiedInvariants left.");
			}
			outer++;
		}

		if (DEBUG) {
			GraphVizExporter.quickExport("output/rounds/" + outer
					+ "-final.dot", partitionGraph);
		}
	}

	/**
	 * Compute possible splits to remove the path relPath from partitionGraph.
	 * This is done by following relPath in the original graph and determining
	 * the point where partitionGraph allows a transition it should not allow.
	 * The original graph is accessed via the Messages (which are nodes in the
	 * original graph) in the partitions.
	 * 
	 * @param relPath
	 *            - the path to remove
	 * @param partitionGraph
	 *            - the graph from which the path shall be removed
	 * @return a list of partition splits that remove relPath
	 */
	private static List<PartitionSplit> getSplits(
			RelationPath<Partition> relPath, PartitionGraph partitionGraph) {
		List<PartitionSplit> ret = new ArrayList<PartitionSplit>();
		Set<MessageEvent> hot = new HashSet<MessageEvent>();
		hot.addAll(relPath.path.get(0).getMessages());
		Partition prevPartition = null;
		Partition nextPartition = null;
		Partition curPartition = null;
		if (VERBOSE)
			System.out.println(relPath.path);
		for (Partition part : relPath.path) {
			if (part == null)
				throw new RuntimeException("relation path contained null");
			prevPartition = curPartition;
			curPartition = nextPartition;
			nextPartition = part;
			hot.retainAll(part.getMessages());
			if (hot.size() == 0)
				break;
			Set<MessageEvent> successors = new HashSet<MessageEvent>();
			for (MessageEvent m : hot)
				successors.addAll(m.getSuccessors(relPath.invariant
						.getRelation()));
			hot = successors;
		}
		ITransition<Partition> partTrans = curPartition.getTransition(
				nextPartition, relPath.invariant.getRelation());
		ITransition<Partition> partTrans2 = null;
		if (prevPartition != null)
			partTrans2 = prevPartition.getTransition(curPartition,
					relPath.invariant.getRelation());
		if (partTrans != null) {
			if (VERBOSE)
				System.out.println(partTrans);
			ret.add(curPartition.getCandidateDivision(partTrans));
		}
		if (partTrans2 != null && incommingEdgeSplit) {
			if (VERBOSE)
				System.out.println(partTrans2);
			ret.add(curPartition.getCandidateDivisionReach(prevPartition,
					partTrans2));
		}
		return ret;
	}

	/**
	 * Construct a partition graph from {@code graph} (by partitioning by
	 * label), call {@code refinePartitions} on it, and return the refined
	 * graph.
	 * 
	 * @param graph
	 *            the graph from which should be used as initial graph
	 * @return the refined graph
	 * @throws InterruptedException
	 */
	public static PartitionGraph getRefinedGraph(IGraph<MessageEvent> graph)
			throws InterruptedException {
		PartitionGraph g = new PartitionGraph(graph, true);
		refinePartitions(g);
		return g;
	}

	/**
	 * Construct a partition graph from {@code graph} (by partitioning by
	 * label), call {@code mergePartitions} on it, and return the refined graph.
	 * 
	 * @param graph
	 *            the graph from which should be used as initial graph
	 * @return the merged graph
	 * @throws InterruptedException
	 */
	public static PartitionGraph getMergedGraph(IGraph<MessageEvent> graph) {
		PartitionGraph g = new PartitionGraph(graph);
		mergePartitions(g);
		return null;
	}

	/**
	 * Works as {@code mergePartitions} but fixes invariants to {@code
	 * partitionGraph.getInvariants()}
	 * 
	 * @param partitionGraph
	 */
	public static void mergePartitions(PartitionGraph partitionGraph) {
		TemporalInvariantSet invariants = partitionGraph.getInvariants();
		mergePartitions(partitionGraph, invariants);
	}

	/**
	 * Works as {@code mergePartitions} but fixes k to 0.
	 * 
	 * @param partitionGraph
	 * @param invariants
	 */
	public static void mergePartitions(PartitionGraph partitionGraph,
			TemporalInvariantSet invariants) {
		mergePartitions(partitionGraph, invariants, 0);
	}

	/**
	 * Merge partitions if they are {@code k} equal, while maintaining {@code
	 * invariants}
	 * 
	 * @param partitionGraph
	 *            the graph to coarsen
	 * @param invariants
	 *            - the invariants to maintain, can be null
	 * @param k
	 *            - the k parameter for k-equality
	 */
	public static void mergePartitions(PartitionGraph partitionGraph,
			TemporalInvariantSet invariants, int k) {
		int outer = 0;
		merge = 0;
		HashMap<Partition, HashSet<Partition>> blacklist = new HashMap<Partition, HashSet<Partition>>();
		out: while (true) {
			if (ESSENTIAL)
				System.out.println("m " + partitionGraph.getNodes().size());
			if (DEBUG) {
				GraphVizExporter.quickExport(
						"output/rounds/m" + outer + ".dot", partitionGraph);
			}
			boolean progress = false;
			ArrayList<Partition> partitions = new ArrayList<Partition>();
			partitions.addAll(partitionGraph.getPartitions());
			for (Partition p : partitions) {
				for (Partition q : partitions) {
					if (p != q && StateUtil.kEquals(p, q, k, false)) {
						if ((blacklist.containsKey(p) && blacklist.get(p)
								.contains(q))
								|| (blacklist.containsKey(q) && blacklist
										.get(q).contains(p)))
							continue;
						// if (partitionGraph.getInitialNodes().contains(p) !=
						// partitionGraph
						// .getInitialNodes().contains(q))
						// continue;
						if (VERBOSE)
							System.out.println("merge " + p + " with " + q);
						Set<Partition> parts = new HashSet<Partition>();
						parts.addAll(partitionGraph.getNodes());
						Operation rewindOperation = partitionGraph
								.apply(new PartitionMerge(p, q));
						merge++;
						List<RelationPath<Partition>> vio = null;
						// partitionGraph.checkSanity();
						// if (true)
						// continue out;
						if (invariants != null)
							vio = invariants.getViolations(partitionGraph);

						if (invariants != null && vio != null && vio.size() > 0) {

							if (VERBOSE)
								System.out.println("  REWIND");
							if (!blacklist.containsKey(p))
								blacklist.put(p, new HashSet<Partition>());
							blacklist.get(p).add(q);
							partitionGraph.apply(rewindOperation);
							partitionGraph.checkSanity();
							if (!parts.containsAll(partitionGraph.getNodes())
									|| !partitionGraph.getNodes().containsAll(
											parts))
								throw new RuntimeException(
										"partition set changed due to rewind: "
												+ rewindOperation);
							// if (!invariants.check(partitionGraph)) {
							// throw new RuntimeException("could not rewind");
							// }
						} else {
							progress = true;
							continue out;
						}
					}
				}
			}
			if (!progress)
				break;
			outer++;
		}
		if (DEBUG) {
			GraphVizExporter.quickExport("output/rounds/m" + outer
					+ "-final.dot", partitionGraph);
		}
	}

	/**
	 * Wrapper to mergePartitions without invariant preservation.
	 * 
	 * @param partitionGraph
	 *            the graph to reduce (merge {@code k}-equivalent partitions)
	 * @param k
	 *            parameter for equality
	 */
	public static void kReduce(PartitionGraph partitionGraph, int k) {
		mergePartitions(partitionGraph, null, k);
	}
}
