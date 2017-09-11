package com.tests.sumup;

public class PrintSemForOuWhile {

	private static void print(int a, int b) {
		System.out.println(a);
		a++;
		if(a <= b) 
			print(a, b);
		
	}
	

	public static void main(String[] args) {
		print(1,100);
	}
}
