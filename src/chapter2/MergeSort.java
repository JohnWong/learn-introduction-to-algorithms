/*
 * 归并排序
 */
package chapter2;

import java.util.Arrays;

import Utils.P;

public class MergeSort {

	public static void merge(int[] d, int p, int q, int r) {
		int[] a = Arrays.copyOfRange(d, p, q);
		int[] b = Arrays.copyOfRange(d, q, r);
		for(int i=p,ia=0,ib=0; i<r; i++)
			if(ia >= a.length || ib < b.length && a[ia] > b[ib])
				d[i] = b[ib++];
			else
				d[i] = a[ia++];
	}
	
	public static void mergeSort(int[] d){
		mergeSort(d, 0, d.length);
	}
	
	public static void mergeSort(int[] d, int p, int r){
		if(r-p < 2)
			return;
		int q = (p + r)/2;
		mergeSort(d, p, q);
		mergeSort(d, q, r);
		merge(d, p, q, r);
	}

	public static void main(String[] args) {
		int[] d = { 6, 7, 10, 1, 4, 5};
		mergeSort(d);
		P.rint(d);
	}
}
// [1, 4, 5, 6, 7, 10]