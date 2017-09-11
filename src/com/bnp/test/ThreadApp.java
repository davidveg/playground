package com.bnp.test;

public class ThreadApp {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i= 0; i < 1000 ; i++){
					System.out.println(i);
				}
				
			}
		};
		new Thread(r).start();
	}
}
