<%-- 
    Document   : comoTrocar
    Created on : 05/06/2011, 15:55:56
    Author     : ADS - FACULDADE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Como Trocar</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
       <div id="container">
            <div id="header">
                <%@ include file="/inc/inc_topo_padrao.jsp" %>
            </div>
            <div id="content">
                <div style="float:left; width: 200px">
             <%@ include file="/inc/inc_menuAjuda.jsp" %>
                    </div>

                <div style="float:left;">
                    <h3><b>Como Trocar</b></h3>
                    <br/><br/>
                    Va em buscas e procure o jogo desejado<br/>
                    Va ao perfil do usuario que o possua e verifique os jogos desejados;<br/>
                    Se você tiver o jogo desejado, click no jogo e em solicitar troca;<br/>
                    Se não tiver, click apenas em solictar troca;<br/>
                    Aguarde a resposta do usuário;<br/><br/>
                    <b>Boa Troca!!!</b>
                    <br/><br />
                </div><br />
                <div class="cb"></div>
            </div>
             
            <div id="footer">
                <%@ include file="/inc/inc_rdp.jsp" %>
            </div>
        </div>
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->

        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>
