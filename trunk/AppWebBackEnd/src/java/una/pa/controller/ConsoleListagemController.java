/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import una.pa.model.Console;

import java.sql.Connection;
import java.sql.ResultSet;

import java.util.*;

/**
 *
 * @author Magno
 */
public class ConsoleListagemController extends AbstractController {

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        List<Console> objC = new ArrayList<Console>();

        String sql = "SELECT ID_CONSOLE, DS_CONSOLE FROM CONSOLE";


        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Console o = new Console();
                o.setId_console(Integer.parseInt(rs.getString("id").toString()));
                o.setDs_console(rs.getString("id"));
                objC.add(o);
            }

            rs.close();
            c.close();


        } catch (Exception e) {
            return new ModelAndView("console/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("console/listagem", "consoles", objC);
    }
}
