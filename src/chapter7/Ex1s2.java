package chapter7;

import Utils.P;

public class Ex1s2 {

	public static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static int partition(int[] a, int p, int r) {
		int x = a[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j] <= x && j % 2 == 1) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i + 1, r);
		return i + 1;
	}

	public static void quickSort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			P.rint(q);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}

	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
		quickSort(a);
	}
}
