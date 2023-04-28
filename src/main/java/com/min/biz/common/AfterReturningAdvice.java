package com.min.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.min.biz.user.UserVO;
@Service
@Aspect
public class AfterReturningAdvice {

//	@Pointcut("execution(* com.min.biz..*Impl.*(..))") // ����Ʈ�� �żҵ带 ����
//	public void getPointcut() {}	
//	
//	// ���ε� ������ �ݵ�� �����ؾ��Ѵ� ! 
//	
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp ,Object returnObj) {
		
		// �ٸ� �Ű������� ���� ����Ҷ� JoinPoint �� �� ù��° �Ű��������߸� �Ѵ�. 
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] �żҵ� ���� �� ����"); 
		System.out.println("[���� ó��] "+ method +"�޼ҵ� ���� �� : " + returnObj.toString()); 
		
		// ����Ͻ� �޼ҵ尡 ������ �����Ͱ� USERVO Ÿ���� ���������� Ȯ���Ѵ�.
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			
			
			// ���ϵ� UserVO ��ü�� role �������� ADMIN���� Ȯ���Ѵ�.
			if(user.getRole().equals("ADMIN")) {
				System.out.println(user.getRole() + "�����ڴ� ȯ���մϴ�."); 
			}
		}
		
		}
}
