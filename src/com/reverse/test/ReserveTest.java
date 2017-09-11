package com.reverse.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.StreamSupport;

public class ReserveTest {

	private static final String WORD = "Hello";

	public static void main(String[] args) {
		//System.out.println(new StringBuilder(WORD).reverse().toString()); // via
																			// StringBuilder
		//System.out.println(new StringBuffer(WORD).reverse().toString()); // via
																			// StringBuffer
		//System.out.println(reverse(WORD)); // via Iterative mode
		//System.out.println(recursionReverse(WORD)); // via recursive Mode
		System.out.println(reverseUsingLambda(WORD)); // via recursive Mode
	}

	public static String reverse(String input) {
		char[] in = input.toCharArray();
		int begin = 0;
		int end = in.length - 1;
		char temp;
		while (end > begin) {
			temp = in[begin];
			in[begin] = in[end];
			in[end] = temp;
			end--;
			begin++;
		}
		return new String(in);
	}

	public static String recursionReverse(String stringToReverse, int... index) {
		if (index.length == 0) {
			index = new int[] { stringToReverse.length() - 1 };
		}

		if (index[0] == 0) {
			return stringToReverse.charAt(0) + "";
		}

		char letter = stringToReverse.charAt(index[0]);
		return letter + recursionReverse(stringToReverse, index[0] - 1);
	}

	public static String reverseUsingLambda(String stringToReverse) {
		String result="";
		Character[] charObjectArray = stringToReverse.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
		Arrays.asList(charObjectArray).stream().sorted(Comparator.reverseOrder()).forEach(x -> {
			 System.out.print(x);
		});
		
		return result;
		
	}
}
