/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.repository;
import una.pa.model.AvaliacaoUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author Tiago
 */
public class AvaliacaoUsuarioDao {
    public static boolean incluir(AvaliacaoUsuario _obj){
        try{
            Connection c = Data.openConnection();
            String qsl = "insert into AVALIACAO_USUARIO(id_troca,id_usuario,dt_avaliacao,pontos,descricao) "
                    + "values(?, ?, getdate(),? , ?)";

            Object[] vetor = {_obj.getId_troca(),_obj.getId_usuario(),_obj.getPontos(),_obj.getDescricao()};
            Data.executeUpdate(c, qsl, vetor);
            c.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
     public static boolean excluir(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "delete AVALIACAO_USUARIO where id_avaliacao_usuario = ?";
            Object[] vetor = {_id};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
      public static boolean alterar(AvaliacaoUsuario _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "update AVALIACAO_USUARIO set pontos = ?, descricao = ? where id_avaliacao_usuario = ?";
            Object[] vetor = {_obj.getPontos(),_obj.getDescricao()};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     
}
