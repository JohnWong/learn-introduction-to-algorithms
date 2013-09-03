package cpt6;

import Utils.P;

public class Ex2s5 {
	public static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static int left(int i) {
		return i * 2 + 1;
	}

	public static int right(int i) {
		return i * 2 + 2;
	}

	public static void maxHeapify(int[] a, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l < a.length && a[l] > a[largest])
			largest = l;
		if (r < a.length && a[r] > a[largest])
			largest = r;
		if (largest != i) {
			swap(a, i, largest);
			maxHeapify(a, largest);
		}
	}

	public static void maxHeapifyLoop(int[] a, int i) {
		while (i < a.length / 2) {
			int l = left(i);
			int r = right(i);
			int largest = i;
			if (l < a.length && a[l] > a[largest])
				largest = l;
			if (r < a.length && a[r] > a[largest])
				largest = r;
			if (largest != i) {
				swap(a, i, largest);
				i = largest;
			} else {
				i = a.length;
			}
		}
	}

	public static void buildMaxHeap(int[] a) {
		for (int i = a.length / 2 - 1; i >= 0; i--) {
			maxHeapifyLoop(a, i);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 4, 10, 14, 17, 9, 23, 2, 8, 13 };
		P.rintTree(a);
		buildMaxHeap(a);
		P.rintTree(a);
	}
}
