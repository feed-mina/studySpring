package com.min.biz.tv;

import org.springframework.context.support.GenericXmlApplicationContext;


public class TVUser3 {
	
	public static void main(String[] args) {
	
		// 순방향 제어: 자바 소스로 객체 제어 <----> 역제어 (IoC) : 컨테이너에 올려서 제어 
//		TV tv1 = new SamsungTV();
//		TV tv2 = new SamsungTV();
//		TV tv3 = new SamsungTV();
//		
//		TV tv2 = tv1;
//		TV tv3 = tv2;
//	
		
		// 1. 스프링 컨테이너를 생성(구동)한다.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 스프링 컨테이너로부터 테스트할 객체를 검색(LookUp)한다.
	
		TV tv1 = (TV) container.getBean("tv");
		TV tv2 = (TV) container.getBean("tv");
		TV tv3 = (TV) container.getBean("tv");
		
		System.out.println(tv1.toString());
		System.out.println(tv2.toString());
		System.out.println(tv3.toString());
		
		// 하나의 클래스에서 여러개의 객체를 만들지 않고 어떤객체의 인스턴스 주소를 하나만 만들려면 주소를 복사해서 재사용한다.
		
		// 싱글톤 패턴이 등장하게 된다. scope = singleton (default)
		
	}

}
