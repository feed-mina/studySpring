package com.min.biz.common;

import java.sql.SQLException;

public class AfterThrowingAdvice {

	public void exceptionLog(Exception exceptionObj) {
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ���� �߻�"); 
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
