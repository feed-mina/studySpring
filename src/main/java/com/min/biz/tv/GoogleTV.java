package com.min.biz.tv;

public class GoogleTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public GoogleTV() {
		System.out.println("=====> GoogleTV����");
	}
	// alt + shift + s
	// generate getter and setter
	
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("=====> setSpeaker()");
		this.speaker = speaker;
	}


	public void setPrice(int price) {

		System.out.println("=====> setPrice()");
		this.price = price;
	}


	public void powerOn() {
		System.out.println("GoogleTV ���� Ű��." + price);
	}
	public void powerOff() {
		System.out.println("GoogleTV ���� ����.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}

}
