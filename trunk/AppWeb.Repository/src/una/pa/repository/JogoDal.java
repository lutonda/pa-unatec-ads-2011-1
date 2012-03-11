/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.repository;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import una.pa.model.Jogo;

/**
 *
 * @author Felipe
 */
public class JogoDal {

    public static List<Jogo> listaDal() {
        return listaDal(0, 0, 0, null, 0, -1);
    }

    public static List<Jogo> listaDal(int pId_usuario, int quantidePorPagina, int pagina) {
        return listaDal(pId_usuario, quantidePorPagina, pagina, null, 0, -1);
    }

    public static List<Jogo> listaDal(int pId_usuario, int quantidePorPagina, int pagina, String busca, int console, int nivelOferta) {

        String sql = "";
        String sqlWhere = "";

        if (console != 0) {
            sqlWhere = "where j.id_console = " + console;
        }
        if (busca != null) {
            sqlWhere = "where nm_titulo like '%" + busca + "%'";
        }
        if (pId_usuario != 0) {
            sqlWhere = "where ju.id_usuario = " + pId_usuario;
        }
        if (nivelOferta != -1){
            sqlWhere += " and NIVEL_INTERESSE = " + nivelOferta;
        }
        
        int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }

        sql = "select top " + quantidePorPagina + " * from (select distinct row_number() over (order by j.id_jogo) as linha"
                + ", (select distinct count( distinct j.id_jogo) from jogo j "
                + "left join console c on j.id_console = c.id_console "
                + "left join jogo_usuario ju on j.id_jogo = ju.id_jogo "
                + " " + sqlWhere + ") as totalregistros"
                + ", j.id_jogo, j.id_console, j.id_titulo_jogo, imagem, nm_titulo, ds_console "
                + "from jogo j "
                + "left join titulo_jogo t on j.id_titulo_jogo = t.id_titulo_jogo "
                + "left join console c on j.id_console = c.id_console "
                + "left join jogo_usuario ju on j.id_jogo = ju.id_jogo "
                + "" + sqlWhere + " ) as buscapaginada where linha > " + inicio + " and linha <= " + fim;

        if ((busca == null) && (pId_usuario == 0) && (console == 0)) {
            sql = "select *, '0' as totalregistros "
                    + "from jogo j "
                    + "left join titulo_jogo t on j.id_titulo_jogo = t.id_titulo_jogo "
                    + "left join console c on j.id_console = c.id_console";
        }


        List<Jogo> objC = new ArrayList<Jogo>();

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Jogo o = new Jogo();

