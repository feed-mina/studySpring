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
		System.out.println("---> �α��� ȭ������ �̵�");
// Arithmetic Error �Ϻη� �߻� 
	//	System.out.println(9/0);
		vo.setId("aaa");
		vo.setPassword("aaa");
		return "login";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String Login(UserVO vo, UserDAO userDAO) {  
		System.out.println("---> �α��� ���� ó��");
		if(userDAO.getUser(vo) != null){ 
			// forward�� ������ ������� ��ȯ�Ǽ� �ӵ��� �������� url�� �ٲ��� �ʴ´�. redirect�� url�� �ٲ����� �ι��� ��û�� �ι��� ������ �ʿ��Ѵ�.
			return "forward:getBoardList.do";
		} // �α��� ������ ���
		else return "login";
	
		}

}
