<div>
    <div class="frm_content divisaoDiv" >

        <ul class="frm clearfix">

            <li>
                <b>Notificações</b>
            </li>
            <li>
                <div  class="rolagemDivisao">
                    <table cellpadding="0" cellspacing="0" class="tb_list tb_list_divisao">
                        <colgroup>
                            <col width="20" />
                            <col width="50"  />
                            <col width="50"  />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Notificação</th>
                                <th>Data</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${notificacoes}" var="Notificacoes" varStatus="count" >
                            <c:if test="${(count.index%2==0)}">
                                <c:set var="estiloLinha" value="even"/>
                            </c:if>
                            <c:if test="${(count.index%2==1)}">
                                <c:set var="estiloLinha" value="odd"/>
                            </c:if>

                            <tr class="${estiloLinha}">
                                <td>
                                     <c:out value="${Notificacoes.id_notificacao}"/>
                                </td>
                                <td>
                                     <c:out value="${Notificacoes.descricao}"/>
                                </td>
                                <td>
                                    <c:out value="${Notificacoes.dt_notificacoes}"/>
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
                <b>TAGS's</b>
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
                                <th>Tags</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${tags}" var="tag" varStatus="count" >
                            <c:if test="${(count.index%2==0)}">
                                <c:set var="estiloLinha" value="even"/>
                            </c:if>
                            <c:if test="${(count.index%2==1)}">
                                <c:set var="estiloLinha" value="odd"/>
                            </c:if>
                            <tr class="${estiloLinha}">
                            <td>
                            <c:out value="${tag.id_tag}"/>
                            </td>
                            <td>
                            <c:out value="${tag.ds_tag}"/>
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