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
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.oferta}</div></div><div style="padding-top: 10px;"><a href="#">Ofertas</a></div></li><div class="cb"></div>
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.desejo}</div></div><div style="padding-top: 10px;"><a href="#">Desejos</a></div></li><div class="cb"></div>
                            <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.pontos}</div></div><div style="padding-top: 10px;"><a href="#">Avaliações</a></div></li><div class="cb"></div>
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
                    <div id="usuarios"class="box-df">
                        <span style="font-size: 18px; font-weight: bold;">${DadosIniciais.nm_usuario} ${DadosIniciais.nm_sobrenome}</span> <span style="display: none;" id="idUser">${DadosIniciais.id_usuario}</span><br/>
                        ${Endereco.ds_cidade} / ${Endereco.ds_estado} <span style="float: right"><a href="#">Adicionar</a></span>
                    </div>
                    <div class="box-df">
                        <ul id="notificacao">
                            <li><input type="text" id="txtMsgNotifica" size="90"></input><input type="submit" name="btnSendNotica"></input>  </li>
                        </ul>
                        <span style="float: right; margin-top: 0"><< <a id="anterior" href="javascript:void(0);" >anterior</a> | <a href="javascript:void(0);" id="proximo">próxima</a> >></span>
                    </div>
                    <div class="box-df">
                        <ul id="listaJogos" style="margin-left: 15px; height: 260px;">
                            <li></li>
                        </ul>
                        <span style="float: right; margin-top: 0"><< <a id="ant" href="javascript:void(0);" >anterior</a> | <a href="javascript:void(0);" id="prox">próxima</a> >></span>
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
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>