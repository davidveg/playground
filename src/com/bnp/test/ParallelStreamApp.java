package com.bnp.test;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamApp {

	static List<Integer> list = new ArrayList<>();
	final static Integer max = 1_000_000;
	
	static Long ordernaStram(){
		Long t0 = System.currentTimeMillis();
		list.stream().sorted();
		Long t1 = System.currentTimeMillis();
		return t1-t0;
	};
	
	static Long ordernaPrallelStream(){
		Long t0 = System.currentTimeMillis();
		list.parallelStream().sorted();
		Long t1 = System.currentTimeMillis();
		return t1-t0 ;
	};
	
	public static void main(String[] args) {
		for(int i = 0 ; i <= max; i++ ){
			list.add(i);
		}
		
		System.out.println(ordernaStram());
		System.out.println(ordernaPrallelStream());
	}
}
