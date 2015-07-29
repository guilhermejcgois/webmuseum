<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <meta charset="utf-8">

        <link href="resources/css/bootstrap.css" rel="stylesheet">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" />

        <title>Quest�o</title>
    </head>

    <body onload="Message();">
        <script type="text/javascript" src="resources/js/menu.js"></script>
        <div class="container">
            <form action="actions/savePresentPast" method="POST">

                <div id="divForm1" class="row">
                    <div class='span5'>
                        <br>
                        <label class="control-label" for="selectbasic">Quest�o
                        </label>
                        

                        <div class="controls">
                            <div class="required-field-block">
                                <select id="Measured" name="id_objectquestion" class="input-xlarge" required> 
                                    <option value="">Selecione uma Op��o</option>
                                    <c:forEach items="${list}" var="list">
                                        <c:if test="${fn:contains(list.getClass().name,'Image')}">
                                            <option  name=""  value="${list.id}">${list.name}</option>
                                        </c:if>
                                    </c:forEach>                 
                                </select>

                            </div>
                        </div>
                    </div>

                    <div class='span5'>
                        <br>
                        <label class="control-label" for="selectbasic">Resposta
                        </label>
                        <div class="controls">
                            <div class="required-field-block">
                                <select id="Measured" name="id_objectanswer" class="input-xlarge" required> 
                                    <option value="">Selecione uma Op��o</option>
                                    <c:forEach items="${list}" var="list">
                                        <c:if test="${fn:contains(list.getClass().name,'Image')}">
                                            <option  name=""  value="${list.id}">${list.name}</option>
                                        </c:if>
                                    </c:forEach>                 
                                </select>

                            </div>
                        </div>
                    </div>

                    <div class="span5">
                        <br>
                        <label class="control-label" for="selectbasic">Alternativas 
                            <a class="btn-mini btn-info required-selon"  onclick="checkAll();"><i class="icon-white icon-check"></i></a>
                            <a class="btn-mini btn-danger required-seloff"  onclick="checkNone();"><i class="icon-white  icon-remove-circle"></i></a></label>
                        <div class="controls" id="divCheckAlt">
                            <c:forEach items="${list}" var="list">
                                <c:if test="${fn:contains(list.getClass().name,'Image')}">
                                    <input type="checkbox"  name="imageAlternativas" id="${list.id}" value="${list.id}">${list.name}
                                    <br>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>



                <div id="divActions" class="form-actions" style='width: 70%'>
                    <input class="btn btn-primary" type="submit" value="Salvar" onClick="return checkTest();">

                </div>

            </form>

        </div>
        <script src="resources/js/jquery-min.js"></script>
        <script src="resources/js/bootstrap.js"></script>
        <script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>   
        <script type="text/javascript" src="resources/js/jquery_plugin_date.js"></script>   
        <script type="text/javascript" src="resources/js/jquery.dataTables.bootstrap.js"></script>   
        <script src="resources/js/jquery.tablesorter.min.js" type="text/javascript"></script>
        <script src="resources/js/jquery.tablesorter.pager.js" type="text/javascript"></script> 

        <script src="resources/js/jquery.toastmessage.js"></script>
        <script>
                        function checkTest() {

                            if (!$('input[name=imageAlternativas]').is(':checked'))
                            {
                                showMessageToast('Selecione pelo menos uma Alternativa.');
                                return false;
                            }
                        }
                        ;

                        function checkAll() {
                            $("#divCheckAlt input[type=checkbox]").prop("checked", true);
                        }
                        ;
                        function checkNone() {
                            $("#divCheckAlt input[type=checkbox]").prop("checked", false);
                        }
                        ;

                        function showMessageToast(message, time) {
                            $().toastmessage('showToast', {
                                text: "" + message + "",
                                stayTime: time,
                                position: 'middle-center',
                                type: 'notice'
                            });
                        }
                        ;

                        function closeMessage()
                        {
                            $("#divMessage").remove();
                        }
                        ;

                        function Message()
                        {

                            if (${param.Message != null ? true : false})
                            {
                                var msg = "${param.Message}";
                                window.history.pushState({msg: 'Message'}, 'Quest�o', 'Question');
                                showMessageToast(msg, 2000);
                            }

                        }

        </script>

    </body>
</html>
