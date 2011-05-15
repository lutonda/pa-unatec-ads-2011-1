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

        /* Coisa do Felipe
        String sql = "SELECT J.*,(SELECT NM_TITULO FROM TITULO_JOGO"
        + "WHERE ID_TITULO_JOGO = J.ID_TITULO_JOGO) AS TITITULO_JOGO,"
        + "(SELECT DS_CONSOLE FROM CONSOLE"
        + "WHERE ID_CONSOLE = J.ID_CONSOLE)AS CONSOLE"
        + "FROM JOGO AS J";

         */

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
}
