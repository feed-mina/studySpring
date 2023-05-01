package com.min.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.min.biz.user.UserVO;
import com.min.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	@RequestMapping("/login.do")
	public String Login(UserVO vo, UserDAO userDAO) {
		System.out.println("�α��� ����ó��");	
//		
//		// 1. ����� �Է� ���� ����
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//	// 2. DB ���� ó�� 
//		vo.setId(id);
//		vo.setPassword(password); 
//		UserVO user = userDAO.getUser(vo);
//		
		
		// 3. ȭ�� �׺���̼� (�̵��� ȭ�� ������ ModelAndView ��ü�� ����Ͽ� �����Ѵ�.)	
		if(userDAO.getUser(vo) != null){
			// �α��� �����ΰ�� 
			// HttpSession session = request.getSession();
			// session.setAttribute("user", user); 
			

			// ���� ���⿡�� ViewResolver�� �����ϴٸ� /WEB-INF/board/getBoardList.do.jsp �� �ȴ�.
			// ViewResolver�� �̿����� �ʰڴٴ� ǥ������ forward �� redirect�� �տ� �پ�� �Ѵ� !! 
			// forward�� ������ ������� ��ȯ�Ǽ� �ӵ��� �������� url�� �ٲ��� �ʴ´�. redirect�� url�� �ٲ����� �ι��� ��û�� �ι��� ������ �ʿ��Ѵ�.
			return "forward:getBoardList.do";
		} // �α��� ������ ���
		else
			return "redirect:login.jsp";
	
		}

}
