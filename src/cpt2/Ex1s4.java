package cpt2;

import Utils.P;

public class Ex1s4 {

	public static int[] add(int[] a, int[] b) {
		int[] c = new int[a.length];
		int flag = 0;
		for(int i=a.length - 1; i>=0; i--){
			int t = a[i] + b[i] + flag;
			flag = t / 2;
			c[i] = t % 2;
		}
		return c;
	}

	public static void main(String[] args) {
		int[] a = { 1, 0, 1, 1, 0 };
		int[] b = { 0, 0, 1, 1, 1 };
		
		P.rint(add(a, b));
	}
}
