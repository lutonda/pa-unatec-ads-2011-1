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
                        <col width="50" />
                        <col  />
                        <col  />
                        <col  />
                        <col width="100" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th>Dt Troca</th>
                            <th>Dt Solicitação</th>
                            <th>Status</th>
                            <th>Usuário Origem</th>
                            <th>Jogo Origem</th>
                            <th>Console Origem</th>
                            <th>Dt Avaliação Origem</th>
                            <th>Pontuação Origem</th>
                            <th>Usuário Destino</th>
                            <th>Titulo Destino</th>
                            <th>Console Destino</th>
                            <th>Dt Avaliação Destino</th>
                            <th>Pontuaçao Destino</th>
                            <th></th>
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
                                    <c:out value="${Trocajogos.dt_troca}"/>
                                </td>
                                <td>
                                    <c:out value="${Trocajogos.dt_solicitacao}"/>
                                </td>
                                <td>
                                    <c:out value="${Trocajogos.status_troca}"/>
                                </td>
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