package com.collection.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.collection.model.vo.Fruit;

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
		
		set.add("김상현");
		set.add("김상현");
		set.add("김상현");
		System.out.println("중복 출력됨?");
		Iterator it2 = set.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		it2 = set.iterator();//이미 출력한 값을 다시 출력할려면 재할당, 재지정 후 출력해야 함(why? 출력하는 순간 iterator 공간이 비워지기 때문에, 다시 출력할 경우 NoSuchElements 에러 남)
		System.out.println(it2);
		
		
		//set을 이용해 중복값 제거하기
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		System.out.println(list);
		HashSet temp = new HashSet(list);
		list = new ArrayList(temp);
		System.out.println(list);
		
		//lotto 만들기
		list.clear();
		while(list.size()!=6) {
			list.add((int)(Math.random()*45)+1);
//			HashSet s = new HashSet(list);
//			list = new ArrayList(s);//2줄을 축약하여 아래 코드가 됨
			list = new ArrayList(new HashSet(list));
		}
		System.out.println(list);
		
		
		//저장순서를 유지하는 set-> 순서가 없는 set의 단점을 보완함
		LinkedHashSet lset = new LinkedHashSet();
		lset.add(1);
		lset.add("유병승");
		lset.add(new Fruit("배","나주",10,12000));
		//쌤코드 확인
//		it2 = lset.iterator();
//		while(it2.hasNext()) {
//			System.out.println(it2.next());
//		}
		
		
		//treeSet->트리 구조이기 때문에 무조건 오름차순 정렬됨(비교하는 자료형들이 같아야함)
		TreeSet tset = new TreeSet();
//		tset.add("유병승");
//		tset.add("김상현");
//		tset.add("장혜린");
//		tset.add("김동규");
		Iterator it3 = tset.iterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		//treeSet 내림차순
		it3 = tset.descendingIterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		//숫자 정렬
//		tset.add(1);
//		tset.add(35);
//		tset.add(652);
//		tset.add(51);
//		tset.add(2);
//		tset.add(2);
//		tset.add(2);
//		tset.add(2);
		Iterator it4 = tset.iterator();
		while(it4.hasNext()) {
			System.out.println(it4.next());
		}//오름차순
		it4 = tset.descendingIterator();
		while(it4.hasNext()) {
			System.out.println(it4.next());
		}//내림차순
		
		
		
		HashSet fruits = new HashSet();
		fruits.add(new Fruit("복숭아","천도",5,5000));//Object
		fruits.add(new Fruit("체리","미국",3,12000));
		fruits.add(new Fruit("체리","미국",3,12000));
		//값이 중복됐을 때 동등비교를 통해 name과 price를 출력하게 되면 체리가 2번 나옴
		//그 이유는? equals와 짝궁인 hashcode를 override해주지 않았기 때문
		
		it3 = fruits.iterator();
		//fruit에서 과일 이름이랑 가격만 출력해보자!
		while(it3.hasNext()) {
//			System.out.println(((Fruit)it3.next()).getName());
//			System.out.println(((Fruit)it3.next()).getPrice());
			Fruit f = (Fruit)it3.next();
			System.out.println(f.getName()+" "+f.getPrice());
		}
	}
	

}
