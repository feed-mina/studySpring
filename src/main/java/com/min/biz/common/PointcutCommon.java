package com.min.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	@Pointcut("execution(* com.min.biz.board..*Impl.*(..))") // ����Ʈ�� �żҵ带 ����
	public void boardPointcut() {}
	
	@Pointcut("execution(* com.min.biz.user..*Impl.*(..))") // ����Ʈ�� �żҵ带 ����
	public void userPointcut() {}
	
	@Pointcut("execution(* com.min.biz..*Impl.*(..))") // ����Ʈ�� �żҵ带 ����
	public void allPointcut() {}
	
	@Pointcut("execution(* com.min.biz..*Impl.get*(..))") // ����Ʈ�� �żҵ带 ����
	public void getPointcut() {}
	
	
}


// com.min.biz.common ��Ű���� ������ > ctrl + shift + o �� ���� ������ import �κ��� �����Ѵ�.