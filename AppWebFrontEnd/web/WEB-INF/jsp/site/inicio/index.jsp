<%-- 
    Document   : index
    Created on : May 19, 2011, 11:36:41 PM
    Author     : Magno
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
    <head>
        <title>Joga Troca</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <%@ include file="../inc_topo_padrao.jsp" %>
            </div>
            <div id="content">
                <div id="sidebarleft">
                    <%@ include file="../inc_navegacao.jsp" %>
                </div>
                <div id="main">
                    <div id="usuarios"class="box-df">
                        <ul style="margin-left: 15px;">
                            <li style="margin-bottom: 20px; margin-left: -2px;"><input type="text" name="txtMsgNotifica"></input><input type="submit" value="Buscar" name="btnSendNotica"></input></li>
                            <c:forEach items="${jogos}" var="Jogo" varStatus="count" >
                                <c:set var="estiloLinha" value="margin-right: 25px;"/>
                                <c:if test="${((count.index+1)%5==0)}">
                                    <c:set var="estiloLinha" value=""/>
                                </c:if>
                                <li style="float: left; height: 130px; ${estiloLinha}"><c:if test="${Jogo.imagem == null}"><img width="80px" src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" alt=""/></c:if>
                                    <c:if test="${Jogo.imagem != null}"><a title="${Jogo.titulo_jogo}" href="/AppWebFrontEnd/site/jogo/detalhesjogo.html?id=${Jogo.id_jogo}"><img width="80px" src="/AppWebBackEnd/resources/capa/${Jogo.imagem}" alt=""/></a></c:if></li>
                                </c:forEach>
                            <div class="cb"></div>

                        </ul>
                        <span style="float: right; margin-top: 0"><< anterior | próxima >></span>
                    </div>
                    <div class="box-df">
                        <ul id="notificacao">
                            <li><input type="text" name="txtMsgNotifica"></input><input type="submit" name="btnSendNotica"></input>  </li>
                            <c:forEach items="${notificacoes}" var="Notificacoes" varStatus="count" >
                                <li><a href="#">${Notificacoes.nm_nome}</a> <i>${Notificacoes.descricao}</i> ${Notificacoes.dt_notificacoes}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <br class="cb"/>
            </div>
            <div id="footer">
                <%@ include file="../inc_rdp.jsp" %>
            </div>
        </div>
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>