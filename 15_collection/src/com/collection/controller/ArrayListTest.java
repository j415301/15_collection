package com.collection.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.collection.common.FruitNameAscending;
import com.collection.common.FruitNameDesending;
import com.collection.common.FruitPriceAscending;
import com.collection.model.vo.Fruit;

public class ArrayListTest {

	public static void main(String[] args) {
		//ArrayList: 배열과 동일한 저장방식을 가지고 배열의 단점을 보완한 자료구조 형태
		//클래스로 되어 있어 메소드를 이용해 데이터 수정, 삭제, 추가(직접접근 불가)
		//데이터를 Object[]로 저장함
		
		
		ArrayList list = new ArrayList();
		//클래스이기 때문에 이용하기 위해서는 반드시 생성해야 함
		//Default_Capacity = 10;
		
		
		//저장공간을 지정해서 생성할 수 있음
		ArrayList list2 = new ArrayList(20);
		
		
		//다형성에 의해 구현 인터페이스 자료형에 대입될 수 있다.
		List listTest = list;
		Collection collection = list2;//list는 Collection을 상속받기 때문
		
		
		//생성된 list에 값 넣기
		//add() 메소드를 이용해서 값을 대입함 -> setter와 비슷
		//프로젝트에서 사용하는 모든 타입 저장 가능
		list.add(false);
		list.add("유병승");
		list.add(19);
		list.add(180.5);
		list.add(new Date());
		//저장 순서에 따라 자동으로 index가 부여됨
		//실질적으로 사용할 때 이렇게 입력하지는 않음 걍 예시임
		System.out.println(list);//자동으로 toString overriding 되어 있음
		
		
		//list 자료형을 사용할 때는 vo객체(데이터 저장용 클래스)를 저장할 때 사용함
		ArrayList fruits = new ArrayList();
		fruits.add(new Fruit("사과","영주",5,30000));
		fruits.add(new Fruit("포도","체코",3,15000));
		fruits.add(new Fruit("딸기","논산",8,8000));
		
		
		//ArrayList에 있는 값 출력하기: 각 데이터의 인덱스를 기준으로 출력
		//방법: get(인덱스 번호)
		System.out.println(list.get(0));//list[0]->이렇게 쓰면 안 됨
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		//다 wrapper 처리 되어 있음
		//for문을 이용해 더욱 간단히 처리하자!
		//size() : List의 데이터 개수를 확인하는 방법
		System.out.println("list 데이터 수 : "+list.size());//5
		System.out.println("fruits 데이터 수 : "+fruits.size());//3
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}//list데이터 전체 순회
		
		
		//List에 있는 데이터를 변수에 저장하기
		String name = (String)list.get(1);
		//list.get(1)의 자료형은 Object이므로 강제형변환해야 함
		System.out.println(name);//유병승
		
		
		//List데이터 삭제하기
		//remove(index||객체, 데이터값) 메소드를 이용해서 삭제
		list.remove(0);
		System.out.println(list.get(0));//유병승
		list.remove("유병승");
		System.out.println(list.get(0));//19
		
		
		//set(index, 수정할 데이터): List 데이터 수정하기
		list.set(0, "이제 곧 쉬는 시간");
		System.out.println(list.get(0));//이제 곧 쉬는 시간
		
		
		//add(index,데이터): 인덱스 위치에 데이터 추가
		list.add(1, "이건 추가한 것!");
		System.out.println(list);//[이제 곧 쉬는 시간, 이건 추가한 것!, 180.5, Tue Feb 09 10:49:49 KST 2021]
		
		
		//내가 만든 객체를 이용해보기
		fruits.add(new Fruit("수박","시골",8,20000));//데이터 추가
		System.out.println(fruits);
		fruits.add(1,new Fruit("키위","뉴질랜드",5,10000));//지정 인덱스에 데이터 추가
		System.out.println(fruits);
		fruits.remove(0);//해당 인덱스의 데이터 삭제
		System.out.println(fruits);
		fruits.remove(new Fruit("키위","뉴질랜드",5,10000));
		System.out.println(fruits);//원하는 데이터 삭제
		//equal가 오버라이드 되어 있어야 내가 원하는 데이터에 맞는 데이터가 삭제됨
		fruits.set(0, new Fruit("바나나","필리핀",7,8000));
		System.out.println(fruits);//데이터 수정
		
		
		//fruits 변수: 과일들을 관리하기 위해 선언됨
		fruits.add(new Date());
		System.out.println(fruits);
		//but 과일과 관계 없는 데이터들이 무분별하게 들어갈 수 있음
		//이를 막고 관리할 있는 것이 제네릭 선언!
		
		
		//list 관련 메소드
		//1. contains(객체): list 내부에 매개변수의 객체가 있는지 알려주는 메소드
		//객체에 equals() 오버라이딩이 되어 있어야지 사용 가능
		System.out.println(fruits.contains(new Fruit("바나나","필리핀",7,8000)));//true
		System.out.println(fruits.contains(new Fruit("망고","필리핀",7,8000)));//false
		if(!fruits.contains(new Fruit("망고","필리핀",9,5000))) {
			fruits.add(new Fruit("망고","필리핀",9,5000));
		}
		
