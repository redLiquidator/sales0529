<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<style>
table {
     border-collapse: collapse;
}
table,tr,th,td{
border:	1px solid gray;}
</style>
</head>
<body>
	<h2>세일즈 목록</h2>
	<p><a href="insert.do">.</a></p>
	
	<table border="1" width="1300px">
		<tr>
			<th>ENAME</th>
			<th>JOB</th>
			<th>DEPTNO</th>
		</tr>
		<c:forEach var="sale" items="${list}">
			<tr>
				<td>${sale.ename}</td>
	            <td>${sale.job}</td>
	            <td>${sale.deptno}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>