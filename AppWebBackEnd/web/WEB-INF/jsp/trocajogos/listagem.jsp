<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
    <head>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="container">
            <!-- Header -->
            <div id="header">
                <%@ include file="/inc/header.jsp" %>
            </div>

            <!-- Content -->
            <div id="content" class="clearfix">
                <h2>Listagem de Troca de Jogos</h2>

                <div class="filtro">
                    <ul class="frm clearfix">    
                    </ul>
                </div>

                <table cellpadding="0" cellspacing="0" class="tb_list">
                    <colgroup>
                        <col />
                        <col />
                        <col />
                        <col />
                        <col />
                        <col />
                        <col />
                        <col />
                        <col />
                    </colgroup>
                    <thead>
                        <tr>
                            <th>Data Solicita��o</th>
                            <th>Data Troca </th>
                            <th>Status</th>
                            <th>Tipo</th>
                            <th>Usu�rio</th>
                            <th>Jogo</th>
                            <th>Console</th>
                            <th>Data Avalia��o</th>
                            <th>Pontua��o</th>

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

            <!-- Footer -->
            <div id="footer">
                <%@ include file="/inc/footer.jsp" %>
            </div>

        </div>
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->
    </body>
</html>