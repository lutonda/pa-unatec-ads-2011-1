<%-- 
    Document   : detalhesUsuario
    Created on : 03/06/2011, 20:19:19
    Author     : Tiago
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
                <%@ include file="/inc/inc_topo_padrao.jsp" %>
            </div>
            <div id="content">
                <div id="sidebarleft">
                    <div class="box-nav">
                        <c:if test="${DadosIniciais.imagem == null}">
                            <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 140px; height: 195px;" alt=""/>
                        </c:if>
                        <c:if test="${DadosIniciais.imagem != null}">
                            <img src="/AppWebFrontEnd/resources/perfil/${DadosIniciais.imagem}" alt=""/>
                        </c:if>
                        <ul id="nav-user">
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.trocas}</div></div><div style="padding-top: 10px;"><a href="#">Trocas Realizadas</a></div><div class="cb"></div></li>
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.oferta}</div></div><div style="padding-top: 10px;">Ofertas</div></li><div class="cb"></div>
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.desejo}</div></div><div style="padding-top: 10px;">Desejos</div></li><div class="cb"></div>
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.pontos}</div></div><div style="padding-top: 10px;">Avaliações</div></li><div class="cb"></div>
                        </ul>
                        <div class="cb"></div>
                    </div>
                    <div class="box-nav">descriçao usuario
                    </div>
                    <div class="box-nav box-nav-final">
                        <c:forEach items="${tags}" var="Tags" varStatus="count" >
                            <c:out value="${Tags.ds_tag}${count.index}"/><br/>
                        </c:forEach>
                    </div>
                </div>
                <div id="main">
                    <div id="usuarios"class="box-df">
                        <b><h1>${DadosIniciais.nm_usuario} ${DadosIniciais.nm_sobrenome}</h1 ></b><br/>
                           ${Endereco.ds_cidade} / ${Endereco.ds_estado}
                    </div>
                    <div class="box-df">
                        <ul id="notificacao">
                            <li><input type="text" name="txtMsgNotifica"></input><input type="submit" name="btnSendNotica"></input>  </li>
                            <c:forEach items="${notificacoes}" var="Notificacoes" varStatus="count" >
                                <li><a href="#">${Notificacoes.nm_nome}</a> <i>${Notificacoes.descricao}</i> ${Notificacoes.dt_notificacoes}</li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div id="usuarios "class="box-df">
                        <ul style="margin-left: 15px;">
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