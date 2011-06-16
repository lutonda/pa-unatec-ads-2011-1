<div align="left">
    <h1>
        <a href="/AppWebBackEnd/" title="Projeto Rede de Troca de Jogos" ><span style="font-size: 18px; font-weight: bold;"><br/><br/>TROCA DE JOGOS</span><br/>Rede de troca de Jogo - <b>Área Administrativa</b></a>
    </h1>
</div>
<div>
    <ul id="nav">
        <li>
            <a href="#" title="Cadastros" class="selected">Cadastros</a>
            <ul>
                <li><a href="/AppWebBackEnd/console/listar.htm" title="Consoles">Consoles</a></li>
                <li><a href="/AppWebBackEnd/genero/listar.htm" title="Generos">Gêneros</a></li>
                <li><a href="/AppWebBackEnd/desenvolvedor/listar.htm" title="Desenvolvedor">Desenvolvedor</a></li>
                <li><a href="/AppWebBackEnd/editora/listar.htm" title="Editora">Editora</a></li>
                <li><a href="/AppWebBackEnd/titulojogo/listar.htm" title="TituloJogo">Titulo Jogo</a></li>
                <li><a href="/AppWebBackEnd/jogo/listar.htm" title="Jogos">Jogos</a></li>
            </ul>
        </li>
        <li>
            <a href="#" title="Relatórios">Relatórios</a>
            <ul>
                 <li><a href="/AppWebBackEnd/trocajogos/listar.htm" title="Trocajogos">Jogos Trocados</a></li>
                 <li><a href="/AppWebBackEnd/usuario/listar.htm" title="Usuario">Listar Usuario</a></li>
                 <li><a href="/AppWebBackEnd/notificacoes/listar.htm" title="Notificacoes">Listar Notificações</a></li>
            </ul>
        </li>
        <li><a href="#" title="Configuração">Configuração</a>
            <ul>
                <li><a href="/AppWebBackEnd/convite/listar.htm" title="Convite">Convite</a></li>
                <li><a href="/AppWebBackEnd/configuracao/editar.htm" title="E-mail">E-mail</a></li>
            </ul>
        </li>
        <li><a href="/AppWebBackEnd/usuariosistema/listar.htm" title="UsuarioSistema">Usuário Sistema</a></li>
    </ul>
</div>
<div id="user">
    <p>Logado como: <strong> <%=(String)request.getSession().getAttribute("usuario") %></strong></p>
    <a href="/AppWebBackEnd/logout.htm" title="SAIR" class="bt">Sair</a>
</div> 