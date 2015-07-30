<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <meta charset="utf-8">

        <title>Questão</title>
    </head>

    <body onload="Message();">
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Scenario</th>
                    <th>Question</th>
                    <th>Answer</th>
                    <th>Alternative 1</th>
                    <th>Alternative 2</th>
                    <th>Alternative 3</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${challenges}" var="challenge">
                    <tr>
                        <td><a href="pastpresent/edit?id=${challenge.challengeId}">${challenge.challengeId}</a></td>
                        <td>${challenge.scenario.id} - ${challenge.scenario.name}</td>
                        <td>${challenge.imageQuetion.urlAddress}</td>
                        <td>${challenge.imageAnswer.urlAddress}</td>
                        <td>${challenge.imagesAlternativas.get(0).urlAddress}</td>
                        <td>${challenge.imagesAlternativas.get(1).urlAddress}</td>
                        <td>${challenge.imagesAlternativas.get(2).urlAddress}</td>
                        <td><a href="pastpresent/delete?id=${challenge.challengeId}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br /><a href="pastpresent/create">Add new Past-Present Challenge</a>
    </body>
</html>
