<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<h2>세일즈 목록</h2>
	<p><a href="insert.do">세일즈 추가하기</a></p>
	
	<table border="1" width="700px">
		<tr>
			<th>도시</th>
			<th>지역</th>
			<th>상품명</th>
			<th>거래량</th>
		</tr>
		<c:forEach var="sale" items="${list}">
			<tr>
				<td>${sale.cd_nm}</td>
	            <td>${sale.region_area}</td>
	            <td>${sale.prod_nm}</td>
	            <td>${sale.sales_cnt}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>