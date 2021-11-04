<%@page import="vo.BoardVO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>

</head>
<body>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String now = sdf.format(new Date());
%>
<form action="/Board/board?cmd=create" method="post">
	<table>
<% 
	BoardVO vo = (BoardVO)request.getAttribute("view");
//	out.print(vo.getGroupNO());
%>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="<%=vo.getTitle() %>" ></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content" value="<%=vo.getContent() %>" ></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="id" value="<%=vo.getId() %>" ></td>
			<td></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><input type="text" name="" value="<%=vo.getWriteDate() %>" readonly="readonly"/></td>
		</tr>
		<tr>
			<td><a href="/Board/board?cmd=view_reply&groupNO=<%= vo.getNo()%>">답글</a></td>
			<td><a href="/Board/board?cmd=view_update&articleNO=<%= vo.getNo()%>">수정</a></td>
			<td><a href="/Board/board?cmd=delete&articleNO=<%= vo.getNo()%>">삭제</a></td>
		</tr>
	</table>
	
</form>
</body>
</html>