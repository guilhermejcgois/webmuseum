<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
         import="com.lpsmuseum.webmuseum.view.ScenarioView,com.lpsmuseum.dto.scenario.ChallengePresent"
         %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <link rel="stylesheet" href="/ux/common-files/css/bootstrap.min.css">
  <link rel="stylesheet" href="/ux/common-files/css/fonts.css">
  <link rel="stylesheet" href="/ux/common-files/css/base-v4.css">
  <link rel="stylesheet" href="/ux/styles/properties.css">
  <script type="text/javascript" src="/ux/common-files/js/jquery-1.11.min.js"></script>
<script>
    var scenarioChallenge=<%= ScenarioView.getJSON(request.getParameter("id")) %>;
</script>
</head>

<body>
  <div id="_1">
    <form id="_2" role="form">
      <div id="_3">
        <div class="radio" id="_4">
          <label id="_5">
            <input type="radio" name=4e3a8747-cd14-ac20-bab0-ab3193a72394 /><span id=alter1>58 museus</span>
          </label>
        </div>
        <div class="radio" id="_6">
          <label id="_7">
            <input type="radio" name=4e3a8747-cd14-ac20-bab0-ab3193a72394 />83 museus
          </label>
        </div>
        <div class="radio" id="_8">
          <label id="_9">
            <input type="radio" name=4e3a8747-cd14-ac20-bab0-ab3193a72394 />121 museus
          </label>
        </div>
        <div class="radio" id="_10">
          <label id="_11">
            <input type="radio" checked name=4e3a8747-cd14-ac20-bab0-ab3193a72394 />132 museus
          </label>
        </div>
        <div class="radio" id="_12">
          <label id="_13">
            <input type="radio" name=4e3a8747-cd14-ac20-bab0-ab3193a72394 />156 museus
          </label>
        </div>
      </div>

      <p id="_14"></p>
      <div id="_15">
        <div id="_16"></div>
      </div>

      <h2 id="_17">Quiz</h2>
      <button id="_18"  class="btn btn-default" formaction="/ux/pages/Page1Correta.html" type="submit" >
		
        <i id="_19">
        <img src="/ux/img/next.png" align="center">
    </i>
      </button>

      <span id="_20">Você acertou: 0 de 3</span>
      <div id="_21">

        <div id="_22" class="nm-label">
          <div id="_23">
            <span id="_24">
            1<br/>
            </span>
          </div>
        </div>

        <div id="_25" class="nm-label">
          <div id="_26">
            <span id="_27">
            2<br/>
            </span>
          </div>
        </div>

        <div id="_28" class="nm-label">
          <div id="_29">
            <span id="_30">
            3<br/>
            </span>
          </div>
        </div>

      </div>
    </form>
  </div>
  <!--script type="text/javascript" src="/ux/common-files/js/require.min.js" data-main="/scripts/startup"></script-->
  <script type="text/javascript" src="/ux/setup.js" data-main="/scripts/startup"></script>
</body>

</html>