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
                <h2>Listagem de Notificações</h2>

                <div class="filtro">
                    <ul class="frm clearfix">    
                    </ul>
                </div>

                <table cellpadding="0" cellspacing="0" class="tb_list">
                    <colgroup>
                        <col width="100"/>
                        <col width="100"/>
                        <col width="100"/>
                        <col width="500"/>
                        <col width="75"/>
                        <col width="150"/>
                        
                    </colgroup>
                    <thead>
                        <tr>
                            <th>ID Notificação</th>
                            <th>ID Usuário</th>
                            <th>Nome</th>
                            <th>Descrição</th>
                            <th>Broadcast</th>
                            <th>Data Notificação</th>
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
                                    <c:out value="${Notificacoes.id_usuario}"/>
                                </td>
                                <td>
                                    <c:out value="${Notificacoes.nm_nome}"/>
                                </td>
                                <td>
                                    <c:out value="${Notificacoes.descricao}"/>
                                </td>
                                <td>
                                    <c:if test="${(Notificacoes.broadcast)==1}">
                                        <c:out value="Não"/>
                                    </c:if>
                                    <c:if test="${(Notificacoes.broadcast)==0}">
                                        <c:out value="Sim"/>
                                    </c:if>
                                </td>
                                <td>
                                    <c:out value="${Notificacoes.dt_notificacoes}"/>
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