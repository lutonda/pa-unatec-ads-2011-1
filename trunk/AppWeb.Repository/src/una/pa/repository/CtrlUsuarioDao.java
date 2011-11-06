package una.pa.repository;

import java.sql.Connection;

public class CtrlUsuarioDao {

    public static boolean aceita(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "update amigo_usuario "
                    + "set dt_aceite = getDate(), "
                    + "sn_aceite = 1 "
                    + "where id_amigo_usuario = ?";

            Object[] vetor = {_id};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean ignorar(int _id, int _ign) {

        try {
            Connection c = Data.openConnection();
            String sql = "update amigo_usuario "
                    + "set ignorado = ? "
                    + "where id_amigo_usuario = ?";

            Object[] vetor = {_ign, _id};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean recusa(int _id) {
        try {
            Connection c = Data.openConnection();
            String sql = "delete amigo_usuario where id_amigo_usuario = ? ";
            Object[] vetor = {_id};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean adicionar(int _id, int _idUserVis) {
        try {
            Connection c = Data.openConnection();
            String sql = "insert into amigo_usuario (id_usuario,id_usuario_amigo,dt_convite,sn_aceite,ignorado)"
                    + " values(?,?,getdate(),0,0) ";
            Object[] vetor = {_idUserVis, _id};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
