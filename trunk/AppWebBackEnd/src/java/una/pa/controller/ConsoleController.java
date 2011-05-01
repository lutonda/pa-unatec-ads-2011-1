/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import una.pa.model.Console;
import una.pa.service.ConsoleService;

import java.util.*;

public class ConsoleController extends MultiActionController {

    public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Console objC = ConsoleService.unico(Integer.parseInt(request.getParameter("id")));

        return new ModelAndView("console/editar", "console", objC);
    }

    public ModelAndView editarForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Console objC = new Console();
        objC.setId_console(Integer.parseInt(request.getParameter("id_console")));
        objC.setDs_console(request.getParameter("ds_console"));

        try {

            flag = ConsoleService.alterar(objC);

        } catch (Exception e) {
            return new ModelAndView("console/editar", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("console/editar", "console", objC);
    }

    public ModelAndView incluir(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("console/incluir", "msg", "");
    }

    public ModelAndView incluirForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Console objC = new Console();
        objC.setDs_console(request.getParameter("ds_console"));

        try {

            flag = ConsoleService.incluir(objC);

        } catch (Exception e) {
            return new ModelAndView("console/incluir", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("console/incluir", "console", objC);
    }

    public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        try {

            flag = ConsoleService.excluir(Integer.parseInt(request.getParameter("id")));

        } catch (Exception e) {
            return new ModelAndView("console/listagem", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("console/listagem", "msg", "Erro ao excluir o item.");
    }

    public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<Console> objC;
        try {

            objC = ConsoleService.listar();

        } catch (Exception e) {
            return new ModelAndView("console/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("console/listagem", "consoles", objC);
    }
}
