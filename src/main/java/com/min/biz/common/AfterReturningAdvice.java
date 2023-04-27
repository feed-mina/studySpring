package com.min.biz.common;

import org.aspectj.lang.JoinPoint;

import com.min.biz.user.UserVO;

public class AfterReturningAdvice {

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
