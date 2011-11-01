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
                        <ul><li style="margin-bottom: 10px;">
                                <a id="btnGeneros" href="javascript:void(0);">G�neros</a> -
                                <a id="btnLancamentos" href="javascript:void(0);">Lan�amentos</a> - 
                                <a id="btnTop10" href="javascript:void(0);">Top 10</a> -
                                <a id="btnNovidades" href="javascript:void(0);">Novidades</a><br/>
                                <a id="maisDesejados" href="javascript:void(0);">Mais Desejados</a> -
                                <a id="maisTrocados" href="javascript:void(0);">Mais Trocados</a> -
                                <a id="maisQualificados" href="javascript:void(0);">Mais Qualificados</a></li></ul>
                        <ul id="listaJogos" style="height: 310px;">                            
                            <li id="campoBusca"><input type="text" id="txtBuscarJogo" size="89"></input><input type="submit" value="Buscar" id="btnBuscar"></input></li>
                        </ul>
                        <span id="paginacao" style="float: right; margin-top: 0; display: none;">&lt;&lt; <a id="ant" href="javascript:void(0);" >anterior</a> | <a href="javascript:void(0);" id="prox">pr�xima</a> >></span>
                    </div>

                    <div class="box-df">
                        <ul id="notificacao">
                            <li><input type="text" id="txtNotificacao" size="90"></input><input type="submit" value="Enviar" id="btnEnviarNotificacao"></input>  </li>
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