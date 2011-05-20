/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.ExecutionException;
import una.pa.model.*;

/**
 *
 * @author ADS - FACULDADE
 */
public class ConfiguracaoDal {

    public static Configuracao getConfiguracao(){

        Configuracao o = new Configuracao();
        String sql = "select ID_CONFIG, SERV_EMAIL,NM_CONTA, SENHA,"
                + "AUTO_SSL, EMAIL_RESPOSTA from dbo.CONFIGURACAO";

        try{

            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()){
                
                o.setId_config(Integer.parseInt(rs.getString("id_config").toString()));
                o.setServ_email(rs.getString("serv_email"));
                o.setNm_conta(rs.getString("Nm_Conta"));
                o.setSenha(rs.getString("Senha"));
                if (rs.getString("Auto_Ssl").equals("1")){
                    o.setAuto_ssl(true);
                }else {
                    o.setAuto_ssl(false);
                }
                o.setEmail_resposta(rs.getString("Email_Resposta"));
            }
            c.close();
            rs.close();
            return o;
        }catch (Exception e){
        return null;
    }
 }

    public static boolean alteraConfiguracao (Configuracao _obj){

        try{
            Connection c = Data.openConnection();
            String sql = "update CONFIGURACAO set "
                    + "SERV_EMAIL = ?, NM_CONTA = ?, SENHA = ?, AUTO_SSL = ?, EMAIL_RESPOSTA = ? "
                    + "where ID_CONFIG = ?";

            Object[] vetor = {_obj.getServ_email(),_obj.getNm_conta(),
            _obj.getSenha(), _obj.isAuto_ssl(), _obj.getEmail_resposta(), _obj.getId_config()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true ;
            } catch (Exception e){
                return false;
        }
    }
        public static boolean incluirConfiguracao (Configuracao _obj){

            try{
                Connection c = Data.openConnection();
                String sql = "insert into configuracao "
                + "(SERV_EMAIL,NM_CONTA,SENHA,AUTO_SSL,EMAIL_RESPOSTA)"
                + "values(?,?,?,?,?)";

                Object[] vetor = {_obj.getServ_email(), _obj.getNm_conta(),
                _obj.getSenha(), _obj.isAuto_ssl(), _obj.getEmail_resposta()};

                Data.executeUpdate(c, sql, vetor);
                c.close();
                return true;

                }catch (Exception e){
                    return false;


            }
    }

        public static boolean excluirConfiguracao (int _id){

            try{
                Connection c = Data.openConnection();
                String sql = "delete dbo.CONFIGURACAO where ID_CONFIG = ?";
                Object[] vetor = {_id};

                Data.executeUpdate(c, sql, vetor);
                c.close();

            return true;
        }catch (Exception e){
            return false;
        }
    }
}



    

   


