package chapter6;

import Utils.P;

public class HeapSort {
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

	public static void maxHeapify(int[] a, int i, int size) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l < size && a[l] > a[largest])
			largest = l;
		if (r < size && a[r] > a[largest])
			largest = r;
		if (largest != i) {
			swap(a, i, largest);
			maxHeapify(a, largest, size);
		}
	}

	public static void buildMaxHeap(int[] a) {
		for (int i = a.length / 2 - 1; i >= 0; i--) {
			maxHeapify(a, i, a.length);
		}
	}

	public static void heapSort(int[] a) {
		buildMaxHeap(a);
		int size = a.length;
		for (int i = size - 1; i > 0; i--) {
			swap(a, 0, i);
			size--;
			maxHeapify(a, 0, size);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 4, 10, 14, 17, 9, 23, 2, 8, 13 };
		P.rintTree(a);
		heapSort(a);
		P.rintTree(a);
		a = new int[]{1, 2, 3,4,5,6,7};
		buildMaxHeap(a);
		P.rintTree(a);
	}
}
