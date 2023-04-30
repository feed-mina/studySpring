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
		System.out.println("�α��� ����ó��");	
		
		// 1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");

	// 2. DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		
		// 3. ȭ�� �׺���̼� (�̵��� ȭ�� ������ ModelAndView ��ü�� ����Ͽ� �����Ѵ�.)	
		ModelAndView mav = new ModelAndView();
		if(user != null){
			// �α��� �����ΰ�� 
			// HttpSession session = request.getSession();
			// session.setAttribute("user", user); 
			

			// ���� ���⿡�� ViewResolver�� �����ϴٸ� /WEB-INF/board/getBoardList.do.jsp �� �ȴ�.
			// ViewResolver�� �̿����� �ʰڴٴ� ǥ������ forward �� redirect�� �տ� �پ�� �Ѵ� !! 
			// forward�� ������ ������� ��ȯ�Ǽ� �ӵ��� �������� url�� �ٲ��� �ʴ´�. redirect�� url�� �ٲ����� �ι��� ��û�� �ι��� ������ �ʿ��Ѵ�.
			mav.setViewName("forward:getBoardList.do");
		}
		else{
			// �α��� ������ ���
			mav.setViewName("redirect:login.jsp");
		}	
		return mav;
		}

}
