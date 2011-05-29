/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.repository;

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

        List<Jogo> objC = new ArrayList<Jogo>();

        String sql = "select * from jogo j left join titulo_jogo t on j.id_titulo_jogo = t.id_titulo_jogo left join console c on j.id_console = c.id_console";


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
                + "       (SELECT	isnull(count(*),0) as interessado "
                + "          FROM	JOGO_DESEJADO"
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
            return o;

        } catch (Exception c) {
            return null;
        }
    }
}
