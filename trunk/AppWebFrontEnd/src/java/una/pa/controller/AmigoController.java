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
import una.pa.model.AmigoUsuario;
import una.pa.repository.AmigoUsuarioDao;

/**
 *
 * @author Tiago
 */
public class AmigoController extends MultiActionController {

    public ModelAndView amigos(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("site/amigo/amigos");
        
        try{
            int id = Integer.parseInt(request.getParameter("id"));

            List<AmigoUsuario> obj = AmigoUsuarioDao.detalheAmigos(id);
            mav.addObject("amigos", obj);
            return mav;
        }catch(Exception e){
            return null;
        }
    }

}