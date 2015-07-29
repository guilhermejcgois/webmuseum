<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Navigate museum</title>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    </head>
    <body>
        <table id="museumNavigator" border="1">
            <thead id="currentScenario"><tr><th colspan="4"></th></tr></thead>
            <tbody id="currentObjects">
                <tr>
                    <td>Name</td>
                    <td>Date</td>
                    <td>URL</td>
                </tr>
            </tbody>
        </table>
        <input type="button" id="back" value="Back Scenario" disabled/>
        <input type="button" id="next" value="Next Scenario" />

        <script type="text/javascript">
                    $(function () {
                    var currentScenario = 0;
                            var museum = {
                            id: "${museum.id}",
                                    name: "${museum.name}",
                                    scenarios: [
            <c:forEach items = "${museum.scenarios}" var = "scenario" >
                                    {
                                    id: "${scenario.id}",
                                            name: "${scenario.name}",
                                            objects: [
                <c:forEach items = "${scenario.objects}" var = "object" >
                                            {
                                            name: "${object.name}",
                                                    date: "${object.date}",
                                                    url:
                    <c:choose >
                        <c:when test = "${object.class.name == 'com.lpsmuseum.dto.object.Image'}" >"${object.urlAddress}" </c:when>
                        <c:otherwise > "-" </c:otherwise>
                    </c:choose>
                                            },
                </c:forEach>
                                            ]
                                    },
            </c:forEach>
                                    ]
                            };
                            var objects = [];
                            $.each(museum.scenarios[currentScenario].objects,
                                    function (key, value) {
                                    objects.push(value);
                                    });
                            var setObjects = function () {
                            objects = [];
                                    $.each(museum.scenarios[currentScenario].objects, function (key, value) {
                                    objects.push(value);
                                    });
                            };
                            var updateTable = function () {
                            $('thead#currentScenario th').html(museum.scenarios[currentScenario].name);
                                    var rowCount = $('tbody#currentObjects tr').length;
                                    for (i = 1; i < rowCount; i++)
                                    $('tbody#currentObjects tr:last-child').remove();
                                    for (i = 0; i < objects.length; i++) {
                            var newRow = "";
                                    newRow = newRow.concat("<tr>");
                                    newRow = newRow.concat("<td>");
                                    newRow = newRow.concat(objects[i].name);
                                    newRow = newRow.concat("</td>");
                                    newRow = newRow.concat("<td>");
                                    var date = objects[i].date;
                                    newRow = newRow.concat(date.dayOfMonth + "/" + date.month + "/" + date.year);
                                    newRow = newRow.concat("</td>");
                                    newRow = newRow.concat("<td>");
                                    newRow = newRow.concat(objects[i].url);
                                    newRow = newRow.concat("</td>");
                                    newRow = newRow.concat("</tr>");
                                    $('tbody#currentObjects').append(newRow);
                            }
                            };
                            $('input#back').click(function () {
                    if ((currentScenario - 2) >= 0) {
                    currentScenario -= 2;
                            setObjects();
                            updateTable();
                            if ($('input#next').is(":disabled") && currentScenario < museum.scenarios.length)
                            $('input#next').removeAttr("disabled");
                            // is enabled can be not necessary, because currentScenario never will be less than 0.
                            if ((currentScenario == 0) && $('input#back').is(":enabled"))
                            $('input#back').attr("disabled", true);
                    }
                    });
                            $('input#next').click(function () {
                    if ((currentScenario + 2) < museum.scenarios.length) {
                    currentScenario += 2;
                            setObjects();
                            updateTable();
                            if ($('input#back').is(":disabled") == true && currentScenario > 0)
                            $('input#back').removeAttr("disabled");
                            if (((currentScenario + 2) >= museum.scenarios.length) && $('input#back').is(":enabled"))
                            $('input#next').attr("disabled", true);
                    }
                    });
                            setObjects();
                            updateTable();
                    });
        </script>
    </body>
</html>