package com.min.biz.tv;

public class GoogleTV implements TV {
	public GoogleTV() {
		System.out.println("=====> GoogleTV생성");
	}
	public void powerOn() {
		System.out.println("GoogleTV 전원 키다.");
	}
	public void powerOff() {
		System.out.println("GoogleTV 전원 끄다.");
	}
	public void volumeUp() {
		System.out.println("GoogleTV 소리 울리다.");
	}
	public void volumeDown() {
		System.out.println("GoogleTV 소리 내린다.");
	}

}
