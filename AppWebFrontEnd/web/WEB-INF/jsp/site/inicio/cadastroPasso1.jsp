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
                <%@ include file="../inc_topo_padrao.jsp" %>
            </div>
            <div id="content">
                <h2>Cadastro Passo 1</h2>
                <div>

                </div>
                <form action="cadastroPasso1Form.do" method="POST">

                    <div class="frm_content">

                        <ul class="frm clearfix">
                            <li>
                                ${msg}
                            </li>
                            <li>
                                <label><strong>Descrição</strong></label>
                                <input type="text" name="ds_console" value="${console.ds_console}"/>
                            </li>
                            <li>
                                <label><strong>Descrição</strong></label>
                                <input type="text" name="ds_console" value="${console.ds_console}"/>
                            </li>
                            <li>
                                <label><strong>Descrição</strong></label>
                                <input type="text" name="ds_console" value="${console.ds_console}"/>
                            </li>
                            <li>
                                <label><strong>Descrição</strong></label>
                                <input type="text" name="ds_console" value="${console.ds_console}"/>
                            </li>
                            <li>
                                <label><strong>Descrição</strong></label>
                                <input type="text" name="ds_console" value="${console.ds_console}"/>
                            </li>
                            <li>
                                <label><strong>Descrição</strong></label>
                                <input type="text" name="ds_console" value="${console.ds_console}"/>
                            </li>
                            <li>
                                <input type="submit" value="Salvar" class="bt" />
                            </li>
                        </ul>
                    </div>
                </form>

            </div>
            <div id="footer">
                <%@ include file="../inc_rdp.jsp" %>
            </div>
        </div>
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>