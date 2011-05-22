<div>
<div class="frm_content">

    <ul class="frm clearfix">

        <li>
            <b>Endereco</b>
        </li>
        <li>
            <label><strong>Logradouro</strong></label>
            <c:out value="${Endereco.logradouro}"/>
        </li>
         <li>
            <label><strong>Número</strong></label>
            <c:out value="${Endereco.numero}"/>
        </li>
         <li>
            <label><strong>Complemento</strong></label>
         <c:out value="${Endereco.complemento}"/>
        </li>
        <li>
            <label><strong>Bairro</strong></label>
            <c:out value="${Endereco.ds_bairro}"/>
        </li>
         <li>
            <label><strong>CEP</strong></label>
            <c:out value="${Endereco.cep}"/>
        </li>
         <li>
            <label><strong>Cidade</strong></label>
            <c:out value="${Endereco.ds_cidade}"/>
        </li>
         <li>
            <label><strong>Estado</strong></label>
            <c:out value="${Endereco.ds_estado}"/>
        </li>
        <li>

        </li>
    </ul>
</div>
</div>