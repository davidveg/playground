package com.bnp.test;

public class IMathUse {

	
	public static void main(String[] args) {
		IMathUse ex = new IMathUse();
		IMath<Integer> soma = (a,b) -> a + b;
		IMath<Integer> divisao = (a,b) -> a / b;
		IMath<Integer> multiplicacao = (a,b) -> a * b;
		IMath<Integer> subtracao = (a,b) -> a - b;
		IMath<Double> expo = (a,b) -> Math.pow(a,b);
		IMath<Double> radix = (a,b) -> Math.pow(a, 1/b);
		
		System.out.println(ex.executaOperacao(10, 2, soma));
		System.out.println(ex.executaOperacaoDefaultDouble(10, 2, soma));
		System.out.println(ex.executaOperacaoDefaultInt(10, 2, soma));
		System.out.println(ex.executaOperacaoDefaultLong(10, 2, soma));
		System.out.println(ex.executaOperacao(10, 2, divisao));
		System.out.println(ex.executaOperacao(10, 2, multiplicacao));
		System.out.println(ex.executaOperacao(10, 2, subtracao));
		System.out.println(ex.executaOperacao(10D, 2D, expo));
		System.out.println(ex.executaOperacao(10D, 2D, radix));
		
	}
	
	public <T extends Number> Number executaOperacao(T a, T b, IMath<T> operacao){
		return operacao.operacao(a, b);
	}
	
	public <T extends Number> Number executaOperacaoDefaultDouble(T a, T b, IMath<T> operacao){
		return operacao.operarDouble(a, b);
	}
	
	public <T extends Number> Number executaOperacaoDefaultInt(T a, T b, IMath<T> operacao){
		return operacao.operarInt(a, b);
	}
	
	public <T extends Number> Number executaOperacaoDefaultLong(T a, T b, IMath<T> operacao){
		return operacao.operarLong(a, b);
	}
}
