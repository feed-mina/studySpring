package com.min.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DispatcherServlet() {
    	System.out.println("===> DispatcherServlet ����");
    }
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("===> service() ����");		
    	// 1. ����� ��û path ���� �����Ѵ�.
    	String uri = request.getRequestURI();
    	System.out.println("uri:" + uri);		
    	String path = uri.substring(uri.lastIndexOf("/"));
    	System.out.println("PATH : " + path);		
    	
    	
    	// 2. ����� path �� ����  ��û�� �б�ó���Ѵ�.
    	if(path.equals("/login.do")) {
    		System.out.println("�α��� ����ó��");	
    	} else if(path.equals("/logout.do")) {

    		System.out.println("�α׾ƿ� ó��");	
    	} else if(path.equals("/insertBoard.do")) {

    		System.out.println("�۵�� ");	
    	} else if(path.equals("/updateBoard.do")) {

    		System.out.println("�ۼ���");	
    	} else if(path.equals("/deleteBoard.do")) {

    		System.out.println("�� ����");	
    	} else if(path.equals("/getBoard.do")) {

    		System.out.println("�� �� ��ȸ");	
    	} else if(path.equals("/getBoardList.do")) {

    		System.out.println("�� ��� �˻�ó��");	
    	}  else {
    		System.out.println("URL ��û�� �ٽ� Ȯ�����ּ���.");
    	}
    	
	}
}

// �ݵ�� ������ ���� �ٽ� �����ؾ� �Ѵ�. ->  ���ϼ����� �ٽ� �����ؾ� web.xml�� ���� �����̳ʸ� �ٽ� ���� �� �� �ֱ� �����̴�.
//
