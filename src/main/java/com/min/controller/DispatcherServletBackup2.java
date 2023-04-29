package com.min.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;
import com.min.biz.user.UserVO;
import com.min.biz.user.impl.UserDAO;
 
public class DispatcherServletBackup2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DispatcherServletBackup2() {
    	System.out.println("===> DispatcherServlet 생성");
    }
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		
		System.out.println("===> service() 실행");		
    	// 1. 사용자 요청 path 정보 추출한다.
    	String uri = request.getRequestURI();
    	System.out.println("uri:" + uri);		
    	String path = uri.substring(uri.lastIndexOf("/"));
    	System.out.println("PATH : " + path);		
    	
    	
    	// 2. 추출된 path 에 따라  요청을 분기처리한다.
    	if(path.equals("/login.do")) {
    		System.out.println("로그인 인증처리");	
    		
    		// 1. 사용자 입력 정보 추출
    		String id = request.getParameter("id");
    		String password = request.getParameter("password");

    	// 2. DB 연동 처리
    		UserVO vo = new UserVO();
    		vo.setId(id);
    		vo.setPassword(password);
    		
    		UserDAO userDAO = new UserDAO();
    		UserVO user = userDAO.getUser(vo);

    	// 3. 화면 네비게이션

    	if(user != null){
    		// 로그인 성공인경우
    		response.sendRedirect("getBoardList.do");
    	}
    	else{
    		response.sendRedirect("login.jsp");
    	}
    		
    	} else if(path.equals("/logout.do")) {

    		System.out.println("로그아웃 처리");	
    		
    		// 로그아웃을 요청한 브라우저와 매핑된 세션 객체를 획득한다.
    		// 획득한 세션을 강제종료하고 메인 페이지로 이동한다.
    		HttpSession session = request.getSession();
    		session.invalidate();
    		// 2. 세션 종료 후 메인 화면으로 이동한다.
    		response.sendRedirect("login.jsp");

    		
    	} else if(path.equals("/insertBoard.do")) {

    		System.out.println("글등록 ");	
    		
    		// 1. 사용자 입력정보 추출
    		String title = request.getParameter("title");
    		String writer = request.getParameter("writer");
    		String content = request.getParameter("content");

    		//2. DB 연동 처리
    		BoardVO vo = new BoardVO();
    		vo.setTitle(title);
    		vo.setWriter(writer);
    		vo.setContent(content);
    		
    		BoardDAO boardDAO = new BoardDAO();
    		// 꼭 객체를 주입했으면 매서드도 같이 설정해야 작동한다. ! 
    		boardDAO.insertBoard(vo);
    		
    		// 3. 화면 네비게이션
    		response.sendRedirect("getBoardList.do");
    		
    	} else if(path.equals("/updateBoard.do")) {

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
    		
    		// 3. 화면 네비게이션
    		response.sendRedirect("getBoardList.do");
    		
    	} else if(path.equals("/deleteBoard.do")) {

    		System.out.println("글 삭제");	
    		
    		// 1. 사용자 입력정보 추출
    		String seq = request.getParameter("seq");

    		//2. DB 연동 처리
    		BoardVO vo = new BoardVO();
    		vo.setSeq(Integer.parseInt(seq));
    		
    		BoardDAO boardDAO = new BoardDAO();
    		// 꼭 객체를 주입했으면 매서드도 같이 설정해야 작동한다. ! 
    		boardDAO.deleteBoard(vo);
    		
    		// 3. 화면 네비게이션
    		response.sendRedirect("getBoardList.do");
    		
    	} else if(path.equals("/getBoard.do")) {

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
    		
    		// 3. 화면 네비게이션
    		response.sendRedirect("getBoard.jsp");
    		
    		
    	} else if(path.equals("/getBoardList.do")) {

    		System.out.println("글 목록 검색처리");	
    		
    		// 1. DB 연동 처리 jdbc 기반의 dao 사용

    		String seq = request.getParameter("seq");

    		
    		BoardVO vo = new BoardVO();
    		BoardDAO boardDAO = new BoardDAO(); 
    		List<BoardVO> boardList = boardDAO.getBoardList(vo);
    		
    		// 2. Model(DAO)를 이용해서 검색한 데이터를 view(JSP)화면에서 사용할 수 있도록 세션에 등록한다.
    		HttpSession session = request.getSession();
    		session.setAttribute("boardList", boardList);
    		
    		// 3. 화면 네비게이션
    		response.sendRedirect("getBoardList.jsp");
    		
    	}  else {
    		System.out.println("URL 요청을 다시 확인해주세요.");
    	}
    	
	}
}

// 반드시 서버를 끄고 다시 실행해야 한다. ->  톰켓서버를 다시 실행해야 web.xml의 서블릿 컨테이너를 다시 실행 할 수 있기 때문이다.
//
