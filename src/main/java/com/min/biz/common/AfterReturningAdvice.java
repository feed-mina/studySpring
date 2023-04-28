package com.min.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.min.biz.user.UserVO;
@Service
@Aspect
public class AfterReturningAdvice {

//	@Pointcut("execution(* com.min.biz..*Impl.*(..))") // 포인트컷 매소드를 생성
//	public void getPointcut() {}	
//	
//	// 바인딩 변수를 반드시 맵핑해야한다 ! 
//	
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp ,Object returnObj) {
		
		// 다른 매개변수와 같이 사용할때 JoinPoint 는 꼭 첫번째 매개변수여야만 한다. 
		String method = jp.getSignature().getName();
		
		System.out.println("[사후 처리] 매소드 수행 후 동작"); 
		System.out.println("[사후 처리] "+ method +"메소드 리턴 값 : " + returnObj.toString()); 
		
		// 비즈니스 메소드가 리턴한 데이터가 USERVO 타입의 데이터인지 확인한다.
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			
			
			// 리턴된 UserVO 객체의 role 변수값이 ADMIN인지 확인한다.
			if(user.getRole().equals("ADMIN")) {
				System.out.println(user.getRole() + "관리자님 환영합니다."); 
			}
		}
		
		}
}
