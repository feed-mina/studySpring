package com.min.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회");	
		
		// 1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");

		//2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		// 3. 응답 화면 구성
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		// 4. 화면 네비게이션 화면 네비게이션(이동할 화면 정보를 ModelAndView 객체에 등록하여 리턴한다.)	
		ModelAndView mav = new ModelAndView();
		// mav.setViewName("getBoard.jsp");
		// ViewResolver에서 접미사 .jsp를 붙이기 때문에 파일의 .jsp를 지운다. 
		mav.setViewName("getBoard");
	
		return mav;
		 
	}

}
