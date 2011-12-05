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

@Controller
public class AjaxNotificacaoController {

    @RequestMapping(value = "site/inicio/listaNotificacao.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String getListaNotificacao(HttpServletRequest request,
            @RequestParam int idUsuario, @RequestParam int qtd, @RequestParam int pagina) {

        String Itens = "";
        int vTotal = 0;
        try {
            List<Notificacoes> objNot = NotificacoesService.listarNotPerfil(idUsuario, qtd, pagina,0);// Acrescentar o Id do Visitante no Lugar do 0, se nao existir passa o 0

            if (!objNot.isEmpty()) {
                for (Iterator<Notificacoes> it = objNot.iterator(); it.hasNext();) {
                    Notificacoes notificacoes = it.next();

                    Itens += "<li><a href=\"/AppWebFrontEnd/site/inicio/perfil.html?id=" + notificacoes.getId_usuario() + "\">" + notificacoes.getNm_nome() + "</a> <i>" + notificacoes.getDescricao() + "</i> " + notificacoes.getDt_notificacoes() + "</li>";
                    vTotal = notificacoes.getTotal();
                }
                Itens += "<div class=\"cb\"></div>|" + vTotal;
            } else {
                Itens = "";
            }
        } catch (Exception e) {
            Itens += "<li>Erro: "+ e.getMessage()+ "</li>";
            Itens += "<div class=\"cb\"></div>|0";
        }

        return Itens;
    }
}
