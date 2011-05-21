<div>
    <div class="frm_content divisaoDiv" >

        <ul class="frm clearfix">

            <li>
                <b>Meus Amigos</b>
            </li>
            <li>
                <div  class="rolagemDivisao">
                    <table cellpadding="0" cellspacing="0" class="tb_list tb_list_divisao">
                        <colgroup>
                            <col width="20" />
                            <col  />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nome Amigo</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${amigoUsuarios}" var="AmigoUsuario" varStatus="count" >
                            <c:if test="${(count.index%2==0)}">
                                <c:set var="estiloLinha" value="even"/>
                            </c:if>
                            <c:if test="${(count.index%2==1)}">
                                <c:set var="estiloLinha" value="odd"/>
                            </c:if>

                            <tr class="${estiloLinha}">
                            <td>
                            <c:out value="${AmigoUsuario.id_usuario_amigo}"/>
                            </td>
                            <td>
                            <c:out value="${AmigoUsuario.nm_usuario}"/> <c:out value="${AmigoUsuario.nm_sobrenome}"/>
                            </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </li>
        </ul>
    </div>

    <div class="frm_content diviaoDivE" >
        <ul class="frm clearfix">

            <li>
                <b>Lista Negra</b>
            </li>
            <li>
                <div  class="rolagemDivisao">
                    <table cellpadding="0" cellspacing="0" class="tb_list tb_list_divisao">
                        <colgroup>
                            <col width="20" />
                            <col  />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Amigo na Lista</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listasNegras}" var="listaNegra" varStatus="count" >
                            <c:if test="${(count.index%2==0)}">
                                <c:set var="estiloLinha" value="even"/>
                            </c:if>
                            <c:if test="${(count.index%2==1)}">
                                <c:set var="estiloLinha" value="odd"/>
                            </c:if>

                            <tr class="${estiloLinha}">
                            <td>
                            <c:out value="${listaNegra.id_usuario}"/>
                            </td>
                            <td>
                            <c:out value="${listaNegra.nm_usuario}"/>
                            </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </li>
        </ul>
    </div>
    <div style="clear: both;"></div>
</div>