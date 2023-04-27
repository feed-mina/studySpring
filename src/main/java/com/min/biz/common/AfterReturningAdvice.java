package com.min.biz.common;

import com.min.biz.user.UserVO;

public class AfterReturningAdvice {

	public void afterLog(Object returnObj) {
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 동작"); 
		System.out.println("[사후 처리] 비즈니스 메소드 리턴 값 : " + returnObj.toString()); 
		
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
