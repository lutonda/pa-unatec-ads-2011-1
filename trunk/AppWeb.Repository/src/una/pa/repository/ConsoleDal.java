/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
}
