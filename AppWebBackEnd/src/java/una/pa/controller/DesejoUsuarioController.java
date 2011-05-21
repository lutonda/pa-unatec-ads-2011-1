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
import una.pa.model.Desejousuario;
import una.pa.service.DesejoUsuarioService;

/**
 *
 * @author Tiago
 */
public class DesejoUsuarioController extends MultiActionController {

    public ModelAndView visualizar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        int _id = Integer.parseInt(request.getParameter("id"));
        List<Desejousuario> desejoUsuario;
       // AmigoUsuario amigoUsuario = new AmigoUsuario();

        try{
            desejoUsuario =  DesejoUsuarioService.listarDesejo(_id); //AmigoUsuarioService.listarAmigo(_id);
       }catch(Exception e){
           return new ModelAndView("desejousuario/visualizar", "msg", e.getMessage());
       }
        return new ModelAndView("desejousuario/visualizar", "amigoUsuario", desejoUsuario);
   }

}