<%@page import="vo.BoardVO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>

</head>
<body>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String now = sdf.format(new Date());
	BoardVO vo = (BoardVO)request.getAttribute("update");
%>
<form action="/Board/board?cmd=update&articleNO=<%= vo.getNo()%>" method="post">
	<table>

		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="<%=vo.getTitle() %>" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content" value="<%=vo.getContent() %>" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="id" value="<%=vo.getId() %>" readonly/></td>
			<td></td>
		</tr>
		<tr>
			<td>수정일</td>
			<td><input type="text" name="" value="<%=now%>" readonly/></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정완료"></td>
			<td></td>
		</tr>
	</table>
	
</form>
</body>
</html>