package com.bnp.test;

@FunctionalInterface
public interface IMath<T extends Number> {
	T operacao( T a, T b);
	
	default Double operarDouble(T a, T b){
		return a.doubleValue() + b.doubleValue() ;
	}
	
	default Integer operarInt(T a, T b){
		return a.intValue() + b.intValue() ;
	}
	
	default Long operarLong(T a, T b){
		return a.longValue() + b.longValue() ;
	}
}
