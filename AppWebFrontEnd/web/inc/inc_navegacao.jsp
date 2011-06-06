<div class="box-nav">
    <c:if test="${DadosIniciais.imagem == null}">
        <img src="/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg" class="imgPerfil" alt=""/>
    </c:if>
    <c:if test="${DadosIniciais.imagem != null}">
        <img src="/AppWebFrontEnd/resources/perfil/${DadosIniciais.imagem}" class="imgPerfil" alt=""/>
    </c:if>
    <div style="float: right;">
        ${DadosIniciais.pontos}<br/><a href="#" title="Replicas Pendentes">Avalia��es (${DadosIniciais.replica_pendente})</a>
    </div>
    <ul id="nav-user">
        <li><b>${DadosIniciais.nm_usuario} ${DadosIniciais.nm_sobrenome}</b><span style="display: none;" id="idUser">${DadosIniciais.id_usuario}</span> </li>
        <li><a href="#">Editar Meus Dados</a></li>
    </ul>
    <div class="cb"></div>
</div>
<div class="box-nav">
    <ul id="nav-itens">
        <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.trocas}</div></div> <div style="padding-top: 10px;"><a href="#">Trocas Realizadas</a> <span style="float: right;"><a href="#">Em Andamento (${DadosIniciais.trocas_pendentes})</a></span> </div></li><div class="cb"></div>
        <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.jogos}/<b>${DadosIniciais.oferta}</b></div></div> <div style="padding-top: 10px;">Jogos / Ofertas <span style="float: right;"><a href="#">Propostas (${DadosIniciais.propostas})</a></span> </div></li><div class="cb"></div>
        <li><div style="float: left; width: 40px; margin-bottom: 5px;"><div class="box-itemcount">${DadosIniciais.desejo}</div></div> <div style="padding-top: 10px;">Desejos <span style="float: right;"><a href="#">Possibilidades de Trocas (0)</a></span> </div> </li><div class="cb"></div>
    </ul>
</div>
<div class="box-nav">
    Convidar Amigo<span style="float: right"><a href="#">Enviar Convite</a></span>
</div>
<div class="box-nav box-nav-final">
    <c:forEach items="${tags}" var="Tags" varStatus="count" >
        <c:out value="${Tags.ds_tag}${count.index}"/><br/>
    </c:forEach>
    <span style="float: right"><a href="#">Adicionar Tags</a></span>
</div>