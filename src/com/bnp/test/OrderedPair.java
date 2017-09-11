package com.bnp.test;

public class OrderedPair<K,V> implements Pair<K, V> {

	private K key;
	private V value;
	
	
	public OrderedPair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public V getValue() {
		return this.value;
	}
	
	@Override
	public String toString(){
		return String.format("Key: %s, Value: %s", this.key, this.value);
	}
	
	public static void main(String[] args) {
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
		Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
		
		System.out.println("p1 [" + p1.toString() + "]");
		System.out.println("p2 [" + p2.toString() + "]");
	}

}
