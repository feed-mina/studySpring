package com.min.controller.board;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.min.biz.board.BoardService;
import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO; 

@Controller

//board라는 이름으로 어떤 정보가 저장이 되면 session에도 그대로 저장할 수 있다. 
@SessionAttributes("board")
public class BoardController {
	
	@Autowired 
	private BoardService boardService;
	
	@RequestMapping(value = "/insertBoard.do", method=RequestMethod.GET)
	public String insertBoard() {
		return "insertBoard"; 
	 
	}
	
	@RequestMapping(value = "/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws Exception {
		// 파일 업로드할때는 예외처리가 필요하다.	
		// request : 사용자가 입력하 정보를 추출하고 그 추출한 정보를 vo에서 추출해서 dao로 받기 위해 request객체가 필요하다.  //BoardVo , BoardDAO  둘다 매개변수로 넘길 수 있다. 
		System.out.println("글등록처리 ");	
		// 1. 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:\\DEV"+ fileName));
		}

		boardService.insertBoard(vo);
		// 2. 글 등록처리
		// returntype을 String으로 받으면 된다. forward: 을 붙어서 viewResolver가 실행되지 않도록 한다.
		return "forward:getBoardList.do"; 
	 
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글수정처리"+ vo.toString());	
		boardDAO.updateBoard(vo);
		return "forward:getBoardList.do";  
	} 
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글삭제처리 ");	
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do"; 
	 
	}
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {

		System.out.println("글 목록 검색처리");	
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,  Model model) {
		// Null Check
	
		System.out.println("글 목록 검색조건" + vo.getSearchCondition());	 
	
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		System.out.println("글 목록 검색처리");	 
		//session.setAttribute("boardList", boardDAO.getBoardList(vo));
		// ModelAndView 객체에 검색 결과와 View 이름을 저장한다. 
		// Model에 저장된 검색 결과는 자동으로 request에 등록된다.
		model.addAttribute("boardList", boardService.getBoardList(vo));
	//	mav.setViewName("getBoardList");
		return "getBoardList";
	} 

}
