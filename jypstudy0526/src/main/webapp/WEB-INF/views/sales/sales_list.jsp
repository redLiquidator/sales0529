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
table{
     border-collapse: collapse;
	 }
table,tr,th,td{
border:	1px solid gray;}
th{background-color:orange;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
 $(document).ready(function(){
          $(".expt_rt").each(function(index){
        	 if($(this).children().first().html().substr(2,2)=="총계"){
        		 $(this).css("background","yellowgreen");
        	 }else
        	 if($(this).children().first().html()=="총계"){
        		 $(this).css("background","yellow");
        	 }});
});

</script>

</head>
<body>


<form action="/study/sales/list.do" method="get"> 
<select name="city">
<option value="">전체</option>
<c:forEach var="area" items="${areaList}">
<option value="${area.area_cd}">${area.cd_nm}</option>
</c:forEach>
</select>

<select name="direction">
<option value="1">도시총계를 아래쪽에</option>
<option value="-1">도시총계를 위쪽에</option>
</select>
<input type="submit" value="Submit">
</form>
<br>	

<br>	

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
			<tr class="expt_rt">
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