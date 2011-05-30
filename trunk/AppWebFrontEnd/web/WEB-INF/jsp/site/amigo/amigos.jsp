<%-- 
    Document   : amigos
    Created on : 29/05/2011, 22:24:46
    Author     : Tiago
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html>
    <head>
        <title>Amigos</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div>
            <div id="container">
                <div id="header">
                    <%@ include file="../inc_topo_padrao.jsp" %>
                </div>
                <div id="content">
                    <div id="sidebarleft">
                        <%@ include file="../inc_navegacao.jsp" %>
                    </div>
                    <div id="main">
                        <span>Início > Amigos<br/><br/></span>
                        <span>Solicitações de Amizade</span>
                        <div class="box-df" style="position: relative">
                            <div style="position: absolute; top: 40px; right: 50px;">
                                <input type="submit" name="btnAceita" value="Aceitar"><br/><br/>
                                <input type="submit" name="btnAceita" value="Nao Agora">
                            </div>
                            <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 70px; height: 70px; margin-right: 10px;" alt="teste"/>
                            <ul style="float: left; width: 392px;">
                                <li style="font-size: 20px; font-weight: bold; margin-bottom: 5px;">Fulano de Tal</li>
                                <li style="margin-bottom: 5px;">9 Jogos</li>
                                <li style="margin-bottom: 15px;">5 Desejados</li><br/>
                                <li><hr></li><br/>
                            </ul>

                            <div style="position: absolute; top: 150px; right: 50px;">
                                <input type="submit" name="btnAceita" value="Aceitar"><br/><br/>
                                <input type="submit" name="btnAceita" value="Nao Agora">
                            </div>
                            <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 70px; height: 70px; margin-right: 10px;" alt="teste"/>
                            <ul style="float: left; width: 392px;">
                                <li style="font-size: 20px; font-weight: bold; margin-bottom: 5px;">Fulano de Tal</li>
                                <li style="margin-bottom: 5px;">9 Jogos</li>
                                <li style="margin-bottom: 15px;">5 Desejados</li><br/>
                                
                            </ul>
                            <div class="cb"></div>

                        </div>
                        <span>Amigos</span>
                        <div id="usuarios"class="box-df">
                            <ul>
                                <li style="float: left; height: 110px; width: 255px"><img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt="teste"/>
                                    <div>Fulanito Soares de Souza<br/>Proprietario<br/><br/>Oferta de Troca</div></li>
                                <li style="float: left; height: 110px; width: 255px; margin-right: 10px;"><img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt="teste"/>
                                    <div>Fulanito Soares de Souza<br/>Proprietario<br/><br/>Oferta de Troca</div></li>
                                <li style="float: left; height: 110px; width: 255px"><img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt="teste"/>
                                    <div>Fulanito Soares de Souza<br/>Proprietario<br/><br/>Oferta de Troca</div></li>
                                <li style="float: left; height: 110px; width: 255px; margin-right: 10px;"><img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt="teste"/>
                                    <div>Fulanito Soares de Souza<br/>Proprietario<br/><br/>Oferta de Troca</div></li>
                                <li style="float: left; height: 110px; width: 255px"><img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt="teste"/>
                                    <div>Fulanito Soares de Souza<br/>Proprietario<br/><br/>Oferta de Troca</div></li>
                                <li style="float: left; height: 110px; width: 255px"><img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt="teste"/>
                                    <div>Fulanito Soares de Souza<br/>Proprietario<br/><br/>Oferta de Troca</div></li>

                                <div class="cb"></div>
                                <span style="float: right; margin-top: 0"><< anterior | próxima >></span>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="/inc/scripts.jsp" %>
            <!-- scripts de escopo local -->
            <%@ include file="/inc/metrics.jsp" %>
    </body>

</html>
