
<div id="content" class="clearfix">
    <p>
        <a href="listar.htm" title="Voltar para a listagem">&lt; Voltar para a listagem</a>
    </p>
    <h2>Incluir Usuários do Sistema</h2>

    <div class="frm_content">

        <ul class="frm clearfix">
            <li>
                <input type="submit" value="Salvar" class="bt" />
            </li>
            <li>
                ${msg}
            </li>
            <li>
                <label><strong>Username</strong></label>
                <input type="text" size="80" maxlength="10" name="username" value="${usuariosistema.username}"/>
            </li>
            <li>
               <label><strong>Status</strong></label>
                    <c:if test="${(usuariosistema.sn_ativo == true)}">
                        <input checked type="radio" name="sn_ativo" value="true">Ativado
                        <input type="radio" name="sn_ativo" value="false">Desativado
                    </c:if>
                    <c:if test="${(usuariosistema.sn_ativo == false)}">
                        <input type="radio" name="sn_ativo" value="true">Ativado
                        <input checked type="radio" name="sn_ativo" value="false">Desativado
                    </c:if>
                    <c:if test="${(usuariosistema.sn_ativo == null)}">
                        <input checked type="radio" name="sn_ativo" value="true">Ativado
                        <input type="radio" name="sn_ativo" value="false">Desativado
                    </c:if>
            </li>
            <li>
                <label><strong>Perfil</strong></label>
                <c:if test="${(usuariosistema.perfil=='A')}">
                    <input checked type="radio" name="perfil" value="A">Administrador
                    <input type="radio" name="perfil" value="E">Editor
                    <input type="radio" name="perfil" value="L">Leitura
                </c:if>
                <c:if test="${(usuariosistema.perfil=='E')}">
                    <input type="radio" name="perfil" value="A">Administrador
                    <input checked type="radio" name="perfil" value="E">Editor
                    <input type="radio" name="perfil" value="L">Leitura
                </c:if>
                <c:if test="${(usuariosistema.perfil=='L')}">
                    <input type="radio" name="perfil" value="A">Administrador
                    <input type="radio" name="perfil" value="E">Editor
                    <input checked type="radio" name="perfil" value="L">Leitura
                </c:if>
                <c:if test="${(usuariosistema.perfil!='L')&&(usuariosistema.perfil!='E')&&(usuariosistema.perfil!='A')}">
                    <input type="radio" name="perfil" value="A">Administrador
                    <input type="radio" name="perfil" value="E">Editor
                    <input checked type="radio" name="perfil" value="L">Leitura
                </c:if>
            </li>

            <li>
                <label><strong>Senha</strong></label>
                    <input type="password" name="password" value="${usuariosistema.password}">
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


