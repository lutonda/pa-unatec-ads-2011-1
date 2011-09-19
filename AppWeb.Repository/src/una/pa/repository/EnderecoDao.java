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
public class EnderecoDao {

    public static Endereco listarEndereco(int _id){
        String sql = "select endereco.logradouro, " +
                     " endereco.cep, " +
                     "  endereco.numero," +
                     "  endereco.complemento, " +
                     " tp_logradouro, " +
                     " ds_bairro,  " +
                     " ds_cidade, " +
                     " ds_estado  " +
                     " from usuario, " +
                     " endereco " +
                     " where usuario.id_usuario = endereco.id_usuario" +
                     " and usuario.id_usuario = ?;" ;
        Object[] vetor = {_id};
        Endereco o = new Endereco();

        try{

            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            if(rs.next()){
                o.setLogradouro(rs.getString("logradouro") != null ? rs.getString("logradouro") : " ");
                o.setTp_logradouro(rs.getString("tp_logradouro") != null ? rs.getString("tp_logradouro") : " ");
                o.setCep(rs.getString("cep")!= null ? Integer.parseInt(rs.getString("cep")) : Integer.parseInt(" "));
                o.setNumero(rs.getString("numero") != null ? Integer.parseInt(rs.getString("numero")) : Integer.parseInt(" "));
                o.setComplemento(rs.getString("complemento") != null ? rs.getString("complemento") : " ");
                o.setDs_bairro(rs.getString("ds_bairro") != null ? rs.getString("ds_bairro") : " ");
                o.setDs_cidade(rs.getString("ds_cidade") != null ? rs.getString("ds_cidade") : " ");
                o.setDs_estado(rs.getString("ds_estado") != null ? rs.getString("ds_estado") : " ");
            }  
            rs.close();
            c.close();
            return o;
        }catch(Exception e){
            return  null;
        }
        
    }

}
