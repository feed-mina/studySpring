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

		System.out.println("글 목록 검색처리");	
		
		// 1. DB 연동 처리 jdbc 기반의 dao 사용

		String seq = request.getParameter("seq");

		
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO(); 
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 2. Model(DAO)를 이용해서 검색한 데이터를 view(JSP)화면에서 사용할 수 있도록 세션에 등록한다.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		// 3. 화면 네비게이션
		
		return "getBoardList.jsp";
	}

}
