
<div id="content" class="clearfix">
    <h2>Editar Configura��o</h2>

    <div class="frm_content">

        <ul class="frm clearfix">
            <li>
                <input type="submit" value="Salvar" class="bt" />
            </li>
            <li>
                ${msg}
            </li>
            <li>
                <label><strong>Servidor de Email</strong></label>
                <input type="text" name="serv_email" value="${Configuracao.serv_email}"/>
            </li>
            <li>
                <label><strong>Nome da Conta</strong></label>
                <input type="text" name="nm_conta" value="${Configuracao.nm_conta}"/>
            </li>
            <li>
                <label><strong>Senha</strong></label>
                <input type="text" name="senha" value="${Configuracao.senha}"/>
            </li>
            <li>
                <label><strong>Auto Ssl</strong></label>
                true  <input name="auto_ssl" type="checkbox" value="true" <c:if test="${Configuracao.auto_ssl}">checked</c:if> /> 
                False
                <input name="auto_ssl" type="checkbox" value="null" <c:if test="${!Configuracao.auto_ssl}">checked</c:if> />
            </li>
            <li>
                <label><strong>Email de Resposta</strong></label>
                <input type="text" size="30" name="email_resposta" value="${Configuracao.email_resposta}"/>
            </li>

            <li>
                <input type="submit" value="Salvar" class="bt" />
            </li>
        </ul>
    </div>
</div>


