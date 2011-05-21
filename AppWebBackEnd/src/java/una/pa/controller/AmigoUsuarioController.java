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
import una.pa.service.AmigoUsuarioService;

/**
 *
 * @author Tiago
 */
public class AmigoUsuarioController extends MultiActionController {

   public ModelAndView visualizar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       
        int _id = Integer.parseInt(request.getParameter("id"));
        List<AmigoUsuario> amigoUsuario;
       // AmigoUsuario amigoUsuario = new AmigoUsuario();

        try{
            amigoUsuario =  AmigoUsuarioService.listarAmigo(_id);
       }catch(Exception e){
           return new ModelAndView("amigousuario/visualizar", "msg", e.getMessage());
       }
        return new ModelAndView("amigousuario/visualizar", "amigoUsuario", amigoUsuario);
   }

}