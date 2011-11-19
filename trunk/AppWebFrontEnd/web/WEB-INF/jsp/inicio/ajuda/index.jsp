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
        <title>Index</title>
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
                <div style="float:left; display: block; width: 772px">
                    <h3><b>Ajuda</b></h3>
                    <br/><br/>
                    O JogaTroca é uma rede social feita para fanáticos por jogos, usuários podem se cadastrar por convite de um usuário já cadastrado ou no cadastre-se já, que é obrigatória a confirmação de e-mail.<br/>
                    No site você encontrará as mais diversas mídias dos consoles mais utilizados.<br/>
                    Os usuários não fazem o cadastro de seus jogos, apenas troca eles, eles são selecionados e aparecem em seu perfil como jogos que tenho ou jogos que possuo, desse modo é mais fácil a comunicação e evida fraudes.<br/><br/>
                    Navegue pelo menu ao lado para facilitar seu acesso.<br/><br/>

                    Seja Bem Vindo ao JogaTroca!!!
                </div>
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