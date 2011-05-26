<%-- 
    Document   : estrutura-pagina-a
    Created on : May 25, 2011, 8:45:43 PM
    Author     : Magno
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
    <head>
        <title>Nome do Projeto</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <%@ include file="inc_topo_padrao.jsp" %>
            </div>
            <div id="content">
                <div id="sidebarleft">navegação</div>
                <div id="main">
                    <div class="box-df">box</div>
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
                <%@ include file="/inc/footer.jsp" %>
            </div>
        </div>
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>