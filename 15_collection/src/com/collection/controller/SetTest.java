package com.collection.controller;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	
	public static void main(String[] args) {
		//Set: ��ü���� ������ �� �ִ� ���� ����
		//������ ����, �ߺ����� �������� ����
		
		HashSet set = new HashSet();
		
		//add(): ������ �Է�
		set.add("������");
		set.add("������");
		set.add("������");
		set.add("�����");
		set.add("�迹��");
		
		//set�� ����Ǿ� �ִ� ���� ����ϱ� ���ؼ��� ��� ���� ������ ����ؾ� ��
		//Ư�� ���� �����ؼ� ����� �� ����
		//Iterator ��ü�� �̿��ؼ� ���(StringTokenizer�� ���)
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
