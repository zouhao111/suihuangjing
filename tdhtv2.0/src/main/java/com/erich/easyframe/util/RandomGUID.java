package com.erich.easyframe.util;

public class RandomGUID extends Object {

	private static long[] ls = new long[3000];
	private static int li = 0;

	public synchronized static long getPK() {
		long lo = getpk();
		for (int i = 0; i < 3000; i++) {
			long lt = ls[i];
			if (lt == lo) {
				lo = getPK();
				break;
			}
		}
		ls[li] = lo;
		li++;
		if (li == 3000) {
			li = 0;
		}
		return lo;
	}

	private static long getpk() {
		String a = (String.valueOf(System.currentTimeMillis())).substring(3, 13);
		String d = (String.valueOf(Math.random())).substring(2, 8);
		return Long.parseLong(a + d);
	}

	public static void main(String args[]) {

		Thread t = new Thread();

		t.run();

		for (int i = 0; i < 100; i++) {
			System.out.println(getpk());
		}
	}
}
