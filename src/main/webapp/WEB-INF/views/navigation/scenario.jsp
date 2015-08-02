<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Scenario</title>
        <link rel="stylesheet"
              href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script>
//            $(function () {
//                $("#accordion").accordion();
//            });
        </script>
    </head>
    <body>
        <div>
            <h1>${scenario.getId()} - Cenário : ${scenario.getName()}</h1>
        </div>
        
        <div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${scenario.objects}" var="object">
                        <tr>
                            <td>${object.getName()}</td>
                            <td>${object.getDate().getTime()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <a href="./back"  align="left" class="btn btn-danger">Voltar</a>
            <c:choose>
                <c:when test="${hasChallenge}">
                    <input name="scenarioId" value="${scenario.getId()}" hidden/>
                    <a href="./challenge" align="right" class="btn btn-danger">Desafio!</a>
                </c:when>
                <c:otherwise>
                    <a href="./challenge" align="right" class="btn btn-danger" disabled>Desafio!</a>
                </c:otherwise>
            </c:choose>
            <a href="./next" align="right" class="btn btn-danger">Avançar</a>
        </div>
    </body>