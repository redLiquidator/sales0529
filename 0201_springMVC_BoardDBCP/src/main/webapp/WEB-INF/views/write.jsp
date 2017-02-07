<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기 양식</title>

</head>
<body>
	<form action="writeOK" method="post">
		<table width="500" border="1" align="center" cellspacing="0">
			<tr><th colspan="2">글쓰기</th></tr>
			<tr><td>이름</td><td><input type="text" name="name" /></td></tr>
			<tr><td>제목</td><td><input type="text" name="title" /></td></tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="입력하기" />
					<input type="reset" value="다시쓰기" />
					<input type="button" value="목록보기" onclick="location.href='list'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>