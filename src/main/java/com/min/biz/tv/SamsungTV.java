package com.min.biz.tv;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("=====> SamsungTV����");
	}
	public void powerOn() {
		System.out.println("Samsung TV ���� Ű��.");
	}
	public void powerOff() {
		System.out.println("Samsung TV ���� ����.");
	}
	public void volumeUp() {
		System.out.println("Samsung TV �Ҹ� �︮��.");
	}
	public void volumeDown() {
		System.out.println("Samsung TV �Ҹ� ������.");
	}

}
