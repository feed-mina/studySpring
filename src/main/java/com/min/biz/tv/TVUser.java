package com.min.biz.tv;

import org.springframework.context.support.GenericXmlApplicationContext;

// ������ = ��� + Overriding + ����ȯ


public class TVUser {
	
	public static void main(String[] args) {
		// 1. ������ �����̳ʸ� ����(����)�Ѵ�.
				GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
				
		// 2. ������ �����̳ʷκ��� �׽�Ʈ�� ��ü�� �˻�(LookUp)�Ѵ�.
				 TV tv = (TV) container.getBean("tv");
			
				 
		// ������ �����̳ʸ� �����Ѵ�.  (�����̳ʴ� ���� ������ �ڽ��� ������ ��ü���� �����Ѵ�.)
				 tv.powerOn();
				 tv.powerOff();
				 tv.volumeUp();
				 tv.volumeDown();
				 
				 container.close();
	}

}
// �����������̳� �����Ҷ� xml���������� ����Ͽ� �ε��Ѵ�. xml������ ���ؼ� �����������̳ʰ� �����Ѵ�. 