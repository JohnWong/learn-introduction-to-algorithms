package chapter2;

import Utils.P;

public class BubbleSort {

	public static void bubbleSort(int[] d){
		for(int i=1; i<d.length; i++){
			for(int j=i; j<d.length; j++){
				int k = j-1;
				if(d[k] > d[j]){
					int t = d[k];
					d[k] = d[j];
					d[j] = t;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] d = {1, 8, 2, 3, 7, 6, 9};
		bubbleSort(d);
		P.rint(d);
	}
}
