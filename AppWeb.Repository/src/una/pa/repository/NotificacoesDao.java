/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import una.pa.model.*;
import una.pa.repository.FormataData;
import java.util.List;


/**
 *
 * @author ALEXANDRE
 */
public class NotificacoesDao {

    public static List<Notificacoes> listarDao(){

        List<Notificacoes> objc = new ArrayList<Notificacoes>();

    String sql = "select "
            + " notificacoes.id_notificacao,"
            + " usuario.id_usuario,"
            + " usuario.nm_usuario,"
            + "	notificacoes.descricao,"
            + "	notificacoes.broadcast,"
            + "	notificacoes.dt_notificacao "
            + " from  usuario"
            + "	inner join amigo_usuario on usuario.id_usuario = amigo_usuario.id_usuario"
            + "	inner join notificacoes	on amigo_usuario.id_amigo_usuario = notificacoes.id_amigo_usuario";

       try{

           Connection c = Data.openConnection();
           ResultSet rs = Data.executeQuery(c, sql);

           while(rs.next()){
               Notificacoes o = new Notificacoes();
               o.setId_notificacao(Integer.parseInt(rs.getString("id_notificacao")));
               o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
               o.setNm_nome(rs.getString("nm_usuario"));
               o.setDescricao(rs.getString("descricao"));
               o.setBroadcast(rs.getString("broadcast"));
               o.setDt_notificacoes(rs.getString("dt_notificacao"));
               objc.add(o);
           }
           c.close();
           rs.close();
           return objc;
        }catch(Exception e){
        return null;
    }
}
}
