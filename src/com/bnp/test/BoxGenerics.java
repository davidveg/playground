package com.bnp.test;

import java.util.ArrayList;
import java.util.List;

public class BoxGenerics implements Generics<String, Integer> {
	
	List<String> list = new ArrayList<>();


	@Override
	public void addToList(String item, Integer value) {
		this.list.add(item);
	}
}
