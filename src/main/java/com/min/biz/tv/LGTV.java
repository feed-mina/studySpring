package com.min.biz.tv;

import org.springframework.stereotype.Component;

// ��ġ xml���� <bean class="com.min.biz.tv.LGTV#0"/> �� ����ѰͰ� @Component ����� ���� ������ �Ѵ�.
// Ŭ���� �̸��� �����Ҷ� ������Ʈ�� �ν��ϸ� �Ǳ� ������ xml�� ���� �������� �ʾƵ� �Ǵ� ������ �ִ�.
// Ŭ������ �̸��� �������� ù���ڸ� �ҹ��ڷ� �����Ͽ� id�� �ν��Ѵ�.
// ���࿡ class�̸��� ������ ���,  @("id�̸�")�� ���� ������ �� �ִ�.
// @Component("tv")

@Component("tv")
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

// @component ������Ʈ�� �� ������̼����� ������ Ŭ������ context:component-scan �±׸� ����ؼ� �߰��ϰ� ����Ҽ��ִ�.