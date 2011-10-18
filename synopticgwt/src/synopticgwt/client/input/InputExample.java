package synopticgwt.client.input;

public enum  InputExample {
	SHOPPINGCART (
			"ShoppingCart",
            "74.15.155.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n13.15.232.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n13.15.232.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n74.15.155.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n74.15.155.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n74.15.155.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n74.15.155.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n13.15.232.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n74.15.155.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n13.15.232.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n13.15.232.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n74.15.155.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n4.15.155.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n3.15.232.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n3.15.232.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n4.15.155.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n4.15.155.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n4.15.155.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n4.15.155.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n3.15.232.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n4.15.155.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n3.15.232.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n3.15.232.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n4.15.155.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n4.5.155.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n3.5.232.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n3.5.232.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n4.5.155.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n4.5.155.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n4.5.155.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n4.5.155.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n3.5.232.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n4.5.155.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n3.5.232.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n3.5.232.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n4.5.155.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n74.5.155.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n13.5.232.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n13.5.232.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n74.5.155.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n74.5.155.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n74.5.155.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n74.5.155.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n13.5.232.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n74.5.155.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n13.5.232.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n13.5.232.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n74.5.155.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n74.15.55.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n13.15.32.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n13.15.32.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n74.15.55.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n74.15.55.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n74.15.55.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n74.15.55.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n13.15.32.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n74.15.55.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n13.15.32.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n13.15.32.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n74.15.55.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n74.15.155.3 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n13.15.232.1 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n13.15.232.1 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n74.15.155.3 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n74.15.155.9 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n74.15.155.3 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n74.15.155.9 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n13.15.232.1 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n74.15.155.3 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n13.15.232.1 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n13.15.232.1 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n74.15.155.3 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n4.15.55.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n3.15.32.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n3.15.32.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n4.15.55.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n4.15.55.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n4.15.55.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n4.15.55.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n3.15.32.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n4.15.55.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n3.15.32.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n3.15.32.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n4.15.55.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n4.15.155.3 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n3.15.232.1 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n3.15.232.1 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n4.15.155.3 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n4.15.155.9 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n4.15.155.3 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n4.15.155.9 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n3.15.232.1 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n4.15.155.3 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n3.15.232.1 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n3.15.232.1 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n4.15.155.3 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n4.15.55.3 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n3.15.32.1 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n3.15.32.1 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n4.15.55.3 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n4.15.55.9 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n4.15.55.3 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n4.15.55.9 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n3.15.32.1 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n4.15.55.3 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n3.15.32.1 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n3.15.32.1 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n4.15.55.3 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n74.155.155.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n13.155.232.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n13.155.232.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n74.155.155.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n74.155.155.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n74.155.155.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n74.155.155.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n13.155.232.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n74.155.155.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n13.155.232.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n13.155.232.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n74.155.155.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n74.156.155.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n13.156.232.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n13.156.232.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n74.156.155.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n74.156.155.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n74.156.155.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n74.156.155.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n13.156.232.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n74.156.155.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n13.156.232.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n13.156.232.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n74.156.155.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n74.154155.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n13.154232.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n13.154232.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n74.154155.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n74.154155.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n74.154155.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n74.154155.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n13.154232.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n74.154155.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n13.154232.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n13.154232.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n74.154155.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n74.14.155.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n13.14.232.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n13.14.232.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n74.14.155.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n74.14.155.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n74.14.155.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n74.14.155.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n13.14.232.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n74.14.155.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n13.14.232.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n13.14.232.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n74.14.155.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n74.13.155.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n13.13.232.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n13.13.232.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n74.13.155.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n74.13.155.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n74.13.155.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n74.13.155.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n13.13.232.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n74.13.155.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n13.13.232.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n13.13.232.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n74.13.155.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n74.167.155.103 [06/Jan/2011:07:24:13] \"GET HTTP/1.1 /check-out.php\"\n13.167.232.201 [06/Jan/2011:07:24:19] \"GET HTTP/1.1 /check-out.php\"\n13.167.232.201 [06/Jan/2011:07:25:33] \"GET HTTP/1.1 /invalid-coupon.php\"\n74.167.155.103 [06/Jan/2011:07:27:05] \"GET HTTP/1.1 /valid-coupon.php\"\n74.167.155.199 [06/Jan/2011:07:28:43] \"GET HTTP/1.1 /check-out.php\"\n74.167.155.103 [06/Jan/2011:07:28:14] \"GET HTTP/1.1 /reduce-price.php\"\n74.167.155.199 [06/Jan/2011:07:29:02] \"GET HTTP/1.1 /get-credit-card.php\"\n13.167.232.201 [06/Jan/2011:07:30:22] \"GET HTTP/1.1 /reduce-price.php\"\n74.167.155.103 [06/Jan/2011:07:30:55] \"GET HTTP/1.1 /check-out.php\"\n13.167.232.201 [06/Jan/2011:07:31:17] \"GET HTTP/1.1 /check-out.php\"\n13.167.232.201 [06/Jan/2011:07:31:20] \"GET HTTP/1.1 /get-credit-card.php\"\n74.167.155.103 [06/Jan/2011:07:31:44] \"GET HTTP/1.1 /get-credit-card.php\"\n\n",
            "(?<ip>) .+ \"GET HTTP/1.1 /(?<TYPE>.+).php\"",
            "\\k<ip>", ""),
	
