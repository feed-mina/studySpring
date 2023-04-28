package com.min.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


// serviceImpl 위에는 @Service , DAO 위에는 @repository , aroundadvice 객체를 @service 어노테이션을 id를 around로 줘서 bean 등록을 하지 않고 가능하게 해보자.

//@Service("around")

@Service
@Aspect // "컨테이너야 이 객체가 어스펙트야 " // Aspect = Pointcut + Advice 
public class AroundAdvice {
	
	
//	@Pointcut("execution(* com.min.biz..*Impl.*(..))") // 포인트컷 매소드를 생성
//	public void allPointcut() {}
//
//	
//	// 어드바이스 객체의 동작시점을 결정한다.
	@Around("PointcutCommon.allPointcut()") // 포인트컷 매소드() 괄호까지 어노테이션 안에 적는다. : '참조용 매소드'라고 부른다.
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{
		
		// ProceedingJoinPoint 포인트는 around 메서드만 가질 수 있다. 나머지는 JoinPoint를 받아야만 한다.
		
		// String method = jp.getSignature().getName(); // 비즈니스 메소드 이름을 알 수 있다.
		// String method = jp.getSignature().toLongString();
		String method = jp.getSignature().toShortString();
		
		Object obj = null;
		System.out.println("----[Before Logic]---"); 

		StopWatch watch = new StopWatch();
		watch.start();
		
		
		// 실질적으로 클라이언트가 호출한 비즈니스 메소드 실행
		obj = jp.proceed();
		
		watch.stop();
		System.out.println( method + "() 메소드 수행에 소요된 시간 :" + watch.getTotalTimeSeconds()); 
		return obj;
	}

}
