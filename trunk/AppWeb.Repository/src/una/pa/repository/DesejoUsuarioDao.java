/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import una.pa.model.*;

/**
 *
 * @author Tiago
 */
public class DesejoUsuarioDao {

    public static List<Desejousuario> listarDesejo(int _id) {
        List<Desejousuario> objct = new ArrayList<Desejousuario>();
        String sql = " SELECT	TITULO_JOGO.NM_TITULO,"
                + " CONSOLE.DS_CONSOLE, "
                + " JOGO_DESEJADO.NIVEL_DESEJO "
                + " FROM	JOGO_DESEJADO "
                + " INNER JOIN USUARIO	ON JOGO_DESEJADO.ID_USUARIO =	USUARIO.ID_USUARIO "
                + " INNER JOIN JOGO		ON JOGO_DESEJADO.ID_JOGO    =	JOGO.ID_JOGO "
                + " INNER JOIN TITULO_JOGO	ON JOGO.ID_TITULO_JOGO	    =	TITULO_JOGO.ID_TITULO_JOGO "
                + " INNER JOIN CONSOLE	ON JOGO.ID_CONSOLE	    =	CONSOLE.ID_CONSOLE "
                + " where USUARIO.ID_USUARIO = ?";

        Object[] vetor = {_id};

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while (rs.next()) {
                Desejousuario o = new Desejousuario();
                o.setNm_titulo(rs.getString("nm_titulo"));
                o.setDs_console(rs.getString("ds_console"));
                o.setNivel_desejo(Integer.parseInt(rs.getString("nivel_desejo")));
                objct.add(o);
            }
            rs.close();
            c.close();
            return objct;

        } catch (Exception e) {
            return null;
        }
    }

    public static List<Jogo> listaJogosDesejados(int pId_usuario, int quantidePorPagina, int pagina) {

        int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }

        List<Jogo> objct = new ArrayList<Jogo>();
        String sql = "select top " + quantidePorPagina + " * "
                + "from (select row_number() over (order by id_jogo) as linha "
                + ", (select count(*) from jogos_desejados where id_usuario = ?) as totalregistros "
                + ", * from jogos_desejados where id_usuario = ?) as buscapaginada where linha > " + inicio + " and linha <= " + fim;

        Object[] vetor = {pId_usuario, pId_usuario};

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while (rs.next()) {
                Jogo o = new Jogo();

                o.setId_jogo(Integer.parseInt(rs.getString("ID_JOGO").toString()));
                o.setId_console(Integer.parseInt(rs.getString("ID_CONSOLE")));
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO")));
                o.setImagem(rs.getString("IMAGEM"));
                o.setTitulo_jogo(rs.getString("NM_TITULO"));
                o.setConsole(rs.getString("DS_CONSOLE"));
                o.setNivelDesejo(rs.getString("NIVEL_DESEJO"));
                o.setTotal(Integer.parseInt(rs.getString("totalregistros")));
                objct.add(o);
            }
            rs.close();
            c.close();
            return objct;

        } catch (Exception e) {
            return null;
        }

    }
}
