package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import una.pa.model.*;
import una.pa.service.*;

import java.util.*;

public class DesenvolvedorController extends MultiActionController {

    public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Desenvolvedor objC = DesenvolvedorService.unico(Integer.parseInt(request.getParameter("id")));

        return new ModelAndView("desenvolvedor/editar", "desenvolvedor", objC);
    }

    public ModelAndView editarForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Desenvolvedor objC = new Desenvolvedor();
        objC.setId_desenv(Integer.parseInt(request.getParameter("id_desenv")));
        objC.setDs_desenv(request.getParameter("ds_desenv"));

        try {

            flag = DesenvolvedorService.alterar(objC);

        } catch (Exception e) {
            return new ModelAndView("desenvolvedor/editar", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("desenvolvedor/editar", "desenvolvedor", objC);
    }

    public ModelAndView incluir(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("desenvolvedor/incluir", "msg", "");
    }

    public ModelAndView incluirForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Desenvolvedor objC = new Desenvolvedor();
        objC.setDs_desenv(request.getParameter("ds_desenv"));

        try {

            flag = DesenvolvedorService.incluir(objC);

        } catch (Exception e) {
            return new ModelAndView("desenvolvedor/incluir", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("desenvolvedor/incluir", "console", objC);
    }

    public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        try {

            flag = DesenvolvedorService.excluir(Integer.parseInt(request.getParameter("id")));

        } catch (Exception e) {
            return new ModelAndView("desenvolvedor/listagem", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("desenvolvedor/listagem", "msg", "Erro ao excluir o item.");
    }

    public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<Desenvolvedor> objC;
        try {

            objC = DesenvolvedorService.listar();

        } catch (Exception e) {
            return new ModelAndView("desenvolvedor/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("desenvolvedor/listagem", "desenvolvedores", objC);
    }
}