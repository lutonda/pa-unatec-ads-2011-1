<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><%@ include file="/inc/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
    <head>
        <%@ include file="/inc/taghead.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <h1>
                    <a href="#" title="Projeto Rede de Troca de Jogos" ><span style="font-size: 18px; font-weight: bold;"><br/><br/>JOGA TROCA</span><br/>Rede de troca de Jogos - <b>Área Administrativa</b></a>
                </h1>
            </div>
            <div id="content" class="clearfix">
                <fieldset class="fieldset_login">
                    <ul>
                        <li>Para acessar a área administrativa do JOGA TROCA, preencha os campos abaixo:</li>
                        <form action="loginForm.htm" method="post">
                            <li>
                                <label><strong>Login :</strong></label>
                                <input type="text" maxlength="10" name="txtUser" value="${txtUser}" size="30"/>
                            </li>
                            <li>
                                <label><strong>Senha :</strong></label>
                                <input type="password" maxlength="8" name="txtPassword" size="20"/>
                            </li>
                            <li>
                                <a href="#" title="esqueci minha senha" >esqueci minha senha</a>
                            </li>
                            <li class="bts">
                                <input type="submit" value="Acessar"/>
                            </li>
                        </form>
                        <li>${msgErro}</li>
                    </ul>

                </fieldset>
            </div>
        </div>
        <%@ include file="/inc/scripts.jsp" %>
        <!-- scripts de escopo local -->
    </body>
</html>