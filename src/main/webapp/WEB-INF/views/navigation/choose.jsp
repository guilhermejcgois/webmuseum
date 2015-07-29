<%-- 
    Document   : GuiaAleatorio
    Created on : 24/04/2015, 21:10:37
    Author     : Realtime
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Entering museum</title>
    </head>
    <body>
        <h3>Choose a museum to navigate:</h3>
        <form action="navigation/navigate" method="post" accept-charset="utf-8">
            Museum: <select name="id">
                <c:forEach items="${museums }" var="museum">
                    <option value="${museum.id }">${museum.name }</option>
                </c:forEach> 
            </select><br>
            Navigation: <select name="navigationMode">
                <option value="Aleatory">Aleatory</option>
                <option value="Guided">Guided</option>
            </select><br>
            <input type="submit" value="Enter museum">
        </form>
    </body>
</html>
