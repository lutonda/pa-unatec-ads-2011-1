<div class="frm_content">

    <ul class="frm clearfix">

        <li>
            <b>Jogos Trocados</b>
        </li>
        <li>
            <div style="overflow: scroll; overflow-x:hidden; height: 200px">
                <table cellpadding="0" cellspacing="0" class="tb_list">
                    <colgroup>
                        <col width="89"/>
                        <col width="89"/>
                        <col width="50"/>
                        <col width="50"/>
                        <col />
                        <col />
                        <col />
                        <col width="89"/>
                        <col width="110" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th>Data Solicitação</th>
                            <th>Data Troca </th>
                            <th>Status</th>
                            <th>Tipo</th>
                            <th>Usuário</th>
                            <th>Jogo</th>
                            <th>Console</th>
                            <th>Data Avaliação</th>
                            <th>Pontuação</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${trocajogos}" var="Trocajogos" varStatus="count" >
                        <c:if test="${(count.index%2==0)}">
                            <c:set var="estiloLinha" value="even"/>
                        </c:if>
                        <c:if test="${(count.index%2==1)}">
                            <c:set var="estiloLinha" value="odd"/>
                        </c:if>

                        <tr class="${estiloLinha}">
                            <td>
                        <c:out value="${Trocajogos.dt_solicitacao}"/>
                        </td>
                        <td>
                        <c:out value="${Trocajogos.dt_troca}"/>
                        </td>
                        <td>
                        <c:out value="${Trocajogos.status_troca}"/>
                        </td>
                        <td>Origem</td>
                        <td>
                        <c:out value="${Trocajogos.nm_usuario_origem}"/>
                        </td>
                        <td>
                        <c:out value="${Trocajogos.nm_titulo_origem}"/>
                        </td>
                        <td>
                        <c:out value="${Trocajogos.ds_console_origem}"/>
                        </td>
                        <td>
                        <c:out value="${Trocajogos.dt_avaliacao_origem}"/>
                        </td>
                        <td>
                        <c:out value="${Trocajogos.pontos_origem}"/>
                        </td>

                        </tr>
                        <tr class="${estiloLinha}">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Destino</td>
                            <td>
                        <c:out value="${Trocajogos.nm_usuario_destino}"/>
                        </td>
                        <td>
                        <c:out value="${Trocajogos.nm_titulo_destino}"/>
                        </td>
                        <td>
                        <c:out value="${Trocajogos.ds_console_destino}"/>
                        </td>
                        <td>
                        <c:out value="${Trocajogos.dt_avaliacao_destino}"/>
                        </td>
                        <td>
                        <c:out value="${Trocajogos.pontos_destino}"/>
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </li>
    </ul>
</div>