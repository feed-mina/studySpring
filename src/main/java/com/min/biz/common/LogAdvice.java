package com.min.biz.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {

	// 관심 분리 - 객체지향언어
	// 매서드마다 사전 처리로 적어야 하는 부분을 분리해서 간편하게 바꿀 수 있다.
	// 객체가 다른 객체로 바꾸거나, 매서드 이름이 바뀐다면 어떻게 유지보수를 할 수 있을까?
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리] 비즈니스 로직 수행 전 동작"); 
		System.out.println("[사전 처리] " + method + "()메소드 ARGS" + args[0].toString()); 
		}
}
