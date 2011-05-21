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
import una.pa.model.Notificacoes;
import una.pa.service.*;


/**
 *
 * @author ALEXANDRE
 */
public class NotificacaoController extends MultiActionController {

    public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception{

        List<Notificacoes> objct;

        try{
            objct = NotificacoesService.listar();
        }catch(Exception e ){
            return new ModelAndView("notificacoes/listagem", "msg", e.getMessage());
        }

        return new ModelAndView("notificacoes/listagem", "notificacoes", objct);
    }
    
    public ModelAndView visualizar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        int _id = Integer.parseInt(request.getParameter("id"));
        List<Notificacoes> notificacao;
       // AmigoUsuario amigoUsuario = new AmigoUsuario();

        try{
            notificacao = NotificacoesService.listarUnico(_id);
       }catch(Exception e){
           return new ModelAndView("notificacoes/visualizar", "msg", e.getMessage());
       }
        return new ModelAndView("notificacoes/visualizar", "notificacoes", notificacao);
   }

}