		//2. clear(): list에 있는 데이터를 모두 지우는 것
		fruits.clear();
		System.out.println(fruits);
		
		//3. isEmpty(): List에 데이터가 있는지 확인
		System.out.println(fruits.isEmpty());//true
		if(!fruits.isEmpty()) {
			for (int i=0 ; i<fruits.size() ; i++) {
				System.out.println(fruits.get(i));
			}
		}
		
		//4. indexOf(객체): 객체와 일치하는 값의 인덱스 번호 반환
		System.out.println(list.indexOf(180.5));//2
		//인덱스가 -1이면 없는 값이라는 뜻!
		
		//5. toArray(): List를 Object[]로 반환해주는 메소드
		Object[] objs = list.toArray();//매소드 이용 시 매개변수에 배열로 선언한 경우
		
		
		//List는 중복값을 저장할 수 있음
		fruits.add(new Fruit("망고","필리핀",7,8000));
		fruits.add(new Fruit("망고","필리핀",7,8000));
		fruits.add(new Fruit("망고","필리핀",7,8000));
		System.out.println(fruits);//중복값 다 저장됨
		
		
		//List는 순서가 있기 때문에 정렬이 가능함
		list.clear();
		for(int i=0 ; i<10 ; i++) {
			list.add((int)(Math.random()*10)+1);
		}
		System.out.println(list);
		//list를 정렬할 수 있는 메소드를 제공함 -> Collections.sort()
		Collections.sort(list);//default: 오름차순 정렬
		System.out.println(list);
		
		list.clear();
	//list에 문자열로 취미를 입력받아 저장 5개
		//내코드
		ArrayList hobby = new ArrayList();
		hobby.add("영화보기");
		hobby.add("피아노 치기");
		hobby.add("운동");
		hobby.add("뜨개");
		hobby.add("베이킹");
		System.out.println(hobby);
		Collections.sort(hobby);
		System.out.println(hobby);
		//쌤코드
		Scanner sc = new Scanner(System.in);
//		for (int i=0 ; i<5 ; i++) {
//			System.out.print("취미: ");
//			list.add(sc.nextLine());
//		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		//생성한 객체 정렬하기1: Compareable 인터페이스 구현
		//-> implements Comparable<Fruit> 후 compareTo() 오버라이딩하여 정렬방식 정함
		fruits.clear();
		
		System.out.println("생성한 객체 정렬");
		for (Object o : fruits) {
			System.out.println(o);
		}
		Collections.sort(fruits);
		System.out.println("정렬 후 결과");
		for (Object o : fruits) {
			System.out.println(o);
		}//객체는 이런 방식으로 정렬할 수 없음
		
		//생성한 객체 정렬하기2: 정렬 클래스를 새로 생성해서 적용하는 방법
		//Comparator 인터페이스를 구현하는 객체를 만들고 Collections.sort(리스트, Comparator구현객체);
		//이름 오름차순
		Collections.sort(fruits, new FruitNameAscending());
		System.out.println("compare 이용해서 정렬");
		for (Object o : fruits) {
			System.out.println(o);
		}
		//이름을 기준으로 내림차순 정렬
		Collections.sort(fruits, new FruitNameDesending());
		for (Object o : fruits) {
			System.out.println(o);
		}
		//가격 오름차순
		Collections.sort(fruits, new FruitPriceAscending());
		for (Object o : fruits) {
			System.out.println(o);
		}
		
		
		//lambda 표현식: lambda 표현식 방식으로 메소드를 표현해서 바로 실행할 수 있게 만든 것
		//메소드의 선언부를 간단하게 표시해서 매개변수로 넘길 수 있음
		//인터페이스에서 한 개의 메소드만 선언한 것으로 처리
		Collections.sort(fruits,(Object o1, Object o2)
			-> ((Fruit)o2).getPrice()-((Fruit)o1).getPrice());//리턴값
//		Collections.sort(fruits, new Comparator<fruit>() {
//			@Override
//			public int compare(Fruit o1, Fruit o2) {
//				return o2.getName().compareTo(o1.getName());
//			}
//		}//이것을 lambda 표현식으로 작성한 것이 바로 위 코드임
		
		
		//LinkedList: ArrayList와 동일하고, 메소드에서 약간의 차이가 있음
		//메소드에서 약간의 차이가 있음.
		LinkedList linkList = new LinkedList();
		linkList.add("유병승");
		linkList.add("김상현");
		linkList.add("정유정");
		linkList.add("김예진");
		
		for (Object o : linkList) {
			System.out.println(o);
		}
		for (int i=0 ; i<linkList.size() ; i++) {
			System.out.println(linkList.get(i));
		}//위와 같음
		
		System.out.println(linkList.getFirst());//유병승
		System.out.println(linkList.getLast());//김예진
		System.out.println(linkList.pop());
		System.out.println(linkList);
	}

}
