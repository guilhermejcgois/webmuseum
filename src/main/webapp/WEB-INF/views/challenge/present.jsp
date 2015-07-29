<%-- 
    Document   : Challenge
    Created on : 22/06/2015, 13:51:31
    Author     : Raphael
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Desafio</title>
    </head>
<body onload="Message();">
        <script type="text/javascript" src="resources/js/menu.js"></script>
          <link href="resources/css/dataTables.bootstrap.css" rel="stylesheet"> 
        <link rel="stylesheet" type="text/css" href="resources/css/jquery.toastmessage.css">
         <link href="resources/css/bootstrap.min.css" rel="stylesheet">
            <div class="container">
         <div class="page-header">
            <h3>
        Desafio Presente / Passado
        </h3>
        </div>
        <div id="divQuestao1" style="display: inline">
            <img src="http://www.techclube.com.br/blog/wp-content/uploads/2010/03/eniac.jpg" width="250" height="250"/><br />
            <label>1 - Qual das opções abaixo representam no presente a imagem ?</label><br />        

            <img id="Questao1_Correta" src="http://tecnologia.culturamix.com/blog/wp-content/uploads/2011/10/computador1.jpg" width="200"  height="200" />&nbsp;&nbsp;&nbsp;
            <img id="Questao1_Errada" src="http://www.garratech.com.br/fotos/solucao-empresarial-virtualizacao-de-servidores-big.jpg" width="200"  height="200"/>&nbsp;&nbsp;&nbsp;
            <img id="Questao1_Errada2" src="http://blogbringit.com.br/wp-content/uploads/2014/11/HP-notebook.jpg" width="200"  height="200" />

        </div>
        
        <div id="divQuestao2" style="display: none">
            <img src="http://i150.photobucket.com/albums/s94/socagada/notebook.jpg" width="250" height="250"/><br />
            <label>2 - Qual das opções abaixo representam no presente a imagem ?</label><br />
            <img id="Questao2_Errada2" src="http://tecnologia.culturamix.com/blog/wp-content/uploads/2011/10/computador1.jpg" width="200"  height="200" />&nbsp;&nbsp;&nbsp;
            <img id="Questao2_Errada" src="http://www.garratech.com.br/fotos/solucao-empresarial-virtualizacao-de-servidores-big.jpg" width="200"  height="200"/>&nbsp;&nbsp;&nbsp;
            <img id="Questao2_Correta" src="http://blogbringit.com.br/wp-content/uploads/2014/11/HP-notebook.jpg" width="200"  height="200" />

        </div>
        
        
        <div id="divQuestao3" style="display: none">
            <img src="http://www.conhecendomuseus.com.br/wp-content/uploads/2013/06/17-6-FOTO-MUSEU-DA-IMPRENSA-EXTRA-300x199.jpg" width="250" height="250"/><br />
            <label>3 - Qual das opções abaixo representam no presente a imagem ?</label><br />
            <img id="Questao3_Errada2" src="http://i.ytimg.com/vi/CxS_7Nb1fu0/maxresdefault.jpg" width="200"  height="200" />&nbsp;&nbsp;&nbsp;
            <img id="Questao3_Errada" src="http://impressorasublimacao.com/wp-content/uploads/2013/09/impressora-que-pode-imprimir-tinta-branca.jpg" width="200"  height="200"/>&nbsp;&nbsp;&nbsp;
            <img id="Questao3_Correta" src="http://img.ibxk.com.br/2015/02/20/20182607975207.jpg?w=1040" width="200"  height="200" />

        </div>
        
        <div id="divPlacar" style="display: none">
            <h1>Parabéns ! Você concluiu o desafio !</h1><br />            
            <h1>Placar</h1><br />
            
            <label>Acertos - </label><input id="txtAcertos" value=""/><br /><br />
            <label>Erros - </label><input id="txtErros" value=""/><br />
            
            <!-- Botão compartilhar Facebook -->
            <div class="fb-share-button" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button"></div>
  
        </div>
  
    </body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="resources/js/jquery-min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>   
    <script type="text/javascript" src="resources/js/jquery_plugin_date.js"></script>   
    <script type="text/javascript" src="resources/js/jquery.dataTables.bootstrap.js"></script>   
    <script src="resources/js/jquery.tablesorter.min.js" type="text/javascript"></script>
    <script src="resources/js/jquery.tablesorter.pager.js" type="text/javascript"></script> 
    
    <script>
        
        //Compartilhar no Facebook
        (function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.3";
            fjs.parentNode.insertBefore(js, fjs);
          }(document, 'script', 'facebook-jssdk'));
          
        
         function showMessageToast(message, temp) {
                $().toastmessage('showToast', {
                    text: "" + message + "",
                    stayTime: temp,
                    position: 'middle-center',
                    type: 'notice'
                });
            };
            
             function Message()
            {

                if (${param.Message != null ? true : false})
                {
                    var msg = "${param.Message}";
                    window.history.pushState({msg: 'Message'}, 'Present', 'Present');

                    showMessageToast(msg, 5000);
                }

            }
            
            $(function () {
            $('.required-clicar').tooltip({
                placement: 'right',
                title: 'Clique sobre a resposta correta!'
            });
        });
        
        var certo=0, errado=0;
        
        //Questao1
        $("#Questao1_Correta").click(function (event) {
            certo++;
            alert("Resposta correta!");
            $("#divQuestao1").css("display","none");
            $("#divQuestao2").css("display","inline");
        });
        $("#Questao1_Errada").click(function (event) {
            errado++;
            alert("Resposta errada!");
            $("#divQuestao1").css("display","none");
            $("#divQuestao2").css("display","inline");
        });
        $("#Questao1_Errada2").click(function (event) {
            errado++;
            alert("Resposta errada!");
            $("#divQuestao1").css("display","none");
            $("#divQuestao2").css("display","inline");
        });      
        
        
        
        //Questao2
        $("#Questao2_Correta").click(function (event) {
            certo++;
            alert("Resposta correta!");
            $("#divQuestao2").css("display","none");
            $("#divQuestao3").css("display","inline");
        });
        $("#Questao2_Errada").click(function (event) {
            errado++;
            alert("Resposta errada!");
            $("#divQuestao2").css("display","none");
            $("#divQuestao3").css("display","inline");
        });
        $("#Questao2_Errada2").click(function (event) {
            errado++;
            alert("Resposta errada!");
            $("#divQuestao2").css("display","none");
            $("#divQuestao3").css("display","inline");
        });
        
        
        //Questao3
        $("#Questao3_Correta").click(function (event) {
            certo++;
            alert("Resposta correta!");
            $("#divQuestao3").css("display","none");
            $("#divPlacar").css("display","inline");
            
        });
        $("#Questao3_Errada").click(function (event) {
            errado++;
            alert("Resposta errada!");
            $("#divQuestao3").css("display","none");
            $("#divPlacar").css("display","inline");
            
        });
        $("#Questao3_Errada2").click(function (event) {
            errado++;
            alert("Resposta errada!");
            $("#divQuestao3").css("display","none");
            $("#divPlacar").css("display","inline");
            
             document.getElementById('txtAcertos').value =  certo.toString();
             document.getElementById('txtErros').value =  errado.toString();
       
            
        });   
        
        
    </script>
</html>
