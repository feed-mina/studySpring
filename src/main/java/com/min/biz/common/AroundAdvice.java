package com.min.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;


// serviceImpl ������ @Service , DAO ������ @repository , aroundadvice ��ü�� @service ������̼��� id�� around�� �༭ bean ����� ���� �ʰ� �����ϰ� �غ���.

@Service("around")
public class AroundAdvice {

	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{
		Object obj = null;
		System.out.println("----[Before Logic]---"); 

		// ���������� Ŭ���̾�Ʈ�� ȣ���� ����Ͻ� �޼ҵ� ����
		obj = jp.proceed();
		
		System.out.println("----[After Logic]---"); 
		return obj;
	}

}
