package cpt4;

import Utils.P;

public class Ex1s4 {

	static int[] maxCrossingSubArray(int[] d, int low, int mid, int high) {
		int leftSum = 0;
		int sum = 0;
		int maxLeft = 0;
		for (int i = mid - 1; i >= low; i--) {
			sum = sum + d[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		int rightSum = 0;
		sum = 0;
		int maxRight = 0;
		for (int j = mid; j < high; j++) {
			sum = sum + d[j];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		return new int[] { maxLeft, maxRight, leftSum + rightSum };
	}

	public static int[] maxSubarray(int[] d, int low, int high) {
		if (high - 1 == low)
			return new int[] { low, high, d[low] };
		int mid = (low + high) / 2;
		int[] result = maxSubarray(d, low, mid);
		int leftLow = result[0], leftHigh = result[1], leftSum = result[2];
		result = maxSubarray(d, mid, high);
		int rightLow = result[0], rightHigh = result[1], rightSum = result[2];
		result = maxCrossingSubArray(d, low, mid, high);
		int crossLow = result[0], crossHigh = result[1], crossSum = result[2];

		if (leftSum >= rightSum && leftSum >= crossSum)
			return new int[] { leftLow, leftHigh, leftSum };
		else if (rightSum > leftSum && rightSum > crossSum)
			return new int[] { rightLow, rightHigh, rightSum };
		else
			return new int[] { crossLow, crossHigh, crossSum };
	}

	public static int maxSubarray(int[] d) {
		return maxSubarray(d, 0, d.length)[2];
	}

	public static void main(String[] args) {
		int[] d = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15,
				-4, 7 };
		d = new int[]{-22, -1, -3, -11};
		P.rint(maxSubarray(d));
	}
}
