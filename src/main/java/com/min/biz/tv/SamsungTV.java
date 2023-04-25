package com.min.biz.tv;

public class SamsungTV implements TV {
	private int price; // price는 초기화값으로 0이다
	
	public SamsungTV() {
		System.out.println("=====> SamsungTV생성");
	}
	
	public void 맴버변수초기화() {
		System.out.println("=====> 맴버변수초기화()");
		price = 1700000;
	}

	public void 자원해제() {
		System.out.println("=====> 자원해제()");
		price = 0;
	}
	public void powerOn() {
		System.out.println("Samsung TV 전원 키다." + price);
	}
	public void powerOff() {
		System.out.println("Samsung TV 전원 끄다.");
	}
	
	public void volumeUp() {
		System.out.println("Samsung TV 소리 울리다." );
	}
	public void volumeDown() {
		System.out.println("Samsung TV 소리 내린다.");
	}
	

}
