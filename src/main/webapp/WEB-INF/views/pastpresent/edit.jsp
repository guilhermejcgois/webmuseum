<%-- 
    Document   : form
    Created on : 29/07/2015, 09:39:23
    Author     : USER
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">

        <link href="resources/css/bootstrap.css" rel="stylesheet">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" />
        <title>JSP Page</title>
    </head>
    <body>
        <script type="text/javascript" src="resources/js/menu.js"></script>
        <div class="container">
            <form action="add" method="POST">
                <div id="divForm1" class="row">
                    <div class='span5'>
                        <br>
                        <label class="control-label" for="selectbasic">Questão
                        </label>


                        <div class="controls">
                            <div class="required-field-block">
                                <select id="Measured" name="id_objectquestion" class="input-xlarge" required> 
                                    <option value="">Selecione uma Opção</option>
                                    <c:forEach items="${list}" var="object">
                                        <option  value="${object.id}">${object.name}</option>
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
                                    <option value="">Selecione uma Opção</option>
                                    <c:forEach items="${list}" var="object">
                                        <option value="${object.id}">${object.name}</option>
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
                            <c:forEach items="${list}" var="object">
                                <input type="checkbox"  name="imageAlternativas" id="${object.id}" value="${object.id}">${object.name}
                                <br>
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
                                window.history.pushState({msg: 'Message'}, 'Questão', 'Question');
                                showMessageToast(msg, 2000);
                            }

                        }
        </script>
    </body>
</html>
