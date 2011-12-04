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
import una.pa.model.Categoria;
import una.pa.service.CategoriaService;
/**
 *
 * @author Tiago
 */
public class CategoriaController extends MultiActionController {

     public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Categoria objC = CategoriaService.unico(Integer.parseInt(request.getParameter("id")));

        return new ModelAndView("categoria/editar", "categoria", objC);
    }
     public ModelAndView editarForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Categoria objC = new Categoria();
        objC.setId_categoria(Integer.parseInt(request.getParameter("id_categoria")));
        objC.setNm_categoria(request.getParameter("nm_categoria"));

        try {

            flag = CategoriaService.alterar(objC);

        } catch (Exception e) {
            return new ModelAndView("categoria/editar", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("categoria/editar", "categoria", objC);
    }
     public ModelAndView incluir(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("categoria/incluir", "msg", "");
    }
      public ModelAndView incluirForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Categoria objC = new Categoria();
        objC.setNm_categoria(request.getParameter("nm_categoria"));

        try {

            flag = CategoriaService.incluir(objC);

        } catch (Exception e) {
            return new ModelAndView("categoria/incluir", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("categoria/incluir", "categoria", objC);
    }
      public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        try {

            flag = CategoriaService.excluir(Integer.parseInt(request.getParameter("id")));

        } catch (Exception e) {
            return new ModelAndView("categoria/listagem", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("categoria/listagem", "msg", "Erro ao excluir o item.");
    }
       public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<Categoria> objC;
        try {

            objC = CategoriaService.listar();

        } catch (Exception e) {
            return new ModelAndView("categoria/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("categoria/listagem", "categorias", objC);
    }

}