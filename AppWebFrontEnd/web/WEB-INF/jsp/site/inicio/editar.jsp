<%-- 
    Document   : editar
    Created on : 14/06/2011, 20:09:57
    Author     : ALEXANDRE
--%>

<%@page import="una.pa.model.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
    <head>
        <title>Joga Troca</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <%@ include file="/inc/inc_topo_padrao.jsp" %>
            </div>
            <div id="content">
                <h2>Informações basicas</h2>
                <div>

                </div>
                <form action="updateEditarDados.do" method="POST">
                    <input type="hidden" name="id_usuario" value="${Usuario.id_usuario}"/>
                    <div class="frm_content">

                        <ul class="frm clearfix">
                            <li>
                            </li>
                            <li>
                                <label><strong>Nome</strong></label>
                                <input type="text" name="nm_usuario" value="${Usuario.nm_usuario}"/>
                            </li>
                            <li>
                                <label><strong>Sobrenome</strong></label>
                                <input type="text" name="nm_sobrenome" value="${Usuario.nm_sobrenome}"/>
                            </li>
                            <li>
                                <label><strong>E-mail</strong></label>
                                <input type="text" disabled name="email" value="${Usuario.email}"/>
                            </li>
                            <li>
                                <label><strong>Nome do Usuário</strong></label>
                                <input type="text" name="usuario" value="${Usuario.usuario}"/>
                            </li>
                            <li>
                                <label><strong>Senha</strong></label>
                                <input type="text" name="senha" value="${Usuario.senha}"/>
                            </li>
                            <li>
                                <label><strong>Confirmação da senha</strong></label>
                                <input type="text" name="conf_senha" value="${Usuario.senha}"/>
                            </li>

                            <li>
                                <label><strong>Sexo: </strong></label>
                                <c:set var="usu" value='${Usuario.sexo}'></c:set>
                                <jsp:useBean id="usu" type="java.lang.String"></jsp:useBean>
                                <c:if test='<%=usu.equals("M")%>'>
                                    <input type="radio" checked name="sexo" value="M"/>Masculino
                                    <input type="radio" name="sexo" value="F"/>Feminino
                                </c:if>
                                <c:if test='<%=usu.equals("F")%>'>
                                    <input type="radio" name="sexo" value="M"/>Masculino
                                    <input type="radio" checked name="sexo" value="F"/>Feminino
                                </c:if>
                            </li>

                            <li>
                                <label><strong>Data de Nascimento: </strong></label>
                                <c:set var="nasc" value='${Usuario.dt_nascimento}'></c:set>
                                <jsp:useBean id="nasc" type="java.lang.String"></jsp:useBean>
                                <%String dia = nasc.substring(8, 10);
                                  dia += "/"+nasc.substring(5, 7);
                                  dia += "/"+nasc.substring(0, 4);
                                %>
                                <input type="text" name="dt_nascimento" value='<%=dia%>'
                                       maxlength="10" onkeypress="formatar_mascara(this, '##/##/####')"/> Somente números
                            </li>
                                <c:set var="telef" value='${Usuario.tel_usuario}'></c:set>
                                <jsp:useBean id="telef" type="java.lang.String"></jsp:useBean>
                                <%String tel = telef.substring(0, 2);
                                  tel = telef.substring(0, 2)+" "+telef.substring(2, 6)+"-"+telef.substring(6);
                                %>
                             <li>
                                <label><strong>Telefone: </strong></label>
                                <input type="text" name="telefone" maxlength="12" value='<%=tel%>'
                                       onfocus=" " onkeypress="formatar_mascara(this, '## ####-####')"/> DDD + Telefone - Somente números
                            </li>
                            <ul>
                                <label><strong>Descrição do perfil: </strong></label>
                                <textarea style="position: static "name="descricao" rows="10" cols="180" >${Usuario.descricao_usuario}</textarea>
                            </ul>

                            <label><strong>Dados da localidade</strong></label>

                            <li>
                                <label><strong>CEP: </strong></label>
                                <input type="text" name="cep" maxlength="10" value='${Endereco.cep}'
                                       onkeypress="formatar_mascara(this, '##.###-###')" />
                            </li>
                            <li>
                                <label><strong>Tipo Logradouro: </strong></label>
                                <input type="text" name="tp_logradouro" value="${Endereco.tp_logradouro}"/>
                            </li>
                            <li>
                                <label><strong>Logradouro: </strong></label>
                                <input type="text" name="logradouro" value="${Endereco.logradouro}"/>
                            </li>
                            <li>
                                <label><strong>Numero: </strong></label>
                                <input type="text" name="numero" value="${Endereco.numero}"/>
                            </li>

                            <li>
                                <label><strong>Complemento: </strong></label>
                                <input type="text" name="complemento" value="${Endereco.complemento}"/>
                            </li>
                            <li>
                                <label><strong>Bairro: </strong></label>
                                <input type="text" name="bairro" value="${Endereco.ds_bairro}"/>
                            </li>
                            <li>
                                <label><strong>Cidade: </strong></label>
                                <input type="text" name="cidade" value="${Endereco.ds_cidade}"/>
                            </li>
                            <li>
                                <label><strong>Estado: </strong></label>
                                <input type="text" name="estado" value="${Endereco.ds_estado}"/>
                            </li>

                            <li>
                                <input type="submit" value="Salvar Alterações" name="btSalvar"/>
                            </li>

                        </ul>
                    </div>
                </form>

            </div>
            <div id="footer">
                <%@ include file="/inc/inc_rdp.jsp" %>
            </div>
        </div>
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>