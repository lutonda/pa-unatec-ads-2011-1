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

    public static boolean incluirCategoria(Categoria _obj) {
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

    public static List<Categoria> listarDal(int _idTitulo) {

        List<Categoria> objC = new ArrayList<Categoria>();

        String sql = "SELECT * FROM CATEGORIA C INNER JOIN CATEGORIA_TITULO CT ON C.ID_CATEGORIA = CT.ID_CATEGORIA WHERE ID_TITULO_JOGO = ?";


        try {
            Connection c = Data.openConnection();
            Object[] vetor = {_idTitulo};
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while (rs.next()) {
                Categoria o = new Categoria();
                o.setId_categoria(Integer.parseInt(rs.getString("id_categoria").toString()));
                o.setNm_categoria(rs.getString("nm_categoria"));
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

    public static List<Categoria> listarDal() {

        List<Categoria> objC = new ArrayList<Categoria>();

        String sql = "select id_categoria,nm_categoria from categoria";


        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Categoria o = new Categoria();
                o.setId_categoria(Integer.parseInt(rs.getString("id_categoria").toString()));
                o.setNm_categoria(rs.getString("nm_categoria"));
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
