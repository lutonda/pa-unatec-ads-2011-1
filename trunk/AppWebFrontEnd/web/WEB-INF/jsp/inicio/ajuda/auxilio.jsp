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
        <title>Ajuda</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <%@ include file="/inc/inc_topo_padrao.jsp" %>
            </div>
            <h2> <b>Como podemos ajudar?</b></h2><br/><br/>
            <div style="height: 95px;">
                <li><a href="/AppWebFrontEnd/inicio/ajuda/auxilio.html"><p align=right><i><b><i> < Voltar </i></b></i></p></a><br/><br/>
        <ul>
            <ol>
                <li><a href="/AppWebFrontEnd/inicio/ajuda/comoTrocar.html"><b><li type=square>Como Trocar</b></a>
                <li><a href="/AppWebFrontEnd/inicio/ajuda/orientacao.html"><b><li type=square>Como se Cadastrar</b></a>
                <li><a href="/AppWebFrontEnd/inicio/ajuda/perguntasFrequentes.html"><b><li type=square>Perguntas Frequentes</b></a>
                <li><a href="/AppWebFrontEnd/inicio/ajuda/termosdeuso.html"><b><li type=square>Termos de Uso</b></a>
            </ol>
        </ul>
            </div>
    
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->

        <script type="text/javascript" src="/AppWebFrontEnd/resources/js/listaJogos.js"></script>
        </div>

        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>
