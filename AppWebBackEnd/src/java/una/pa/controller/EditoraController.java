

package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import una.pa.model.*;
import una.pa.service.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

public class EditoraController extends MultiActionController {

    public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Editora objC = EditoraService.unico(Integer.parseInt(request.getParameter("id")));

        return new ModelAndView("editora/editar", "editora", objC);
    }

     public ModelAndView editarForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Editora objC = new Editora();
        objC.setId_editora(Integer.parseInt(request.getParameter("id_editora")));
        objC.setNm_editora(request.getParameter("nm_editora"));
        String  verifica =  request.getParameter("nm_editora");

        if (verifica.trim().equals("")){
           return new ModelAndView("editora/incluir", "msg", "Preencha o campo para continuar.");
        }
        try {

            flag = EditoraService.alterar(objC);

        } catch (Exception e) {
            return new ModelAndView("editora/editar", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("editora/editar", "editora", objC);
    }
     public ModelAndView incluir(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("editora/incluir", "msg", "");
    }

      public ModelAndView incluirForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Editora objC = new Editora();
        objC.setNm_editora(request.getParameter("nm_editora"));

         String  verifica =  request.getParameter("nm_editora");

        if (verifica.trim().equals("")){
           return new ModelAndView("editora/incluir", "msg", "Preencha o campo para continuar.");
        }

        try {

            flag = EditoraService.incluir(objC);

        } catch (Exception e) {
            return new ModelAndView("editora/incluir", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("editora/incluir", "editora", objC);
    }
       public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        try {

            flag = EditoraService.excluir(Integer.parseInt(request.getParameter("id")));

        } catch (Exception e) {
            return new ModelAndView("editora/listagem", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("editora/listagem", "msg", "Erro ao excluir o item.");
    }
       public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        List<Editora> objC;
        try {

            objC = EditoraService.listar();

        } catch (Exception e) {
            return new ModelAndView("editora/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("editora/listagem", "editoras", objC);
    }

}