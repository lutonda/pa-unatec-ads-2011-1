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
                <p>
                    <a href="listar.htm" title="Voltar para a listagem">&lt; Voltar para a listagem</a>
                </p>
                <h2>Visualiza Detalhes</h2>

                 <%@ include file="inc_dadosPessoais.jsp"%>
                 <%@ include file="inc_endereco.jsp"%>
                 <%@ include file="inc_mesJogosMeusDesejos.jsp"%>
                 <%@ include file="inc_jogosTrocados.jsp"%>
                 <%@ include file="inc_notificacoesTags.jsp"%>
                 <%@ include file="inc_amigosListaNegra.jsp"%>

                <!-- Inicio da DIV de Amigos do Usu�rio-->

            </div>
                <p>
                    <a href="listar.htm" title="Voltar para a listagem">&lt; Voltar para a listagem</a>
                </p>
                <!-- Footer -->
                <div id="footer">
                    <%@ include file="/inc/footer.jsp" %>
                </div>

            </div>
            <%@ include file="/inc/scripts.jsp" %>
            <!-- scripts de escopo local -->
    </body>
</html>