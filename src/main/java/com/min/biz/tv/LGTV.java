package com.min.biz.tv;

public class LGTV implements TV {
	public LGTV() {
		System.out.println("=====>LGTV생성");
	}
	public void powerOn() {
		System.out.println("LGTV 전원 키다.");
	}
	public void powerOff() {
		System.out.println("LGTV 전원 끄다.");
	}
	public void volumeUp() {
		System.out.println("LGTV 소리 울리다.");
	}
	public void volumeDown() {
		System.out.println("LGTV 소리 내린다.");
	}

}
