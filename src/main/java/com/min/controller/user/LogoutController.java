package com.min.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("로그아웃 처리");	
		
		// 로그아웃을 요청한 브라우저와 매핑된 세션 객체를 획득한다.
		// 획득한 세션을 강제종료하고 메인 페이지로 이동한다.
		HttpSession session = request.getSession();
		session.invalidate();
		// 2. 세션 종료 후 메인 화면으로 이동한다.
		// 3. 화면 네비게이션 (이동할 화면 정보를 ModelAndView 객체에 등록하여 리턴한다.)	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav; 
	}

}
