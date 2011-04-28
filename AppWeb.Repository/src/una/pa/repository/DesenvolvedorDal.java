package una.pa.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import una.pa.model.*;

public class DesenvolvedorDal {
    public static List<Desenvolvedor> listarDesenvolvedorDal(){
        List<Desenvolvedor> objC = new ArrayList<Desenvolvedor>();

        String sql = "select ID_DESENV,DS_DESENV from desenvolvedor";

        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while(rs.next()){
                Desenvolvedor o = new Desenvolvedor();
                o.setId_desenv(Integer.parseInt(rs.getString("ID_DESENV").toString()));
                o.setDs_desenv(rs.getString("DS_DESENV"));
                objC.add(o);
            }
            rs.close();
            c.close();
            return objC;
        }catch(Exception e){
            return null;
        }
    }
    public static boolean alteraDesenvolvedor(Desenvolvedor _obj){

        try {
            Connection c = Data.openConnection();
            String sql = "update desenvolvedor set ds_desenv = ? where id_desenv = ?";
            Object[] vetor =  {_obj.getDs_desenv(),_obj.getId_desenv()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

           }catch(Exception e){
                return false;
        } 
    }

    public static boolean incluiDesenvolvedor(Desenvolvedor _obj){

        try {
            Connection c = Data.openConnection();
            String sql = "insert into desenvolvedor(ds_desenv) values (?)";
            Object[] vetor =  {_obj.getDs_desenv()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

           }catch(Exception e){
                return false;
        }
    }

    public static boolean excluiDesenvolvedor(int _id){

        try {
            Connection c = Data.openConnection();
            String sql = "delete desenvolvedor where id_desenv = ?";
            Object[] vetor =  {_id};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

           }catch(Exception e){
                return false;
        }
    }

}
