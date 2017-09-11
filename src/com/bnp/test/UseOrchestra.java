package com.bnp.test;

import java.util.ArrayList;
import java.util.List;

public class UseOrchestra<T extends Orchestra> {

	List<T> list = new ArrayList<>();

	public List<T> addToList(T o) {
		this.list.add(o);

		return this.list;
	}
	
	public static void main(String[] args) {
		UseOrchestra<Orchestra> t = new UseOrchestra<>();
		
		Piano piano = new Piano();
		Violin violin = new Violin();
		t.addToList(piano);
		t.addToList(violin);
		
		
		for(Orchestra o : t.list){
			if(o instanceof Piano){
				o.play();
			}
		}
		
	}
}
