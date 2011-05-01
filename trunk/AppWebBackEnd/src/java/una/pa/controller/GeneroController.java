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
public class GeneroController extends MultiActionController {

    public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Genero objC = GeneroService.unico(Integer.parseInt(request.getParameter("id")));

        return new ModelAndView("genero/editar", "genero", objC);
    }
    public ModelAndView editarForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Genero objC = new Genero();
        objC.setId_genero(Integer.parseInt(request.getParameter("id_genero")));
        objC.setDs_genero(request.getParameter("ds_genero"));

         String  verifica =  request.getParameter("ds_genero");

        if (verifica.trim().equals("")){
           return new ModelAndView("genero/incluir", "msg", "Preencha o campo para continuar.");
        }

        try {

            flag = GeneroService.alterar(objC);

        } catch (Exception e) {
            return new ModelAndView("genero/editar", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("genero/editar", "genero", objC);
    }
     public ModelAndView incluir(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("genero/incluir", "msg", "");
    }
     public ModelAndView incluirForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Genero objC = new Genero();
        objC.setDs_genero(request.getParameter("ds_genero"));
        String  verifica =  request.getParameter("ds_genero");

        if (verifica.trim().equals("")){
           return new ModelAndView("genero/incluir", "msg", "Preencha o campo para continuar.");
        }

        try {

            flag = GeneroService.incluir(objC);

        } catch (Exception e) {
            return new ModelAndView("genero/incluir", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("genero/incluir", "genero", objC);
    }
      public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        try {

            flag = GeneroService.excluir(Integer.parseInt(request.getParameter("id")));

        } catch (Exception e) {
            return new ModelAndView("genero/listagem", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("genero/listagem", "msg", "Erro ao excluir o item.");
    }
     public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<Genero> objC;
        try {

            objC = GeneroService.listar();

        } catch (Exception e) {
            return new ModelAndView("genero/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("genero/listagem", "generos", objC);
    }

}