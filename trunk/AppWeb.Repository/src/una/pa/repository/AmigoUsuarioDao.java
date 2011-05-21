/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import una.pa.model.*;
/**
 *
 * @author Tiago
 */
public class AmigoUsuarioDao {
      public static List<AmigoUsuario> listarAmigo(int _id){
        List<AmigoUsuario> objC = new ArrayList<AmigoUsuario>();
        String sql =    "select AMIGO_USUARIO.ID_USUARIO_AMIGO, " +
                        " USUARIO_AMIGO.nm_usuario , " +
                        " USUARIO_AMIGO.nm_sobrenome " +
                        " from dbo.AMIGO_USUARIO, " +
                        " dbo.USUARIO," +
                        " dbo.USUARIO USUARIO_AMIGO " +
                        " where AMIGO_USUARIO.id_usuario = ? " +
                        " and AMIGO_USUARIO.id_usuario = USUARIO.id_usuario " +
                        " and AMIGO_USUARIO.ID_USUARIO_AMIGO = USUARIO_AMIGO.id_usuario ";

        Object[] vetor = {_id};
        

        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while(rs.next()){
                AmigoUsuario o = new AmigoUsuario();
                o.setId_usuario_amigo(Integer.parseInt(rs.getString("id_usuario_amigo")));
                o.setNm_usuario(rs.getString("nm_usuario"));
                o.setNm_sobrenome(rs.getString("nm_sobrenome"));
                objC.add(o);
            }
            rs.close();
            c.close();
            return objC;
        }catch(Exception e){
            return null;
        }
    }

}
