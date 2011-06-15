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
                        <ul id="listaJogos" style="margin-left: 15px; height: 310px;">
                            <li id="campoBusca"><input type="text" id="txtBuscarJogo" ></input><input type="submit" value="Buscar" id="btnBuscar"></input></li>
                        </ul>
                        <span style="float: right; margin-top: 0"><< <a id="ant" href="javascript:void(0);" >anterior</a> | <a href="javascript:void(0);" id="prox">próxima</a> >></span>
                    </div>
                    <div class="box-df">
                        <ul id="notificacao">
                            <li><input type="text" id="txtNotificacao" size="90"></input><input type="submit" id="btnEnviarNotificacao"></input>  </li>
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
        <script type="text/javascript" src="/AppWebFrontEnd/resources/js/notificacoes.js"></script>

        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>