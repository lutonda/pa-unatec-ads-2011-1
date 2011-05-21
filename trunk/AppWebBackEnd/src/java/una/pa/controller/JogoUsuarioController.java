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
import una.pa.model.Jogousuario;
import una.pa.service.JogoUsuarioService;

/**
 *
 * @author Tiago
 */
public class JogoUsuarioController extends MultiActionController {

     public ModelAndView visualizar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        int _id = Integer.parseInt(request.getParameter("id"));
        List<Jogousuario> jogousuario;
       // AmigoUsuario amigoUsuario = new AmigoUsuario();

        try{
            jogousuario =  JogoUsuarioService.listarJogoUsuario(_id);
       }catch(Exception e){
           return new ModelAndView("jogousuario/visualizar", "msg", e.getMessage());
       }
        return new ModelAndView("jogousuario/visualizar", "jogoUsuario", jogousuario);
   }
}