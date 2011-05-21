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
public class DesejoUsuarioDao {
    public static List<Desejousuario> listarDesejo(int _id){
        List<Desejousuario> objct = new ArrayList<Desejousuario>();
        String sql = " SELECT	TITULO_JOGO.NM_TITULO," +
                     " CONSOLE.DS_CONSOLE, " +
                     " JOGO_DESEJADO.NIVEL_DESEJO " +
                     " FROM	JOGO_DESEJADO " +
                     " INNER JOIN USUARIO	ON JOGO_DESEJADO.ID_USUARIO =	USUARIO.ID_USUARIO " +
                     " INNER JOIN JOGO		ON JOGO_DESEJADO.ID_JOGO    =	JOGO.ID_JOGO " +
                     " INNER JOIN TITULO_JOGO	ON JOGO.ID_TITULO_JOGO	    =	TITULO_JOGO.ID_TITULO_JOGO " +
                     " INNER JOIN CONSOLE	ON JOGO.ID_CONSOLE	    =	CONSOLE.ID_CONSOLE " +
                     " where USUARIO.ID_USUARIO = ?";

        Object[] vetor= {_id};

        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while(rs.next()){
                Desejousuario o = new Desejousuario();
                o.setNm_titulo(rs.getString("nm_titulo"));
                o.setDs_console(rs.getString("ds_console"));
                o.setNivel_desejo(Integer.parseInt(rs.getString("nivel_desejo")));
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
