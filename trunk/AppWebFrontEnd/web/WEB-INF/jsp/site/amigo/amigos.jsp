<%-- 
    Document   : amigos
    Created on : 29/05/2011, 22:24:46
    Author     : Tiago
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html>
    <head>
        <title>Amigos</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div>
            <div id="container">
                <div id="header">
                    <%@ include file="../inc_topo_padrao.jsp" %>
                </div>
                <div id="content">
                    <div id="sidebarleft">
                        <%@ include file="../inc_navegacao.jsp" %>
                    </div>
                    <div id="main">
                        <span>In�cio > Amigos<br/><br/></span>
                            <c:if test="${amigosPendentes != null}">
                            <b>Solicita��es de Amizade</b>
                            <div class="box-df">
                                <c:forEach items="${amigosPendentes}" var="AmigoUsuario" varStatus="count" >
                                    <div style="float: right;">
                                        Aceitar<br/>N�o agora
                                    </div>
                                    <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt=""/>
                                    <ul style="float: left; width: 392px;">
                                        <li style="font-weight: bold; margin-bottom: 5px;">${AmigoUsuario.nm_usuario} ${AmigoUsuario.nm_sobrenome} (${AmigoUsuario.pontos})</li>
                                        <li>${AmigoUsuario.qtd_jogo} Jogos</li>
                                        <li>${AmigoUsuario.qtd_desejo} Desejados</li><br/>
                                    </ul>
                                    <div style="border-bottom-color: #ececed; border-bottom-style: solid; border-bottom-width: 1px; margin-bottom: 10px" class="cb"></div>
                                </c:forEach>
                            </div>
                        </c:if>
                        <b>Amigos</b>
                        <div id="usuarios"class="box-df">
                            <ul>
                                <c:forEach items="${amigos}" var="AmigoUsuario" varStatus="count" >
                                    <li style="float: left; height: 110px; width: 255px;">
                                        <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt=""/>
                                        <ul>
                                            <li style="margin-bottom: 5px;"><b>${AmigoUsuario.nm_usuario} ${AmigoUsuario.nm_sobrenome} (${AmigoUsuario.pontos})</b></li>
                                            <li>${AmigoUsuario.qtd_jogo} Jogos</li>
                                            <li>${AmigoUsuario.qtd_desejo} Desejados</li>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="cb"></div>
                            <span style="float: right;"><< anterior | pr�xima >></span>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="/inc/scripts.jsp" %>
            <!-- scripts de escopo local -->
            <%@ include file="/inc/metrics.jsp" %>
    </body>

</html>
