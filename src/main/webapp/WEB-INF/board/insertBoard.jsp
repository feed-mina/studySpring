<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���۵��</title>
</head>
<body>
	<center>
	<h1>�۵��</h1>
	<a href="logout.do">Log-out</a>
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
		<table border="1" cellpadding="0" cellspacing="0" >
			<tr>
				<td bgcolor="orange" width="70">����</td>
				<td align="left"><input name="title" type="text" /></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="150">�ۼ���</td>
				<td align="left" ><input type="text" name="writer" size="10" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">����</td>
				<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
			</tr>
			
			<tr>
				<td bgcolor="orange" width="100">���ε�</td>
				<td align="left"><input name="uploadFile" type="file" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="���۵��"/>
				</td>
			</tr>
		</table>	
		
		</form>
		<hr>
		<a href="getBoardList.jsp">�� ��� ����</a>
	</center>
</body>
</html>