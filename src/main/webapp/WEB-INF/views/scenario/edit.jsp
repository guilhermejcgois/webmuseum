<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Edit Scenario</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
</head>
<body>
	<h3>Edit Scenario</h3>
	<form action="update" method="post">
		Id: <input type="text" name="id" value="${ scenario.getId() }"
			readonly /><br> Name: <input type="text" name="name"
			value="${scenario.getName() }" /><br> Theme: <select
			name="theme" id="chk_themes">
			<c:forEach items="${themes }" var="theme">
				<c:choose>
					<c:when
						test="theme.getId().longValue() == scenariotheme.getId().longValue()">
						<option value="${theme.getId() }" selected>${theme.getId() }-
							${theme.getTitle() }</option>
					</c:when>
					<c:otherwise>
						<option value="${theme.getId() }">${theme.getId() }-
							${theme.getTitle() }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select><br>
		Objects: <select name="objects" id="drp_objects" multiple>
			<c:forEach items="${objects}" var="obj">
				<c:choose>
					<c:when test="scenario.getObjects().contains(obj)">
						<option value="${obj.getId()}" selected>${obj.getId()}-
							${obj.getName() }</option>
					</c:when>
					<c:otherwise>
						<option value="${obj.getId()}">${obj.getId()}-
							${obj.getName() }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> <br> <input type="submit" value="Save">
	</form>
</body>
<script>
	$(function() {
		$('.date-picker').datepicker({
			showButtonPanel : true,
			dateFormat : 'dd/mm/yy'
		});
	});
</script>
</html>