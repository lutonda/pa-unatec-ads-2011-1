<div class="frm_content">

    <ul class="frm clearfix">

        <li>
            <b>Jogos Trocados</b>
        </li>
        <li>
            <table cellpadding="0" cellspacing="0" class="tb_list">
                <colgroup>
                    <col width="50" />
                    <col  />
                    <col  />
                    <col  />
                    <col  />
                    <col  />
                    <col width="100" />
                </colgroup>
                <thead>
                    <tr>
                        <th>ID</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${usuarios}" var="Usuario" varStatus="count" >
                    <c:if test="${(count.index%2==0)}">
                        <c:set var="estiloLinha" value="even"/>
                    </c:if>
                    <c:if test="${(count.index%2==1)}">
                        <c:set var="estiloLinha" value="odd"/>
                    </c:if>

                    <tr class="${estiloLinha}">
                        <td>
                    <c:out value="${Usuario.id_usuario}"/>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </li>
    </ul>
</div>