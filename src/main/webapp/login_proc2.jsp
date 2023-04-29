<%@page import="com.min.biz.user.impl.UserDAO"%>
<%@page import="com.min.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
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
	response.sendRedirect("getBoardList.jsp");
}
else{
	response.sendRedirect("login.jsp");
}
%>

<!--  jsp 가 가지고 있는 문서중에 view가 없는 코드가 있는 파일을 컨트롤이라고 말한다. -->