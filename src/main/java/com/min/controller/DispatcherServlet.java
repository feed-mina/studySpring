package com.min.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// import org.springframework.web.servlet.HandlerMapping;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;
import com.min.biz.user.UserVO;
import com.min.biz.user.impl.UserDAO;
 
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DispatcherServlet() {
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
    	// 주어진 라이브러리를 쓰지 않고 HandlerMapping를 클래스로, Controller를 인터페이스로  직접 만드는 중
    	HandlerMapping mapper = new HandlerMapping();
    	Controller ctrl = mapper.getController(path);
    	
    	
    	// 3. 검색한 Controller를 실행한다.
    	String viewPage = ctrl.handleRequest(request, response);
    	
    	
    	
    	/// 4. Controller가 리턴한 화면으로 이동한다.
    	response.sendRedirect(viewPage);
	}
}


