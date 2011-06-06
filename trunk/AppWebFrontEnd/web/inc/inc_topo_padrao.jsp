<div id="sidebarleft">logo</div>
<div id="main">
    <div style="height: 95px;">
        <ul>
            <li style="float: left; width: 134px; margin-right: 10px; border: #ececed solid 1px;"><a href="/AppWebFrontEnd/site/inicio/index.html" title="Ir ao Início">Início</a></li>
            <li style="float: left; width: 134px; margin-right: 10px; border: #ececed solid 1px;"><a href="/AppWebFrontEnd/site/amigo/amigos.html" title="Ir aos Amigos">Amigos</a> <c:if test="${DadosIniciais.amigos_pendentes != 0}">(${DadosIniciais.amigos_pendentes})</c:if></li>
            <li style="float: left; width: 134px; margin-right: 10px; border: #ececed solid 1px;">Como Trocar</li>
            <li style="float: left; width: 134px; border: #ececed solid 1px;">Ajuda</li>
        </ul>
    </div>
    <div><a id="btnMeusJogos" href="javascript:void(0);">Meus Jogos</a> | <a id="btnMeusDesejos" href="javascript:void(0);">Meus Desejos</a><span style="float:right;"><a id="btnPs3" href="javascript:void(0);">PS3</a> - <a id="btnWii" href="javascript:void(0);">WII</a> - <a id="btnXbox" href="javascript:void(0);">XBOX</a></span></div>
</div>