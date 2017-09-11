package com.bnp.test;

import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueApp {

	
	Queue<String> list = new ArrayBlockingQueue<>(100);
	Queue<String> modified = new ArrayBlockingQueue<>(100);
	
	public static void main(String[] args) {
		QueueApp app = new QueueApp();
		app.list.add("teste");
		app.list.add("teste1");
		app.list.add("teste3");
		app.list.add("teste5");
		app.list.add("teste2");
		app.list.add("teste3");
		
		app.list.forEach(x -> {
			x = x + "bla";
			app.modified.add(x);
		});
		System.out.println(app.list);
		System.out.println(app.modified);
		app.list.stream().sorted(Comparator.reverseOrder()).distinct().forEach(x -> {
			System.out.println(x);
		});
	}
}
