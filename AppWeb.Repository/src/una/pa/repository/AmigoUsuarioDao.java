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
      public static List<AmigoUsuario> detalheAmigos(int _id){
          List<AmigoUsuario> objt = new ArrayList<AmigoUsuario>();

          String sql = " SELECT	USUARIO.ID_USUARIO," +
                       " USUARIO.NM_USUARIO," +
                       " USUARIO.NM_SOBRENOME," +
                       " (SELECT isnull(COUNT(*),0) FROM JOGO_USUARIO WHERE ID_USUARIO = AMIGO_USUARIO.ID_USUARIO_AMIGO) as QDT_JOGO," +
                       " (SELECT isnull(COUNT(*),0) FROM JOGO_DESEJADO WHERE ID_USUARIO = AMIGO_USUARIO.ID_USUARIO_AMIGO)as QTD_DESEJO," +
                       " (select isnull(avg(pontos),0) from avaliacao_usuario where id_usuario = AMIGO_USUARIO.ID_USUARIO_AMIGO) as pontos" +
                       " FROM	USUARIO," +
                       " AMIGO_USUARIO" +
                       " WHERE USUARIO.ID_USUARIO = AMIGO_USUARIO.ID_USUARIO_AMIGO" +
                       " AND AMIGO_USUARIO.ID_USUARIO = ?" +
                       " AND AMIGO_USUARIO.SN_ACEITE = 1";

          Object[] vetor = {_id};
          try{
              Connection c = Data.openConnection();
              ResultSet rs = Data.executeQuery(c, sql, vetor);

              while(rs.next()){
                  AmigoUsuario o = new AmigoUsuario();
                  o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                  o.setNm_usuario(rs.getString("nm_usuario"));
                  o.setNm_sobrenome(rs.getString("nm_sobrenome"));
                  o.setQtd_jogo(Integer.parseInt(rs.getString("qtd_jogo")));
                  o.setQtd_desejo(Integer.parseInt(rs.getString("qtd_desejo")));
                  o.setPontos(Integer.parseInt(rs.getString("pontos")));
                  objt.add(o);
              }
              rs.close();
              c.close();
              return objt;

          }catch(Exception e){
              return null;
          }
      }

}
