package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import una.pa.model.*;
import una.pa.service.*;

import java.util.*;
import una.pa.util.Upload;

public class JogoController extends MultiActionController {

    public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Jogo objC = JogoService.unico(Integer.parseInt(request.getParameter("id")));

        ModelAndView mav = new ModelAndView("jogo/editar");
        mav.addObject("jogo", objC);
        List<TituloJogo> objTituloJogo = TituloJogoService.listar();
        List<Console> objConsole = ConsoleService.listar();

        mav.addObject("titulojogos", objTituloJogo);
        mav.addObject("consoles", objConsole);
        return mav;
    }

    public ModelAndView editarForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag = false;
        Jogo objC = new Jogo();
        objC.setId_jogo(Integer.parseInt(request.getParameter("id_jogo")));
        objC.setId_titulo_jogo(Integer.parseInt(request.getParameter("id_titulo_jogo")));
        objC.setId_console(Integer.parseInt(request.getParameter("id_console")));

        String server_path = getServletContext().getRealPath("/");
        String upload_directory = "resources/capa/";
        String complete_path = server_path + upload_directory;

        List<String> rt = Upload.uploadImagem(request, response, complete_path);

        if (rt != null)
            objC.setImagem(rt.get(0));
        else if (request.getParameter("imagem") != null)
            objC.setImagem(request.getParameter("imagem"));


        ModelAndView mav = new ModelAndView("jogo/editar");
        try {

            flag = JogoService.alterar(objC);

        } catch (Exception e) {
            mav.addObject("msg", e.getMessage());
        }

        if (flag)
            response.sendRedirect("listar.htm");

        List<TituloJogo> objTituloJogo = TituloJogoService.listar();
        List<Console> objConsole = ConsoleService.listar();
        mav.addObject("jogo", objC);
        mav.addObject("titulojogos", objTituloJogo);
        mav.addObject("consoles", objConsole);

        return mav;
    }

    public ModelAndView incluir(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("jogo/incluir");

        List<TituloJogo> objTituloJogo = TituloJogoService.listar();
        List<Console> objConsole = ConsoleService.listar();

        mav.addObject("titulojogos", objTituloJogo);
        mav.addObject("consoles", objConsole);

        return mav;
    }

    public ModelAndView incluirForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        Jogo objC = new Jogo();
        objC.setId_titulo_jogo(Integer.parseInt(request.getParameter("id_titulo_jogo")));
        objC.setId_console(Integer.parseInt(request.getParameter("id_console")));

        String server_path = getServletContext().getRealPath("/");
        String upload_directory = "resources/capa/";
        String complete_path = server_path + upload_directory;

        List<String> rt = Upload.uploadImagem(request, response, complete_path);

        if (rt != null)
            objC.setImagem(rt.get(0));

        try {

            flag = JogoService.incluir(objC);

        } catch (Exception e) {
            return new ModelAndView("jogo/incluir", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("jogo/incluir", "jogo", objC);
    }

    public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        try {

            flag = JogoService.excluir(Integer.parseInt(request.getParameter("id")));

        } catch (Exception e) {
            return new ModelAndView("jogo/listagem", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("jogo/listagem", "msg", "Erro ao excluir.");
    }

    public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<Jogo> objC;
        try {

            objC = JogoService.listar();

        } catch (Exception e) {
            return new ModelAndView("jogo/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("jogo/listagem", "jogos", objC);
    }
}