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

        sql = "select top " + quantidePorPagina + " * from (select row_number() over (order by j.id_jogo) as linha"
                + ", (select count(j.id_jogo) from jogo j left join "
                + "titulo_jogo t on j.id_titulo_jogo = t.id_titulo_jogo "
                + "left join console c on j.id_console = c.id_console "
                + "left join jogo_usuario ju on j.id_jogo = ju.id_jogo "
                + " " + sqlWhere + ") as totalregistros"
                + ", ju.nivel_interesse"
                + ", j.id_jogo, j.id_console, j.id_titulo_jogo, imagem, nm_titulo, ds_console "
                + "from jogo j "
                + "left join titulo_jogo t on j.id_titulo_jogo = t.id_titulo_jogo "
                + "left join console c on j.id_console = c.id_console "
                + "left join jogo_usuario ju on j.id_jogo = ju.id_jogo "
                + "" + sqlWhere + ") as buscapaginada where linha > " + inicio + " and linha <= " + fim;

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
                if ((busca != null) || (pId_usuario != 0) || (console != 0))
                    o.setNivelInteresse(rs.getString("NIVEL_INTERESSE"));
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

    public static boolean exclui(int _id) {

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

    public static Jogo detalesJogo(int _id) {
        String sql = " SELECT	ID_JOGO, "
                + " NM_TITULO, "
                + " TIPO,"
                + " NM_EDITORA,"
                + " DS_CONSOLE,"
                + " DS_GENERO,"
                + " DS_DESENV,"
                + " DESCRICAO,"
                + " pontos,"
                + " IMAGEM,"
                + " proprietario ,"
                + " interessado ,"
                + " oferta"
                + " FROM"
                + " (SELECT  ID_JOGO,"
                + "   NM_TITULO,"
                + "   TIPO,"
                + "   NM_EDITORA, "
                + "   DS_CONSOLE,"
                + "   DS_GENERO,"
                + "   DS_DESENV,"
                + "   DESCRICAO,"
                + "   avg(PONTOS) as pontos, IMAGEM "
                + "   FROM ("
                + "   	SELECT	JOGO.ID_JOGO,"
                + "   		TITULO_JOGO.NM_TITULO,"
                + "   		TITULO_JOGO.TIPO,"
                + "   		EDITORA.NM_EDITORA,"
                + "   		CONSOLE.DS_CONSOLE,"
                + "   		GENERO.DS_GENERO,"
                + "   		DESENVOLVEDOR.DS_DESENV,"
                + "   		TITULO_JOGO.DESCRICAO,"
                + "   		isnull( PONTOS, 0) as PONTOS, jOGO.IMAGEM"
                + "   	FROM JOGO"
                + "   		INNER JOIN TITULO_JOGO	 ON JOGO.ID_TITULO_JOGO    = TITULO_JOGO.ID_TITULO_JOGO"
                + "  		INNER JOIN CONSOLE	 ON JOGO.ID_CONSOLE	   = CONSOLE.ID_CONSOLE"
                + "  		INNER JOIN EDITORA	 ON TITULO_JOGO.ID_EDITORA = EDITORA.ID_EDITORA 	"
                + "   		INNER JOIN GENERO	 ON TITULO_JOGO.ID_GENERO  = GENERO.ID_GENERO"
                + "   		INNER JOIN DESENVOLVEDOR ON TITULO_JOGO.ID_DESENV  = DESENVOLVEDOR.ID_DESENV"
                + "   		LEFT JOIN AVALIACAO_JOGO ON JOGO.ID_JOGO	   = AVALIACAO_JOGO.ID_JOGO"
                + "   	)a	"
                + "   WHERE ID_JOGO = ? "
                + "    GROUP BY ID_JOGO,"
                + "   NM_TITULO,"
                + "   TIPO,"
                + "   NM_EDITORA,"
                + "   DS_CONSOLE,"
                + "   DS_GENERO,"
                + "   DS_DESENV,"
                + "   DESCRICAO, IMAGEM)DETALHES, "
                + "  (select p.proprietario,"
                + "          i.interessado,"
                + "          o.oferta "
                + "    from 		"
                + "       (SELECT isnull(count(*),0) as proprietario "
                + "          FROM JOGO_USUARIO"
                + "         where id_jogo = ?) p,"
                + "       (SELECT isnull(count(*),0) as interessado "
                + "          FROM JOGO_DESEJADO"
                + "         WHERE ID_JOGO = ?)i, "
                + "       (select isnull(count(*),0) as oferta "
                + "          from jogo_usuario "
                + "         where id_jogo = ? "
                + "           and nivel_interesse = 0) o) OUTROS";


        Object[] vetor = {_id, _id, _id, _id};
        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);
            Jogo o = new Jogo();
            if (rs.next()) {
                o.setId_jogo(Integer.parseInt(rs.getString("id_jogo")));
                o.setTitulo_jogo(rs.getString("nm_titulo"));
                o.setTipo(rs.getString("tipo"));
                o.setEditora(rs.getString("nm_editora"));
                o.setGenero(rs.getString("DS_GENERO"));
                o.setConsole(rs.getString("ds_console"));
                o.setDesenv(rs.getString("ds_desenv"));
                o.setDescricao(rs.getString("descricao"));
                o.setPontos(Integer.parseInt(rs.getString("pontos")));
                o.setImagem(rs.getString("imagem"));
                o.setInteressado(Integer.parseInt(rs.getString("interessado")));
                o.setProprietario(Integer.parseInt(rs.getString("proprietario")));
                o.setOferta(Integer.parseInt(rs.getString("oferta")));
            }
            rs.close();
            c.close();
            return o;

        } catch (Exception c) {
            return null;
        }
    }
    public static List<Jogo> filtroJogosGenerico(int _idGenero, String _tipo,  int quantidePorPagina, int pagina){
        String sql = "";
        String sqlWhere = "";

        if(_tipo.equals("G")){ //para buscar por genero
            sqlWhere = "g.id_genero = " + _idGenero;
        }
        if(_tipo.equals("L")){// para buscar por lancamentos
            sqlWhere = "dt_lancamento between DATEADD(DAY, -30 , GETDATE()) AND getdate()";
        }
        if(_tipo.equals("N")){ // para buscar por Novidades
            sqlWhere = "t.dt_cadastro between DATEADD(DAY, -30 , GETDATE()) AND getdate()";
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
                + "(select count(j.id_jogo)"
                + "  from jogo j "
                + " left join titulo_jogo t on j.id_titulo_jogo = t.id_titulo_jogo "
                + " left join console c on j.id_console = c.id_console "
                + " left join jogo_usuario ju on j.id_jogo = ju.id_jogo "
                + " left join genero g on g.id_genero = t.id_genero"
                + " where " + sqlWhere + " ) as totalregistros "
                + " from titulo_jogo t"
                + " inner join jogo on t.id_titulo_jogo = jogo.id_titulo_jogo "
                + "	  inner join genero g on t.id_genero = g.id_genero"
                + "	  inner join console on jogo.id_console = console.id_console"
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
                + " nm_titulo,"
                + " genero.ds_genero,"
                + " titulo_jogo.tipo,"
                + " console.id_console,"
                + " console.ds_console,"
                + " jogo.imagem,"
                + " troca.qtd, "
		+ " row_number() over (order by troca.qtd desc) as linha,"
                + " dbo.fnc_retornaTotalRegistros(1) totalregistros "
                + " from (select id_jogo,"
                + "		 count(*)qtd	"
                + "        from (select	jogo_usuario.id_jogo"
                + "                from	troca"
                + "			inner join jogo_usuario on troca.id_jogo_origem = jogo_usuario.id_jogo_usuario"
                + " 		 where	status_troca = 'A'"
                + "     	   and	dt_troca between DATEADD(DAY, -30 , GETDATE()) AND getdate()"
                + "		 union	all "
                + "		select	jogo_usuario.id_jogo	 "
                + "		  from	troca"
                + "			inner join jogo_usuario on troca.ID_JOGO_DESTINO = jogo_usuario.id_jogo_usuario"
                + "		 where	status_troca = 'A'"
                + "		   and	dt_troca between DATEADD(DAY, -30 , GETDATE()) AND getdate()"
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

}
