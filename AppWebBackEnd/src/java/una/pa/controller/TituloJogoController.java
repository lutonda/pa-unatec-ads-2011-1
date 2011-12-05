package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import una.pa.model.*;
import una.pa.service.*;

import java.util.*;

public class TituloJogoController extends MultiActionController {

    public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        TituloJogo objC = TituloJogoService.unico(Integer.parseInt(request.getParameter("id")));

        ModelAndView mav = new ModelAndView("titulojogo/editar");
        mav.addObject("titulojogo", objC);
        return mav;
    }

    public ModelAndView editarForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag = false;
        TituloJogo objC = new TituloJogo();
        objC.setId_titulo_jogo(Integer.parseInt(request.getParameter("id_titulo_jogo")));
        objC.setNm_titulo(request.getParameter("nm_titulo"));
        objC.setDescricao(request.getParameter("descricao"));
        objC.setDt_lancamento(request.getParameter("dt_lancamento"));

        ModelAndView mav = new ModelAndView("titulojogo/editar");
        try {

            flag = TituloJogoService.alterar(objC);

        } catch (Exception e) {
            mav.addObject("msg", e.getMessage());
        }

        if (flag)
            response.sendRedirect("listar.htm");

        List<Editora> objEditora = EditoraService.listar();
        List<Genero> objGnero = GeneroService.listar();
        List<Desenvolvedor> objDesenv = DesenvolvedorService.listar();
        
        mav.addObject("titulojogo", objC);
        mav.addObject("editoras", objEditora);
        mav.addObject("generos", objGnero);
        mav.addObject("desenvolvedores", objDesenv);
       
        return mav;
        //return new ModelAndView("titulojogo/editar", "titulojogo", objC);
    }

    public ModelAndView incluir(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("titulojogo/incluir");

        List<Editora> objEditora = EditoraService.listar();
        List<Genero> objGnero = GeneroService.listar();
        List<Desenvolvedor> objDesenv = DesenvolvedorService.listar();

        mav.addObject("editoras", objEditora);
        mav.addObject("generos", objGnero);
        mav.addObject("desenvolvedores", objDesenv);

        return mav;
        //return new ModelAndView("titulojogo/incluir", "msg", "");
    }

    public ModelAndView incluirForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        TituloJogo objC = new TituloJogo();
        //objC.setId_editora(Integer.parseInt(request.getParameter("id_editora")));
        //objC.setId_genero(Integer.parseInt(request.getParameter("id_genero")));
        //objC.setId_desenv(Integer.parseInt(request.getParameter("id_desenv")));
        objC.setNm_titulo(request.getParameter("nm_titulo"));
        //objC.setTipo(request.getParameter("tipo"));

        try {

            flag = TituloJogoService.incluir(objC);

        } catch (Exception e) {
            return new ModelAndView("titulojogo/incluir", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("titulojogo/incluir", "titulojogo", objC);
    }

    public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        try {

            flag = TituloJogoService.excluir(Integer.parseInt(request.getParameter("id")));

        } catch (Exception e) {
            return new ModelAndView("titulojogo/listagem", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("titulojogo/listagem", "msg", "Erro ao excluir.");
    }

    public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<TituloJogo> objC;
        try {

            objC = TituloJogoService.listar();

        } catch (Exception e) {
            return new ModelAndView("titulojogo/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("titulojogo/listagem", "titulo_jogos", objC);
    }
}
