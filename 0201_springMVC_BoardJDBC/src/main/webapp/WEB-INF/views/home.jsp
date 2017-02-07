<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<%-- <c:forEach var="vo" items="${list }">

</c:forEach> --%>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
