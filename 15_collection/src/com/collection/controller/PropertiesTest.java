package com.collection.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//properties: map 형식으로 데이터를 저장하는 객체
		//1. 파일 연동해서 처리 -> 확장자 xml, txt, proterties 등 가능
		//2. 문자열(String) 전용 데이터 보관
		//3. key, value 형식으로 저장
		
		Properties prop = new Properties();
		//값 넣기
		prop.setProperty("userId","admin");
		prop.setProperty("password", "1234");//properties 파일에 직접 입력도 가능
		
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
		//저장된 properties를 불러와보자
		//load 메소드 이용
		Properties prop = new Properties();
		try {
			//prop에 저장된 데이터 출력/가져오기
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
