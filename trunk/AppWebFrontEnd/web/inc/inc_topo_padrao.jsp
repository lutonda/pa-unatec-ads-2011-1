<div id="sidebarleft"><span style="font-size: 18px; font-weight: bold;"><br/><br/>TROCA DE JOGOS</span><br/>Rede de troca de Jogo</div>
<% //if ((String) request.getSession().getAttribute("usuario") != null) {%>
<div id="main">
    <div style="height: 95px;">
        <ul>
            <li style="float: left; width: 123px; margin-right: 10px; border: #ececed solid 1px;"><a href="/AppWebFrontEnd/site/inicio/index.html" title="Ir ao Início">Início</a></li>
            <li style="float: left; width: 123px; margin-right: 10px; border: #ececed solid 1px;"><a href="/AppWebFrontEnd/site/amigo/amigos.html" title="Ir aos Amigos">Amigos</a> <c:if test="${DadosIniciais.amigos_pendentes != 0}">(${DadosIniciais.amigos_pendentes})</c:if></li>
            <li style="float: left; width: 123px; margin-right: 10px; border: #ececed solid 1px;"><a href="/AppWebFrontEnd/inicio/ajuda/comoTrocar.html" title="Aprenda Como Trocar">Como Trocar</a></li>
            <li style="float: left; width: 123px; margin-right: 10px; border: #ececed solid 1px;"><a href="/AppWebFrontEnd/inicio/ajuda/perguntasFrequentes.html" title="Posso Ajuda?">Ajuda</a></li>
            <li style="float: left; width: 25px; border: #ececed solid 1px;"><a href="/AppWebFrontEnd/inicio/cadastro/logout.do" title="Sair">Sair</a></li>
        </ul>
    </div>
    <div><a id="btnMeusJogos" href="javascript:void(0);">Meus Jogos</a> | <a id="btnMeusDesejos" href="javascript:void(0);">Meus Desejos</a><span style="float:right;"><a id="btnPs3" href="javascript:void(0);">PS3</a> - <a id="btnWii" href="javascript:void(0);">WII</a> - <a id="btnXbox" href="javascript:void(0);">XBOX</a></span></div>
</div>
<%//}%>