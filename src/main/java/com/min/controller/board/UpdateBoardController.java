package com.min.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("글수정");	
		
		// 1. 사용자 입력정보 추출
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");

		//2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new BoardDAO();
		// 꼭 객체를 주입했으면 매서드도 같이 설정해야 작동한다. ! 
		
		boardDAO.updateBoard(vo);
		
		// 3. 화면 네비게이션 (이동할 화면 정보를 ModelAndView 객체에 등록하여 리턴한다.)	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:getBoardList.do");
		return mav; 
	}

}
