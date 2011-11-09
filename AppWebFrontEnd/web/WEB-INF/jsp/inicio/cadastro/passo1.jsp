<%--
    Document   : cadastro_passo1
    Created on : 30/05/2011, 20:36:40
    Author     : Tiago
--%>

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
                <h2>Cadastro</h2>
                <form action="cadastroPasso1Form.do" method="POST" id="formCadastro1">
                    <input type="hidden" id="id_usuario" name="id_usuario" value=""/>
                    <!--input type="hidden" id="id_usuario" name="id_usuario" value="${Usuario.id_usuario}"/-->
                    <div class="frm_content">

                        <ul class="frm clearfix">
                            <li>
                            </li>
                            <li>
                                <label><strong>Nome</strong></label>
                                <input type="text" id="nm_usuario" name="nm_usuario" value=""/>
                            </li>
                            <li>
                                <label><strong>Sobrenome</strong></label>
                                <input type="text" id="nm_sobrenome" name="nm_sobrenome" value=""/>
                            </li>
                            <li>
                                <label><strong>E-mail</strong></label>
                                <input type="text" id="email" name="email" value=""/>
                                <!--input type="text" disabled id="email" name="email" value="${Usuario.email}"/-->
                            </li>
                            <li>
                                <label><strong>Nome do Usuário</strong></label>
                                <input type="text" id="usuario" name="usuario" value=""/>
                            </li>
                            <li>
                                <label><strong>Senha</strong></label>
                                <input type="password" id="senha" name="senha" value=""/>
                            </li>
                            <li>
                                <label><strong>Confirmação da senha</strong></label>
                                <input type="password" id="conf_senha" name="conf_senha" value=""/>
                            </li>
                            <li>
                                <label><strong>Sim, aceito os termos de contrato do trocajoga.</strong></label>
                                <input type="checkbox" id="aceiteTermos" name="aceiteTermos" checked />
                            </li>
                            <li>
                                <label><strong>Sim, desejo receber as notificações de novas trocas por e-mail.</strong></label>
                                <input type="checkbox" id="aceiteNotificacoes" name="aceiteNotificacoes" checked />
                            </li>
                            <li>
                                <label><strong>Sim, aceito receber os e-mails de parceiros do trocajoga.</strong></label>
                                <input type="checkbox" id="aceiteParceiros" name="aceiteParceiros" />
                            </li>
                            <li>
                                <input type="submit" value="Salvar" class="bt" />
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
        <script type="text/javascript" src="/AppWebFrontEnd/resources/js/validacaoPasso1.js"/>
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>