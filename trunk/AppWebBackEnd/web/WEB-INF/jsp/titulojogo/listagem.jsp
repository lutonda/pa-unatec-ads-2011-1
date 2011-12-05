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
                <h2>Titulo Jogos</h2>

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
                            <th>Categoria</th>
                            <th>Editora</th>
                            <th>Genero</th>
                            <th>Desenvolvedor</th>
                            <th>Linguagem</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${titulo_jogos}" var="Titulo_jogo" varStatus="count" >
                            <c:if test="${(count.index%2==0)}">
                                <c:set var="estiloLinha" value="even"/>
                            </c:if>
                            <c:if test="${(count.index%2==1)}">
                                <c:set var="estiloLinha" value="odd"/>
                            </c:if>

                            <tr class="${estiloLinha}">
                                <td>
                                    <c:out value="${Titulo_jogo.id_titulo_jogo}"/>
                                </td>
                                <td>
                                    <c:out value="${Titulo_jogo.nm_titulo}"/>
                                </td>
                                <td>
                                    <c:forEach items="${Titulo_jogo.listaCategoria}" var="Categoria" varStatus="count" >
                                        <c:out value="${Categoria.nm_categoria}"/>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${Titulo_jogo.listaEditora}" var="Editora" varStatus="count" >
                                        <c:out value="${Editora.nm_editora}"/>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${Titulo_jogo.listaGenero}" var="Genero" varStatus="count" >
                                        <c:out value="${Genero.ds_genero}"/>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${Titulo_jogo.listaDesenv}" var="Desenvolvedor" varStatus="count" >
                                        <c:out value="${Desenvolvedor.ds_desenv}"/>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${Titulo_jogo.listaLinguagem}" var="Linguagem" varStatus="count" >
                                        <c:out value="${Linguagem.nm_linguagem}"/>
                                    </c:forEach>
                                </td>
                                <td>
                                    <a href="editar.htm?id=${Titulo_jogo.id_titulo_jogo}" title="Editar">Editar</a>
								|
                                    <a href="remove.htm?id=${Titulo_jogo.id_titulo_jogo}" onclick="return(window.confirm('Confirma a exclusão?'))" title="Excluir">Excluir</a>
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