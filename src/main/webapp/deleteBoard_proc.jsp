<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
  <%@page import="com.min.biz.board.impl.BoardDAO"%>
<%@page import="com.min.biz.board.BoardVO"%>
<%
	// 1. ����� �Է����� ����
	String seq = request.getParameter("seq");

	//2. DB ���� ó��
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	// �� ��ü�� ���������� �ż��嵵 ���� �����ؾ� �۵��Ѵ�. ! 
	boardDAO.deleteBoard(vo);
	
	// 3. ȭ�� �׺���̼�
	response.sendRedirect("getBoardList.jsp");
	
%>   
