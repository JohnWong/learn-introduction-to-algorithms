package cpt2;

import Utils.P;

public class Ex1s2 {

	public static void insertSort(int[] d) {
		for (int i = 1; i < d.length; i++) {
			int x = d[i];
			int j;
			for (j = i - 1; j >= 0 && d[j] < x; j--) {
				d[j + 1] = d[j];
			}
			d[j + 1] = x;
		}
	}

	public static void main(String[] args) {
		int[] data = { 1, 4, 6, 2, 3 };
		insertSort(data);
		P.rint(data);
	}
}
