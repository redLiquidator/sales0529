<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- c는 제어문, 변수세팅 등 -->
<!-- fmt는 각 나라스타일로 포맷을.. -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	h1{
		text-align:center;
		color:blue;
	}
	table .title{
		height:50px;
		background:black;
	}
	table .title th{
		color:white;
		font-size:16px;
	}
	
	table .btnline{
		height:30px;
	}
</style>
<title>게시글 보기</title>
</head>
<body>
	<h1>게  시  판</h1>
	<div id="board">
		<table width="500" align="center" border="1" cellspacing="0">
			<tr class="title">
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<!-- vo는 items(${list})에서 꺼내오는 한 행마다.. -->
			<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.idx }</td>
				<td>${vo.name }</td>
				<td>
					<c:forEach begin="1" end="${vo.indent }">☞</c:forEach>
					<a href="increment?idx=${vo.idx }">${vo.title }</a>
				</td>
				<td><fmt:formatDate value="${vo.writeDate }" pattern="yyyy.MM.dd(E) a h:mm"/></td>
				<td>${vo.readCount }</td>
			</tr>
			</c:forEach>
			<tr class="btnline">
				<td colspan="5" align="right">
					<input type="button" value="글쓰기" onclick="location.href='write'" />
					
				</td>
			</tr>
		</table>
	</div>
</body>
</html>