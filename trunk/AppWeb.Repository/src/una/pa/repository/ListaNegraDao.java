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
public class ListaNegraDao {
    public static List<ListaNegra> listaNegra(int _id){
        List<ListaNegra> objct = new ArrayList<ListaNegra>();

        String sql = " select  usuario.id_usuario, " +
                     " usuario.nm_usuario " +
                     " from  usuario, " +
                     " amigo_usuario, " +
                     " lista_negra " +
                     " where usuario.id_usuario = amigo_usuario.id_usuario_amigo " +
                     " and amigo_usuario.id_amigo_usuario = lista_negra.id_amigo_usuario " +
                     " and usuario.id_usuario = ?";

        Object[] vetor = {_id};

        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while(rs.next()){
                ListaNegra o = new ListaNegra();

                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setNm_usuario(rs.getString("nm_usuario"));

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
