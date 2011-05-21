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
public class JogoUsuarioDao {

    public static List<Jogousuario> listarJogoUsuario(int _id){
        List<Jogousuario> objct = new ArrayList<Jogousuario>();

        String sql = " SELECT	JOGO_USUARIO.ID_JOGO_USUARIO, " +
                     " TITULO_JOGO.NM_TITULO, " +
                     " CONSOLE.DS_CONSOLE, " +
                     " JOGO_USUARIO.DT_CADASTRO, " +
                     " JOGO_USUARIO.DESCRICAO " +
                     " FROM JOGO_USUARIO " +
                     " INNER JOIN USUARIO     ON JOGO_USUARIO.ID_USUARIO = USUARIO.ID_USUARIO " +
                     " INNER JOIN JOGO	      ON JOGO_USUARIO.ID_JOGO	 = JOGO.ID_JOGO " +
                     " INNER JOIN TITULO_JOGO ON JOGO.ID_TITULO_JOGO	 =  TITULO_JOGO.ID_TITULO_JOGO " +
                     " INNER JOIN CONSOLE     ON JOGO.ID_CONSOLE	 = CONSOLE.ID_CONSOLE " +
                     " where usuario.id_usuario = ?";
        Object[] vetor = {_id};

        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while(rs.next()){
                Jogousuario o = new Jogousuario();
                o.setNm_titulo(rs.getString("nm_titulo"));
                o.setDs_console(rs.getString("ds_console"));
                o.setDt_cadastro_jogo(rs.getString("dt_cadastro"));
                o.setDescricao(rs.getString("descricao"));
                objct.add(o);

            }
            rs.close();
            c.close();
            return objct;
        }catch(Exception e){
            return null;
        }
    }

}