                o.setId_jogo(Integer.parseInt(rs.getString("ID_JOGO").toString()));
                o.setId_console(Integer.parseInt(rs.getString("ID_CONSOLE")));
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO")));
                o.setImagem(rs.getString("IMAGEM"));
                o.setTitulo_jogo(rs.getString("NM_TITULO"));
                o.setConsole(rs.getString("DS_CONSOLE"));
               // if ((busca != null) || (pId_usuario != 0) || (console != 0))
               //     o.setNivelInteresse(rs.getString("NIVEL_INTERESSE"));
                o.setTotal(Integer.parseInt(rs.getString("totalregistros")));
                objC.add(o);
            }

            rs.close();
            c.close();

            return objC;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean altera(Jogo _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "UPDATE JOGO "
                    + "SET ID_TITULO_JOGO = ? "
                    + ",ID_CONSOLE = ? "
                    + ",IMAGEM = ? "
                    + "WHERE ID_JOGO = ? ";

            Object[] vetor = {(_obj.getId_titulo_jogo() != 0) ? _obj.getId_titulo_jogo() : null,
                (_obj.getId_console() != 0) ? _obj.getId_console() : null,
                _obj.getImagem(), _obj.getId_jogo()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean incluir(Jogo _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "INSERT INTO JOGO(ID_TITULO_JOGO,ID_CONSOLE,IMAGEM) "
                    + "VALUES(?,?,?)";

            Object[] vetor = {_obj.getId_titulo_jogo(), _obj.getId_console(), _obj.getImagem()};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean excluir(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "DELETE FROM JOGO WHERE ID_JOGO = ?";
            Object[] vetor = {_id};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static Jogo detalhesJogo(int _id) {
        String sql = "select j.id_jogo,"
                    + "	tj.id_titulo_jogo,"
                    + "	tj.nm_titulo,"
                    + "	c.ds_console,"
                    + "	j.imagem, "
                    + " tj.descricao,"
                    + "	avg(isnull(pontos, 0)) as pontos,"
                    + "	(SELECT isnull(count(*),0) FROM JOGO_USUARIO where id_jogo = j.id_jogo)as proprietario,"
                    + "	(SELECT isnull(count(*),0) FROM JOGO_DESEJADO WHERE ID_JOGO = j.id_jogo) interessado,"
                    + "	(select isnull(count(*),0) from jogo_usuario where id_jogo = j.id_jogo and nivel_interesse = 0) as oferta ,"
                    + "	(select isnull(avg(pontos),0) from dbo.AVALIACAO_JOGO where id_jogo = j.id_jogo) as avalicacao"
                    + "	 from jogo j"
                    + "	   inner join titulo_jogo tj on j.id_titulo_jogo = tj.id_titulo_jogo"
                    + "	   inner join console c on c.id_console = j.id_console"
                    + "	   left join avaliacao_jogo aj on j.id_jogo = aj.id_jogo"
                    + "	 where j.id_jogo = ?"
                    + "	group by j.id_jogo,"
                    + "		tj.id_titulo_jogo,"
                    + "		tj.nm_titulo,"
                    + "		c.ds_console,"
                    + "		j.imagem,tj.descricao";

        Object[] vetor = {_id};
        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);
            Jogo o = new Jogo();
            if (rs.next()) {
                o.setId_jogo(Integer.parseInt(rs.getString("id_jogo")));
                o.setTitulo_jogo(rs.getString("nm_titulo"));
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("id_titulo_jogo")));
                o.setDescricao(rs.getString("descricao"));
                o.setPontos(Integer.parseInt(rs.getString("pontos")));
                o.setImagem(rs.getString("imagem"));
                o.setInteressado(Integer.parseInt(rs.getString("interessado")));
                o.setProprietario(Integer.parseInt(rs.getString("proprietario")));
                o.setOferta(Integer.parseInt(rs.getString("oferta")));
                o.setConsole(rs.getString("ds_console"));
                o.setListaCategoria(CategoriaDao.listarDal(o.getId_titulo_jogo()));
                o.setListaEditora(EditoraDal.listarEditora(o.getId_titulo_jogo()));
                o.setListaGenero(GeneroDal.listarGeneroDal(o.getId_titulo_jogo()));
                o.setListaDesenv(DesenvolvedorDal.listarDesenvolvedorDal(o.getId_titulo_jogo()));

            }
            rs.close();
            c.close();
            return o;

        } catch (Exception c) {
            return null;
        }
    }
    public static List<Jogo> filtroJogosGenerico(int _idTipo, String _tipoFiltro, String tipoCategoria,  int quantidePorPagina, int pagina){
        String sql = "";
        String sqlWhere = "";

        if(_tipoFiltro.equals("G")){ //para buscar por genero
            sqlWhere = " id_genero = " + _idTipo;
        }
        if(_tipoFiltro.equals("L")){// para buscar por lancamentos
            sqlWhere = "dt_lancamento between DATEADD(DAY, -30 , GETDATE()) AND getdate()";
        }
        if(_tipoFiltro.equals("N")){ // para buscar por Novidades
            sqlWhere = "t.dt_cadastro between DATEADD(DAY, -30 , GETDATE()) AND getdate()";
        }
        if(_tipoFiltro.equals("D")){ // para buscar por Desenvolvedor
            sqlWhere = " id_desenv = " + _idTipo;
        }
        if(_tipoFiltro.equals("C")){ // para buscar por Categoria
            sqlWhere = " tipo like '%" + tipoCategoria + "%'";
        }
        if(_tipoFiltro.equals("E")){ // para buscar por Editora
            sqlWhere = " id_editora = " + _idTipo;
        }
         
        int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }
        sql = "select top " + quantidePorPagina + " * from ("
                + "select  id_jogo,"
                + " c.id_console,"
                + " t.id_titulo_jogo,"
                + " jogo.imagem, "
                + " nm_titulo,"
                + " c.ds_console,"
                + " dt_lancamento,"
                + " row_number() over (order by t.dt_lancamento desc) as linha,"
                + "(select count(distinct j.id_jogo)"
                + "  from jogo j "
                + " left join titulo_jogo t on j.id_titulo_jogo = t.id_titulo_jogo "
                + " left join console c on j.id_console = c.id_console "
                + " left join jogo_usuario ju on j.id_jogo = ju.id_jogo "
                + " left join genero_titulo gt on t.id_titulo_jogo = gt.id_titulo_jogo "
                + " left join editora_titulo et on t.id_titulo_jogo = et.id_titulo_jogo "
                + " left join desenvolvedor_titulo dt on t.id_titulo_jogo = dt.id_titulo_jogo"
                + " where " + sqlWhere + " ) as totalregistros "
                + " from titulo_jogo t"
                + " inner join jogo on t.id_titulo_jogo = jogo.id_titulo_jogo "
                + " inner join genero_titulo gt on t.id_titulo_jogo = gt.id_titulo_jogo "
                + " inner join editora_titulo et on t.id_titulo_jogo = et.id_titulo_jogo "
                + " inner join desenvolvedor_titulo dt on t.id_titulo_jogo = dt.id_titulo_jogo "
                + " inner join console c on jogo.id_console = c.id_console"
                + "  where " + sqlWhere
                + " ) a"
                + " where linha > " + inicio + " and linha <= " + fim
                + " order by dt_lancamento desc";

        List<Jogo> objC = new ArrayList<Jogo>();
        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);
            
            while (rs.next()) {
                Jogo o = new Jogo();
                o.setId_jogo(Integer.parseInt(rs.getString("id_jogo")));
                o.setId_console((Integer.parseInt(rs.getString("ID_CONSOLE"))));                
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO")));
                o.setImagem(rs.getString("imagem"));
                o.setTitulo_jogo(rs.getString("nm_titulo"));
                o.setConsole(rs.getString("ds_console"));
                o.setTotal(Integer.parseInt(rs.getString("totalregistros")));
                objC.add(o);
            }
            rs.close();
            c.close();
            return (objC);

        }catch(Exception e){
            return null;
        }
    }
    public static List<Jogo> filtroJogosGenerico(int _idTipo, String _tipoFiltro, String tipoCategoria,  int quantidePorPagina, int pagina,String nmTitulo,int _idConsole){
        String sql = "";
        String sqlWhere ="";

        if(_tipoFiltro.equals("G")){ //para buscar por genero
            sqlWhere += " and g.id_genero = " + _idTipo;
        }
        if(_tipoFiltro.equals("L")){// para buscar por lancamentos
            sqlWhere += "and dt_lancamento between DATEADD(DAY, -30 , GETDATE()) AND getdate()";
        }
        if(_tipoFiltro.equals("N")){ // para buscar por Novidades
            sqlWhere += "and t.dt_cadastro between DATEADD(DAY, -30 , GETDATE()) AND getdate()";
        }
        if(_tipoFiltro.equals("D")){ // para buscar por Desenvolvedor
            sqlWhere += " and id_desenv = " + _idTipo;
        }
        if(_tipoFiltro.equals("C")){ // para buscar por Categoria
            sqlWhere += " and tipo like '%" + tipoCategoria + "%'";
        }
        if(_tipoFiltro.equals("E")){ // para buscar por Editora
            sqlWhere += " and id_editora = " + _idTipo;
        }
        if(_tipoFiltro.equals("T")) {// para buscar por Título
            sqlWhere += " and t.nm_titulo like '%" + nmTitulo +"%'";
        }
        if(_tipoFiltro.equals("S")){// para buscar por Console
            sqlWhere += " and c.id_console =" + _idConsole;
        }

        int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }
        sql = "select top " + quantidePorPagina + " * from ("
                + "select  id_jogo,"
                + " console.id_console,"
                + " t.id_titulo_jogo,"
                + " jogo.imagem, "
                + " nm_titulo,"
                + " console.ds_console,"
                + " dt_lancamento,"
                + " row_number() over (order by t.dt_lancamento desc) as linha,"
                + "(select count(distinct j.id_jogo)"
                + "  from jogo j "
                + " left join titulo_jogo t on j.id_titulo_jogo = t.id_titulo_jogo "
                + " left join console c on j.id_console = c.id_console "
                + " left join jogo_usuario ju on j.id_jogo = ju.id_jogo "
                + " left join genero g on g.id_genero = t.id_genero"
                + " where 1 = 1 and " + sqlWhere + " ) as totalregistros "
                + " from titulo_jogo t"
                + " inner join jogo on t.id_titulo_jogo = jogo.id_titulo_jogo "
                + "	  inner join genero g on t.id_genero = g.id_genero"
                + "	  inner join console on jogo.id_console = console.id_console"
                + "  where 1 = 1 and " + sqlWhere
                + " ) a"
                + " where linha > " + inicio + " and linha <= " + fim
                + " order by dt_lancamento desc";

        List<Jogo> objC = new ArrayList<Jogo>();
        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Jogo o = new Jogo();
                o.setId_jogo(Integer.parseInt(rs.getString("id_jogo")));
                o.setId_console((Integer.parseInt(rs.getString("ID_CONSOLE"))));
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO")));
                o.setImagem(rs.getString("imagem"));
                o.setTitulo_jogo(rs.getString("nm_titulo"));
                o.setConsole(rs.getString("ds_console"));
                o.setTotal(Integer.parseInt(rs.getString("totalregistros")));
                objC.add(o);
            }
            rs.close();
            c.close();
            return (objC);

        }catch(Exception e){
            return null;
        }
    }
    public static List<Jogo> FiltroJogoDesejado(int quantidePorPagina, int pagina){
        String sql;
        int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }
        sql =   "select top " + quantidePorPagina + " * from ("
                + "select jogo.id_jogo,"
                + "titulo_jogo.id_titulo_jogo,"
                + " nm_titulo,"
                + " console.id_console,"
                + " genero.ds_genero,"
                + " titulo_jogo.tipo,"
                + " console.ds_console,"
                + " jogo.imagem,"
                + " desejado.qtd, "
                + " row_number() over (order by desejado.qtd desc) as linha,"
                +" (select count(distinct id_jogo) qtd "
                + " from jogo_desejado"
                + " where dt_solicitacao between DATEADD(DAY, -30 , GETDATE()) AND getdate() ) as totalregistros "
                + "  from	titulo_jogo"
                + " inner join jogo on titulo_jogo.id_titulo_jogo = jogo.id_titulo_jogo "
                + " inner join genero on titulo_jogo.id_genero = genero.id_genero"
                + " inner join console on jogo.id_console = console.id_console"
                + " inner join (select count(*) qtd,  id_jogo"
                + " from jogo_desejado"
                + " where dt_solicitacao between DATEADD(DAY, -30 , GETDATE()) AND getdate()"
                + " group by id_jogo "
                + " ) desejado on jogo.id_jogo = desejado.id_jogo"
                + " ) a"
                + " where linha > " + inicio + " and linha <= " + fim 
                + " order by qtd desc, nm_titulo asc, ds_genero asc";
            List<Jogo> objC = new ArrayList<Jogo>();
            
        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);
            
            while (rs.next()) {
                Jogo o = new Jogo();
                o.setId_jogo(Integer.parseInt(rs.getString("id_jogo")));
                o.setId_console((Integer.parseInt(rs.getString("ID_CONSOLE"))));
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO")));
                o.setImagem(rs.getString("imagem"));
                o.setTitulo_jogo(rs.getString("nm_titulo"));
                o.setConsole(rs.getString("ds_console"));
                o.setTotal(Integer.parseInt(rs.getString("totalregistros")));
                objC.add(o);
            }
            rs.close();
            c.close();
            return objC;

        }catch(Exception e){
            return null;
        }
    }
      public static List<Jogo> FiltroJogosTrocados(int quantidePorPagina, int pagina){
        String sql;
        int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }
        sql =   "select top " + quantidePorPagina + " * from(" 
                +" select troca.id_jogo,"
                +" titulo_jogo.id_titulo_jogo,"
                + " nm_titulo,"
                + " genero.ds_genero,"
                + " titulo_jogo.tipo,"
                + " console.id_console,"
                + " console.ds_console,"
                + " jogo.imagem,"
                + " troca.qtd, "
		+ " row_number() over (order by troca.qtd desc) as linha,"
                + " dbo.fnc_retornaTotalRegistros(1,0) totalregistros "
                + " from (select id_jogo,"
                + "		 count(*)qtd	"
                + "        from (select	jogo_usuario.id_jogo"
                + "                from	troca"
                + "			inner join jogo_usuario on troca.id_jogo_origem = jogo_usuario.id_jogo_usuario"
                + " 		 where	data_final_usu_origem is not null and data_final_usu_destino is not null"
                + "     	   and	isnull(data_final_usu_origem,data_final_usu_destino) between DATEADD(DAY, -30 , GETDATE()) AND getdate()"
                + "		 union	all "
                + "		select	jogo_usuario.id_jogo	 "
                + "		  from	troca"
                + "			inner join jogo_usuario on troca.ID_JOGO_DESTINO = jogo_usuario.id_jogo_usuario"
                + " 		 where	data_final_usu_origem is not null and data_final_usu_destino is not null"
                + "     	   and	isnull(data_final_usu_origem,data_final_usu_destino) between DATEADD(DAY, -30 , GETDATE()) AND getdate()"
                + "		)troca"
                + "		 group by id_jogo"
                + "	) troca"
                + "	inner join jogo			on	troca.id_jogo = jogo.id_jogo"
                + "	inner join titulo_jogo	on	jogo.id_titulo_jogo = titulo_jogo.id_titulo_jogo"
                + "	inner join genero on titulo_jogo.id_genero = genero.id_genero"
                + "	inner join console on jogo.id_console = console.id_console"
                + ") a"
                + " where linha > " + inicio + " and linha <= " + fim 
                + "  order by qtd desc";

                List<Jogo> objC = new ArrayList<Jogo>();
        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);
            
            while (rs.next()) {
                Jogo o = new Jogo();
                o.setId_jogo(Integer.parseInt(rs.getString("id_jogo")));
                o.setId_console((Integer.parseInt(rs.getString("ID_CONSOLE"))));
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO")));
                o.setImagem(rs.getString("imagem"));
                o.setTitulo_jogo(rs.getString("nm_titulo"));
                o.setConsole(rs.getString("ds_console"));
                o.setTotal(Integer.parseInt(rs.getString("totalregistros")));
                objC.add(o);
            }
            rs.close();
            c.close();
            return objC;

        }catch(Exception e){
            return null;
        }
    }
   public static List<Jogo> FiltroMaisQualificados(int quantidePorPagina, int pagina){
        String sql;
        int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }
        sql ="select top "+ quantidePorPagina+ "  * from("
                + " select	j.id_jogo,"
                + " c.id_console,"
                + " t.id_titulo_jogo,"
                + " j.imagem,"
                + " t.nm_titulo,"
                + " c.ds_console,"
                + " avg(aj.pontos) pts,"
                + " row_number() over (order by avg(aj.pontos) desc) as linha,"
                + " dbo.fnc_retornaTotalRegistros(2,0) totalregistros"
                + " from	avaliacao_jogo aj"
                + " inner join jogo j on j.id_jogo = aj.id_jogo"
                + " inner join titulo_jogo t on t.id_titulo_jogo = j.id_titulo_jogo"
                + " inner join console c on c.id_console = j.id_console"
                + " where dt_avaliacao between DATEADD(DAY, -30 , GETDATE()) AND getdate()"
                + " group by j.id_jogo,"
                + " c.id_console,"
                + " t.id_titulo_jogo,"
                + " j.imagem,"
                + " t.nm_titulo,"
                + " c.ds_console"
                + " ) top10"
                + " where linha > " + inicio + " and linha <= " +fim ;
        
         List<Jogo> objC = new ArrayList<Jogo>();
        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Jogo o = new Jogo();
                o.setId_jogo(Integer.parseInt(rs.getString("id_jogo")));
                o.setId_console((Integer.parseInt(rs.getString("ID_CONSOLE"))));
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO")));
                o.setImagem(rs.getString("imagem"));
                o.setTitulo_jogo(rs.getString("nm_titulo"));
                o.setConsole(rs.getString("ds_console"));
                o.setTotal(Integer.parseInt(rs.getString("totalregistros")));
                objC.add(o);
            }
            rs.close();
            c.close();
            return objC;

        }catch(Exception e){
            return null;
        }
   }
}
