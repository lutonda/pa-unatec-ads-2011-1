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
            int idUsuario,  String dsNotificacao) {

        Notificacoes objct = new Notificacoes();
        try{
            objct.setId_usuario(idUsuario);
            objct.setDescricao(dsNotificacao);
            return String.valueOf(NotificacoesService.enviaNotificacao(objct));
        }catch(Exception e){
            return String.valueOf(false);
        }  
    }

}