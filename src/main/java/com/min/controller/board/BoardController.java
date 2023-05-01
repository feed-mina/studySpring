package com.min.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO; 

@Controller
public class BoardController {
 
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
			// request : ����ڰ� �Է��� ������ �����ϰ� �� ������ ������ vo���� �����ؼ� dao�� �ޱ� ���� request��ü�� �ʿ��ϴ�.  //BoardVo , BoardDAO  �Ѵ� �Ű������� �ѱ� �� �ִ�. 
		System.out.println("�۵��ó�� ");	
		boardDAO.insertBoard(vo);
		// returntype�� String���� ������ �ȴ�. forward: �� �پ viewResolver�� ������� �ʵ��� �Ѵ�.
		return "forward:getBoardList.do"; 
	 
	}
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, HttpSession session, ModelAndView mav) {

		System.out.println("�� ��� �˻�ó��");	
		session.setAttribute("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard");
		return mav;
	}

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, HttpSession session, ModelAndView mav) {

		System.out.println("�� ��� �˻�ó��");	
		session.setAttribute("boardList", boardDAO.getBoardList(vo));
		mav.setViewName("getBoardList");
		return mav;
	} 
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�ۼ���ó�� ");	
		boardDAO.updateBoard(vo);
		return "forward:getBoardList.do";  
	} 
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�ۻ���ó�� ");	
		boardDAO.deleteBoard(vo);
		return "forward:getBoardList.do"; 
	 
	}

}
