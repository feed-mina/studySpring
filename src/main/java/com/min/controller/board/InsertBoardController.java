package com.min.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;
import com.min.controller.Controller;

public class InsertBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글등록 ");	
		
		// 1. 사용자 입력정보 추출
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		//2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		// 꼭 객체를 주입했으면 매서드도 같이 설정해야 작동한다. ! 
		boardDAO.insertBoard(vo);
		
		// 3. 화면 네비게이션 
		return "getBoardList.do";
	}

}
