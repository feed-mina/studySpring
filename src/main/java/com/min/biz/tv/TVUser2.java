package com.min.biz.tv;

import org.springframework.context.support.GenericXmlApplicationContext;

// ������ = ��� + Overriding + ����ȯ
// 1. ��� �������̽��϶� implements, class��� extends�� ����Ѵ�.
// 2. �ٸ� Ŭ�������� �����ϰ� �ż��带 ���� �������̵��Ѵ�.
// 3. ������ ����ȯ : �ڽİ�ü�� �θ�Ÿ�� ��ü�� �Ҵ��ϴ°� (����� ���θ���̶� �θ���.)
// �������� ����ϴ� ���� : ���������� �������� ������ !
// ���������� ���Ϸ��� �������� ����ؾ� �Ѵ�.

public class TVUser2 {
	
	public static void main(String[] args) {
	
		// 1. ������ �����̳ʸ� ����(����)�Ѵ�.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. ������ �����̳ʷκ��� �׽�Ʈ�� ��ü�� �˻�(LookUp)�Ѵ�.
		
		TV tv = (TV) container.getBean("tv");
		// TV tv = (TV) container.getBean("com.min.biz.tv.LGTV#0");
		 tv.powerOn();
		 tv.powerOff();
		 tv.volumeUp();
		 tv.volumeDown();
		 // 3. ������ �����̳ʸ� �����Ѵ�. (�����̳ʴ� ���� ������ �ڽ��� ������ ��ü���� �����Ѵ�.)
		 container.close();
	}

}
