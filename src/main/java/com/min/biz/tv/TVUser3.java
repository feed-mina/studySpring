package com.min.biz.tv;

import org.springframework.context.support.GenericXmlApplicationContext;


public class TVUser3 {
	
	public static void main(String[] args) {
	
		// ������ ����: �ڹ� �ҽ��� ��ü ���� <----> ������ (IoC) : �����̳ʿ� �÷��� ���� 
//		TV tv1 = new SamsungTV();
//		TV tv2 = new SamsungTV();
//		TV tv3 = new SamsungTV();
//		
//		TV tv2 = tv1;
//		TV tv3 = tv2;
//	
		
		// 1. ������ �����̳ʸ� ����(����)�Ѵ�.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. ������ �����̳ʷκ��� �׽�Ʈ�� ��ü�� �˻�(LookUp)�Ѵ�.
	
		TV tv1 = (TV) container.getBean("tv");
		TV tv2 = (TV) container.getBean("tv");
		TV tv3 = (TV) container.getBean("tv");
		
		System.out.println(tv1.toString());
		System.out.println(tv2.toString());
		System.out.println(tv3.toString());
		
		// �ϳ��� Ŭ�������� �������� ��ü�� ������ �ʰ� ���ü�� �ν��Ͻ� �ּҸ� �ϳ��� ������� �ּҸ� �����ؼ� �����Ѵ�.
		
		// �̱��� ������ �����ϰ� �ȴ�. scope = singleton (default)
		
	}

}
