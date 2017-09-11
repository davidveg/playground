package com.bnp.test;

public class SingletonInstance {

	private static SingletonInstance instance = null;

	private SingletonInstance() {
	}

	public synchronized static SingletonInstance getInstance() {
		if (instance == null) {
			synchronized (SingletonInstance.class) { // Thread Safe
				instance = new SingletonInstance();
			}

		}
		return instance;
	}

	public static void main(String[] args) {
		SingletonInstance s = SingletonInstance.getInstance();
		System.out.println(s.toString());
		SingletonInstance b = SingletonInstance.getInstance();
		System.out.println(b.toString());

	}

}
