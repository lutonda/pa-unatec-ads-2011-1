
<div id="content" class="clearfix">
    <p>
        <a href="listar.htm" title="Voltar para a listagem">&lt; Voltar para a listagem</a>
    </p>

    <h2>Alterar Convite</h2>

    <div class="frm_content">

        <ul class="frm clearfix">
            <li>
                <input type="submit" value="Salvar" class="bt" />
            </li>
            <li>
                ${msg}
            </li>
            <li>
                <label><strong>Assunto</strong></label>
                <input type="text" size="129" maxlength="50" name="assunto" value="${convite.assunto}"/>
            </li>
            <li>
                <label><strong>Corpo Convite</strong></label>
                <textarea name="corpo_convite" rows="20" cols="130">${convite.corpo_convite}</textarea>
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


