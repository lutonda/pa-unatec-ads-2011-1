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
                            <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 140px; height: 185px;" alt=""/>
                        </c:if>
                        <c:if test="${DadosIniciais.imagem != null}">
                            <img src="/AppWebFrontEnd/resources/perfil/${DadosIniciais.imagem}" alt=""/>
                        </c:if>
                        <ul id="nav-user">
                            <li><div style="float: left; width: 40px; margin-bottom: 6px;"><div class="box-itemcount">${DadosIniciais.trocas}</div></div><div style="padding-top: 10px; width: 150px;"><a href="#">Trocas Realizadas</a></div><div class="cb"></div></li>
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.jogos}/<b>${DadosIniciais.oferta}</b></div></div><div style="padding-top: 10px;"><a id="btnMeusJogos" href="javascript:void(0);">Jogos</a> / <a id="btnOfertas" href="javascript:void(0);">Ofertas</a></div></li><div class="cb"></div>
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.desejo}</div></div><div style="padding-top: 10px;"><a id="btnMeusDesejos" href="javascript:void(0);">Desejos</a></div></li><div class="cb"></div>
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.pontos}</div></div><div style="padding-top: 10px;">Reputação</div></li><div class="cb"></div>
                        </ul>
                        <div class="cb"></div>
                    </div>
                    <div class="box-nav">${DadosIniciais.descricao_usuario}</div>
                    <div class="box-nav box-nav-final">
                        <c:forEach items="${tags}" var="Tags" varStatus="count" >
                            <a href="#"> <c:out value="${Tags.ds_tag}"/> </a> &nbsp;&nbsp;
                        </c:forEach>
                    </div>
                </div>
                <div id="main">
                    <div id="usuarios" class="box-df">
                        <span style="font-size: 18px; font-weight: bold;">${DadosIniciais.nm_usuario} ${DadosIniciais.nm_sobrenome}</span><span style="display: none;" id="idUser">${DadosIniciais.id_usuario}</span><span style="display: none;" id="idUserAmigo">${AmigoUsuario.id_amigo_usuario}</span> <br/>
                        ${Endereco.ds_cidade} / ${Endereco.ds_estado} <span id="acaoRsp" style="float: right">
                            <c:if test="${AmigoUsuario.sn_aceite == 0 && AmigoUsuario.solitante == 'N' }"><a id="btnRspCancelar" href="javascript:void(0)">Cancelar Solicitação</a></c:if>
                            <c:if test="${AmigoUsuario.sn_aceite == 0 && AmigoUsuario.solitante == 'S' }"><a id="btnRspSolitacao" href="javascript:void(0)">Responder a Solicitação</a></c:if>
                            <c:if test="${AmigoUsuario.sn_aceite == 1 }"><a id="btnRemoverSolitacao" href="javascript:void(0)">Remover</a></c:if>
                            <c:if test="${AmigoUsuario.id_usuario == 0 && DadosIniciais.id_usuario != IdParam}"><a href="#">Adicionar</a></c:if></span>
                    </div>
                    <div class="box-df">
                        <ul id="notificacao">
                            <li><c:if test="${AmigoUsuario.ignorado == 0}"><input type="text" id="txtNotificacao" size="90"></input><input type="submit" value="Enviar" id="btnEnviarNotificacao"></input></c:if></li>
                        </ul>
                        <span style="float: right; margin-top: 0"><a href="javascript:void(0);" id="btnMais">Mais(+)</a></span>
                    </div>
                    <div class="box-df">
                        <ul id="listaJogos" style="margin-left: 15px; height: 260px;">
                            <li></li>
                        </ul>
                        <span id="paginacao" style="float: right; margin-top: 0; display: none;">&lt;&lt; <a id="ant" href="javascript:void(0);" >anterior</a> | <a href="javascript:void(0);" id="prox">próxima</a> >></span>
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
        <script type="text/javascript" src="/AppWebFrontEnd/resources/js/listaJogos.js"></script>
        <script type="text/javascript" src="/AppWebFrontEnd/resources/js/notificacoes.js"></script>
        <script type="text/javascript" src="/AppWebFrontEnd/resources/js/ctrlUsuarioPerfil.js"></script>
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>