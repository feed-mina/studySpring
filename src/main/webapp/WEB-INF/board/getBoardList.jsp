 <%@page import="com.min.biz.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
  <!-- 
  JSTL(JSP Standard Tag Library)이란?
  JSP 파일에서 if, for, switch 등과 같은 자바 코드 대체하는 표준태그
   -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>글 목록</h1>
		<h3>
		 	테스터님 환영합니다... <a href="logout.do">Log-out</a>
		</h3>
		
		<!--  검색시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700" >
				<tr>
					<td align="rignt">
						<select name="searchCondition">
						<option value="TITLE">제목
						<option value="CONTENT">내용
						</select>
					<input name="searchKeyword" type="text"/>
					<input type="submit" value="검색" />	
					</td>
				</tr>
			</table>
		</form>
		
		<!-- 검색 종료 -->
		
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</td>
				<th bgcolor="orange" width="200">제목</td>
				<th bgcolor="orange" width="150">작성자</td>
				<th bgcolor="orange" width="150">등록일</td>
				<th bgcolor="orange" width="100">조회수</td>					
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
		<a href="insertBoard.do">새글등록</a>
		
	</center>


</body>
</html>