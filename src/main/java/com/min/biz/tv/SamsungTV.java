package com.min.biz.tv;

public class SamsungTV implements TV {
	private int price; // price�� �ʱ�ȭ������ 0�̴�
	
	public SamsungTV() {
		System.out.println("=====> SamsungTV����");
	}
	
	public void �ɹ������ʱ�ȭ() {
		System.out.println("=====> �ɹ������ʱ�ȭ()");
		price = 1700000;
	}

	public void �ڿ�����() {
		System.out.println("=====> �ڿ�����()");
		price = 0;
	}
	public void powerOn() {
		System.out.println("Samsung TV ���� Ű��." + price);
	}
	public void powerOff() {
		System.out.println("Samsung TV ���� ����.");
	}
	
	public void volumeUp() {
		System.out.println("Samsung TV �Ҹ� �︮��." );
	}
	public void volumeDown() {
		System.out.println("Samsung TV �Ҹ� ������.");
	}
	

}
