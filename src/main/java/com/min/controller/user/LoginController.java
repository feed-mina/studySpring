package com.min.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.min.biz.user.UserVO;
import com.min.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("---> 로그인 화면으로 이동");
// Arithmetic Error 일부러 발생 
	//	System.out.println(9/0);
		vo.setId("aaa");
		vo.setPassword("aaa");
		return "login";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String Login(UserVO vo, UserDAO userDAO) {  
		System.out.println("---> 로그인 인증 처리");
		if(userDAO.getUser(vo) != null){ 
			// forward는 포워딩 방식으로 전환되서 속도는 빠르지만 url이 바뀌지 않는다. redirect는 url이 바뀌지만 두번의 요청과 두번의 응답이 필요한다.
			return "forward:getBoardList.do";
		} // 로그인 실패한 경우
		else return "login";
	
		}

}
