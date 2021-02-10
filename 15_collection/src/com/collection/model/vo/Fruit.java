package com.collection.model.vo;

import java.util.Objects;

public class Fruit implements Comparable<Fruit>{
	
	private String name;
	private String origin;
	private int brix;
	private int price;
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}

	public Fruit(String name, String origin, int brix, int price) {
		super();
		this.name = name;
		this.origin = origin;
		this.brix = brix;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getBrix() {
		return brix;
	}

	public void setBrix(int brix) {
		this.brix = brix;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", origin=" + origin + ", brix=" + brix + ", price=" + price + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fruit) {
			Fruit f = (Fruit)obj;
			if(name.equals(f.name) && origin.equals(f.origin) && brix==f.brix &&
					price==f.price) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,origin,brix,price);
	}
	
	@Override
	public int compareTo(Fruit f) {
		//정렬 알고리즘이 적용되어 있어 서로 비교하여 정렬할 것을 고정시킴: +, 0, -
		//+: 자리 변경
		//0, -: 상태 유지
		//과일이름으로 정렬
		//return name.compareTo(f.name);//이름 오름차순
		//return f.name.compareTo(name);//이름 내림차순
		//return price-f.price;//가격 오름차순
		//return f.price-price;//가격 내림차순
//		if(price<f.price) {
//			return -1;
//		} else if (price==f.price) {
//			return 0;
//		} else {
//			return 1;
//		}//가격 오름차순
		if(price<f.price) {
			return 1;
		} else if (price==f.price) {
			return 0;
		} else {
			return -1;
		}//가격 내림차순
	}

}
