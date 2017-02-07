<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="replyOK" method="post">
	
		<input type="hidden" name="idx" value="${reply.idx}"/>
		<input type="hidden" name="ref" value="${reply.ref}"/>
		<input type="hidden" name="step" value="${reply.step}"/>
		<input type="hidden" name="indent" value="${reply.indent}"/>
		
		<table width="500" align="center" border="1">
			<tr><th colspan="2">답변달기</th></tr>
			<tr>
				<td width="100">번호</td>
				<td>
					${reply.idx}
				</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${reply.readCount}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="답변쓰기"/>
					<input type="reset" value="다시쓰기"/>
					<input type="button" value="목록으로"  onclick="location.href='list'"/>
					<input type="button" value="돌아가기"  onclick="history.back()"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>