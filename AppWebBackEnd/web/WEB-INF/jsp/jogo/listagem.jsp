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
                <h2>Jogos</h2>

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
                            <th>Titulo</th>
                            <th>Console</th>
                            <th>Imagem</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${jogos}" var="Jogo" varStatus="count" >
                            <c:if test="${(count.index%2==0)}">
                                <c:set var="estiloLinha" value="even"/>
                            </c:if>
                            <c:if test="${(count.index%2==1)}">
                                <c:set var="estiloLinha" value="odd"/>
                            </c:if>

                            <tr class="${estiloLinha}">
                                <td>
                                    <c:out value="${Jogo.id_jogo}"/>
                                </td>
                                <td>
                                    <c:out value="${Jogo.titulo_jogo}"/>
                                </td>
                                <td>
                                    <c:out value="${Jogo.console}"/>
                                </td>
                                <td>
                                    <c:out value="${Jogo.imagem}"/>
                                </td>
                                <td>
                                    <a href="editar.htm?id=${Jogo.id_jogo}" title="Editar">Editar</a>
								|
                                    <a href="remove.htm?id=${Jogo.id_jogo}" onclick="return(window.confirm('Confirma a exclus�o?'))" title="Excluir">Excluir</a>
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