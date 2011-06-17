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
                
                <form action="cadastroPasso2Form.do?id=<%= request.getParameter("id") %>
                      &usuario=<%= request.getParameter("usuario") %>" method="POST">

                    <div class="frm_content">

                        <ul class="frm clearfix">
                            <li>
                                <label><strong>Data de Nascimento: </strong></label>
                                <input type="text" name="dt_nascimento" value=""
                                       maxlength="10" onkeypress="formatar_mascara(this, '##/##/####')"/>
                            </li>
                            <li>
                                <label><strong>Sexo: </strong></label>
                                <input type="radio" name="sexo" value="0"/>Masculino
                                <input type="radio" name="sexo" value="1"/>Feminino
                            </li>
                             <li>
                                <label><strong>Telefone: </strong></label>
                                <input type="text" name="telefone" maxlength="12"
                                       onkeypress="formatar_mascara(this, '## ####-####')"/>
                            </li>
                            <li>
                                <label><strong>Descrição do perfil: </strong></label>
                                <textarea cols="40" rows="6" name="descricao"> </textarea>
                            </li>
                                                        
                            <li>Endereço</li>

                            <li>
                                <label><strong>CEP: </strong></label>
                                <input type="text" name="cep" maxlength="11"
                                       onkeypress="formatar_mascara(this, '##.###-###')" />
                            </li>
                            <li>
                                <label><strong>Tipo Logradouro: </strong></label>
                                <input type="text" name="tp_logradouro" />
                            </li>
                            <li>
                                <label><strong>Logradouro: </strong></label>
                                <input type="text" name="logradouro" />
                            </li>
                            <li>
                                <label><strong>Numero: </strong></label>
                                <input type="text" name="numero" />
                            </li>

                            <li>
                                <label><strong>Complemento: </strong></label>
                                <input type="text" name="complemento" />
                            </li>
                            <li>
                                <label><strong>Bairro: </strong></label>
                                <input type="text" name="bairro" />
                            </li>
                            <li>
                                <label><strong>Cidade: </strong></label>
                                <input type="text" name="cidade" />
                            </li>
                            <li>
                                <label><strong>Estado: </strong></label>
                                <input type="text" name="estado" />
                            </li>

                            <li>
                                <label><strong>Preferências de envio </strong></label><br/>
                                <input type="checkbox" name="pref_maos" />Em mãos <br/>
                                <input type="checkbox" name="pref_correio" />Pelo correios <br/>
                                <input type="checkbox" name="pref_tansportadora" />Pela transportadora <br/>
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
        <!-- scripts de escopo local -->
        <%@ include file="/inc/metrics.jsp" %>
    </body>
</html>