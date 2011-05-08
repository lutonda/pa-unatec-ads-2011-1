/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import una.pa.model.Jogos;

/**
 *
 * @author Felipe
 */
public class JogosDal {

    public static boolean addJogo(Jogos _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "INSERT INTO JOGO(ID_TITULO_JOGO,ID_CONSOLE,IMAGEM)"
                    + "VALUES(?,?,?)";

            Object[] vetor = {_obj.getId_titulo_jogo(), _obj.getId_console(), _obj.getUrl_IMG()};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<Jogos> listaDal() {

        List<Jogos> objC = new ArrayList<Jogos>();


        String sql = "SELECT J.*,(SELECT NM_TITULO FROM TITULO_JOGO"
                + "WHERE ID_TITULO_JOGO = J.ID_TITULO_JOGO) AS TITITULO_JOGO,"
                + "(SELECT DS_CONSOLE FROM CONSOLE"
                + "WHERE ID_CONSOLE = J.ID_CONSOLE)AS CONSOLE"
                + "FROM JOGO AS J";


        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Jogos o = new Jogos();

                o.setId_jogo(Integer.parseInt(rs.getString("ID_JOGO").toString()));
                o.setId_jogo(Integer.parseInt(rs.getString("NM_TITULO")));
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_CONSOLE")));
                o.setUrl_IMG(rs.getString("IMAGEM"));
                o.setTitulo_jogo(rs.getString("TITULO_JOGO"));
                o.setConsole(rs.getString("CONSOLE"));
                objC.add(o);
            }

            rs.close();
            c.close();

            return objC;
        } catch (Exception e) {
            return null;
        }


    }

    public static boolean exclui(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "DELETE FROM JOGOS WHERE ID_JOGO = ?";
            Object[] vetor = {_id};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
