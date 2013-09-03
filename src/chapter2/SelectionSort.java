/*
 * 选择排序
 */
package chapter2;

import Utils.P;

public class SelectionSort {

	public static void selectionSort(int[] d) {
		for (int i = 0; i < d.length - 1; i++) {
			int tag = i;
			for (int j = tag + 1; j < d.length; j++) {
				if (d[j] < d[tag])
					tag = j;
			}
			// do swap
			int t = d[tag];
			d[tag] = d[i];
			d[i] = t;
		}
	}

	public static void main(String[] args) {
		int[] data = { 1, 4, 6, 2, 3 };
		selectionSort(data);
		P.rint(data);
	}
}
// [1, 2, 3, 4, 6]