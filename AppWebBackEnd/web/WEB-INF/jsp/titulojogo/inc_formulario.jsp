
<div id="content" class="clearfix">
    <p>
        <a href="listar.htm" title="Voltar para a listagem">&lt; Voltar para a listagem</a>
    </p>
    <h2>Incluir Titulos</h2>

    <div class="frm_content">

        <ul class="frm clearfix">
            <li>
                <input type="submit" value="Salvar" class="bt" />
            </li>
            <li>
                ${msg}
            </li>
            <li>
                <label><strong>Nome Titulo</strong></label>
                <input type="text" size="80" name="nm_titulo" value="${titulojogo.nm_titulo}"/>
            </li>
            <li>
                <label><strong>Tipo</strong></label>
                <select name="tipo">
                    <option value="0">Selecione...</option>
                    <c:if test="${(titulojogo.tipo == 'Single Player')&&(titulojogo.tipo != 'Multi Player')}">
                        <option selected="selected">Single Player</option>
                        <option>Multi Player</option>
                    </c:if>
                    <c:if test="${(titulojogo.tipo == 'Multi Player')&&(titulojogo.tipo != 'Single Player')}">
                        <option>Single Player</option>
                        <option selected="selected">Multi Player</option>
                    </c:if>
                    <c:if test="${(titulojogo.tipo != 'Multi Player')&&(titulojogo.tipo != 'Single Player')}">
                        <option value="Single Player">Single Player</option>
                        <option value="Multi Player">Multi Player</option>
                    </c:if>
                </select>
            </li>
            <li>
                <label><strong>Editora</strong></label>
                <select name="id_editora">
                    <option value="0">Selecione...</option>
                    <c:forEach items="${editoras}" var="Editora" >
                        <c:if test="${Editora.id_editora == titulojogo.id_editora}">
                            <c:set var="select" value="selected=\"selected\""/>
                        </c:if>
                        <c:if test="${Editora.id_editora != titulojogo.id_editora}">
                            <c:set var="select" value=""/>
                        </c:if>
                        <option ${select} value="${Editora.id_editora}">${Editora.nm_editora}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <label><strong>Genero</strong></label>
                <select name="id_genero">
                    <option value="0">Selecione...</option>
                    <c:forEach items="${generos}" var="Genero" >
                        <c:if test="${Genero.id_genero == titulojogo.id_genero}">
                            <c:set var="select" value="selected=\"selected\""/>
                        </c:if>
                        <c:if test="${Genero.id_genero != titulojogo.id_genero}">
                            <c:set var="select" value=""/>
                        </c:if>
                        <option ${select} value="${Genero.id_genero}">${Genero.ds_genero}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <label><strong>Desenvolvedor</strong></label>
                <select name="id_desenv">
                    <option value="0">Selecione...</option>
                    <c:forEach items="${desenvolvedores}" var="Desenvolvedor" >
                        <c:if test="${Desenvolvedor.id_desenv == titulojogo.id_desenv}">
                            <c:set var="select" value="selected=\"selected\""/>
                        </c:if>
                        <c:if test="${Desenvolvedor.id_desenv != titulojogo.id_desenv}">
                            <c:set var="select" value=""/>
                        </c:if>
                        <option ${select} value="${Desenvolvedor.id_desenv}">${Desenvolvedor.ds_desenv}</option>
                    </c:forEach>
                </select>
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


