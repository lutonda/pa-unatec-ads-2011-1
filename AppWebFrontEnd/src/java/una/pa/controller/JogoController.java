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
import una.pa.model.Jogo;
import una.pa.model.Usuario;
import una.pa.service.JogoService;
import una.pa.service.UsuarioService;

/**
 *
 * @author Tiago
 */
public class JogoController extends MultiActionController {

    public ModelAndView detalhesjogo(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("site/jogo/detalhesjogo");
        try {
            int id  = Integer.parseInt(request.getParameter("id"));
            int cod = Integer.parseInt(request.getParameter("cod"));

            Jogo objct = JogoService.detalheJogo(id);
            List <Usuario> usu = UsuarioService.usuarioJogos(id, cod);
            mav.addObject("Jogo", objct);
            mav.addObject("usuarios", usu);

        } catch (Exception e) {
            response.sendRedirect("/site/inicio/index.html");
            return null;
        }
        return mav;
    }
}
