package com.collection.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.collection.model.vo.Fruit;

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
		
		set.add("�����");
		set.add("�����");
		set.add("�����");
		System.out.println("�ߺ� ��µ�?");
		Iterator it2 = set.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		it2 = set.iterator();//�̹� ����� ���� �ٽ� ����ҷ��� ���Ҵ�, ������ �� ����ؾ� ��(why? ����ϴ� ���� iterator ������ ������� ������, �ٽ� ����� ��� NoSuchElements ���� ��)
		System.out.println(it2);
		
		
		//set�� �̿��� �ߺ��� �����ϱ�
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		System.out.println(list);
		HashSet temp = new HashSet(list);
		list = new ArrayList(temp);
		System.out.println(list);
		
		//lotto �����
		list.clear();
		while(list.size()!=6) {
			list.add((int)(Math.random()*45)+1);
//			HashSet s = new HashSet(list);
//			list = new ArrayList(s);//2���� ����Ͽ� �Ʒ� �ڵ尡 ��
			list = new ArrayList(new HashSet(list));
		}
		System.out.println(list);
		
		
		//��������� �����ϴ� set-> ������ ���� set�� ������ ������
		LinkedHashSet lset = new LinkedHashSet();
		lset.add(1);
		lset.add("������");
		lset.add(new Fruit("��","����",10,12000));
		//���ڵ� Ȯ��
//		it2 = lset.iterator();
//		while(it2.hasNext()) {
//			System.out.println(it2.next());
//		}
		
		
		//treeSet->Ʈ�� �����̱� ������ ������ �������� ���ĵ�(���ϴ� �ڷ������� ���ƾ���)
		TreeSet tset = new TreeSet();
//		tset.add("������");
//		tset.add("�����");
//		tset.add("������");
//		tset.add("�赿��");
		Iterator it3 = tset.iterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		//treeSet ��������
		it3 = tset.descendingIterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		//���� ����
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
		}//��������
		it4 = tset.descendingIterator();
		while(it4.hasNext()) {
			System.out.println(it4.next());
		}//��������
		
		
		
		HashSet fruits = new HashSet();
		fruits.add(new Fruit("������","õ��",5,5000));//Object
		fruits.add(new Fruit("ü��","�̱�",3,12000));
		fruits.add(new Fruit("ü��","�̱�",3,12000));
		//���� �ߺ����� �� ����񱳸� ���� name�� price�� ����ϰ� �Ǹ� ü���� 2�� ����
		//�� ������? equals�� ¦���� hashcode�� override������ �ʾұ� ����
		
		it3 = fruits.iterator();
		//fruit���� ���� �̸��̶� ���ݸ� ����غ���!
		while(it3.hasNext()) {
//			System.out.println(((Fruit)it3.next()).getName());
//			System.out.println(((Fruit)it3.next()).getPrice());
			Fruit f = (Fruit)it3.next();
			System.out.println(f.getName()+" "+f.getPrice());
		}
	}
	

}
