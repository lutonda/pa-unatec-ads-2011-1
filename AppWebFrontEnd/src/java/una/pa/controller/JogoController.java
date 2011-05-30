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
import una.pa.model.*;
import una.pa.service.*;

/**
 *
 * @author Tiago
 */
public class JogoController extends MultiActionController {

    public ModelAndView detalhesjogo(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("site/jogo/detalhesjogo");

        int cod;// = Integer.parseInt(request.getParameter("cod"));
        if (request.getParameter("cod") == null)
            cod = 0;
        else
            cod = Integer.parseInt(request.getParameter("cod"));

        try {
            int id  = Integer.parseInt(request.getParameter("id"));
            

            Jogo objct = JogoService.detalheJogo(id);
            List <Usuario> usu = UsuarioService.usuarioJogos(id, cod);

            DadosIniciais obj = UsuarioService.inicioPerfil();
            List<Tags> objTags = TagsService.listarTags(obj.getId_usuario());
            mav.addObject("Jogo", objct);
            mav.addObject("usuarios", usu);
            mav.addObject("DadosIniciais", obj);
            mav.addObject("tags", objTags);

        } catch (Exception e) {
            response.sendRedirect("/site/inicio/index.html");
            return null;
        }
        return mav;
    }
}
