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
        <title>Ajuda</title>
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

                > Vosê deverá receber um convite de um usuário já cadastrado;<br/>
                > O convite chegara via e-mail contendo um link;<br/>
                > Acesse o link e faça o cadastro que contem as seguintes questões;<br/><br/>

                > Nome;<br/>
                > Nickname;<br/>
                > Senha;<br/>
                > Endereço residencial;<br/>
                > Endereço de e-mail.<br/><br/>

                <b>OBS:</b> <br/><br/>Os dados fornecidos são de inteira responsabilidade do usuário.<br/>
                Só é possível fazer cadastro no JogaTroca via convite e esse convite só pode ser enviado por algum usuário já cadastrado.<br/>
                O JogaTroca não se responsabiliza por eventuais transtornos, podendo ser banido o usuário por fornecimento de informações falsas.<br/>

                O JogaTroca não fornece dados pessoais de seus usuários. Os mesmos ficam ocultos e confidenciais ao site.<br/><br/>

                Dúvidas leia nossos <a href="#">Termos de Uso</a>.
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