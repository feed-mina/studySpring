package com.min.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DispatcherServlet() {
    	System.out.println("===> DispatcherServlet 생성");
    }
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("===> service() 실행");		
    	// 1. 사용자 요청 path 정보 추출한다.
    	String uri = request.getRequestURI();
    	System.out.println("uri:" + uri);		
    	String path = uri.substring(uri.lastIndexOf("/"));
    	System.out.println("PATH : " + path);		
    	
    	
    	// 2. 추출된 path 에 따라  요청을 분기처리한다.
    	if(path.equals("/login.do")) {
    		System.out.println("로그인 인증처리");	
    	} else if(path.equals("/logout.do")) {

    		System.out.println("로그아웃 처리");	
    	} else if(path.equals("/insertBoard.do")) {

    		System.out.println("글등록 ");	
    	} else if(path.equals("/updateBoard.do")) {

    		System.out.println("글수정");	
    	} else if(path.equals("/deleteBoard.do")) {

    		System.out.println("글 삭제");	
    	} else if(path.equals("/getBoard.do")) {

    		System.out.println("글 상세 조회");	
    	} else if(path.equals("/getBoardList.do")) {

    		System.out.println("글 목록 검색처리");	
    	}  else {
    		System.out.println("URL 요청을 다시 확인해주세요.");
    	}
    	
	}
}

// 반드시 서버를 끄고 다시 실행해야 한다. ->  톰켓서버를 다시 실행해야 web.xml의 서블릿 컨테이너를 다시 실행 할 수 있기 때문이다.
//
