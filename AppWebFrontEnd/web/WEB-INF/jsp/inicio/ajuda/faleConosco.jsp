<%--
    Document   : politicaPrivacidade
    Created on : 16/10/2011, 16:54:43
    Author     : ADS - FACULDADE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/inc/taglibs.jsp" %>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fale Conosco</title>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <%@ include file="/inc/inc_topo_padrao.jsp" %>
            </div>
            <div id="content">

               <div style="float:left; width: 200px">
             <%@ include file="/inc/inc_menuAjuda.jsp" %>
                    </div>
                <div style="float:left;">
                    <h3><b>Fale conosco</b></h3>
                    <br/><br/>
                    Texto
                </div>
                 <div class="cb"></div>
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