/*
 * 算法使用前提是数组中有正负数都存在
 */
package cpt4;

import Utils.P;

public class Ex1s3 {

	public static int maxSubarrayBrute(int[] d) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < d.length; i++) {
			int sum = 0;
			for (int j = i; j < d.length; j++) {
				sum += d[j];
				if (sum > max)
					max = sum;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] d = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15,
				-4, 7 };
		P.rintln(maxSubarrayBrute(d));
	}
}
