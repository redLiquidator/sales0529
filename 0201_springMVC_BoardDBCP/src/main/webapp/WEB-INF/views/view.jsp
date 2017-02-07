<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글보기</title>
<style type="text/css">
	table .head{
		height:60px;
		background:black;
	}
	
	table .head th{
		color:white;
		font-size:20px;
	}
	table .content{

	}
	table .last{
		height:80px;
		background:gray;
	}
</style>
</head>
<body>
	<form action="update" method="post" >
		<table width="500" border="1" align="center" cellspacing="0">
			<tr class="head"><th colspan="2">게시글 보기</th></tr>
			<tr class="idx"><td width="100">번호</td><td><input type="hidden" name="idx" value="${view.idx}" readonly="readonly">${view.idx}</td></tr>
			<tr class="readcount"><td>조회수</td><td><input value="${view.readCount }" /></td></tr>
			<tr class="name"><td>이름</td><td><input value="${view.name }" name="name"/></td></tr>
			<tr class="title"><td>제목</td><td><input type="text" value="${view.title }" name="title"/></td></tr>
			<tr class="content">
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="content">${view.content }</textarea></td>
			</tr>
			<tr class="last">
				<td colspan="2" align="center">
					<input type="submit" value="수정하기" />
					<input type="button" value="삭제하기" onclick="location.href='delete?idx=${view.idx}'"/>
					<input type="button" value="답변하기" onclick="location.href='reply?idx=${view.idx}'"/>
					<input type="button" value="목록보기" onclick="location.href='list'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>