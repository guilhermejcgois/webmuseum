<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Scenario</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
</head>
<body>
	<h3>Scenario Creation</h3>
	<form action="add" method="post">
		Name: <input type="text" name="name" /><br>
                Theme: <select
			name="theme" id="chk_themes">
			<c:forEach items="${themes }" var="theme">
				<option value="${theme.getId() }">${theme.getId() }-
					${theme.getTitle() }</option>
			</c:forEach>
		</select><br>
		Objects: <select name="objects" id="chk_objects" multiple>
			<c:forEach items="${objects}" var="obj">
				<option value="${obj.getId()}">${obj.getId()}-
					${obj.getName() }</option>
			</c:forEach>
		</select> <br>
		<br> <input type="submit" value="Create">
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