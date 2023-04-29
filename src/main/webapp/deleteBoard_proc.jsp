<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
  <%@page import="com.min.biz.board.impl.BoardDAO"%>
<%@page import="com.min.biz.board.BoardVO"%>
<%
	// 1. 사용자 입력정보 추출
	String seq = request.getParameter("seq");

	//2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	// 꼭 객체를 주입했으면 매서드도 같이 설정해야 작동한다. ! 
	boardDAO.deleteBoard(vo);
	
	// 3. 화면 네비게이션
	response.sendRedirect("getBoardList.jsp");
	
%>   
