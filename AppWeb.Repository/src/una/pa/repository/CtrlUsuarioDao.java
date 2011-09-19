package una.pa.repository;

import java.sql.Connection;

public class CtrlUsuarioDao {
    public static  boolean aceita(int _id){
        
        try{
            Connection c = Data.openConnection();
            String sql = "update amigo_usuario "
                        + "set dt_aceite = getDate(), "
                        + "sn_aceite = 1 "
                        + "where  id_amigo_usuario = ?";

            Object[] vetor = {_id};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public static boolean recusa(int _id){
        try{
            Connection c = Data.openConnection();
            String sql = "delete amigo_usuario where id_amigo_usuario = ? ";
            Object[] vetor = {_id};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
