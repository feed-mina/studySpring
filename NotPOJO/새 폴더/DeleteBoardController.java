package com.min.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ����");	
		
		// 1. ����� �Է����� ����
		String seq = request.getParameter("seq");

		//2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		// �� ��ü�� ���������� �ż��嵵 ���� �����ؾ� �۵��Ѵ�. ! 
		boardDAO.deleteBoard(vo);
		
		// 3. ȭ�� �׺���̼� (�̵��� ȭ�� ������ ModelAndView ��ü�� ����Ͽ� �����Ѵ�.)	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:getBoardList.do");
		return mav;
	}

}
