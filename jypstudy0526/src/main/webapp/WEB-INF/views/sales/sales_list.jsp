<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<!-- <form action="/sales/list.do">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             SalesController.java" method="post">
	deptno:<input type="text" name="value">
<button type="submit" value="Submit">입력</button>
</form>
 -->
 
<!-- empno: <input type="text" name="value" value=""> -->
 
<%-- <form action="/study/sales/list.do" method="get" name="textform">  --%>
지역선택<form action="/study/sales/list.do" method="get"> 
<select name="value">
<option value="0">전체</option>
<option value="10">10번부서</option>
<option value="20">20번부서</option>
<option value="30">30번부서</option>
</select>
<input type="submit" value="Submit">
</form>
<br>	
	
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