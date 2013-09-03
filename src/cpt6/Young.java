package cpt6;

import Utils.P;

public class Young {
	public static void swap(int[][] a, int i0, int j0, int i1, int j1) {
		int t = a[i0][j0];
		a[i0][j0] = a[i1][j1];
		a[i1][j1] = t;
	}

	private static int extractMin(int[][] a) {
		int ret = a[0][0];
		int x, y;
		for (x = 1; x < a.length && a[x][0] < Integer.MAX_VALUE; x++)
			;
		x--;
		for (y = 1; y < a[0].length && a[x][y] < Integer.MAX_VALUE; y++)
			;
		y--;
		a[0][0] = a[x][y];
		a[x][y] = Integer.MAX_VALUE;
		// adjust Young matrix
		x = 0;
		y = 0;
		int maxX = 0, maxY = 0;
		while (true) {
			maxX = x;
			maxY = y;
			if (x + 1 < a.length && a[x + 1][y] < Integer.MAX_VALUE
					&& a[x + 1][y] < a[maxX][maxY]) {
				maxX = x + 1;
			}
			if (y + 1 < a[0].length && a[x][y + 1] < Integer.MAX_VALUE
					&& a[x][y + 1] < a[maxX][maxY]) {
				maxX = x;
				maxY = y + 1;
			}
			if (maxX == x && maxY == y) {
				break;
			}
			swap(a, x, y, maxX, maxY);
			x = maxX;
			y = maxY;
		}
		return ret;
	}

	private static int extractMin2(int[][] a, int x, int y) {
		int ret = a[x][y];
		boolean ver = false;
		boolean hor = false;
		if (x + 1 < a.length && a[x + 1][y] < Integer.MAX_VALUE)
			hor = true;
		if (y + 1 < a[0].length && a[x][y + 1] < Integer.MAX_VALUE)
			ver = true;
		int isHoriental = 0;
		if (hor && ver) {
			if (a[x][y + 1] < a[x + 1][y])
				isHoriental = 1;
			else
				isHoriental = 2;
		} else {
			if (hor)
				isHoriental = 1;
			else if (ver)
				isHoriental = 2;
		}
		if (isHoriental == 1) {
			a[x][y] = extractMin2(a, x, y + 1);
		} else if (isHoriental == 2) {
			a[x][y] = extractMin2(a, x + 1, y);
		} else {
			a[x][y] = Integer.MAX_VALUE;
		}
		return ret;
	}

	public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		int[][] a = new int[][] { { 2, 3, 8, 9 }, { 4, 5, 16, max },
				{ 11, 12, max, max } };
		P.rint(a);
		P.rintln(extractMin2(a, 0, 0));
		P.rint(a);
	}
}
