package com.min.biz.tv;

public interface Speaker {

	// 다형성은 스프링, 프레임워크를 이해하는데 기본이여야 한다. 
	// 인터페이스 상속 : Alt + Shift + T 키 > Extract Interface  
	void volumeUp();

	void volumeDown();

}