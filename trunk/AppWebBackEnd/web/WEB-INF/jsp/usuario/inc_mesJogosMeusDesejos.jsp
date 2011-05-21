<div>
    <div class="frm_content divisaoDiv">

        <ul class="frm clearfix">

            <li>
                <b>Meus Jogos</b>
            </li>
            <li>
                <div  class="rolagemDivisao">
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
                </div>
            </li>
        </ul>
    </div>

    <div class="frm_content diviaoDivE">

        <ul class="frm clearfix">

            <li>
                <b>Meus Desejos</b>
            </li>
            <li>
                <div class="rolagemDivisao">
                    <table cellpadding="0" cellspacing="0" class="tb_list tb_list_divisao">
                        <colgroup>
                            <col width="200" />
                            <col width="70" />
                            <col width="50"/>
                         </colgroup>
                        <thead>
                            <tr>
                                <th>Titulo</th>
                                <th>Console</th>
                                <th>Nivel Desejo</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${desejosUsuarios}" var="Desejousuario" varStatus="count" >
                            <c:if test="${(count.index%2==0)}">
                                <c:set var="estiloLinha" value="even"/>
                            </c:if>
                            <c:if test="${(count.index%2==1)}">
                                <c:set var="estiloLinha" value="odd"/>
                            </c:if>

                            <tr class="${estiloLinha}">
                            <td>
                            <c:out value="${Desejousuario.nm_titulo}"/>
                            </td>
                            <td>
                            <c:out value="${Desejousuario.ds_console}"/>
                            </td>
                             <td>
                            <c:out value="${Desejousuario.nivel_desejo}"/>
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