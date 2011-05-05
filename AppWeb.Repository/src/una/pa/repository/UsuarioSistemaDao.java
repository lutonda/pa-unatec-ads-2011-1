/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import una.pa.model.UsuarioSistema;

/**
 *
 * @author ALEXANDRE
 */
public class UsuarioSistemaDao {

     public static List<UsuarioSistema> listarDao() {

        List<UsuarioSistema> objC = new ArrayList<UsuarioSistema>();

        String sql = "select * from usuario_sistema";

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                UsuarioSistema o = new UsuarioSistema();

                o.setId_user_sistema(Integer.parseInt(rs.getString("ID_USER_SISTEMA").toString()));
                o.setUsername(rs.getString("USERNAME"));
                o.setPassword(rs.getString("PASSWORD"));
                if (rs.getString("SN_ATIVO").equals("1")){
                    o.setSn_ativo(true);
                }else{
                    o.setSn_ativo(false);
                }
                o.setPerfil(rs.getString("PERFIL"));

                objC.add(o);
            }

            rs.close();
            c.close();

            return objC;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean altera(UsuarioSistema _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "UPDATE USUARIO_SISTEMA "
                    + "SET "
                    + "USERNAME = ? "
                    + ",PASSWORD = ? "
                    + ",SN_ATIVO = ? "
                    + ",PERFIL = ? "
                    + "WHERE ID_USER_SISTEMA = ?";

            Object[] vetor = {_obj.getUsername(),_obj.getPassword(),_obj.isSn_ativo(), _obj.getPerfil(), _obj.getId_user_sistema()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean inclui(UsuarioSistema _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "INSERT INTO USUARIO_SISTEMA "
                    + "(USERNAME "
                    + ",PASSWORD "
                    + ",SN_ATIVO "
                    + ",PERFIL) VALUES (?,?,?,?)";
           Object[] vetor = {_obj.getUsername(),_obj.getPassword(),_obj.isSn_ativo(), _obj.getPerfil()};

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
            String sql = "DELETE FROM USUARIO_SISTEMA WHERE ID_USER_SISTEMA = ?";
            Object[] vetor = {_id};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
