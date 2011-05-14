/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import una.pa.model.*;
import una.pa.service.*;

import java.util.*;
/**
 *
 * @author Tiago
 */
public class ConviteController extends MultiActionController{
     public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Convite objC = ConviteService.unico(Integer.parseInt(request.getParameter("id")));

        return new ModelAndView("convite/editar", "convite", objC);
    }

      public ModelAndView editarForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Convite objC = new Convite();
        objC.setId_convite(Integer.parseInt(request.getParameter("id_convite")));
        objC.setAssunto(request.getParameter("assunto"));
        objC.setCorpo_convite(request.getParameter("corpo_convite"));

        try {

            flag = ConviteService.alterar(objC);

        } catch (Exception e) {
            return new ModelAndView("convite/editar", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("convite/editar", "convite", objC);
    }

       public ModelAndView incluir(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("convite/incluir", "msg", "");
    }

        public ModelAndView incluirForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Convite objC = new Convite();

        objC.setAssunto(request.getParameter("assunto"));
        objC.setCorpo_convite(request.getParameter("corpo_convite"));

        try {

            flag = ConviteService.incluir(objC);

        } catch (Exception e) {
            return new ModelAndView("convite/incluir", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("convite/incluir", "console", objC);
    }
        public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        try {

            flag = ConviteService.excluir(Integer.parseInt(request.getParameter("id")));
                    //ConsoleService.excluir(Integer.parseInt(request.getParameter("id")));

        } catch (Exception e) {
            return new ModelAndView("convite/listagem", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("convite/listagem", "msg", "Erro ao excluir o item.");
    }

     public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<Convite> objC;
        try {

            objC = ConviteService.listar();

        } catch (Exception e) {
            return new ModelAndView("convite/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("convite/listagem", "convites", objC);
    }

}
