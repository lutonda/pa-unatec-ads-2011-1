/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.repository;
import una.pa.model.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author Tiago
 */
public class CategoriaDao {
    public static boolean incluirCategoria(Categoria _obj){
        try {
            Connection c = Data.openConnection();
            String sql = "insert into categoria(nm_categoria,dt_cadastro) values (?,getdate())";
            Object[] vetor = {_obj.getNm_categoria()};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     public static boolean excluiCategoria(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "delete categoria where id_categoria = ?";
            Object[] vetor = {_id};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     public static boolean alteraCategoria(Categoria _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "update categoria set nm_categoria = ? where id_categoria = ?";
            Object[] vetor = {_obj.getNm_categoria(), _obj.getId_categoria()};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
      public static List<Categoria> listarDal() {

        List<Categoria> objC = new ArrayList<Categoria>();

        String sql = "select id_categoria,nm_categoria, dt_cadastro from categoria";


        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Categoria o = new Categoria();
                o.setId_categoria(Integer.parseInt(rs.getString("id_categoria").toString()));
                o.setNm_categoria(rs.getString("nm_categoria"));
                o.setDt_cadastro(rs.getDate("dt_cadastro"));
                objC.add(o);
            }

            rs.close();
            c.close();

            return objC;
        } catch (Exception e) {
            return null;
        }
    }
}
