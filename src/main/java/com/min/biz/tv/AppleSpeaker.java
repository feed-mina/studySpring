package com.min.biz.tv;

import org.springframework.stereotype.Component;

// @Component 
public class AppleSpeaker implements Speaker {
	
	// 다형성은 스프링, 프레임워크를 이해하는데 기본이여야 한다. 
	// 인터페이스 상속 : Alt + Shift + T 키 > Extract Interface  
	
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 객체 생성");
	}
	public void volumeUp() {
		System.out.println("AppleSpeaker 소리 울리다." );
	}
	public void volumeDown() {
		System.out.println("AppleSpeaker 소리 내린다.");
	}
	
}
