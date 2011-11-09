<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
    <head>
        <title>Joga Troca</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="content-center">
            <div id="content" class="clearfix">
                <div style="float: right;">
                    <fieldset class="fieldset_login">
                        <ul>
                            <form action="inicio/cadastro/autForm.do" method="post">
                                <li>
                                    <label><strong>Login :</strong></label>
                                    <input type="text" maxlength="10" name="txtUser" value="${txtUser}" size="33"/>
                                </li>
                                <li>
                                    <label><strong>Senha :</strong></label>
                                    <input type="password" maxlength="8" name="txtPassword" size="21"/> <input type="submit" value="Acessar"/>
                                </li>
                                <li>
                                    <label><a href="/AppWebFrontEnd/inicio/cadastro/passo1.html">Realizar cadastro</a></label>
                                </li>
                            </form>
                            <li>${msgErro}</li>
                        </ul>

                    </fieldset>
                </div>
                <span style="font-size: 18px; font-weight: bold;"><br/><br/>TROCA DE JOGOS</span><br/>Rede de troca de Jogo
            </div>
        </div>

        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>