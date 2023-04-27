package com.min.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;


public class AfterThrowingAdvice {

	public void exceptionLog(JoinPoint jp , Exception exceptionObj) {
		
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] " + method +"() �޼ҵ� ���� �� ���� �߻�"); 
	//	System.out.println("[���� ó��] ����Ͻ� �޼ҵ� ���� �� : " + exceptionObj.toString()); 
		
		// �߻��� ������ Ÿ�Կ� ���� �б�ó��
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("[0]�� ���� ��� �� �� �����ϴ�"); 
		} else if (exceptionObj instanceof ArrayStoreException) {
			System.out.println("0���� ���ڸ� ���� ���� �����ϴ�."); 
				
		} else if (exceptionObj instanceof SQLException) {
			System.out.println("SQL ����"); 
		} else {
			System.out.println("������ �𸣴� ����"); 
		}
		
		}
}
