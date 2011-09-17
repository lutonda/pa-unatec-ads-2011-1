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
        <div id="container">
            <div id="header">
                <%@ include file="/inc/inc_topo_padrao.jsp" %>
            </div>
            <div id="content">
                <div id="sidebarleft">
                    <%@ include file="/inc/inc_navegacao.jsp" %>
                </div>
                <div id="main">
                    <span>Início > Amigos<br/><br/></span>
                        <c:if test="${amigosPendentes != null}">
                        <b>Solicitações de Amizade</b>
                        <div class="box-df">
                            <c:forEach items="${amigosPendentes}" var="AmigoUsuario" varStatus="count" >
                                <div style="float: right;">
                                    <a href="javascript:void(0)">Aceitar</a><br/>
                                    <a href="javascript:void(0)">Não agora</a>
                                </div>
                                <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt=""/>                                <ul style="float: left; width: 392px;">
                                    <li style="font-weight: bold; margin-bottom: 5px;"><a href="/AppWebFrontEnd/site/inicio/perfil.html?id=${AmigoUsuario.id_usuario}">${AmigoUsuario.nm_usuario} ${AmigoUsuario.nm_sobrenome} (${AmigoUsuario.pontos})</a></li>
                                    <li>${AmigoUsuario.qtd_jogo} Jogos</li>
                                    <li>${AmigoUsuario.qtd_desejo} Desejados</li><br/>
                                </ul>
                                <c:set value="border-bottom-color: #ececed; border-bottom-style: solid; border-bottom-width: 1px; margin-bottom: 10px" var="stCss"/>
                                <c:if test="${qtdSolic == (count.index + 1)}">
                                    <c:set value="" var="stCss"/>
                                </c:if>
                                <div style="${stCss}" class="cb"></div>
                            </c:forEach>
                        </div>
                    </c:if>
                    <b>Amigos</b>
                    <div id="usuarios"class="box-df">
                        <ul>
                            <c:forEach items="${amigos}" var="AmigoUsuario" varStatus="count" >
                                <div style="float: right;">
                                   <a href="javascript:void(0)">Remover</a>
                                </div>
                                <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt=""/>                                <ul style="float: left; width: 392px;">
                                    <li style="font-weight: bold; margin-bottom: 5px;"><a href="/AppWebFrontEnd/site/inicio/perfil.html?id=${AmigoUsuario.id_usuario}">${AmigoUsuario.nm_usuario} ${AmigoUsuario.nm_sobrenome} (${AmigoUsuario.pontos})</a></li>
                                    <li>${AmigoUsuario.qtd_jogo} Jogos</li>
                                    <li>${AmigoUsuario.qtd_desejo} Desejados</li><br/>
                                </ul>
                                <c:set value="border-bottom-color: #ececed; border-bottom-style: solid; border-bottom-width: 1px; margin-bottom: 10px" var="stCss"/>
                                <c:if test="${qtdAmigos == (count.index + 1)}">
                                    <c:set value="" var="stCss"/>
                                </c:if>
                                <div style="${stCss}" class="cb"></div>
                            </c:forEach>
                        </ul>
                        <div class="cb"></div>
                    </div>
                </div>
                <br class="cb"/>
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
