package com.tests.sumup;

import java.util.Arrays;
import java.util.stream.IntStream;

public class UnionArrayJava8 {

	public static void main(String... s) {
		int[] a = new int[] { 1, 1, 1, 4, 4, 9, 3 };
		int[] b = new int[] { 1, 4, 4, 4, 1, 2, 5, 3 };
		int[] both = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
		StringBuffer sb = new StringBuffer();
		for (int i : both) {
			sb.append(i).append(", ");
		}
		System.out.println(sb.substring(0, sb.length() - 2).toString());
	}

}
