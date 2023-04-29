package com.min.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;
import com.min.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("�� ��� �˻�ó��");	
		
		// 1. DB ���� ó�� jdbc ����� dao ���

		String seq = request.getParameter("seq");

		
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO(); 
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 2. Model(DAO)�� �̿��ؼ� �˻��� �����͸� view(JSP)ȭ�鿡�� ����� �� �ֵ��� ���ǿ� ����Ѵ�.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		// 3. ȭ�� �׺���̼�
		
		return "getBoardList.jsp";
	}

}
