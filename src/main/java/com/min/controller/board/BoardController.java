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

//board��� �̸����� � ������ ������ �Ǹ� session���� �״�� ������ �� �ִ�. 
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
		// ���� ���ε��Ҷ��� ����ó���� �ʿ��ϴ�.	
		// request : ����ڰ� �Է��� ������ �����ϰ� �� ������ ������ vo���� �����ؼ� dao�� �ޱ� ���� request��ü�� �ʿ��ϴ�.  //BoardVo , BoardDAO  �Ѵ� �Ű������� �ѱ� �� �ִ�. 
		System.out.println("�۵��ó�� ");	
		// 1. ���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:\\DEV"+ fileName));
		}

		boardService.insertBoard(vo);
		// 2. �� ���ó��
		// returntype�� String���� ������ �ȴ�. forward: �� �پ viewResolver�� ������� �ʵ��� �Ѵ�.
		return "forward:getBoardList.do"; 
	 
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�ۼ���ó��"+ vo.toString());	
		boardDAO.updateBoard(vo);
		return "forward:getBoardList.do";  
	} 
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�ۻ���ó�� ");	
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do"; 
	 
	}
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {

		System.out.println("�� ��� �˻�ó��");	
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,  Model model) {
		// Null Check
	
		System.out.println("�� ��� �˻�����" + vo.getSearchCondition());	 
	
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		System.out.println("�� ��� �˻�ó��");	 
		//session.setAttribute("boardList", boardDAO.getBoardList(vo));
		// ModelAndView ��ü�� �˻� ����� View �̸��� �����Ѵ�. 
		// Model�� ����� �˻� ����� �ڵ����� request�� ��ϵȴ�.
		model.addAttribute("boardList", boardService.getBoardList(vo));
	//	mav.setViewName("getBoardList");
		return "getBoardList";
	} 

}
