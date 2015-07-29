<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New musem added</title>
</head>
<body>
<h3>New Museum Created: ${ museum.getName() }</h3>

	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
	<a href="${contextPath}/museum">Go to list.</a>
</body>
</html>