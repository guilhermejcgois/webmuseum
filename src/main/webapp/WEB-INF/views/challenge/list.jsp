<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Listing Challenge</title>
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


            <table class="table table-striped">
                <tr>
                    <td>Id</td>
                    <td>Pergunta</td>
                    <td>Resposta</td>
                    <td>Cenario</td>
                    <td>Delete?</td>
                </tr>
                <c:forEach items="${list}" var="challenge">
                    <tr>
                        <td><a href="challenge/edit?id=${challenge.getChallengeId()}">${challenge.getChallengeId()}</a></td>
                        <td>${challenge.getDescription()}</td>
                        <td>${challenge.getAnswer()}</td>
                        <td>${challenge.getScenario().getId()}</td>
                    <td><a href="challenge/delete?id=${challenge.getChallengeId()}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/webmuseum/challenge/create">Adicionar</a>
        </div>
    </body>