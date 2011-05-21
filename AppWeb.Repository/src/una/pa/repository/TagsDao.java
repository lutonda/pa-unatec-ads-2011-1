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
public class TagsDao {
    public static List<Tags> listarTags(int _id){
        List<Tags> objct = new ArrayList<Tags>();

        String sql = " select tags.id_tag," +
                     " tags.ds_tag " +
                     " from tags " + 
                     " where id_usuario = ? ";
        Object[] vetor = {_id};

        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while(rs.next()){
                Tags o = new Tags();

                o.setId_tag(Integer.parseInt(rs.getString("id_tag")));
                o.setDs_tag(rs.getString("ds_tag"));
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
