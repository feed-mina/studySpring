package com.min.biz.common;

import com.min.biz.user.UserVO;

public class AfterReturningAdvice {

	public void afterLog(Object returnObj) {
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ����"); 
		System.out.println("[���� ó��] ����Ͻ� �޼ҵ� ���� �� : " + returnObj.toString()); 
		
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
