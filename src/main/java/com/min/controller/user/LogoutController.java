package com.min.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("�α׾ƿ� ó��");	
		
		// �α׾ƿ��� ��û�� �������� ���ε� ���� ��ü�� ȹ���Ѵ�.
		// ȹ���� ������ ���������ϰ� ���� �������� �̵��Ѵ�.
		HttpSession session = request.getSession();
		session.invalidate();
		// 2. ���� ���� �� ���� ȭ������ �̵��Ѵ�.
		
		return "login.jsp";
	}

}
