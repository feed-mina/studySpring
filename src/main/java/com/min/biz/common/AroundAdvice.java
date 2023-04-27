package com.min.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;


// serviceImpl 위에는 @Service , DAO 위에는 @repository , aroundadvice 객체를 @service 어노테이션을 id를 around로 줘서 bean 등록을 하지 않고 가능하게 해보자.

@Service("around")
public class AroundAdvice {

	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{
		Object obj = null;
		System.out.println("----[Before Logic]---"); 

		// 실질적으로 클라이언트가 호출한 비즈니스 메소드 실행
		obj = jp.proceed();
		
		System.out.println("----[After Logic]---"); 
		return obj;
	}

}
