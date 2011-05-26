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
        <title>Nome do Projeto</title>
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
                        <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" class="imgPerfil" alt="teste"/>
                        <ul id="nav-user">
                            <li><b>Magno Dias</b></li>
                            <li><a href="#"> Editar Meus Dados</a></li>
                        </ul>
                        <div class="cb"></div>
                    </div>
                    <div class="box-nav">
                        <ul id="nav-itens">
                            <li>1</li>
                            <li>2</li>
                        </ul>
                    </div>
                    <div class="box-nav">
                        Convidar Amigo
                    </div>
                    <div class="box-nav">
                        tags
                    </div>
                </div>
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