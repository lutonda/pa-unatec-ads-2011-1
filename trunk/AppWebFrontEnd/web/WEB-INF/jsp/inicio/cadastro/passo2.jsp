<%--
    Document   : cadastro_passo2
    Created on : 30/05/2011, 20:36:52
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

                <form action="cadastroPasso2Form.do?id=<%= request.getParameter("id")%>
                      &usuario=<%= request.getParameter("usuario")%>" method="POST" id="formCadastro2">

                    <div class="frm_content">

                        <ul class="frm clearfix">
                            <li>
                                <label><strong>Data de Nascimento: </strong></label>
                                <input type="text" name="dt_nascimento" id="dt_nascimento" maxlength="10"/>
                                      <!-- onkeypress="formatar_mascara(this, '##/##/####')"/>-->
                            </li>
                            <li>
                                <label><strong>Sexo: </strong></label>
                                Masculino<input type="radio" name="sexo" id="sexo" value="M"/>
                                Feminino<input type="radio" name="sexo" id="sexo" value="F"/>
                            </li>
                            <li>
                                <label><strong>Telefone: </strong></label>
                                <input type="text" id="telefone" name="telefone" maxlength="10" tabindex="3"/>
                            </li>
                            <li>
                                <label><strong>Descrição do perfil: </strong></label>
                                <textarea cols="40" rows="6" id="descricao" name="descricao"> </textarea>
                            </li>

                            <li>Endereço</li>

                            <li>
                                <label><strong>CEP: </strong></label>
                                <input type="text" id="cep" name="cep" maxlength="10"/>
                                       <!--onkeypress="formatar_mascara(this, '##.###-###')" />-->
                            </li>
                            <li>
                                <label><strong>Tipo Logradouro: </strong></label>
                                <input type="text" id="tp_logradouro" name="tp_logradouro" />
                            </li>
                            <li>
                                <label><strong>Logradouro: </strong></label>
                                <input type="text" id="logradouro" name="logradouro" />
                            </li>
                            <li>
                                <label><strong>Numero: </strong></label>
                                <input type="text" id="numero" name="numero" />
                            </li>

                            <li>
                                <label><strong>Complemento: </strong></label>
                                <input type="text" id="complemento" name="complemento" />
                            </li>
                            <li>
                                <label><strong>Bairro: </strong></label>
                                <input type="text" id="bairro" name="bairro" />
                            </li>
                            <li>
                                <label><strong>Cidade: </strong></label>
                                <input type="text" id="cidade" name="cidade" />
                            </li>
                            <li>
                                <label><strong>Estado: </strong></label>
                                <input type="text" id="estado" name="estado" />
                            </li>

                            <li>
                                <label><strong>Preferências de envio: </strong></label><br/>
                            </li>
                            <li>
                                <label><strong>Em mãos.</strong></label>
                                <input type="checkbox" id="pref_maos" name="pref_maos" />
                            </li>
                            <li>
                                <label><strong>Pelos correios.</strong></label>
                                <input type="checkbox" id="pref_correio" name="pref_correio" />
                            </li>
                            <li>
                                <label><strong>Pela transportadora.</strong></label>
                                <input type="checkbox" id="pref_tansportadora" name="pref_tansportadora" />
                            </li>

                            <li>
                                <input type="submit" value="Finalizar" class="bt" />
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
        <script type="text/javascript" src="/AppWebFrontEnd/resources/js/validacaoPasso2.js"/>
        <!-- scripts de escopo local -->
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>