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
                <h2>Usuários</h2>

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
                        <col  />
                        <col  />
                        <col width="100" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Sobrenome</th>
                            <th>Email</th>
                            <th>Data Nascimento</th>
                            <th>Cidade</th>
                            <th>Estado</th>
                            <th></th>
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
                                <td>
                                    <c:out value="${Usuario.nm_usuario}"/>
                                </td>
                                <td>
                                    <c:out value="${Usuario.nm_sobrenome}"/>
                                </td>
                                <td>
                                    <c:out value="${Usuario.email}"/>
                                </td>
                                <td>
                                    <c:out value="${Usuario.dt_nascimento}"/>
                                </td>
                                <td>
                                    <c:out value="${Usuario.ds_cidade}"/>
                                </td>
                                <td>
                                    <c:out value="${Usuario.ds_Estado}"/>
                                </td>
                                <td>
                                    
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