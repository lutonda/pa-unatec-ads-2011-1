
<div id="content" class="clearfix">
    <p>
        <a href="listar.htm" title="Voltar para a listagem">&lt; Voltar para a listagem</a>
    </p>
    <h2>Jogos</h2>

    <div class="frm_content">

        <ul class="frm clearfix">
            <li>
                <input type="submit" value="Salvar" class="bt" />
            </li>
            <li>
                ${msg}
            </li>
            <li>
                <label><strong>Titulo</strong></label>
                <select name="id_titulo_jogo">
                    <option value="0">Selecione...</option>
                    <c:forEach items="${titulojogos}" var="TituloJogo" >
                        <c:if test="${TituloJogo.id_titulo_jogo == jogo.id_titulo_jogo}">
                            <c:set var="select" value="selected=\"selected\""/>
                        </c:if>
                        <c:if test="${TituloJogo.id_titulo_jogo != jogo.id_titulo_jogo}">
                            <c:set var="select" value=""/>
                        </c:if>
                        <option ${select} value="${TituloJogo.id_titulo_jogo}">${TituloJogo.nm_titulo}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <label><strong>Console</strong></label>
                <select name="id_console">
                    <option value="0">Selecione...</option>
                    <c:forEach items="${consoles}" var="Console" >
                        <c:if test="${Console.id_console == jogo.id_console}">
                            <c:set var="select" value="selected=\"selected\""/>
                        </c:if>
                        <c:if test="${Console.id_console != jogo.id_console}">
                            <c:set var="select" value=""/>
                        </c:if>
                        <option ${select} value="${Console.id_console}">${Console.ds_console}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <label><strong>Imagem</strong></label>
                <input type="file" name="fileUploaded" />
            </li>
            <li>
            <c:if test="${jogo.imagem != null}">
                <img id="img" alt=""  src="/AppWebBackEnd/resources/capa/${jogo.imagem}"/>
            </c:if>
            </li>
            <li>
                <input type="submit" value="Salvar" class="bt" />
            </li>
        </ul>
    </div>

    <p>
        <a href="listar.htm" title="Voltar para a listagem">&lt; Voltar para a listagem</a>
    </p>
</div>


