
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
                <label><strong>Descrição </strong></label>
                <input type="text" size="80" name="descricao" value="${titulojogo.descricao}"/>
            </li>
            <li>
                <label><strong>Data Lançamento </strong></label>
                <input type="text" size="80" name="dt_lancamento" value="${titulojogo.dt_lancamento}"/>
            </li>
            <li>
                <label><strong>Categoria</strong></label>
            <c:forEach items="${titulojogo.listaCategoria}" var="Categoria" varStatus="count" >
                <c:out value="${Categoria.nm_categoria}"/>
            </c:forEach>
            </li>
            <li>
                <label><strong>Editora</strong></label>
            <c:forEach items="${titulojogo.listaEditora}" var="Editora" varStatus="count" >
                <c:out value="${Editora.nm_editora}"/>
            </c:forEach>
            </li>
            <li>
                <label><strong>Genero</strong></label>
            <c:forEach items="${titulojogo.listaGenero}" var="Genero" varStatus="count" >
                <c:out value="${Genero.ds_genero}"/>
            </c:forEach>
            </li>
            <li>
                <label><strong>Desenvolvedor</strong></label>
            <c:forEach items="${titulojogo.listaDesenv}" var="Desenvolvedor" varStatus="count" >
                <c:out value="${Desenvolvedor.ds_desenv}"/>
            </c:forEach>
            </li>
            <li>
                <label><strong>Linguagem</strong></label>
            <c:forEach items="${titulojogo.listaLinguagem}" var="Linguagem" varStatus="count" >
                <c:out value="${Linguagem.nm_linguagem}"/>
            </c:forEach>
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


