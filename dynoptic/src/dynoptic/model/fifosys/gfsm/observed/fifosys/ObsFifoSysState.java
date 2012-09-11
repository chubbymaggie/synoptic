package dynoptic.model.fifosys.gfsm.observed.fifosys;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dynoptic.main.DynopticMain;
import dynoptic.model.fifosys.AbsMultiFSMState;
import dynoptic.model.fifosys.channel.channelstate.ImmutableMultiChState;
import dynoptic.model.fifosys.gfsm.GFSMState;
import dynoptic.model.fifosys.gfsm.observed.ObsMultFSMState;

import synoptic.model.channelid.ChannelId;
import synoptic.model.event.DistEventType;
import synoptic.model.event.Event;

/**
 * <p>
 * Represents an instantaneous state that is predicted by partially-ordered
 * event observation from an input log for an execution of a FIFO system. Note
 * that because the execution is possibly concurrent, there are multiple
 * possible _next_ ObservedFifoSysState instances to this state. That is, the
 * observed state is a cross product of states, and we can have as many states
 * possible as the number of events observed following each of the individual
 * FSM states that comprise this ObservedFifoSysState.
 * </p>
 * <p>
 * Also, note that the queue state (channelStates) are often implicit -- we do
 * not have a record of the actual channel states, but we can reconstruct the
 * channel states based on the sequence of send/receive operations.
 * </p>
 */
public class ObsFifoSysState extends AbsMultiFSMState<ObsFifoSysState> {

    // A global cache of previously created ObsFifoSysState instances. This is
    // an optimization to forego duplicating identical fifo states that might be
    // created because of different interleavings of concurrent events.
    private static final Map<ObsMultFSMState, ObsFifoSysState> fifoSysStatesMap;

    static {
        fifoSysStatesMap = new LinkedHashMap<ObsMultFSMState, ObsFifoSysState>();
    }

    /**
     * Returns a cached ObservedFifoSysState instance, if one was previously
     * created with the given FSM states. Otherwise, returns a new instance and
     * caches it. When looking up an existing FIFO state, the channelStates
     * argument is only used to check that the returned instance has the
     * expected channel state (channel state is determined by the local states
     * of the processes).
     * 
     * @param nextFsmStates
     * @param nextChannelStates
     * @return
     */
    public static ObsFifoSysState getFifoSysState(ObsMultFSMState fsmStates,
            ImmutableMultiChState channelStates) {
        assert fsmStates != null;
        assert channelStates != null;

        ObsFifoSysState ret;
        if (fifoSysStatesMap.containsKey(fsmStates)) {
            ret = fifoSysStatesMap.get(fsmStates);
            assert ret.getChannelStates().equals(channelStates);
        } else {
            ret = new ObsFifoSysState(fsmStates, channelStates);
            fifoSysStatesMap.put(fsmStates, ret);
        }
        return ret;
    }

    // //////////////////////////////////////////////////////////////////

    // The "partition" that this observed fifo state belongs to.
    private GFSMState parent;

    // Observed FSM states.
    private final ObsMultFSMState fsmStates;

    // The observed state of all the channels in the system.
    private final ImmutableMultiChState channelStates;

    // Potentially observed transitions for each following event type.
    private final Map<DistEventType, ObsFifoSysState> transitions;

    // List of observed event instances -- there is a one-to-one correspondence
    // between event observed txn Event and a key in the transitions map.
    private final Set<Event> observedTxns;

    private ObsFifoSysState(ObsMultFSMState fsmStates,
            ImmutableMultiChState channelStates) {
        super(fsmStates.getNumProcesses());

        if (DynopticMain.assertsOn) {
            // Make sure that channelStates only reference pids that are less
            // than fsmStates.size().
            for (ChannelId chId : channelStates.getChannelIds()) {
                assert chId.getSrcPid() >= 0
                        && chId.getSrcPid() < fsmStates.getNumProcesses();
                assert chId.getDstPid() >= 0
                        && chId.getDstPid() < fsmStates.getNumProcesses();
            }

            // Since these are observed states, by definition, if we are in all
            // accepting states, then the queues must be empty.
            if (fsmStates.isAccept()) {
                assert channelStates.isEmpty();
            }
        }

        this.fsmStates = fsmStates;
        this.channelStates = channelStates;
        this.transitions = new LinkedHashMap<DistEventType, ObsFifoSysState>();
        this.observedTxns = new LinkedHashSet<Event>();
    }

    // //////////////////////////////////////////////////////////////////

    @Override
    public boolean isAccept() {
        // NOTE: the assumption that we make here is that a terminal state is
        // an instance of the abstract accepting state. This assumption does not
        // hold if we our traces are lossy.
        return fsmStates.isAccept() && channelStates.isEmpty();
    }

    @Override
    public boolean isAcceptForPid(int pid) {
        assert pid >= 0 && pid < fsmStates.getNumProcesses();
        return fsmStates.isAcceptForPid(pid)
                && channelStates.isEmptyForPid(pid);
    }

    @Override
    public Set<DistEventType> getTransitioningEvents() {
        return transitions.keySet();
    }

    @Override
    public Set<ObsFifoSysState> getNextStates(DistEventType event) {
        return Collections.singleton(transitions.get(event));
    }

    @Override
    public String toString() {
        return fsmStates.toString() + "; " + channelStates.toString();
    }

    @Override
    public boolean isInitForPid(int pid) {
        return fsmStates.isInitForPid(pid) && channelStates.isEmptyForPid(pid);
    }

    @Override
    public boolean isInitial() {
        return fsmStates.isInitial() && channelStates.isEmpty();
    }

    // //////////////////////////////////////////////////////////////////

    public ObsFifoSysState getNextState(DistEventType event) {
        return transitions.get(event);
    }

    public void addTransition(Event e, ObsFifoSysState s) {
        assert !this.transitions.containsKey(e);

        if (DynopticMain.assertsOn) {
            // Make sure that the following states belongs to the same "system",
            // which is identified by number of processes and the channelIds.
            assert channelStates.getChannelIds().equals(getChannelIds());
            assert s.getNumProcesses() == getNumProcesses();
        }

        assert (e.getEType() instanceof DistEventType);
        observedTxns.add(e);
        this.transitions.put((DistEventType) e.getEType(), s);
    }

    public GFSMState getParent() {
        return parent;
    }

    public void setParent(GFSMState newParent) {
        parent = newParent;
    }

    public int getNumProcesses() {
        return super.getNumProcesses();
    }

    public List<ChannelId> getChannelIds() {
        return channelStates.getChannelIds();
    }

    public ImmutableMultiChState getChannelStates() {
        return channelStates;
    }

}