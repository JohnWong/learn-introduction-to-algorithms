/*
 * 算法使用前提是数组中有正负数都存在
 */
package cpt4;

import Utils.P;

public class Ex1s5 {

	/**
	 * find max subarray in O(n)
	 * @param array
	 * @return max < 0 means all are negative. max = 0 means all are zero.
	 */
	public static int[] maxSubarray(int[] d) {
		int max = Integer.MIN_VALUE;
		int start = 0, end = 0, tempStart = 0;
		int count = 0;
		for (int i = 0; i < d.length; i++) {
			count += d[i];
			if (count < 0) {
				count = 0;
				tempStart = i + 1;
			} else if (count > max) {
				max = count;
				start = tempStart;
				end = i;
			}
		}
		return new int[] { start, end, max };
	}

	public static void main(String[] args) {
		int[] d = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15,
				-4, 7 };
		P.rintln(maxSubarray(d));
	}
}
