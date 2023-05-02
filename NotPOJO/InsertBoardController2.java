package com.min.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO; 

@Controller
public class InsertBoardController2 {

	//HandlerReoslver�� ������ ���� RequestMapping���� ����Ѵ�. insertBoard.do��û�� (Ư�� url��û)  �� ��� �ż���� ��Ī�Ѵ�. �� �ǹ��̴�. 
	
// public class InsertBoardController implements Controller {	 
//	@Override implement�� ����� �������̵� �������� ���ص� �ȴ�. �׷��ٸ� �޼ҵ�� �Ű����� , return type�� ���� ��������� �� �ִ�.
	
//	public void insertBoard(HttpServletRequest request) {
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
			// request : ����ڰ� �Է��� ������ �����ϰ� �� ������ ������ vo���� �����ؼ� dao�� �ޱ� ���� request��ü�� �ʿ��ϴ�. 
			//BoardVo , BoardDAO  �Ѵ� �Ű������� �ѱ� �� �ִ�.
		System.out.println("�۵��ó�� ");	
		boardDAO.insertBoard(vo);
		// returntype�� String���� ������ �ȴ�. forward: �� �پ viewResolver�� ������� �ʵ��� �Ѵ�.
		return "forward:getBoardList.do"; 
		
		// 1. ����� �Է����� ����
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");

		//2. DB ���� ó��
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//		
//		BoardDAO boardDAO = new BoardDAO();
		// �� ��ü�� ���������� �ż��嵵 ���� �����ؾ� �۵��Ѵ�. ! 
		
		
		// 3. ȭ�� �׺���̼� (�̵��� ȭ�� ������ ModelAndView ��ü�� ����Ͽ� �����Ѵ�.)	
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("forward:getBoardList.do");
//		return mav;
	} 

}
