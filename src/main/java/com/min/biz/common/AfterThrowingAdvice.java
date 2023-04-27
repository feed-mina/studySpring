package com.min.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;


public class AfterThrowingAdvice {

	public void exceptionLog(JoinPoint jp , Exception exceptionObj) {
		
		String method = jp.getSignature().getName();
		
		System.out.println("[예외 처리] " + method +"() 메소드 수행 중 예외 발생"); 
	//	System.out.println("[예외 처리] 비즈니스 메소드 리턴 값 : " + exceptionObj.toString()); 
		
		// 발생된 예외의 타입에 따른 분기처리
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("[0]번 글은 등록 할 수 없습니다"); 
		} else if (exceptionObj instanceof ArrayStoreException) {
			System.out.println("0으로 숫자를 나눌 수는 없습니다."); 
				
		} else if (exceptionObj instanceof SQLException) {
			System.out.println("SQL 오류"); 
		} else {
			System.out.println("원인을 모르는 오류"); 
		}
		
		}
}
