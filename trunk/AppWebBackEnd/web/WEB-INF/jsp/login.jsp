<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><%@ include file="/inc/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
	<head>
		<%@ include file="/inc/taghead.jsp" %>
	</head>
	<body>
		<div id="container">
			<div id="header">
				<h1>
					<a href="#" title="Projeto ===xxx===" >Projeto ===xxx===</a>
				</h1>
			</div>
			<div id="content" class="clearfix">
				<fieldset class="fieldset_login">
					<ul>
						<li>Para acessar a área administrativa do XXXXXXXXX XXXXXX, preencha os campos abaixo:</li>
						<li>
							<label><strong>Login :</strong></label>
							<input type="text" name="txtUser" size="30"/>
						</li>
						<li>
							<label><strong>Senha :</strong></label>
							<input type="password" name="txtPassword" size="20"/>
						</li>
						<li>
							<a href="/listagem.jsp" title="esqueci minha senha" >esqueci minha senha</a>
						</li>
						<li class="bts">
							<input type="submit" value="Acessar"/>
						</li>
					</ul>       				
													
				</fieldset>   
			</div>			
		</div>
		<%@ include file="/inc/scripts.jsp" %>
		<!-- scripts de escopo local -->
	</body>
</html>