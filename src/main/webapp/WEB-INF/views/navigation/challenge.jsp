<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>CHALLENGE!</title>
        
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
    </head>
    <body>
        <div class="alert" role="alert">
            <h3>${scenarioId} : ${challenge.getDescription()}</h3><br>
            <label>Resposta:</label><input id="userAnswer" type="text" /><br>
            <button class="btn btn-default" id="voltar" disabled>Voltar</button>
            <button class="btn btn-default" id="verificar">Verificar</button>
        </div>
    </body>
    <script>
        (function() {
            var correctAnswer = '${challenge.getAnswer()}';
            var userAnswer = $('input#userAnswer');
            var divAlert = $('div.alert');
            
            $('button#voltar').click(function () {
                window.history.back();
            });
            
            $('button#verificar').click(function () {
                if (userAnswer.val() === correctAnswer) {
                    if (divAlert.hasClass('alert-danger'))
                        divAlert.removeClass('alert-danger');
                    divAlert.addClass('alert-success');
                    $('button#verificar').attr('disabled', 'disabled');
                    $('button#voltar').removeAttr('disabled');
                } else {
                    if (!divAlert.hasClass('alert-danger'))
                        divAlert.addClass('alert-danger');
                }
            });
        })();
    </script>
</html>
