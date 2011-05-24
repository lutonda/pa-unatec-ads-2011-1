<%-- 
    Document   : index
    Created on : May 19, 2011, 11:36:41 PM
    Author     : Magno
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/inc/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
    <head>
        <title>Nome do Projeto</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <%@ include file="../inc_topo_padrao.jsp" %>
            </div>
            <div id="content">
                <div id="sidebarleft"></div>
                <div id="main"><h1>BASE PROJECT</h1></div>
                <div id="sidebarright"></div>
            </div>
            <div id="footer">
                <%@ include file="/inc/footer.jsp" %>
            </div>
        </div>
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>