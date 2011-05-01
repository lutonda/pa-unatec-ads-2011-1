
package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import una.pa.model.Console;

/**
 *
 * @author Magno
 */
public class ConsoleDal {

    public static List<Console> listarDal() {

        List<Console> objC = new ArrayList<Console>();

        String sql = "SELECT ID_CONSOLE, DS_CONSOLE FROM CONSOLE";


        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Console o = new Console();
                o.setId_console(Integer.parseInt(rs.getString("ID_CONSOLE").toString()));
                o.setDs_console(rs.getString("DS_CONSOLE"));
                objC.add(o);
            }

            rs.close();
            c.close();

            return objC;
        } catch (Exception e) {
            return null;
        }
    }
      public static boolean alteraConsole(Console _obj){

        try {
            Connection c = Data.openConnection();
            String sql = "update console set ds_console = ? where id_console = ?";
            Object[] vetor =  {_obj.getDs_console(),_obj.getId_console()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

           }catch(Exception e){
                return false;
        }
    }

    public static boolean incluiConsole(Console _obj){

        try {
            Connection c = Data.openConnection();
            String sql = "insert into console (ds_console) values (?)";
            Object[] vetor =  {_obj.getDs_console()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

           }catch(Exception e){
                return false;
        }
    }

    public static boolean excluiConsole(int _id){

        try {
            Connection c = Data.openConnection();
            String sql = "DELETE FROM CONSOLE WHERE id_console = ?";
            Object[] vetor =  {_id};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

           }catch(Exception e){
                return false;
        }
    }
}
