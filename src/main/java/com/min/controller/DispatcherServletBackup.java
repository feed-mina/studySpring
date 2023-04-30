package com.min.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class DispatcherServletBackup extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DispatcherServletBackup() {
    	System.out.println("===> DispatcherServlet ����");
    }
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		
		System.out.println("===> service() ����");		
    	// 1. ����� ��û path ���� �����Ѵ�.
    	String uri = request.getRequestURI();
    	System.out.println("uri:" + uri);		
    	String path = uri.substring(uri.lastIndexOf("/"));
    	System.out.println("PATH : " + path);		
    	
    	
    	// 2. ����� path �� ����  ��û�� �б�ó���Ѵ�.
    	if(path.equals("/login.do")) { 
    		
    	} else if(path.equals("/logout.do")) {
    		
    	} else if(path.equals("/insertBoard.do")) { 
    		
    	} else if(path.equals("/updateBoard.do")) {

    	} else if(path.equals("/deleteBoard.do")) {

    	} else if(path.equals("/getBoard.do")) { 
    		
    	} else if(path.equals("/getBoardList.do")) {

    	}  else {
    		System.out.println("URL ��û�� �ٽ� Ȯ�����ּ���.");
    	}
    	
	}
}

// �ݵ�� ������ ���� �ٽ� �����ؾ� �Ѵ�. ->  ���ϼ����� �ٽ� �����ؾ� web.xml�� ���� �����̳ʸ� �ٽ� ���� �� �� �ֱ� �����̴�.
//
