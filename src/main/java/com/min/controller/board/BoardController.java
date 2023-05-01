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
			// request : 사용자가 입력하 정보를 추출하고 그 추출한 정보를 vo에서 추출해서 dao로 받기 위해 request객체가 필요하다.  //BoardVo , BoardDAO  둘다 매개변수로 넘길 수 있다. 
		System.out.println("글등록처리 ");	
		boardDAO.insertBoard(vo);
		// returntype을 String으로 받으면 된다. forward: 을 붙어서 viewResolver가 실행되지 않도록 한다.
		return "forward:getBoardList.do"; 
	 
	}
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {

		System.out.println("글 목록 검색처리");	
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard";
	}

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO,  Model model) {

		System.out.println("글 목록 검색처리");	 
		//session.setAttribute("boardList", boardDAO.getBoardList(vo));
		// ModelAndView 객체에 검색 결과와 View 이름을 저장한다. 
		// Model에 저장된 검색 결과는 자동으로 request에 등록된다.
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
	//	mav.setViewName("getBoardList");
		return "getBoardList";
	} 
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글수정처리 ");	
		boardDAO.updateBoard(vo);
		return "forward:getBoardList.do";  
	} 
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글삭제처리 ");	
		boardDAO.deleteBoard(vo);
		return "forward:getBoardList.do"; 
	 
	}

}
