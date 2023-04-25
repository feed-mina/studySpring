package com.min.biz.tv;

import org.springframework.context.support.GenericXmlApplicationContext;

// 다형성 = 상속 + Overriding + 형변환
// 1. 상속 인터페이스일때 implements, class라면 extends로 상속한다.
// 2. 다른 클래스에도 동일하게 매서드를 맞춰 오버라이딩한다.
// 3. 묵시적 형변환 : 자식객체가 부모타입 객체에 할당하는것 (영어로 프로모션이라 부른다.)
// 다형성을 사용하는 이유 : 유지보수가 쉬워지기 때문에 !
// 유지보수가 편하려면 다형성을 사용해야 한다.

public class TVUser {
	
	public static void main(String[] args) {
	
		// 1. 스프링 컨테이너를 생성(구동)한다.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 스프링 컨테이너로부터 테스트할 객체를 검색(LookUp)한다.
		 TV tv = (TV) container.getBean("tv");
	
		 // 디자인 패턴 적용	
		// 마우스 오른쪽 클릭 > Run as > Run configuration > arguments > lg 또는 samsung
	
		 //		BeanFactory factory = new BeanFactory();
		 //		TV tv = (TV) factory.getBean(args[0]);
	
		 //	 TV tv = new SamsungTV();
		 tv.powerOn();
		 tv.powerOff();
		 tv.volumeUp();
		 tv.volumeDown();
		 
		 container.close();

	}

}
