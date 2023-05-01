package com.min.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO; 

@Controller
public class BoardController {
	@RequestMapping(value = "/insertBoard.do", method=RequestMethod.GET)
	public String insertBoard() {
		return "insertBoard"; 
	 
	}
	@RequestMapping(value = "/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
			// request : ����ڰ� �Է��� ������ �����ϰ� �� ������ ������ vo���� �����ؼ� dao�� �ޱ� ���� request��ü�� �ʿ��ϴ�.  //BoardVo , BoardDAO  �Ѵ� �Ű������� �ѱ� �� �ִ�. 
		System.out.println("�۵��ó�� ");	
		boardDAO.insertBoard(vo);
		// returntype�� String���� ������ �ȴ�. forward: �� �پ viewResolver�� ������� �ʵ��� �Ѵ�.
		return "forward:getBoardList.do"; 
	 
	}
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {

		System.out.println("�� ��� �˻�ó��");	
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard";
	}

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO,  Model model) {

		System.out.println("�� ��� �˻�ó��");	 
		//session.setAttribute("boardList", boardDAO.getBoardList(vo));
		// ModelAndView ��ü�� �˻� ����� View �̸��� �����Ѵ�. 
		// Model�� ����� �˻� ����� �ڵ����� request�� ��ϵȴ�.
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
	//	mav.setViewName("getBoardList");
		return "getBoardList";
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
