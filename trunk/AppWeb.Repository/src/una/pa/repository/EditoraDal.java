package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import una.pa.model.*;

public class EditoraDal {

    public static List<Editora> listarEditora() {
        List<Editora> objC = new ArrayList<Editora>();

        String sql = "select id_editora, nm_editora from editora";

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Editora o = new Editora();
                o.setId_editora(Integer.parseInt(rs.getString("id_editora").toString()));
                o.setNm_editora(rs.getString("nm_editora"));
                objC.add(o);
            }
            rs.close();
            c.close();
            return objC;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Editora> listarEditora(int _idTitulo) {
        List<Editora> objC = new ArrayList<Editora>();

        String sql = "SELECT * FROM EDITORA E INNER JOIN EDITORA_TITULO ET ON E.ID_EDITORA = ET.ID_EDITORA WHERE ID_TITULO_JOGO = ?";

        try {
            Connection c = Data.openConnection();
            Object[] vetor = {_idTitulo};
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while (rs.next()) {
                Editora o = new Editora();
                o.setId_editora(Integer.parseInt(rs.getString("id_editora").toString()));
                o.setNm_editora(rs.getString("nm_editora"));
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO").toString()));
                objC.add(o);
            }
            rs.close();
            c.close();
            return objC;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean alteraEditora(Editora _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "update editora set nm_editora = ? where id_editora = ?";
            Object[] vetor = {_obj.getNm_editora(), _obj.getId_editora()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean incluiEditora(Editora _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "insert into editora(nm_editora) values (?)";
            Object[] vetor = {_obj.getNm_editora()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean excluiEditora(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "delete editora where id_editora = ?";
            Object[] vetor = {_id};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
