package com.min.biz.tv;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("=====> SamsungTV생성");
	}
	public void powerOn() {
		System.out.println("Samsung TV 전원 키다.");
	}
	public void powerOff() {
		System.out.println("Samsung TV 전원 끄다.");
	}
	public void volumeUp() {
		System.out.println("Samsung TV 소리 울리다.");
	}
	public void volumeDown() {
		System.out.println("Samsung TV 소리 내린다.");
	}

}
