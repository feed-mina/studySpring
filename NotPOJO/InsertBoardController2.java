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

	//HandlerReoslver로 맵핑한 것을 RequestMapping으로 대신한다. insertBoard.do요청을 (특정 url요청)  글 등록 매서드와 매칭한다. 는 의미이다. 
	
// public class InsertBoardController implements Controller {	 
//	@Override implement를 지우면 오버라이딩 강제성을 안해도 된다. 그렇다면 메소드와 매개변수 , return type을 내가 마음대로할 수 있다.
	
//	public void insertBoard(HttpServletRequest request) {
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
			// request : 사용자가 입력하 정보를 추출하고 그 추출한 정보를 vo에서 추출해서 dao로 받기 위해 request객체가 필요하다. 
			//BoardVo , BoardDAO  둘다 매개변수로 넘길 수 있다.
		System.out.println("글등록처리 ");	
		boardDAO.insertBoard(vo);
		// returntype을 String으로 받으면 된다. forward: 을 붙어서 viewResolver가 실행되지 않도록 한다.
		return "forward:getBoardList.do"; 
		
		// 1. 사용자 입력정보 추출
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");

		//2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//		
//		BoardDAO boardDAO = new BoardDAO();
		// 꼭 객체를 주입했으면 매서드도 같이 설정해야 작동한다. ! 
		
		
		// 3. 화면 네비게이션 (이동할 화면 정보를 ModelAndView 객체에 등록하여 리턴한다.)	
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("forward:getBoardList.do");
//		return mav;
	} 

}
