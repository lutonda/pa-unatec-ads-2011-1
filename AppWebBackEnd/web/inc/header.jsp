<div align="center">
    <h1>
        <a href="/AppWebBackEnd/" title="Projeto Rede de Troca de Jogos" >Projeto Rede de Troca de Jogos</a>
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
        <li><a href="#" title="Relatórios">Relatórios</a></li>
        <li><a href="#" title="Configuração">Configuração</a>
            <ul>
                <li><a href="/AppWebBackEnd/convite/listar.htm" title="Convite">Convite</a></li>
                <li><a href="#" title="E-mail">E-mail</a></li>
            </ul>
        </li>
        <li><a href="/AppWebBackEnd/usuariosistema/listar.htm" title="UsuarioSistema">Usuário Sistema</a></li>
    </ul>
</div>
<div id="user">
    <p>Logado como: <strong> <%=(String)request.getSession().getAttribute("usuario") %></strong></p>
    <a href="/AppWebBackEnd/logout.htm" title="SAIR" class="bt">Sair</a>
</div> 