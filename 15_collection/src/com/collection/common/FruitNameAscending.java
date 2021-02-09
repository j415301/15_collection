package com.collection.common;

import java.util.Comparator;

import com.collection.model.vo.Fruit;

//Fruit 객체를 이름으로 정렬하게 하는 sort 객체
//Fruit 객체 이름을 기준으로 +, -, 0을 반환하는 메소드 구현
public class FruitNameAscending implements Comparator <Fruit>{
	
	@Override
	public int compare(Fruit o1, Fruit o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
