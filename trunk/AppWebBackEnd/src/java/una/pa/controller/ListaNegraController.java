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
import una.pa.model.ListaNegra;
import una.pa.service.ListaNegraService;

/**
 *
 * @author Tiago
 */
public class ListaNegraController extends MultiActionController {

  public ModelAndView visualizar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        int _id = Integer.parseInt(request.getParameter("id"));
        List<ListaNegra> listaNegra;
       // AmigoUsuario amigoUsuario = new AmigoUsuario();

        try{
            listaNegra = ListaNegraService.listar(_id);
       }catch(Exception e){
           return new ModelAndView("listanegra/listar", "msg", e.getMessage());
       }
        return new ModelAndView("listanegra/listar", "listanegra", listaNegra);
   }
}