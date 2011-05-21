<div class="frm_content">

    <ul class="frm clearfix">

        <li>
            <b>Dados Pessoais</b>
        </li>
        <li>
            <label><strong>Nome</strong></label>
        <c:out value="${Usuario.nm_usuario}"/> <c:out value="${Usuario.nm_sobrenome}"/>
        </li>
        <li>
            <label><strong>Email</strong></label>
        <c:out value="${Usuario.email}"/>
        </li>
        <li>
            <label><strong>Data Nascimento</strong></label>
        <c:out value="${Usuario.dt_nascimento}"/>
        </li>
        <li>
            <label><strong>Data Cadastro</strong></label>
        <c:out value="${Usuario.dt_cadastro}"/>
        </li>
        <li>
            <label><strong>Telefone</strong></label>
        <c:out value="${Usuario.tel_usuario}"/>
        </li>
        <li>
            <label><strong>Usuario</strong></label>
        <c:out value="${Usuario.usuario}"/>
        </li>
        <li>
            <label><strong>Sexo</strong></label>
        <c:if test="${Usuario.sexo == 'M'}">Masculino</c:if>
        <c:if test="${Usuario.sexo == 'S'}">Feminino</c:if>
        </li>


    </ul>
</div>