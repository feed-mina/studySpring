package com.min.biz.tv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// ��ġ xml���� <bean class="com.min.biz.tv.LGTV#0"/> �� ����ѰͰ� @Component ����� ���� ������ �Ѵ�.
// Ŭ���� �̸��� �����Ҷ� ������Ʈ�� �ν��ϸ� �Ǳ� ������ xml�� ���� �������� �ʾƵ� �Ǵ� ������ �ִ�.
// Ŭ������ �̸��� �������� ù���ڸ� �ҹ��ڷ� �����Ͽ� id�� �ν��Ѵ�.
// ���࿡ class�̸��� ������ ���,  @("id�̸�")�� ���� ������ �� �ִ�.
// @Component("tv")

// @Component("tv")
public class LGTV implements TV {
	
	@Autowired // 3. Type injection�̶�� �θ���.
//	@Qualifier("sonySpeaker") 
	private Speaker speaker;
	
	
	
//	public LGTV(SonySpeaker speaker) {
//		super();
//		this.speaker = speaker;
//	}

// 1. constructor injection : ������ ������

//	public void setSpeaker(SonySpeaker speaker) {
//		this.speaker = speaker;
//	}
// 2. setter injection 	
// ������ �������̳� setter injection�� ����Ϸ��� xml���������� ������ �ʿ䰡 �ִ�.
// ������ �������� xml�������� Constructor-args �±׸� ����ϰ� setter �������� ����Ϸ��� property �±׸� ���
	
// @Autowired ������ ����ؼ� ������ �������̳� setter injection�� ��� �� �� �ִ�. �ַ� ���� ���� �����Ͽ� ��ü�� ��ü�� �ڵ����� �����ش�.
	

// speaker�� ������ �ٲ𶧸��� �ڹټҽ��� �������� �ʰ� �������� ���� �� �� �ִ� ����� �������� �ִ�.
// speaker�� ���� Ÿ���� ��� speaker�� �ֻ��� �θ�Ÿ���� speaker �������̽� Ÿ������ ����ϸ� �������� �������� ������ ���� �ʾƵ� �ȴ�.
// ������ 3���� : 1. ��� , 2. �ż��� �������̵� , 3. �ڽ� ��ü�� �Ҵ�(auto wired) ������ ����ȯ	
// �����̳ʴ� ������ ��������(meta data)�� �����Ͽ�  �����ϱ� ������
// 
	
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
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}

}

// @component ������Ʈ�� �� ������̼����� ������ Ŭ������ context:component-scan �±׸� ����ؼ� �߰��ϰ� ����Ҽ��ִ�.
// ������Ʈ ������̼��� �̿��� ��ü�� ����Ҷ��� default �����ڸ� ����ϱ� ������  ��������� �ʱ�ȭ�� �Ǽ� null point ������ ����.
// �̶� alt + shift + s ����Ű�� ������ (constructor)�� �߰��ϰų� , generate getter setter�� ����ؼ� setter �ż��带 ����Ѵ�.
