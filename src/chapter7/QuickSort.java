package chapter7;

import java.util.Random;

import Utils.P;

public class QuickSort {

	public static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static int partition(int[] a, int p, int r) {
		int x = a[r];
		int i = p;
		for (int j = p; j < r; j++) {
			if (a[j] <= x) {
				swap(a, i, j);
				i++;
			}
		}
		swap(a, i, r);
		return i;
	}

	public static void quickSort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}

	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	public static int randomizedPartition(int[] a, int p, int r) {
		int i = new Random().nextInt(r - p + 1) + p;
		swap(a, p, i);
		return partition(a, p, r);
	}

	public static void randomizedQuicksort(int[] a, int p, int r) {
		if (p < r) {
			int q = randomizedPartition(a, p, r);
			randomizedQuicksort(a, p, q - 1);
			randomizedQuicksort(a, q + 1, r);
		}
	}

	public static void randomizedQuicksort(int[] a) {
		randomizedQuicksort(a, 0, a.length - 1);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 8, 4, 1, 14, 12 };
		P.rint(a);
		randomizedQuicksort(a);
		P.rint(a);
	}
}
