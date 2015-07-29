<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scenario Error</title>
</head>
<body>
	<p>
		A exception is arised:<br>${ exception.getMessage() }</p>
	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
	<a href="${contextPath}/scenario">Go to list.</a>
</body>
</html>