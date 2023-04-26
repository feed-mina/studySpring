package com.min.biz.tv;

import org.springframework.context.support.GenericXmlApplicationContext;

// 다형성 = 상속 + Overriding + 형변환


public class TVUser {
	
	public static void main(String[] args) {
		// 1. 스프링 컨테이너를 생성(구동)한다.
				GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
				
		// 2. 스프링 컨테이너로부터 테스트할 객체를 검색(LookUp)한다.
				 TV tv = (TV) container.getBean("tv");
			
				 
		// 스프링 컨테이너를 종료한다.  (컨테이너는 종료 직전에 자신이 생성한 객체들을 제거한다.)
				 tv.powerOn();
				 tv.powerOff();
				 tv.volumeUp();
				 tv.volumeDown();
				 
				 container.close();
	}

}
// 스프링컨테이너 설정할때 xml설정파일을 등록하여 로딩한다. xml파일을 통해서 스프링컨테이너가 동작한다. 