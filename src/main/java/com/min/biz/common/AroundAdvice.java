package com.min.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


// serviceImpl 위에는 @Service , DAO 위에는 @repository , aroundadvice 객체를 @service 어노테이션을 id를 around로 줘서 bean 등록을 하지 않고 가능하게 해보자.

@Service("around")
public class AroundAdvice {

	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{
		Object obj = null;
		System.out.println("----[Before Logic]---"); 

		StopWatch watch = new StopWatch();
		watch.start();
		
		
		// 실질적으로 클라이언트가 호출한 비즈니스 메소드 실행
		obj = jp.proceed();
		
		watch.stop();
		System.out.println("비즈니스 메소드 수행에 소요된 시간 :" + watch.getTotalTimeSeconds()); 
		return obj;
	}

}
