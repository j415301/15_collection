package com.collection.common;

import java.util.Comparator;

import com.collection.model.vo.Fruit;

public class FruitNameDesending implements Comparator <Fruit>{
	
	@Override
	public int compare(Fruit f, Fruit f2) {
		return f2.getName().compareTo(f.getName());
	}

}
