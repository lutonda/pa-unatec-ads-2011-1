<%--
    Document   : perguntasFrequentes
    Created on : 02/06/2011, 20:18:28
    Author     : ADS - FACULDADE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orientações</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <%@ include file="/inc/inc_topo_padrao.jsp" %>
            </div>
            <div id="content">

                <h2>Orientações</h2><br/><br/>



                <b>Como se Cadastrar</b><br/><br/>

                <li><a href="/AppWebFrontEnd/inicio/ajuda/auxilio.html"><p align=right><i><b><i> < Voltar </i></b></i></p></a><br/><br/>

                <li>Você deverá receber um convite de um usuário já cadastrado;<br/>
                <li>O convite chegara via e-mail contendo um link;<br/>
                <li>Acesse o link e faça o cadastro que contem as seguintes questões;<br/><br/>
                    <ol>
                <li>Nome;<br/>
                <li>Nickname;<br/>
                <li>Senha;<br/>
                <li>Endereço residencial;<br/>
                <li>Endereço de e-mail.<br/><br/>
                    </ol>
                <b>OBS:</b> <br/><br/><li>Os dados fornecidos são de inteira responsabilidade do usuário.<br/>
                <li>Só é possível fazer cadastro no JogaTroca via convite e esse convite só pode ser enviado por algum usuário já cadastrado.<br/>
                <li>O JogaTroca não se responsabiliza por eventuais transtornos, podendo ser banido o usuário por fornecimento de informações falsas.<br/>

                <li>O JogaTroca não fornece dados pessoais de seus usuários. Os mesmos ficam ocultos e confidenciais ao site.<br/><br/>

                Dúvidas leia nossos <a href="/AppWebFrontEnd/inicio/ajuda/termosdeuso.html">Termos de Uso</a>.
                <br/><br/>
            </div>
            <div id="footer">
                <%@ include file="/inc/inc_rdp.jsp" %>
            </div>
        </div>
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->

        <script type="text/javascript" src="/AppWebFrontEnd/resources/js/listaJogos.js"></script>

        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>