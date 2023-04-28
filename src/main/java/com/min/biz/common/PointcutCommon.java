package com.min.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	@Pointcut("execution(* com.min.biz.board..*Impl.*(..))") // 포인트컷 매소드를 생성
	public void boardPointcut() {}
	
	@Pointcut("execution(* com.min.biz.user..*Impl.*(..))") // 포인트컷 매소드를 생성
	public void userPointcut() {}
	
	@Pointcut("execution(* com.min.biz..*Impl.*(..))") // 포인트컷 매소드를 생성
	public void allPointcut() {}
	
	@Pointcut("execution(* com.min.biz..*Impl.get*(..))") // 포인트컷 매소드를 생성
	public void getPointcut() {}
	
	
}


// com.min.biz.common 패키지를 누르고 > ctrl + shift + o 를 같이 누르면 import 부분을 정리한다.