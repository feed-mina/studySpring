<%@page import="com.min.biz.user.impl.UserDAO"%>
<%@page import="com.min.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
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
	response.sendRedirect("getBoardList.jsp");
}
else{
	response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>