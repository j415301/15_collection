package com.collection.controller;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	
	public static void main(String[] args) {
		//Set: 객체들을 저장할 수 있는 저장 구조
		//순서가 없고, 중복값을 저장하지 않음
		
		HashSet set = new HashSet();
		
		//add(): 데이터 입력
		set.add("유병승");
		set.add("정유정");
		set.add("김태희");
		set.add("김상현");
		set.add("김예진");
		
		//set에 저장되어 있는 값을 출력하기 위해서는 모든 값을 가져와 출력해야 함
		//특정 값을 지정해서 출력할 수 없음
		//Iterator 객체를 이용해서 출력(StringTokenizer과 비슷)
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
