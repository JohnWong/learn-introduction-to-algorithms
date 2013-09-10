package chapter9;

import Utils.P;

public class RandomizedSelect {

	public static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static int randomizedPartition(int[] a, int p, int r) {
		int x = a[r];
		int i = p;
		for (int j = p; j <= r; j++) {
			if (a[j] < x) {
				swap(a, i, j);
				i++;
			}
		}
		swap(a, i, r);
		return i;
	}

	public static int randomizedSelect(int[] a, int p, int r, int i) {
		if (p == r)
			return a[p];
		int q = randomizedPartition(a, p, r);
		int k = q - p + 1;
		if (k == i)
			return a[q];
		if (k < i)
			return randomizedSelect(a, p, q, i);
		else
			return randomizedSelect(a, q + 1, r, i - k);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 16, 9, 1, 3, 8, 12, 6 };
		P.rint(randomizedSelect(a, 0, a.length - 1, 3));
	}
}
