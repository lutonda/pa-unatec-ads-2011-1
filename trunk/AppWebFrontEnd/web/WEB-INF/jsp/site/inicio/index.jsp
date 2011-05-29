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
                    <div class="box-nav">
                        <c:if test="${DadosIniciais.imagem == null}">
                            <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" class="imgPerfil" alt=""/>
                        </c:if>
                        <c:if test="${DadosIniciais.imagem != null}">
                            <img src="/AppWebFrontEnd/resources/perfil/${DadosIniciais.imagem}" class="imgPerfil" alt=""/>
                        </c:if>
                        <ul id="nav-user">
                            <li><b>${DadosIniciais.nm_usuario} ${DadosIniciais.nm_sobrenome}</b></li>
                            <li><a href="#">Editar Meus Dados</a></li>
                            <li>${DadosIniciais.pontos}</li>
                            <li><a href="#" title="Replicas Pendentes">Avaliações (${DadosIniciais.replica_pendente})</a></li>
                        </ul>
                        <div class="cb"></div>
                    </div>
                    <div class="box-nav">
                        <ul id="nav-itens">
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.trocas}</div></div> <div style="padding-top: 10px;"><a href="#">Trocas Realizadas</a> <span style="float: right;"><a href="#">Em Andamento (${DadosIniciais.trocas_pendentes})</a></span> </div></li><div class="cb"></div>
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.jogos}/<b>${DadosIniciais.oferta}</b></div></div> <div style="padding-top: 10px;">Jogos / Ofertas <span style="float: right;"><a href="#">Propostas (${DadosIniciais.propostas})</a></span> </div></li><div class="cb"></div>
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.desejo}</div></div> <div style="padding-top: 10px;">Desejos <span style="float: right;"><a href="#">Possibilidades de Trocas (0)</a></span> </div> </li><div class="cb"></div>
                        </ul>
                    </div>
                    <div class="box-nav">
                        Convidar Amigo<span style="float: right"><a href="#">Enviar Convite</a></span>
                    </div>
                    <div class="box-nav box-nav-final">
                        <c:forEach items="${tags}" var="Tags" varStatus="count" >
                            <c:out value="${Tags.ds_tag}${count.index}"/><br/>
                        </c:forEach>
                        <span style="float: right"><a href="#">Adicionar Tags</a></span>
                    </div>
                </div>
                <div id="main">
                    <div id="usuarios"class="box-df">
                        <ul style="margin-left: 15px;">
                            <li style="margin-bottom: 20px; margin-left: -2px;"><input type="text" name="txtMsgNotifica"></input><input type="submit" value="Buscar" name="btnSendNotica"></input></li>
                            <c:forEach items="${jogos}" var="Jogo" varStatus="count2" >
                                <c:set var="estiloLinha" value="margin-right: 25px;"/>
                                <c:if test="${((count2.index+1)%5==0)}">
                                    <c:set var="estiloLinha" value=""/>
                                </c:if>
                                <li style="float: left; height: 130px; ${estiloLinha}"><c:if test="${Jogo.imagem == null}">${count2.index}<img width="80px" src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" alt=""/></c:if>
                                    <c:if test="${Jogo.imagem != null}"><img width="80px" src="/AppWebBackEnd/resources/capa/${Jogo.imagem}" alt=""/></c:if></li>
                                </c:forEach>
                            <div class="cb"></div>

                        </ul>
                        <span style="float: right; margin-top: 0"><< anterior | próxima >></span>
                    </div>
                    <div class="box-df">
                        <ul id="notificacao">
                            <li><input type="text" name="txtMsgNotifica"></input><input type="submit" name="btnSendNotica"></input>  </li>
                            <li>Fulano de Tal troca jogo (Grand Theft Auto? IV) com Fulanito</li>
                            <li>Fulano de Tal troca jogo (Grand Theft Auto? IV) com Fulanito</li>
                            <li>Fulano de Tal troca jogo (Grand Theft Auto? IV) com Fulanito</li>
                            <li>Fulano de Tal troca jogo (Grand Theft Auto? IV) com Fulanito</li>
                        </ul>
                    </div>
                </div>
                <br class="cb"/>
            </div>
            <div id="footer">
                <%@ include file="../inc_rsp.jsp" %>
            </div>
        </div>
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>