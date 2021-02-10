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
		//map�� ���� �˾ƺ���
		//������ �̷��� �ִ� �ڷ� ���� key(Object) : value(Object)
		//Collection �������̽��� ��ӹ��� ����
		//Map �������̽��� �����Ǿ� ����
		
		HashMap map = new HashMap();//��ü�̱� ������ �����ؼ� ���
		
		//������ �ֱ�: key�� �� value�� ��� �����ؾ� ��
		//put(key, value) �޼ҵ� �̿�
		//key: String, Integer�� ���� �����
		//value : vo(������ ������ ��ü) ���
		map.put("������", 19);
		map.put("�����", 29);
		map.put(1, "������");
		map.put(2, "������");
		System.out.println(map);//{1=������, 2=������, �����=29, ������=19}//������ ���� ����ǹǷ� �������� ��µ�
		
		
		//map�� ����� ������ ��������
		//map�� ����� �����ʹ� key���� �������� ������
		//key�� �ε����� ���� ��
		System.out.println(map.get("������"));//19
		System.out.println(map.get("�����"));//29
		
		
		//key�� �ߺ� �Ұ� but value �ߺ� ����
		System.out.println(map.get(1));//������
		map.put(1, "�赿��");
		System.out.println(map.get(1));//�赿��//�Ȱ��� key���� value���� �Է��ϸ� �ش� value�� ���
		
		
		//remove(): key���� �������� ����
		map.remove(1);
		System.out.println(map);
		
		
		//size(): �� ����
		System.out.println(map.size());
		
		
		//Map�� ����Ǿ� �ִ� ��ü �ڷ� ��ȸ -> Key�� �������� ���� ��������
		//1. key���� Ȯ���ϰ� �� key������ �����͸� �����;���. �̶� key�� set ������� ����Ǳ� ������ Iterator�� ����ؾ� ��
		Iterator it = map.keySet().iterator();//map�� ����� key�� set������� ������
		while(it.hasNext()) {
			Object key = it.next();//key��
			System.out.println(map.get(key));
			System.out.println(key+" : "+map.get(key));
		}//key���� ���� value�� ���
		
		//Map.Entry(Ŭ����)�� �ڷ������� ����ؼ� key, value���� ���ÿ� ������
		Set entrySet = map.entrySet();//Map.entry Ŭ���� //entrySet(): ��ü�� set���� ��ȯ�Ѵ�
		Iterator entry = entrySet.iterator();
		while(entry.hasNext()) {
			//iterator�� map.entry��� ��ü�� �� ����
			Map.Entry e = (Map.Entry)entry.next();
			//getKey()-> key���� ������/ getValue(): value���� ������
			System.out.println(e.getKey()+" : "+e.getValue());
		}
		
		
		//�����Ͱ� �ִ��� Ȯ��
		System.out.println(map.isEmpty());//false
		System.out.println(map.containsKey("������"));//true
		System.out.println(map.containsValue(29));//true
		
		
		//map�� �̿��ϱ� - ��ü
		map.clear();
		map.put(1, new Fruit("��","���ֵ�",10,15000));
		map.put(2, new Fruit("���ξ���","�ʸ���",6,7000));
		map.put(3, new Fruit("����","�̱�",1,3000));
		
		//map�� �ִ� ���� �̸��� ������ ����ϱ�
		/*���ڵ� ���ٸ�
		Set fruits = map.entrySet();
		Iterator fIt = fruits.iterator();
		while(fIt.hasNext()) {
			Map.Entry e = (Map.Entry)fIt.next();
			System.out.println(e.get);
		}*/
		//���ڵ�
		it = map.keySet().iterator();
		//Set s = map.keySet();
		//it = s.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Fruit f = (Fruit)map.get(key);
			System.out.println(f.getName()+" : "+f.getOrigin());
		}
		
		
		//Map.Entry�� �̿��ؼ� ó���ϱ�
		Set es = map.entrySet();//Map.EntryŬ����
		Iterator iee = es.iterator();
		while(iee.hasNext()) {
			Map.Entry e = (Map.Entry)iee.next();
			Fruit f = (Fruit)e.getValue();
			System.out.println(f.getName()+" : "+f.getOrigin());
		}
		
		
		//values(); : Map�� Collection�������� �ٲ� �� ����
		Collection c = map.values();
		System.out.println(c);
		Iterator it3 = c.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
		System.out.println();
		ArrayList list = new ArrayList(c);
		System.out.println(list.get(1));
		
		
		
		//���� �������� ��� ���
		list.clear();
		HashMap data = new HashMap();
		data.put("name", "������");
		data.put("age", 19);
		data.put("address", "��⵵ �����");
		data.put("userId", "admin");
		list.add(data);//db
		for (int i=0 ; i<list.size() ; i++) {//column�� �ϳ��� �ٲٸ鼭 db���
			for (Object o : ((HashMap)list.get(0)).keySet()) {
			HashMap m = (HashMap)list.get(0);
			System.out.println(m.get(o));
		}
		}
		System.out.println();
	}
	
}
