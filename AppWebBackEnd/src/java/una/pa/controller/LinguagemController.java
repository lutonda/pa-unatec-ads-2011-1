/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import una.pa.model.Linguagem;
import una.pa.service.LinguagemService;

/**
 *
 * @author Tiago
 */
public class LinguagemController extends MultiActionController {

    public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Linguagem objC = LinguagemService.unico(Integer.parseInt(request.getParameter("id")));

        return new ModelAndView("linguagem/editar", "linguagem", objC);
    }
     public ModelAndView editarForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Linguagem objC = new Linguagem();
        objC.setId_linguagem(Integer.parseInt(request.getParameter("id_linguagem")));
        objC.setNm_linguagem(request.getParameter("nm_linguagem"));

        try {

            flag = LinguagemService.alterar(objC);

        } catch (Exception e) {
            return new ModelAndView("linguagem/editar", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("linguagem/editar", "linguagem", objC);
    }
     public ModelAndView incluir(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("linguagem/incluir", "msg", "");
    }
      public ModelAndView incluirForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Linguagem objC = new Linguagem();
        objC.setNm_linguagem(request.getParameter("nm_linguagem"));

        try {

            flag = LinguagemService.incluir(objC);

        } catch (Exception e) {
            return new ModelAndView("linguagem/incluir", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("linguagem/incluir", "linguagem", objC);
    }
      public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        try {

            flag = LinguagemService.excluir(Integer.parseInt(request.getParameter("id")));

        } catch (Exception e) {
            return new ModelAndView("linguagem/listagem", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("linguagem/listagem", "msg", "Erro ao excluir o item.");
    }
       public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<Linguagem> objC;
        try {

            objC = LinguagemService.listar();

        } catch (Exception e) {
            return new ModelAndView("linguagem/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("linguagem/listagem", "linguagens", objC);
    }

}