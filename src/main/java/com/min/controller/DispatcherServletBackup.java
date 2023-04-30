package com.min.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class DispatcherServletBackup extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DispatcherServletBackup() {
    	System.out.println("===> DispatcherServlet 생성");
    }
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		
		System.out.println("===> service() 실행");		
    	// 1. 사용자 요청 path 정보 추출한다.
    	String uri = request.getRequestURI();
    	System.out.println("uri:" + uri);		
    	String path = uri.substring(uri.lastIndexOf("/"));
    	System.out.println("PATH : " + path);		
    	
    	
    	// 2. 추출된 path 에 따라  요청을 분기처리한다.
    	if(path.equals("/login.do")) { 
    		
    	} else if(path.equals("/logout.do")) {
    		
    	} else if(path.equals("/insertBoard.do")) { 
    		
    	} else if(path.equals("/updateBoard.do")) {

    	} else if(path.equals("/deleteBoard.do")) {

    	} else if(path.equals("/getBoard.do")) { 
    		
    	} else if(path.equals("/getBoardList.do")) {

    	}  else {
    		System.out.println("URL 요청을 다시 확인해주세요.");
    	}
    	
	}
}

// 반드시 서버를 끄고 다시 실행해야 한다. ->  톰켓서버를 다시 실행해야 web.xml의 서블릿 컨테이너를 다시 실행 할 수 있기 때문이다.
//
