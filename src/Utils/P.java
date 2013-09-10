package Utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class P {
	public static void rint(Object o) {
		if (o.getClass().isArray()) {
			int length = Array.getLength(o);
			System.out.print("[");
			for (int i = 0; i < length; i++) {
				if (i != 0)
					System.out.print(", ");
				System.out.print(Array.get(o, i));
			}
			System.out.println("]");
		} else
			System.out.println(o);
	}

	public static void rint(Object... os) {
		System.out.println(Arrays.deepToString(os));
	}

	public static void rintln() {
		System.out.println();
	}

	public static String space(int count) {
		StringBuilder sb = new StringBuilder();
		while (count-- > 0)
			sb.append("    ");
		return sb.toString();
	}

	public static int normalize(int l) {
		int normal = l;
		if ((normal & normal - 1) > 0) {
			normal = 1;
			for (int i = l; i > 0; i >>= 1)
				normal <<= 1;
		}
		return normal;
	}

	public static void rintTree(int[] a) {
		for (int i = normalize(a.length + 1), c = 0; i > 0; i /= 2, c = c * 2 + 1) {
			StringBuilder dataString = new StringBuilder(space(i / 2 - 1));
			for (int j = c; j < a.length && j < c * 2 + 1; j++) {
				if (j != c)
					dataString.append(space(i - 1));
				dataString.append(String.format("%4d", a[j]));
			}
			P.rint(dataString.toString());
		}
	}

	public static void rintTree(Integer[] a) {
		int[] d = new int[a.length];
		for (int i = 0; i < a.length; i++)
			d[i] = a[i];
		P.rintTree(d);
	}
	
	public static void rintTree(List<Integer> a) {
		int[] d = new int[a.size()];
		for (int i = 0; i < a.size(); i++)
			d[i] = a.get(i);
		P.rintTree(d);
	}

	public static void main(String[] args) {
		int[] a = new int[8];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		P.rintTree(a);
	}
}
