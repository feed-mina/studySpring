package com.min.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


// serviceImpl ������ @Service , DAO ������ @repository , aroundadvice ��ü�� @service ������̼��� id�� around�� �༭ bean ����� ���� �ʰ� �����ϰ� �غ���.

//@Service("around")

@Service
@Aspect // "�����̳ʾ� �� ��ü�� ���Ʈ�� " // Aspect = Pointcut + Advice 
public class AroundAdvice {
	
	
//	@Pointcut("execution(* com.min.biz..*Impl.*(..))") // ����Ʈ�� �żҵ带 ����
//	public void allPointcut() {}
//
//	
//	// �����̽� ��ü�� ���۽����� �����Ѵ�.
	@Around("PointcutCommon.allPointcut()") // ����Ʈ�� �żҵ�() ��ȣ���� ������̼� �ȿ� ���´�. : '������ �żҵ�'��� �θ���.
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{
		
		// ProceedingJoinPoint ����Ʈ�� around �޼��常 ���� �� �ִ�. �������� JoinPoint�� �޾ƾ߸� �Ѵ�.
		
		// String method = jp.getSignature().getName(); // ����Ͻ� �޼ҵ� �̸��� �� �� �ִ�.
		// String method = jp.getSignature().toLongString();
		String method = jp.getSignature().toShortString();
		
		Object obj = null;
		System.out.println("----[Before Logic]---"); 

		StopWatch watch = new StopWatch();
		watch.start();
		
		
		// ���������� Ŭ���̾�Ʈ�� ȣ���� ����Ͻ� �޼ҵ� ����
		obj = jp.proceed();
		
		watch.stop();
		System.out.println( method + "() �޼ҵ� ���࿡ �ҿ�� �ð� :" + watch.getTotalTimeSeconds()); 
		return obj;
	}

}
