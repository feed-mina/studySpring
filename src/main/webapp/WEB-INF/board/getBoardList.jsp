 <%@page import="com.min.biz.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
  <!-- 
  JSTL(JSP Standard Tag Library)이란?
  JSP 파일에서 if, for, switch 등과 같은 자바 코드 대체하는 표준태그
   -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="message.board.list.mainTitle"/></title>
</head>
<body>
	<center>
		<h1><spring:message code="message.board.list.mainTitle"/></h1>
		<a href="getBoardList.do?lang=en"><spring:message code="message.board.language.en"/></a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do?lang=ko"><spring:message code="message.board.language.ko"/></a>&nbsp;&nbsp;
		
		
		<h3>
		 	<spring:message code="message.board.list.welcomeMsg"/>... <a href="logout.do">Log-out</a>
		</h3>
		
		<!--  검색시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700" >
				<tr>
					<td align="rignt">
						<select name="searchCondition">
						<option value="TITLE"><spring:message code="message.board.list.title"/>
						<option value="CONTENT"><spring:message code="message.board.list.content"/>
						</select>
					<input name="searchKeyword" type="text"/>
					<input type="submit" value="<spring:message code="message.board.list.btn"/>" />	
					</td>
				</tr>
			</table>
		</form>
		
		<!-- 검색 종료 -->
		
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.seq"/></td>
				<th bgcolor="orange" width="200"><spring:message code="message.board.list.title"/></td>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.writer"/></td>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.regDate"/></td>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.cnt"/></td>					
			</tr>
	
	 	<%
		List<BoardVO> list = (List) request.getAttribute("boardList");
		%>	
		<%= list.size() %>
		<c:forEach var="board" items="${boardList }">
		<tr>
			<td>${board.seq }</td>
			<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.regDate }</td>
			<td>${board.cnt }</td>
		</tr>
		</c:forEach>
		
		</table>
		<br>
		<a href="insertBoard.do"><spring:message code="message.board.list.insertBoard"/></a>
		
	</center>


</body>
</html>