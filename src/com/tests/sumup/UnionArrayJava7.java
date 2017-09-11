package com.tests.sumup;

import java.util.HashSet;
import java.util.Set;

public class UnionArrayJava7 {

	static Integer[] concat(int[]... arrays) {
		int length = 0;
		for (int[] array : arrays) {
			length += array.length;
		}
		int[] result = new int[length];
		int pos = 0;
		for (int[] array : arrays) {
			for (int element : array) {
				result[pos] = element;

				pos++;
			}
		}
		result = sort(result);
		Integer[] result1 = removeDuplicates(result);
		return result1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 1, 1, 4, 4, 9, 3 };
		int[] b = new int[] { 1, 4, 4, 4, 1, 2, 5, 3 };
		Integer[] c = concat(a, b);
		StringBuffer sb = new StringBuffer();
		for (int i : c) {
			sb.append(i).append(", ");
		}
		System.out.println(sb.substring(0, sb.length() - 2).toString());
	}

	public static int[] sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}

	public static Integer[] removeDuplicates(int[] a) {
		// remove duplicate elements logic
		Set<Integer> set = new HashSet<Integer>();
		for (int i : a) {
			set.add(i);
		}
		return set.toArray(new Integer[set.size()]);
	}
}
