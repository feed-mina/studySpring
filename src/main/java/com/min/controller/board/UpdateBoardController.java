package com.min.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;
import com.min.controller.Controller;

public class UpdateBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("�ۼ���");	
		
		// 1. ����� �Է����� ����
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");

		//2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new BoardDAO();
		// �� ��ü�� ���������� �ż��嵵 ���� �����ؾ� �۵��Ѵ�. ! 
		
		boardDAO.updateBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		return "getBoardList.do";
	}

}
