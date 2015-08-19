<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>New scenario added</title>
    </head>
    <body>
        <h3>New Scenario Created: ${ scenario.getName() }</h3>
        <!-- <p>Date: ${ format.format(scenario.getHistoricalTime().getTime()) }</p> -->
        <c:if test="${scenario.objects != null}">
            <p>Objects:</p>
            <ul>
                <c:forEach items="${scenario.getObjects()}" var="obj">
                    <li value="${obj}">${obj.getId()}-${obj.getName() }</li>
                    </c:forEach>
            </ul>
        </c:if>
        <c:if test="${scenario.getClass().name == 'com.lpsmuseum.dto.scenario.ScenarioChallenge'}">
            <ul>
                <c:forEach items="${scenario.getChallenges() }" var="chlg">
                    <li>${chlg.getChallengeId() }</li>
                    </c:forEach>
            </ul>
        </c:if>
        <c:set var="contextPath" value="${pageContext.request.contextPath }" />
        <a href="${contextPath}/scenario">Go to list.</a>
    </body>
</html>