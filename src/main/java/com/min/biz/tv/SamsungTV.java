package com.min.biz.tv;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	// 다형성을 기준으로 클래스를 계층 구조화 한다.
	// private SonySpeaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("=====> SamsungTV (1)생성");
	}
	// alt + shift + s > generate Constructor using field

	// 원래는 매개변수를 적용한 매서드를 인식할 수 없다. 하지만 만약 SonySpeaker 객체를 매개변수로 받아서 초기화한 값을 적용할 수 있다면?
	public SamsungTV(Speaker speaker) {

		System.out.println("=====> SamsungTV (2)생성");
		this.speaker = speaker;
	}
	
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("=====> SamsungTV (3)생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("Samsung TV 전원 키다." + price);
	}
	public void powerOff() {
		System.out.println("Samsung TV 전원 끄다.");
	}
	
	public void volumeUp() {
		// speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	public void volumeDown() {
		// speaker = new SonySpeaker();
		speaker.volumeDown();
	}
	
	
//	Exception in thread "main" java.lang.NullPointerException => SonySpeaker 객체 할당 => volumeUp, volumeDown 매서드에 SonySpeaker 객체 할당 => 메모리 낭비 
// 및 유지보수할때 sonyspeaker을 사용하지 않고 다른 speaker을 사용하게 될때 관련된 소스를 변경하기가 어렵다. (의존성이 생겼기 때문에) ==> Constructor injection(생성자 인젝션)으로 깔끔하게 해결할 수 있다.
//	at com.min.biz.tv.SamsungTV.volumeUp(SamsungTV.java:26)
//	at com.min.biz.tv.TVUser.main(TVUser.java:31)


}
