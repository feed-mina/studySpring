package com.min.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.min.biz.user.UserVO;
import com.min.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 인증처리");	
		
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");

	// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		
		// 3. 화면 네비게이션 (이동할 화면 정보를 ModelAndView 객체에 등록하여 리턴한다.)	
		ModelAndView mav = new ModelAndView();
		if(user != null){
			// 로그인 성공인경우 
			// HttpSession session = request.getSession();
			// session.setAttribute("user", user); 
			

			// 만약 여기에서 ViewResolver가 동작하다면 /WEB-INF/board/getBoardList.do.jsp 가 된다.
			// ViewResolver를 이용하지 않겠다는 표현으로 forward 나 redirect를 앞에 붙어야 한다 !! 
			// forward는 포워딩 방식으로 전환되서 속도는 빠르지만 url이 바뀌지 않는다. redirect는 url이 바뀌지만 두번의 요청과 두번의 응답이 필요한다.
			mav.setViewName("forward:getBoardList.do");
		}
		else{
			// 로그인 실패한 경우
			mav.setViewName("redirect:login.jsp");
		}	
		return mav;
		}

}
