package com.collection.common;

import java.util.Comparator;

import com.collection.model.vo.Fruit;

public class FruitPriceAscending implements Comparator<Fruit> {

	@Override
	public int compare(Fruit o1, Fruit o2) {
		// TODO Auto-generated method stub
		return o1.getPrice()-o2.getPrice();
	}

}
