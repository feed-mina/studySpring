package com.min.biz.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {

	// ���� �и� - ��ü������
	// �ż��帶�� ���� ó���� ����� �ϴ� �κ��� �и��ؼ� �����ϰ� �ٲ� �� �ִ�.
	// ��ü�� �ٸ� ��ü�� �ٲٰų�, �ż��� �̸��� �ٲ�ٸ� ��� ���������� �� �� ������?
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ����"); 
		System.out.println("[���� ó��] " + method + "()�޼ҵ� ARGS" + args[0].toString()); 
		}
}
