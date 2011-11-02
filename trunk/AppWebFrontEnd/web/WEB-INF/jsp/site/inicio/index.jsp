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
                <%@ include file="/inc/inc_topo_padrao.jsp" %>
            </div>
            <div id="content">
                <div id="sidebarleft">
                    <%@ include file="/inc/inc_navegacao.jsp" %>
                </div>
                <div id="main">
                    <div class="box-df">
                        <ul>
                            <li style="margin-bottom: 10px;" id="campoBusca"><input type="text" id="txtBuscarJogo" size="89"></input><input type="submit" value="Buscar" id="btnBuscar"></input></li>
                            <li>
                                <a id="btnLancamentos" href="javascript:void(0);">Lançamentos</a> - 
                                <a id="btnTop10" href="javascript:void(0);">Top 10</a> -
                                <a id="btnNovidades" href="javascript:void(0);">Novidades</a><br/>
                                Mais: <a id="btnMaisDesejados" href="javascript:void(0);">Desejados</a> -
                                <a id="btnMaisTrocados" href="javascript:void(0);">Trocados</a> -
                                <a id="btnMaisQualificados" href="javascript:void(0);">Qualificados</a><br/>
                                
                                <ul class="dropdown">
                                    <li>
                                        Categorias
                                        <ul>
                                            <li><a id="btn" href="javascript:void(0);">Single-Playe</a></li>
                                            <li><a id="btn" href="javascript:void(0);">Mult-Playe</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        Gêneros
                                        <ul id="lsGeneros">
                                            <c:forEach items="${generos}" var="Genero" varStatus="count" >
                                                <li><a id="btn" rev="G" rel="<c:out value="${Genero.id_genero}"/>" href="javascript:void(0);"><c:out value="${Genero.ds_genero}"/></a></li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li>
                                        Editora
                                        <ul id="lsEditoras">
                                            <c:forEach items="${editoras}" var="Editora" varStatus="count" >
                                                <li><a id="btn" rev="E" rel="<c:out value="${Editora.id_editora}"/>" href="javascript:void(0);"><c:out value="${Editora.nm_editora}"/></a></li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li>
                                        Developers
                                        <ul id="lsDesenv">
                                            <c:forEach items="${desenvolvedores}" var="Desenvolvedor" varStatus="count" >
                                                <li><a id="btn" rev="D" rel="<c:out value="${Desenvolvedor.id_desenv}"/>" href="javascript:void(0);"><c:out value="${Desenvolvedor.ds_desenv}"/></a></li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <div class="cb"></div>
                        <ul id="listaJogos" style="height: 280px; margin-top: 10px">                            
                        </ul>
                        <span id="paginacao" style="float: right; margin-top: 0; display: none;">&lt;&lt; <a id="ant" href="javascript:void(0);" >anterior</a> | <a href="javascript:void(0);" id="prox">próxima</a> >></span>
                    </div>

                    <div class="box-df">
                        <ul id="notificacao">
                            <li><input type="text" id="txtNotificacao" size="90"></input><input type="submit" value="Enviar" id="btnEnviarNotificacao"></input></li>
                        </ul>
                        <span style="float: right; margin-top: 0"><a href="javascript:void(0);" id="btnMais">Mais(+)</a></span>
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
        <script type="text/javascript" src="/AppWebFrontEnd/resources/js/listaFiltroJogos.js"></script>
        <script type="text/javascript" src="/AppWebFrontEnd/resources/js/notificacoes.js"></script>

        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>