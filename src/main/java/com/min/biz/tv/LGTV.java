package com.min.biz.tv;

public class LGTV implements TV {
	public LGTV() {
		System.out.println("=====>LGTV����");
	}
	public void powerOn() {
		System.out.println("LGTV ���� Ű��.");
	}
	public void powerOff() {
		System.out.println("LGTV ���� ����.");
	}
	public void volumeUp() {
		System.out.println("LGTV �Ҹ� �︮��.");
	}
	public void volumeDown() {
		System.out.println("LGTV �Ҹ� ������.");
	}

}
