package chapter6;

import java.util.ArrayList;
import java.util.List;

import Utils.P;

public class PrimaryQueue {
	public static void swap(List<Integer> a, int i, int j) {
		int t = a.get(i);
		a.set(i, a.get(j));
		a.set(j, t);
	}

	public static int left(int i) {
		return i * 2 + 1;
	}

	public static int right(int i) {
		return i * 2 + 2;
	}

	public static int parent(int i) {
		if (i == 0)
			return -1;
		return (i - 1) / 2;
	}

	public static void maxHeapify(List<Integer> a, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l < a.size() && a.get(l) > a.get(largest))
			largest = l;
		if (r < a.size() && a.get(r) > a.get(largest))
			largest = r;
		if (largest != i) {
			swap(a, i, largest);
			maxHeapify(a, largest);
		}
	}

	public static void insert(List<Integer> a, int x) {
		a.add(Integer.MIN_VALUE);
		increaseKey(a, a.size() - 1, x);
	}

	public static void adjust(List<Integer> a, int i) {
		int t = a.get(i);
		int j = i;
		int p = parent(i);
		while (p >= 0 && a.get(p) < t) {
			a.set(j, a.get(p));
			j = p;
			p = parent(p);
		}
		a.set(j, t);
	}

	public static void increaseKey(List<Integer> a, int i, int key) {
		if (key < a.get(i))
			throw new AssertionError();
		a.set(i, key);
		adjust(a, i);
	}

	public static int maximum(int[] a) {
		return a[0];
	}

	public static int extractMax(List<Integer> a) {
		if (a.size() < 1)
			throw new AssertionError();
		int max = a.get(0);
		a.set(0, a.remove(a.size() - 1));
		maxHeapify(a, 0);
		return max;
	}

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		insert(a, 1);
		P.rintTree(a);
		insert(a, 4);
		P.rintTree(a);
		insert(a, 10);
		insert(a, 14);
		insert(a, 17);
		insert(a, 9);
		insert(a, 23);
		insert(a, 2);
		insert(a, 8);
		insert(a, 13);
		increaseKey(a, 5, 25);
		P.rintTree(a);
	}
}
