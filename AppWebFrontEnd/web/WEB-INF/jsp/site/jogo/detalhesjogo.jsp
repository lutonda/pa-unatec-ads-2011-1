<%-- 
    Document   : detalhesjogo
    Created on : 25/05/2011, 22:26:26
    Author     : Tiago
--%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html>
     <head>
        <title>Joga Trocas</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
               <%@ include file="../inc_topo_padrao.jsp" %>
            </div>
            <div id="content">
                <div id="sidebarleft">navega��o</div>
                <div id="main">
                    <span>In�cio > Detalhes Jogos<br/><br/></span>
                    <div class="box-df" style="position: relative">
                        <div style="position: absolute; top: 10px; right: 10px;">PS3</div>
                        <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 128px; height: 147px; margin-right: 10px;" alt="teste"/>
                        <ul style="float: left; width: 392px;">
                            <li style="font-size: 20px; font-weight: bold; margin-bottom: 5px;">Nome do Jogo Teste</li>
                            <li style="margin-bottom: 5px;">A��o</li>
                            <li style="margin-bottom: 15px;">Mult-Playe</li>
                            <li>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</li>
                        </ul>
                        <div class="cb"></div>
                    </div>
                    <div class="box-df"><span>(34) Avalie</span> <span style="float: right">Oferta (2) - Proprietarios (4) - Interesados (6)</span>  </div>
                    
                    <div class="box-df">
                        <ul>
                            <li style="float: left; height: 110px; width: 255px; margin-right: 10px;"><img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" style="float: left; width: 50px; height: 50px; margin-right: 10px;" alt="teste"/>
                                <div>Fulanito Soares de Souza<br/>Proprietario<br/><br/>Oferta de Troca</div></li>
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
                            <span style="float: right"><< anterior | pr�xima >></span>
                            <div class="cb"></div>
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