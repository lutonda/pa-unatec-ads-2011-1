package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import una.pa.model.*;

public class GeneroDal {
    
    public static List<Genero> listarGeneroDal() {
        List<Genero> objC = new ArrayList<Genero>();

        String sql = "SELECT ID_GENERO, DS_GENERO  FROM DBO.GENERO";


        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Genero o = new Genero();
                o.setId_genero(Integer.parseInt(rs.getString("ID_GENERO").toString()));
                o.setDs_genero(rs.getString("DS_GENERO"));
                objC.add(o);
            }

            rs.close();
            c.close();

            return objC;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Genero> listarGeneroDal(int _idTitulo) {
        List<Genero> objC = new ArrayList<Genero>();

        String sql = "SELECT * FROM GENERO G INNER JOIN GENERO_TITULO GT ON G.ID_GENERO = GT.ID_GENERO WHERE ID_TITULO_JOGO = ?";


        try {
            Connection c = Data.openConnection();
            Object[] vetor = {_idTitulo};
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while (rs.next()) {
                Genero o = new Genero();
                o.setId_genero(Integer.parseInt(rs.getString("ID_GENERO").toString()));
                o.setDs_genero(rs.getString("DS_GENERO"));
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

    public static boolean alteraGenero(Genero _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "update genero set ds_genero = ? where id_genero = ?";
            Object[] vetor = {_obj.getDs_genero(), _obj.getId_genero()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean incluiGenero(Genero _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "insert into genero (ds_genero) values (?)";
            Object[] vetor = {_obj.getDs_genero()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean excluiGenero(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "delete genero where id_genero = ?";
            Object[] vetor = {_id};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
