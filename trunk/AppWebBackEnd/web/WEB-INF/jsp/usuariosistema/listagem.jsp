<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><%@ include file="/inc/taglibs.jsp" %>
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
                <h2>Usuários do Sistema</h2>

                <div class="filtro">
                    <ul class="frm clearfix">
                        <li>
                            <a href="incluir.htm" class="bt_grey">Incluir</a> <c:out value="${msg}"/>
                        </li>
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
                            <th>ID</th>
                            <th>Username</th>
                            <th>Status</th>
                            <th>Perfil</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${usuariossistema}" var="Usuariosistema" varStatus="count" >
                            <c:if test="${(count.index%2==0)}">
                                <c:set var="estiloLinha" value="even"/>
                            </c:if>
                            <c:if test="${(count.index%2==1)}">
                                <c:set var="estiloLinha" value="odd"/>
                            </c:if>

                            <tr class="${estiloLinha}">
                                <td>
                                    <c:out value="${Usuariosistema.id_user_sistema}"/>
                                </td>
                                <td>
                                    <c:out value="${Usuariosistema.username}"/>
                                </td>
                                <td>
                                 <c:if test="${Usuariosistema.sn_ativo==true}">
                                    <c:out value="Ativo"/>
                                 </c:if>
                                 <c:if test="${Usuariosistema.sn_ativo==false}">
                                    <c:out value="Desativo"/>
                                 </c:if>
                                </td>
                                <td>
                                 <c:if test="${Usuariosistema.perfil=='A'}">
                                    <c:out value="Administrador"/>
                                 </c:if>
                                 <c:if test="${Usuariosistema.perfil=='E'}">
                                    <c:out value="Editor"/>
                                 </c:if>
                                 <c:if test="${Usuariosistema.perfil=='L'}">
                                    <c:out value="Leitor"/>
                                 </c:if>
                                </td>
                                <td>
                                    <a href="editar.htm?id=${Usuariosistema.id_user_sistema}" title="Editar">Editar</a>
								|
                                    <a href="remove.htm?id=${Usuariosistema.id_user_sistema}" onclick="return(window.confirm('Confirma a exclusão?'))" title="Excluir">Excluir</a>
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