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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import una.pa.model.*;
import una.pa.service.*;

/** 
 *
 * @author Tiago
 */
@Controller
public class AjaxCtrlUsuarioController {

    @RequestMapping(value = "site/inicio/ctrlUsuario.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String postCtrlUsuario(HttpServletRequest request,
            @RequestParam int idAmigoUsuario, @RequestParam int controleTipo, String nmUser, Integer idUser) {

        boolean flag = false;
        // CtrlUsuarioService.aceitaUsuario(idAmigoUsuario);
        if (controleTipo != -1) {
            try {
                switch (controleTipo) {
                    case 0: //Recusar Convite ou Remover Usuário
                        flag = CtrlUsuarioService.recusaUsuario(idAmigoUsuario);
                        break;
                    case 1: //Aceitar solicitação
                        flag = CtrlUsuarioService.aceitaUsuario(idAmigoUsuario);

                        if (flag) {
                            Notificacoes objct = new Notificacoes();

                            try {
                                int idUserCorrente = Integer.parseInt((String) request.getSession().getAttribute("id"));
                                objct.setId_usuario(idUserCorrente);

                                return String.valueOf(NotificacoesService.enviaNotificacao(
                                        Notificacoes.numeraNotificacao.ADICIONA,
                                        "", idUserCorrente, idUser, nmUser, 0, "", 0, "", 0));

                            } catch (Exception e) {
                                return String.valueOf(false);
                            }
                        }

                        break;
                    case 2: //Adiciona
                        int idUserVisit = Integer.parseInt((String) request.getSession().getAttribute("id"));
                        flag = CtrlUsuarioService.adicionarUsuario(idAmigoUsuario, idUserVisit);
                        break;
//                    case 3: //Ignorar
//                        flag = CtrlUsuarioService.ignorarUsuario(idAmigoUsuario, 1);
//                        break;
//                    case 4: //Desfazer Ignorar
//                        flag = CtrlUsuarioService.ignorarUsuario(idAmigoUsuario, 0);
//                        break;
                }

            } catch (Exception e) {
                return String.valueOf(false);
            }
        }
        return String.valueOf(flag);
    }
}