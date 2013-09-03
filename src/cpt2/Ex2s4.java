/*
 * 归并排序
 */
package cpt2;

import java.util.Arrays;

import Utils.P;

public class Ex2s4 {

	public static int merge(int[] d, int p, int q, int r) {
		int[] a = Arrays.copyOfRange(d, p, q);
		int[] b = Arrays.copyOfRange(d, q, r);
		int count = 0;
		for (int i = p, ia = 0, ib = 0; i < r; i++)
			if (ia >= a.length || ib < b.length && a[ia] > b[ib]) {
				d[i] = b[ib++];
				count++;
			} else
				d[i] = a[ia++];
		return count;
	}

	public static int mergeSort(int[] d) {
		return mergeSort(d, 0, d.length);
	}

	public static int mergeSort(int[] d, int p, int r) {
		if (r - p < 2)
			return 0;
		int q = (p + r) / 2;
		int count = 0;
		count += mergeSort(d, p, q);
		count += mergeSort(d, q, r);
		count += merge(d, p, q, r);
		return count;
	}

	public static void main(String[] args) {
		int[] d = { 6, 7, 10, 1, 4, 5 };
		P.rint(mergeSort(d));
	}
}
// [1, 4, 5, 6, 7, 10]