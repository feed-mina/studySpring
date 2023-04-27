package com.min.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


// serviceImpl ������ @Service , DAO ������ @repository , aroundadvice ��ü�� @service ������̼��� id�� around�� �༭ bean ����� ���� �ʰ� �����ϰ� �غ���.

@Service("around")
public class AroundAdvice {

	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{
		Object obj = null;
		System.out.println("----[Before Logic]---"); 

		StopWatch watch = new StopWatch();
		watch.start();
		
		
		// ���������� Ŭ���̾�Ʈ�� ȣ���� ����Ͻ� �޼ҵ� ����
		obj = jp.proceed();
		
		watch.stop();
		System.out.println("����Ͻ� �޼ҵ� ���࿡ �ҿ�� �ð� :" + watch.getTotalTimeSeconds()); 
		return obj;
	}

}
