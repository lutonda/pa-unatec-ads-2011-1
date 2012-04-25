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
                + "from (select row_number() over (order by DT_SOLICITACAO desc) as linha "
                + ", (select count(*) from jogos_desejados where id_usuario = ?) as totalregistros "
                + ", * from jogos_desejados where id_usuario = ? and id_jogo not in(select id_jogo from jogo_usuario where id_usuario = ?)) as buscapaginada where linha > " + inicio + " and linha <= " + fim;

        Object[] vetor = {pId_usuario, pId_usuario, pId_usuario};

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
                o.setNivelDesejo(Integer.parseInt(rs.getString("NIVEL_DESEJO")));
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

    public static boolean incluir(Desejousuario _obj) {
        try {
            Connection c = Data.openConnection();
            String sql = "insert into JOGO_DESEJADO (id_jogo,id_usuario,dt_solicitacao,nivel_desejo)"
                    + " values (?,?,getdate(),?)";
            Object[] vetor = {_obj.getId_jogo(), _obj.getId_usuario(), _obj.getNivelDesejo()};
            Data.executeQuery(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean alterar(Desejousuario _obj) {
        try {
            Connection c = Data.openConnection();
            String sql = "update dbo.JOGO_DESEJADO set id_jogo = ?,id_usuario = ?, dt_solicitacao = getdate(), nivel_desejo = ? where id_jogo_desejado = ?";
            Object[] vetor = {_obj.getId_jogo(), _obj.getId_usuario(), _obj.getNivelDesejo()};

            Data.executeQuery(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean excluir(Desejousuario _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "delete dbo.JOGO_DESEJADO where id_jogo = ? and id_usuario = ?";
            Object[] vetor = {_obj.getId_jogo(), _obj.getId_usuario()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
