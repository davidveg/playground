package com.bnp.test;

public class OddNumbers {

	public static void main(String[] args) {
		int num = 100;
		int i = 1;
		while (i < num) {
		   if (i%2!=0) {
		      System.out.println(i);
		   }
		   i++;
		}
	}
}
