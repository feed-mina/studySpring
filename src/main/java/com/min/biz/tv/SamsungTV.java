package com.min.biz.tv;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	// �������� �������� Ŭ������ ���� ����ȭ �Ѵ�.
	// private SonySpeaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("=====> SamsungTV (1)����");
	}
	// alt + shift + s > generate Constructor using field

	// ������ �Ű������� ������ �ż��带 �ν��� �� ����. ������ ���� SonySpeaker ��ü�� �Ű������� �޾Ƽ� �ʱ�ȭ�� ���� ������ �� �ִٸ�?
	public SamsungTV(Speaker speaker) {

		System.out.println("=====> SamsungTV (2)����");
		this.speaker = speaker;
	}
	
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("=====> SamsungTV (3)����");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("Samsung TV ���� Ű��." + price);
	}
	public void powerOff() {
		System.out.println("Samsung TV ���� ����.");
	}
	
	public void volumeUp() {
		// speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	public void volumeDown() {
		// speaker = new SonySpeaker();
		speaker.volumeDown();
	}
	
	
//	Exception in thread "main" java.lang.NullPointerException => SonySpeaker ��ü �Ҵ� => volumeUp, volumeDown �ż��忡 SonySpeaker ��ü �Ҵ� => �޸� ���� 
// �� ���������Ҷ� sonyspeaker�� ������� �ʰ� �ٸ� speaker�� ����ϰ� �ɶ� ���õ� �ҽ��� �����ϱⰡ ��ƴ�. (�������� ����� ������) ==> Constructor injection(������ ������)���� ����ϰ� �ذ��� �� �ִ�.
//	at com.min.biz.tv.SamsungTV.volumeUp(SamsungTV.java:26)
//	at com.min.biz.tv.TVUser.main(TVUser.java:31)


}
