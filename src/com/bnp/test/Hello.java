package com.bnp.test;

public class Hello {

	static {
		System.out.println("Hello");
	}

	// OR 
	
	public static int value = printHello();

	public static int printHello() {
		System.out.println("Hello");
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("Main started");
	}
}
