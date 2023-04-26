package com.min.biz.tv;

import org.springframework.beans.factory.annotation.Autowired;

public class GoogleTV implements TV {
	
	
	@Autowired
	// 의존성 주입만 @Autowired를 통해 type injection을 한다. 
	// 유지보수 과정에서 xml에 등록된 bean 태그의 클래스 명만 바꾸면 된다. 
	private Speaker speaker;
	private int price;
	
	public GoogleTV() {
		System.out.println("=====> GoogleTV생성");
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
		System.out.println("GoogleTV 전원 키다." + price);
	}
	public void powerOff() {
		System.out.println("GoogleTV 전원 끄다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}

}
