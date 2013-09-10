package chapter8;

import Utils.P;

public class BucketSort {

	public static class Bucket {
		double data;
		Bucket next;

		public Bucket(double data, Bucket next) {
			this.data = data;
			this.next = next;
		}
	}

	public static void insert(Bucket[] b, double d, int pos) {
		Bucket p = b[pos];
		Bucket pre = null;
		while (p != null && p.data < d) {
			pre = p;
			p = p.next;
		}
		Bucket newBucket = new Bucket(d, p);
		if (pre == null) {
			b[pos] = newBucket;
		} else {
			pre.next = newBucket;
		}
	}

	public static void bucketSort(double[] a) {
		int n = a.length;
		Bucket[] b = new Bucket[n];
		for (int i = n - 1; i >= 0; i--) {
			int pos = (int) Math.floor(a[i] * n);
			insert(b, a[i], pos);
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (Bucket p = b[i]; p != null; p = p.next) {
				a[count++] = p.data;
			}
		}
	}

	public static void main(String[] args) {
		double[] a = new double[] { 0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21,
				0.12, 0.23, 0.68 };
		bucketSort(a);
		P.rint(a);
	}
}
