package com.collection.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//properties: map �������� �����͸� �����ϴ� ��ü
		//1. ���� �����ؼ� ó�� -> Ȯ���� xml, txt, proterties �� ����
		//2. ���ڿ�(String) ���� ������ ����
		//3. key, value �������� ����
		
		Properties prop = new Properties();
		//�� �ֱ�
		prop.setProperty("userId","admin");
		prop.setProperty("password", "1234");//properties ���Ͽ� ���� �Էµ� ����
		
		System.out.println(prop);
		
//		try {
//			prop.store(new FileOutputStream("info.properties"), "adminData");
//			prop.storeToXML(new FileOutputStream("info.xml"), "adminData");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		loadproperties();
	}
	
	public static void loadproperties() {
		//����� properties�� �ҷ��ͺ���
		//load �޼ҵ� �̿�
		Properties prop = new Properties();
		try {
			//prop�� ����� ������ ���/��������
			prop.load(new FileInputStream("info.properties"));
			System.out.println(prop.getProperty("userId"));
			System.out.println(prop.getProperty("password"));
			
			prop.loadFromXML(new FileInputStream("info.xml"));
			System.out.println(prop.getProperty("userId"));
			System.out.println(prop.getProperty("password"));
			prop.list(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
