package com.bnp.test;

import java.util.ArrayList;
import java.util.List;

public class StreamApp {

	static List<String> funcionarios = new ArrayList<>();
	
	public static void main(String[] args) {
		funcionarios.add("Antonio");
		funcionarios.add("Jose");
		funcionarios.add("Pedro");
		funcionarios.add("Joao");
		funcionarios.add("Andre");
		
		filtrar("A");
		System.out.println(count("A"));
		ordernar("A");
	}
	
	public static void filtrar(String letra){
		funcionarios.parallelStream().filter(s -> s.contains(letra)).forEach(System.out::println);
	}
	
	public static long count(String letra){
		return funcionarios.parallelStream().sorted().filter(s -> s.startsWith(letra)).count();
	}
	
	public static void ordernar(String letra){
		funcionarios.parallelStream().sorted().filter(s -> s.startsWith(letra)).forEach(System.out::println);
	}
}
