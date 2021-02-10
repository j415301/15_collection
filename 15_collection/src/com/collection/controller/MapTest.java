package com.collection.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.collection.model.vo.Fruit;

public class MapTest {
	
	public static void main(String[] args) {
		//map에 대해 알아보자
		//쌍으로 이뤄져 있는 자료 구조 key(Object) : value(Object)
		//Collection 인터페이스를 상속받지 않음
		//Map 인터페이스로 구성되어 있음
		
		HashMap map = new HashMap();//객체이기 때문에 생성해서 사용
		
		//데이터 넣기: key값 및 value값 모두 대입해야 함
		//put(key, value) 메소드 이용
		//key: String, Integer를 많이 사용함
		//value : vo(데이터 보관용 객체) 사용
		map.put("유병승", 19);
		map.put("김상현", 29);
		map.put(1, "장혜린");
		map.put(2, "정유정");
		System.out.println(map);//{1=장혜린, 2=정유정, 김상현=29, 유병승=19}//순서가 없이 저장되므로 무작위로 출력됨
		
		
		//map에 저장된 데이터 가져오기
		//map에 저장된 데이터는 key값을 기준으로 가져옴
		//key를 인덱스로 보면 됨
		System.out.println(map.get("유병승"));//19
		System.out.println(map.get("김상현"));//29
		
		
		//key값 중복 불가 but value 중복 가능
		System.out.println(map.get(1));//장혜린
		map.put(1, "김동규");
		System.out.println(map.get(1));//김동규//똑같은 key값에 value값을 입력하면 해당 value를 덮어씀
		
		
		//remove(): key값을 기준으로 삭제
		map.remove(1);
		System.out.println(map);
		
		
		//size(): 값 갯수
		System.out.println(map.size());
		
		
		//Map에 저장되어 있는 전체 자료 조회 -> Key를 기준으로 값을 가져오기
		//1. key값을 확인하고 그 key값으로 데이터를 가져와야함. 이때 key는 set 방식으로 저장되기 때문에 Iterator을 사용해야 함
		Iterator it = map.keySet().iterator();//map에 저장된 key를 set방식으로 가져옴
		while(it.hasNext()) {
			Object key = it.next();//key값
			System.out.println(map.get(key));
			System.out.println(key+" : "+map.get(key));
		}//key값을 통한 value값 출력
		
		//Map.Entry(클래스)를 자료형으로 사용해서 key, value값을 동시에 가져옴
		Set entrySet = map.entrySet();//Map.entry 클래스 //entrySet(): 전체를 set으로 변환한다
		Iterator entry = entrySet.iterator();
		while(entry.hasNext()) {
			//iterator에 map.entry라는 객체가 들어가 있음
			Map.Entry e = (Map.Entry)entry.next();
			//getKey()-> key값을 가져옴/ getValue(): value값을 가져옴
			System.out.println(e.getKey()+" : "+e.getValue());
		}
		
		
		//데이터가 있는지 확인
		System.out.println(map.isEmpty());//false
		System.out.println(map.containsKey("유병승"));//true
		System.out.println(map.containsValue(29));//true
		
		
		//map을 이용하기 - 객체
		map.clear();
		map.put(1, new Fruit("귤","제주도",10,15000));
		map.put(2, new Fruit("파인애플","필리핀",6,7000));
		map.put(3, new Fruit("레몬","미국",1,3000));
		
		//map에 있는 값의 이름과 원산지 출력하기
		/*내코드 쓰다맘
		Set fruits = map.entrySet();
		Iterator fIt = fruits.iterator();
		while(fIt.hasNext()) {
			Map.Entry e = (Map.Entry)fIt.next();
			System.out.println(e.get);
		}*/
		//쌤코드
		it = map.keySet().iterator();
		//Set s = map.keySet();
		//it = s.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Fruit f = (Fruit)map.get(key);
			System.out.println(f.getName()+" : "+f.getOrigin());
		}
		
		
		//Map.Entry를 이용해서 처리하기
		Set es = map.entrySet();//Map.Entry클래스
		Iterator iee = es.iterator();
		while(iee.hasNext()) {
			Map.Entry e = (Map.Entry)iee.next();
			Fruit f = (Fruit)e.getValue();
			System.out.println(f.getName()+" : "+f.getOrigin());
		}
		
		
		//values(); : Map을 Collection형식으로 바꿀 수 있음
		Collection c = map.values();
		System.out.println(c);
		Iterator it3 = c.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
		System.out.println();
		ArrayList list = new ArrayList(c);
		System.out.println(list.get(1));
		
		
		
		//실제 웹에서의 사용 방법
		list.clear();
		HashMap data = new HashMap();
		data.put("name", "유병승");
		data.put("age", 19);
		data.put("address", "경기도 시흥시");
		data.put("userId", "admin");
		list.add(data);//db
		for (int i=0 ; i<list.size() ; i++) {//column을 하나씩 바꾸면서 db출력
			for (Object o : ((HashMap)list.get(0)).keySet()) {
			HashMap m = (HashMap)list.get(0);
			System.out.println(m.get(o));
		}
		}
		System.out.println();
	}
	
}
