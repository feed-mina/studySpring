package com.min.biz.tv;

import org.springframework.beans.factory.annotation.Autowired;

public class GoogleTV implements TV {
	
	
	@Autowired
	// ������ ���Ը� @Autowired�� ���� type injection�� �Ѵ�. 
	// �������� �������� xml�� ��ϵ� bean �±��� Ŭ���� �� �ٲٸ� �ȴ�. 
	private Speaker speaker;
	private int price;
	
	public GoogleTV() {
		System.out.println("=====> GoogleTV����");
	}
	// alt + shift + s
	// generate getter and setter
	
	
	/* block command ctrl+shift + /
	 * public void setSpeaker(Speaker speaker) {
	 * System.out.println("=====> setSpeaker()"); this.speaker = speaker; }
	 * 
	 * 
	 * public void setPrice(int price) {
	 * 
	 * System.out.println("=====> setPrice()"); this.price = price; }
	 */

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
