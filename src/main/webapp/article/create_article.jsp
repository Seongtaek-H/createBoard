<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 등록</title>

</head>
<body>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String now = sdf.format(new Date());
%>
<form action="/Board/board?cmd=create" method="post">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="id"></td>
			<td></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><input type="text" name="" value="<%=now%>" readonly="readonly"></td>
		</tr>
		<tr>
			<td><input type="submit" value="등록"></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	
</form>
</body>
</html>