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
			<th>expt_rt</th>
			<th>안마기(%)</th>
			<th>냉장고(%)</th>
			<th>tv(%)</th>
			<th>오디오(%)</th>
			<th>전화기(%)</th>
			<th>에어컨(%)</th>
			<th>전자렌지(%)</th>
			<th>카메라(%)</th>
			<th>김치냉장고(%)</th>
			<th>세탁기(%)</th>
			<th>판매량</th>
		</tr>
		<c:forEach var="sale" items="${list}">
			<tr>
				<td>${sale.expt_rt}</td>
	            <td>${sale.column_no_1}</td>
	            <td>${sale.column_no_2}</td>
	            <td>${sale.column_no_3}</td>
	            <td>${sale.column_no_4}</td>
	            <td>${sale.column_no_5}</td>
	            <td>${sale.column_no_6}</td>
	            <td>${sale.column_no_7}</td>
	            <td>${sale.column_no_8}</td>
	            <td>${sale.column_no_9}</td>
	            <td>${sale.column_no_10}</td>
	            <td>${sale.tot}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>