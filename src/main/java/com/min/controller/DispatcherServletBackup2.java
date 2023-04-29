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
    	System.out.println("===> DispatcherServlet ����");
    }
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		
		System.out.println("===> service() ����");		
    	// 1. ����� ��û path ���� �����Ѵ�.
    	String uri = request.getRequestURI();
    	System.out.println("uri:" + uri);		
    	String path = uri.substring(uri.lastIndexOf("/"));
    	System.out.println("PATH : " + path);		
    	
    	
    	// 2. ����� path �� ����  ��û�� �б�ó���Ѵ�.
    	if(path.equals("/login.do")) {
    		System.out.println("�α��� ����ó��");	
    		
    		// 1. ����� �Է� ���� ����
    		String id = request.getParameter("id");
    		String password = request.getParameter("password");

    	// 2. DB ���� ó��
    		UserVO vo = new UserVO();
    		vo.setId(id);
    		vo.setPassword(password);
    		
    		UserDAO userDAO = new UserDAO();
    		UserVO user = userDAO.getUser(vo);

    	// 3. ȭ�� �׺���̼�

    	if(user != null){
    		// �α��� �����ΰ��
    		response.sendRedirect("getBoardList.do");
    	}
    	else{
    		response.sendRedirect("login.jsp");
    	}
    		
    	} else if(path.equals("/logout.do")) {

    		System.out.println("�α׾ƿ� ó��");	
    		
    		// �α׾ƿ��� ��û�� �������� ���ε� ���� ��ü�� ȹ���Ѵ�.
    		// ȹ���� ������ ���������ϰ� ���� �������� �̵��Ѵ�.
    		HttpSession session = request.getSession();
    		session.invalidate();
    		// 2. ���� ���� �� ���� ȭ������ �̵��Ѵ�.
    		response.sendRedirect("login.jsp");

    		
    	} else if(path.equals("/insertBoard.do")) {

    		System.out.println("�۵�� ");	
    		
    		// 1. ����� �Է����� ����
    		String title = request.getParameter("title");
    		String writer = request.getParameter("writer");
    		String content = request.getParameter("content");

    		//2. DB ���� ó��
    		BoardVO vo = new BoardVO();
    		vo.setTitle(title);
    		vo.setWriter(writer);
    		vo.setContent(content);
    		
    		BoardDAO boardDAO = new BoardDAO();
    		// �� ��ü�� ���������� �ż��嵵 ���� �����ؾ� �۵��Ѵ�. ! 
    		boardDAO.insertBoard(vo);
    		
    		// 3. ȭ�� �׺���̼�
    		response.sendRedirect("getBoardList.do");
    		
    	} else if(path.equals("/updateBoard.do")) {

    		System.out.println("�ۼ���");	
    		
    		// 1. ����� �Է����� ����
    		
    		String title = request.getParameter("title");
    		String content = request.getParameter("content");
    		String seq = request.getParameter("seq");

    		//2. DB ���� ó��
    		BoardVO vo = new BoardVO();
    		vo.setTitle(title);
    		vo.setContent(content);
    		vo.setSeq(Integer.parseInt(seq));

    		BoardDAO boardDAO = new BoardDAO();
    		// �� ��ü�� ���������� �ż��嵵 ���� �����ؾ� �۵��Ѵ�. ! 
    		
    		boardDAO.updateBoard(vo);
    		
    		// 3. ȭ�� �׺���̼�
    		response.sendRedirect("getBoardList.do");
    		
    	} else if(path.equals("/deleteBoard.do")) {

    		System.out.println("�� ����");	
    		
    		// 1. ����� �Է����� ����
    		String seq = request.getParameter("seq");

    		//2. DB ���� ó��
    		BoardVO vo = new BoardVO();
    		vo.setSeq(Integer.parseInt(seq));
    		
    		BoardDAO boardDAO = new BoardDAO();
    		// �� ��ü�� ���������� �ż��嵵 ���� �����ؾ� �۵��Ѵ�. ! 
    		boardDAO.deleteBoard(vo);
    		
    		// 3. ȭ�� �׺���̼�
    		response.sendRedirect("getBoardList.do");
    		
    	} else if(path.equals("/getBoard.do")) {

    		System.out.println("�� �� ��ȸ");	
    		
    		// 1. �˻��� �Խñ� ��ȣ ����
    		String seq = request.getParameter("seq");

    		//2. DB ���� ó��
    		BoardVO vo = new BoardVO();
    		vo.setSeq(Integer.parseInt(seq));
    		
    		BoardDAO boardDAO = new BoardDAO();
    		BoardVO board = boardDAO.getBoard(vo);
    		// 3. ���� ȭ�� ����
    		HttpSession session = request.getSession();
    		session.setAttribute("board", board);
    		
    		// 3. ȭ�� �׺���̼�
    		response.sendRedirect("getBoard.jsp");
    		
    		
    	} else if(path.equals("/getBoardList.do")) {

    		System.out.println("�� ��� �˻�ó��");	
    		
    		// 1. DB ���� ó�� jdbc ����� dao ���

    		String seq = request.getParameter("seq");

    		
    		BoardVO vo = new BoardVO();
    		BoardDAO boardDAO = new BoardDAO(); 
    		List<BoardVO> boardList = boardDAO.getBoardList(vo);
    		
    		// 2. Model(DAO)�� �̿��ؼ� �˻��� �����͸� view(JSP)ȭ�鿡�� ����� �� �ֵ��� ���ǿ� ����Ѵ�.
    		HttpSession session = request.getSession();
    		session.setAttribute("boardList", boardList);
    		
    		// 3. ȭ�� �׺���̼�
    		response.sendRedirect("getBoardList.jsp");
    		
    	}  else {
    		System.out.println("URL ��û�� �ٽ� Ȯ�����ּ���.");
    	}
    	
	}
}

// �ݵ�� ������ ���� �ٽ� �����ؾ� �Ѵ�. ->  ���ϼ����� �ٽ� �����ؾ� web.xml�� ���� �����̳ʸ� �ٽ� ���� �� �� �ֱ� �����̴�.
//
