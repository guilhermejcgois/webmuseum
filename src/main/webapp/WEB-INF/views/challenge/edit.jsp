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
        <h3>Edit Challenge</h3>
        <form action="save" method="post">
            <input type="text" name="challengeId" hidden="true" value="${challenge.getChallengeId() }" /><br>
            Pergunta: <input type="text" name="descricao" value="${challenge.getDescription() }" /><br>
            Resposta: <input type="text" name="resposta" value="${challenge.getAnswer() }" /><br>
            Cenario: <select id="drp_scenario" name="scenarioId">
                <c:forEach items="${scenarios}" var="scenario">
                    <option value="${scenario.getId()}" ${ scenario.getId() == challenge.getScenario().getId?"selected=\"selected\"":""}>${scenario.getId()}- ${scenario.getName() }</option>
                </c:forEach>
            </select>
            <br><br> 
            <br><input type="submit" value="Save">
        </form>
    </body>
</html>