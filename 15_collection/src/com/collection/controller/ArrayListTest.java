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
		//ArrayList: �迭�� ������ �������� ������ �迭�� ������ ������ �ڷᱸ�� ����
		//Ŭ������ �Ǿ� �־� �޼ҵ带 �̿��� ������ ����, ����, �߰�(�������� �Ұ�)
		//�����͸� Object[]�� ������
		
		
		ArrayList list = new ArrayList();
		//Ŭ�����̱� ������ �̿��ϱ� ���ؼ��� �ݵ�� �����ؾ� ��
		//Default_Capacity = 10;
		
		
		//��������� �����ؼ� ������ �� ����
		ArrayList list2 = new ArrayList(20);
		
		
		//�������� ���� ���� �������̽� �ڷ����� ���Ե� �� �ִ�.
		List listTest = list;
		Collection collection = list2;//list�� Collection�� ��ӹޱ� ����
		
		
		//������ list�� �� �ֱ�
		//add() �޼ҵ带 �̿��ؼ� ���� ������ -> setter�� ���
		//������Ʈ���� ����ϴ� ��� Ÿ�� ���� ����
		list.add(false);
		list.add("������");
		list.add(19);
		list.add(180.5);
		list.add(new Date());
		//���� ������ ���� �ڵ����� index�� �ο���
		//���������� ����� �� �̷��� �Է������� ���� �� ������
		System.out.println(list);//�ڵ����� toString overriding �Ǿ� ����
		
		
		//list �ڷ����� ����� ���� vo��ü(������ ����� Ŭ����)�� ������ �� �����
		ArrayList fruits = new ArrayList();
		fruits.add(new Fruit("���","����",5,30000));
		fruits.add(new Fruit("����","ü��",3,15000));
		fruits.add(new Fruit("����","���",8,8000));
		
		
		//ArrayList�� �ִ� �� ����ϱ�: �� �������� �ε����� �������� ���
		//���: get(�ε��� ��ȣ)
		System.out.println(list.get(0));//list[0]->�̷��� ���� �� ��
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		//�� wrapper ó�� �Ǿ� ����
		//for���� �̿��� ���� ������ ó������!
		//size() : List�� ������ ������ Ȯ���ϴ� ���
		System.out.println("list ������ �� : "+list.size());//5
		System.out.println("fruits ������ �� : "+fruits.size());//3
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}//list������ ��ü ��ȸ
		
		
		//List�� �ִ� �����͸� ������ �����ϱ�
		String name = (String)list.get(1);
		//list.get(1)�� �ڷ����� Object�̹Ƿ� ��������ȯ�ؾ� ��
		System.out.println(name);//������
		
		
		//List������ �����ϱ�
		//remove(index||��ü, �����Ͱ�) �޼ҵ带 �̿��ؼ� ����
		list.remove(0);
		System.out.println(list.get(0));//������
		list.remove("������");
		System.out.println(list.get(0));//19
		
		
		//set(index, ������ ������): List ������ �����ϱ�
		list.set(0, "���� �� ���� �ð�");
		System.out.println(list.get(0));//���� �� ���� �ð�
		
		
		//add(index,������): �ε��� ��ġ�� ������ �߰�
		list.add(1, "�̰� �߰��� ��!");
		System.out.println(list);//[���� �� ���� �ð�, �̰� �߰��� ��!, 180.5, Tue Feb 09 10:49:49 KST 2021]
		
		
		//���� ���� ��ü�� �̿��غ���
		fruits.add(new Fruit("����","�ð�",8,20000));//������ �߰�
		System.out.println(fruits);
		fruits.add(1,new Fruit("Ű��","��������",5,10000));//���� �ε����� ������ �߰�
		System.out.println(fruits);
		fruits.remove(0);//�ش� �ε����� ������ ����
		System.out.println(fruits);
		fruits.remove(new Fruit("Ű��","��������",5,10000));
		System.out.println(fruits);//���ϴ� ������ ����
		//equal�� �������̵� �Ǿ� �־�� ���� ���ϴ� �����Ϳ� �´� �����Ͱ� ������
		fruits.set(0, new Fruit("�ٳ���","�ʸ���",7,8000));
		System.out.println(fruits);//������ ����
		
		
		//fruits ����: ���ϵ��� �����ϱ� ���� �����
		fruits.add(new Date());
		System.out.println(fruits);
		//but ���ϰ� ���� ���� �����͵��� ���к��ϰ� �� �� ����
		//�̸� ���� ������ �ִ� ���� ���׸� ����!
		
		
		//list ���� �޼ҵ�
		//1. contains(��ü): list ���ο� �Ű������� ��ü�� �ִ��� �˷��ִ� �޼ҵ�
		//��ü�� equals() �������̵��� �Ǿ� �־���� ��� ����
		System.out.println(fruits.contains(new Fruit("�ٳ���","�ʸ���",7,8000)));//true
		System.out.println(fruits.contains(new Fruit("����","�ʸ���",7,8000)));//false
		if(!fruits.contains(new Fruit("����","�ʸ���",9,5000))) {
			fruits.add(new Fruit("����","�ʸ���",9,5000));
		}
		
		//2. clear(): list�� �ִ� �����͸� ��� ����� ��
		fruits.clear();
		System.out.println(fruits);
		
		//3. isEmpty(): List�� �����Ͱ� �ִ��� Ȯ��
		System.out.println(fruits.isEmpty());//true
		if(!fruits.isEmpty()) {
			for (int i=0 ; i<fruits.size() ; i++) {
				System.out.println(fruits.get(i));
			}
		}
		
		//4. indexOf(��ü): ��ü�� ��ġ�ϴ� ���� �ε��� ��ȣ ��ȯ
		System.out.println(list.indexOf(180.5));//2
		//�ε����� -1�̸� ���� ���̶�� ��!
		
		//5. toArray(): List�� Object[]�� ��ȯ���ִ� �޼ҵ�
		Object[] objs = list.toArray();//�żҵ� �̿� �� �Ű������� �迭�� ������ ���
		
		
		//List�� �ߺ����� ������ �� ����
		fruits.add(new Fruit("����","�ʸ���",7,8000));
		fruits.add(new Fruit("����","�ʸ���",7,8000));
		fruits.add(new Fruit("����","�ʸ���",7,8000));
		System.out.println(fruits);//�ߺ��� �� �����
		
		
		//List�� ������ �ֱ� ������ ������ ������
		list.clear();
		for(int i=0 ; i<10 ; i++) {
			list.add((int)(Math.random()*10)+1);
		}
		System.out.println(list);
		//list�� ������ �� �ִ� �޼ҵ带 ������ -> Collections.sort()
		Collections.sort(list);//default: �������� ����
		System.out.println(list);
		
		list.clear();
	//list�� ���ڿ��� ��̸� �Է¹޾� ���� 5��
		//���ڵ�
		ArrayList hobby = new ArrayList();
		hobby.add("��ȭ����");
		hobby.add("�ǾƳ� ġ��");
		hobby.add("�");
		hobby.add("�߰�");
		hobby.add("����ŷ");
		System.out.println(hobby);
		Collections.sort(hobby);
		System.out.println(hobby);
		//���ڵ�
		Scanner sc = new Scanner(System.in);
