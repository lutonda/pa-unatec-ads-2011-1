/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.repository;
import una.pa.model.Linguagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author Tiago
 */
public class LinguagemDao {
    public static boolean incluirLinguagem(Linguagem _obj){
        try {
            Connection c = Data.openConnection();
            String sql = "insert into Linguagem( NM_LINGUAGEM,DT_CADASTRO) values (?,getdate())";
            Object[] vetor = {_obj.getNm_linguagem()};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     public static boolean excluiLinguagem(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "delete Linguagem where id_linguagem = ?";
            Object[] vetor = {_id};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     public static boolean alteraLinguagem(Linguagem _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "update Linguagem set NM_LINGUAGEM = ? where id_linguagem = ?";
            Object[] vetor = {_obj.getNm_linguagem(), _obj.getId_linguagem()};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
      public static List<Linguagem> listarDal() {

        List<Linguagem> objC = new ArrayList<Linguagem>();

        String sql = "select ID_LINGUAGEM, NM_LINGUAGEM,DT_CADASTRO from dbo.LINGUAGEM";


        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Linguagem o = new Linguagem();
                o.setId_linguagem(Integer.parseInt(rs.getString("ID_LINGUAGEM").toString()));
                o.setNm_linguagem(rs.getString("NM_LINGUAGEM"));
                o.setDt_cadastro(rs.getDate("DT_CADASTRO"));
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
