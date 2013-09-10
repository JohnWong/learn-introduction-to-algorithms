package chapter8;

import Utils.P;

public class CountingSort {

	public static int[] countingSort(int[] a, int k) {
		int[] b = new int[a.length];
		int[] c = new int[k];
		for (int i = 0; i < k; i++)
			c[i] = 0;
		for (int j = 0; j < a.length; j++)
			c[a[j]]++;
		P.rint(c);
		for (int i = 1; i < k; i++) {
			c[i] += c[i - 1];
		}
		P.rint(c);
		for (int j = a.length - 1; j >= 0; j--) {
			b[c[a[j]] - 1] = a[j];
			c[a[j]]--;
		}
		return b;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4, 9, 12, 3, 5, 3 };
		P.rint(countingSort(a, 30));
	}
}
