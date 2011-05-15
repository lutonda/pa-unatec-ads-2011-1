/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import una.pa.model.*;

/**
 *
 * @author Tiago
 */
public class ConviteDal {

    public static List<Convite> listarDAL(){
         List<Convite> objC = new ArrayList<Convite>();

         String sql = "SELECT ID_CONVITE, ASSUNTO, CORPO_CONVITE FROM CONVITE";

         try{
             Connection c = Data.openConnection();
             ResultSet rs = Data.executeQuery(c, sql);

             while(rs.next()){
                 Convite o = new Convite();
                 o.setId_convite(Integer.parseInt(rs.getString("ID_CONVITE").toString()));
                 o.setAssunto(rs.getString("assunto"));
                 o.setCorpo_convite(rs.getString("corpo_convite"));
                 objC.add(o);
             }
             rs.close();
             c.close();
             return objC;
         }catch(Exception e){
             return null;
         }

    }

    public static boolean alteraConvite(Convite _obj){
        try{
            Connection c = Data.openConnection();
            String sql = "update convite set assunto = ?, corpo_convite = ? where id_convite = ?";
            Object[] vetor = {_obj.getAssunto(),_obj.getCorpo_convite(), _obj.getId_convite()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
     public static boolean incluiConvite(Convite _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "insert into CONVITE (ASSUNTO, CORPO_CONVITE ) values(?,?)";
            Object[] vetor = {_obj.getAssunto(),_obj.getCorpo_convite()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
     public static boolean excluiConvite(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "DELETE FROM CONVITE WHERE id_convite = ?";
            Object[] vetor = {_id};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
