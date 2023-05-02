package com.min.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController2  {

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, HttpSession session, ModelAndView mav) {

		System.out.println("글 목록 검색처리");	
		
		// 1. DB 연동 처리 
//		String seq = request.getParameter("seq");

		
//		BoardVO vo = new BoardVO();
//		BoardDAO boardDAO = new BoardDAO(); 
		// List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 2. Model(DAO)를 이용해서 검색한 데이터를 view(JSP)화면에서 사용할 수 있도록 세션에 등록한다.
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);

		session.setAttribute("boardList", boardDAO.getBoardList(vo));
		// 3. 화면 네비게이션(이동할 화면 정보를 ModelAndView 객체에 등록하여 리턴한다.)	
//		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList");
		return mav;
	}

}
