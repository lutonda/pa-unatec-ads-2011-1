package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import una.pa.model.*;
import una.pa.service.*;
import java.util.*;
import una.pa.util.*;

public class InicioController extends MultiActionController {

    public ModelAndView index(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("site/inicio/index");
        try {

            DadosIniciais obj = UsuarioService.inicioPerfil();
            List<Tags> objTags = TagsService.listarTags(obj.getId_usuario());
            List<Jogo> objJogo = JogoService.listar(obj.getId_usuario());
            List<Notificacoes> objNot = NotificacoesService.listarNotPerfil(obj.getId_usuario());

            mav.addObject("DadosIniciais", obj);
            mav.addObject("tags", objTags);
            mav.addObject("jogos", objJogo);
            mav.addObject("notificacoes", objNot);

        } catch (Exception e) {
            return null;
        }
        return mav;
    }

    public ModelAndView processoCadastro(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {
            String email = request.getParameter("email");
            if (email != null) {
                if (Validacao.validaEmail(email)) {
                    if (UsuarioService.verificaEmail(email)) {

                        StringEncryptor ec = new StringEncryptor();
                        String id = ec.encrypt("4");

                        response.sendRedirect("passo1.html?id=" + id);
                    } else {
                        response.sendRedirect("../ajuda/orientacao.html");
                    }
                } else {
                    response.sendRedirect("../ajuda/orientacao.html");
                }
            }
            response.sendRedirect("../ajuda/orientacao.html");
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public ModelAndView passo1(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("inicio/cadastro/passo1");
        try {
            StringEncryptor ec = new StringEncryptor();
            mav.addObject("msg", ec.decrypt(request.getParameter("id")));



        } catch (Exception e) {
            response.sendRedirect("../ajuda/orientacao.html");
            return null;
        }
        return mav;
    }

    public ModelAndView passo2(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("inicio/cadastro/passo2");
        try {
        } catch (Exception e) {
            return null;
        }
        return mav;
    }

    public ModelAndView cadastroPasso1Form(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("inicio/cadastro/passo1");
        try {

            response.sendRedirect("passo2.html");

        } catch (Exception e) {
            return null;
        }
        return mav;
    }

    public ModelAndView cadastroPasso2Form(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("inicio/cadastro/passo2");
        try {

            response.sendRedirect("/AppWebFrontEnd/site/inicio/index.html");

        } catch (Exception e) {
            return null;
        }
        return mav;
    }
}
