/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.ajax.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import una.pa.model.*;
import una.pa.service.*;


/**
 *
 * @author Tiago
*/
public class AjaxEnviaNotificacaoController {


    @RequestMapping(value = "site/inicio/enviarNotificacao.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String  postEnviarNotificacao(HttpServletRequest request,
            int idUsuario,  String dsNotificacao, boolean broadcast) {

        Notificacoes objct = new Notificacoes();

        try{
            int idUserCorrente = Integer.parseInt((String)request.getSession().getAttribute("id"));
            objct.setId_usuario(idUserCorrente);
            objct.setDescricao(dsNotificacao);
            objct.setBroadcast((broadcast)? 1:0);
            return String.valueOf(NotificacoesService.enviaNotificacao(Notificacoes.numeraNotificacao.FALA, dsNotificacao, idUsuario, 5, "Magno", 0, "", 0, "", 0));
        }catch(Exception e){
            return String.valueOf(false);
        }  
    }

}