//		for (int i=0 ; i<5 ; i++) {
//			System.out.print("���: ");
//			list.add(sc.nextLine());
//		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		//������ ��ü �����ϱ�1: Compareable �������̽� ����
		//-> implements Comparable<Fruit> �� compareTo() �������̵��Ͽ� ���Ĺ�� ����
		fruits.clear();
		
		System.out.println("������ ��ü ����");
		for (Object o : fruits) {
			System.out.println(o);
		}
		Collections.sort(fruits);
		System.out.println("���� �� ���");
		for (Object o : fruits) {
			System.out.println(o);
		}//��ü�� �̷� ������� ������ �� ����
		
		//������ ��ü �����ϱ�2: ���� Ŭ������ ���� �����ؼ� �����ϴ� ���
		//Comparator �������̽��� �����ϴ� ��ü�� ����� Collections.sort(����Ʈ, Comparator������ü);
		//�̸� ��������
		Collections.sort(fruits, new FruitNameAscending());
		System.out.println("compare �̿��ؼ� ����");
		for (Object o : fruits) {
			System.out.println(o);
		}
		//�̸��� �������� �������� ����
		Collections.sort(fruits, new FruitNameDesending());
		for (Object o : fruits) {
			System.out.println(o);
		}
		//���� ��������
		Collections.sort(fruits, new FruitPriceAscending());
		for (Object o : fruits) {
			System.out.println(o);
		}
		
		
		//lambda ǥ����: lambda ǥ���� ������� �޼ҵ带 ǥ���ؼ� �ٷ� ������ �� �ְ� ���� ��
		//�޼ҵ��� ����θ� �����ϰ� ǥ���ؼ� �Ű������� �ѱ� �� ����
		//�������̽����� �� ���� �޼ҵ常 ������ ������ ó��
		Collections.sort(fruits,(Object o1, Object o2)
			-> ((Fruit)o2).getPrice()-((Fruit)o1).getPrice());//���ϰ�
//		Collections.sort(fruits, new Comparator<fruit>() {
//			@Override
//			public int compare(Fruit o1, Fruit o2) {
//				return o2.getName().compareTo(o1.getName());
//			}
//		}//�̰��� lambda ǥ�������� �ۼ��� ���� �ٷ� �� �ڵ���
		
		
		//LinkedList: ArrayList�� �����ϰ�, �޼ҵ忡�� �ణ�� ���̰� ����
		//�޼ҵ忡�� �ణ�� ���̰� ����.
		LinkedList linkList = new LinkedList();
		linkList.add("������");
		linkList.add("�����");
		linkList.add("������");
		linkList.add("�迹��");
		
		for (Object o : linkList) {
			System.out.println(o);
		}
		for (int i=0 ; i<linkList.size() ; i++) {
			System.out.println(linkList.get(i));
		}//���� ����
		
		System.out.println(linkList.getFirst());//������
		System.out.println(linkList.getLast());//�迹��
		System.out.println(linkList.pop());
		System.out.println(linkList);
	}

}
