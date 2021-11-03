<%@page import="vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<link rel="stylesheet" href="./css/mystyle.css">
</head>
<body>
자유게시판
<table>
	<tr>
		<td>글번호</td>
		<td>글제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>수정</td>
	</tr>
<% 
	ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("key");
	//out.print(list);
	for(BoardVO vo : list){
%>
	 <tr>
		<td><%=vo.getNo() %></td>
		<td><%=vo.getTitle() %></td>
		<td><%=vo.getId() %></td>
		<td><%=vo.getWriteDate() %></td>
		<td>
			<input type="button" value="수정"/>
			<input type="button" value="삭제"/>
		</td>
	</tr>
<%} %>
	<tr>
		<td><a href="/Board/board?cmd=view_input">글쓰기</a></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>

</body>
</html>