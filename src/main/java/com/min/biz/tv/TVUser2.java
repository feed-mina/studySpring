package com.min.biz.tv;

import org.springframework.context.support.GenericXmlApplicationContext;

// 다형성 = 상속 + Overriding + 형변환
// 1. 상속 인터페이스일때 implements, class라면 extends로 상속한다.
// 2. 다른 클래스에도 동일하게 매서드를 맞춰 오버라이딩한다.
// 3. 묵시적 형변환 : 자식객체가 부모타입 객체에 할당하는것 (영어로 프로모션이라 부른다.)
// 다형성을 사용하는 이유 : 유지보수가 쉬워지기 때문에 !
// 유지보수가 편하려면 다형성을 사용해야 한다.

public class TVUser2 {
	
	public static void main(String[] args) {
	
		// 1. 스프링 컨테이너를 생성(구동)한다.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 스프링 컨테이너로부터 테스트할 객체를 검색(LookUp)한다.
		
		TV tv = (TV) container.getBean("tv");
		// TV tv = (TV) container.getBean("com.min.biz.tv.LGTV#0");
		 tv.powerOn();
		 tv.powerOff();
		 tv.volumeUp();
		 tv.volumeDown();
		 // 3. 스프링 컨테이너를 종료한다. (컨테이너는 종료 직전에 자신이 생성한 객체들을 제거한다.)
		 container.close();
	}

}
