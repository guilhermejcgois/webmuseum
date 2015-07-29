<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Listing Scenarios</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Historical Time</td>
			<td>Objects</td>
			<td>Challenges</td>
			<td>Delete?</td>
		</tr>
		<c:forEach items="${list}" var="scenario">
			<tr>
				<td><a href="scenario/edit?id=${scenario.getId()}">${scenario.getId()}</a></td>
				<td>${scenario.getName()}</td>
                                <td><%--<c:choose>
                                        <c:when test="${format != null}">${format.format(scenario.getHistoricalTime().getTime())}</c:when>
                                        <c:otherwise>--%>${scenario.getHistoricalTime().getTime()}<%--</c:otherwise>
                                    </c:choose>--%></td>
				<td><c:forEach items="${scenario.getObjects()}" var="obj">
						${obj.getId()} - ${obj.getName()}
						<br />
					</c:forEach></td>
				<td><a href="scenario/object/challeng?id=?">Challeges</a></td>
				<td><a href="scenario/delete?id=${scenario.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="scenario/create">Add new scenario</a>
</body>