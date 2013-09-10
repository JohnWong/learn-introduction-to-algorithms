package chapter7;

import Utils.P;

public class QuickSortOth {

	public static int partition(int[] a, int p, int r) {
		int t = a[p];
		while (p < r) {
			while (a[r] > t && p < r)
				r--;
			if (p < r)
				a[p++] = a[r];
			while (a[p] < t && p < r)
				p++;
			if (p < r)
				a[r--] = a[p];
		}
		a[p] = t;
		return p;
	}

	public static void quickSort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}
	
	public static void quickSort(int[] a){
		quickSort(a, 0, a.length-1);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 8, 4, 1, 14, 12 };
		P.rint(a);
		quickSort(a);
		P.rint(a);
	}
}
