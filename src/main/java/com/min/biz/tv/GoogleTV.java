package com.min.biz.tv;

public class GoogleTV implements TV {
	public GoogleTV() {
		System.out.println("=====> GoogleTV����");
	}
	public void powerOn() {
		System.out.println("GoogleTV ���� Ű��.");
	}
	public void powerOff() {
		System.out.println("GoogleTV ���� ����.");
	}
	public void volumeUp() {
		System.out.println("GoogleTV �Ҹ� �︮��.");
	}
	public void volumeDown() {
		System.out.println("GoogleTV �Ҹ� ������.");
	}

}
