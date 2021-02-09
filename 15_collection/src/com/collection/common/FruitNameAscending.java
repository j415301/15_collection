package com.collection.common;

import java.util.Comparator;

import com.collection.model.vo.Fruit;

//Fruit ��ü�� �̸����� �����ϰ� �ϴ� sort ��ü
//Fruit ��ü �̸��� �������� +, -, 0�� ��ȯ�ϴ� �޼ҵ� ����
public class FruitNameAscending implements Comparator <Fruit>{
	
	@Override
	public int compare(Fruit o1, Fruit o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