	TWOPHASECOMMIT (
			"TwoPhaseCommit",
            "TM, 0, tx_prepare, 0\nTM, 1, tx_prepare, 0\nTM, 2, tx_prepare, 0\n0, TM, commit, 0\n1, TM, abort, 0\n2, TM, commit, 0\nTM, 0, tx_abort, 0\nTM, 1, tx_abort, 0\nTM, 2, tx_abort, 0\nTM, 0, tx_prepare, 1\nTM, 1, tx_prepare, 1\nTM, 2, tx_prepare, 1\n0, TM, commit, 1\n1, TM, commit, 1\n2, TM, commit, 1\nTM, 0, tx_commit, 1\nTM, 1, tx_commit, 1\nTM, 2, tx_commit, 1\nTM, 0, tx_prepare, 2\nTM, 1, tx_prepare, 2\nTM, 2, tx_prepare, 2\n0, TM, commit, 2\n1, TM, commit, 2\n2, TM, commit, 2\nTM, 0, tx_commit, 2\nTM, 1, tx_commit, 2\nTM, 2, tx_commit, 2\nTM, 0, tx_prepare, 3\nTM, 1, tx_prepare, 3\nTM, 2, tx_prepare, 3\n0, TM, commit, 3\n1, TM, abort, 3\n2, TM, commit, 3\nTM, 0, tx_abort, 3\nTM, 1, tx_abort, 3\nTM, 2, tx_abort, 3\nTM, 0, tx_prepare, 4\nTM, 1, tx_prepare, 4\nTM, 2, tx_prepare, 4\n0, TM, commit, 4\n1, TM, abort, 4\n2, TM, commit, 4\nTM, 0, tx_abort, 4\nTM, 1, tx_abort, 4\nTM, 2, tx_abort, 4\n",
            "^(?<sender>),(?<receiver>),(?<TYPE>),(?<txId>)",
            "\\k<txId>", ""),
    
    ABSTRACT (
    		"abstract",
			"1 0 c\n2 0 b\n3 0 a\n4 0 d\n1 1 f\n2 1 b\n3 1 a\n4 1 e\n1 2 f\n2 2 b\n3 2 a\n4 2 d",
            "^(?<TIME>)(?<nodename>)(?<TYPE>)$", "\\k<nodename>",
            ""),
	
	TICKETRESERVATION (
			"TicketReservation",
            "1,0,0 client-0 search\n0,1,0 client-1 search\n1,0,1 server available\n1,1,2 server available\n2,0,1 client-0 buy\n2,1,3 server sold\n1,2,2 client-1 buy\n2,2,4 server sold-out\n--\n0,1,0 client-1 search\n1,0,0 client-0 search\n0,1,1 server available\n1,1,2 server available\n0,2,1 client-1 buy\n1,2,3 server sold\n2,1,2 client-0 buy\n2,2,4 server sold-out\n--\n1,0,0 client-0 search\n1,0,1 server available\n0,1,0 client-1 search\n1,1,2 server available\n1,2,2 client-1 buy\n1,2,3 server sold\n2,0,1 client-0 buy\n2,2,4 server sold-out\n--\n1,0,0 client-0 search\n1,0,1 server available\n0,1,0 client-1 search\n1,1,2 server available\n--\n1,0,0 client-0 search\n1,0,1 server available\n2,0,1 client-0 buy\n2,0,2 server sold\n0,1,0 client-1 search\n2,1,3 server sold-out",
            "(?<VTIME>)(?<PID>)(?<TYPE>.+)", "", "^--$");
           
    private String name;
    private String logText;
    private String regExpText;
    private String partitionRegExpText;
    private String separatorRegExpText;

    InputExample(String name, String logText, String regExpText,
            String partitionRegExpText, String separatorRegExpText) {
        this.name = name;
        this.logText = logText;
        this.regExpText = regExpText;
        this.partitionRegExpText = partitionRegExpText;
        this.separatorRegExpText = separatorRegExpText;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getLogText() {
    	return logText;
    }
    
    public String getRegExpText() {
    	return regExpText;
    }
    
    public String getPartitionRegExpText() {
    	return partitionRegExpText;
    }
    
    public String getSeparatorRegExpText() {
    	return separatorRegExpText;
    }
}
