/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import una.pa.model.Jogo;
import una.pa.service.JogoService;

/**
 *
 * @author Tiago
 */
public class JogoController extends MultiActionController {

    public ModelAndView detalhesjogo(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            ModelAndView mav = new ModelAndView("site/jogo/detalhesjogo");
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Jogo objct = JogoService.detalheJogo(id);
            mav.addObject("Jogo", objct);

        } catch (Exception e) {
            response.sendRedirect("/site/inicio/index.html");
            return null;
        }
        return mav;
    }
}
