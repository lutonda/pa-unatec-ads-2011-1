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

        List<Notificacoes> objNot = NotificacoesService.listarNotPerfil(idUsuario);

        for (Iterator<Notificacoes> it = objNot.iterator(); it.hasNext();) {
            Notificacoes notificacoes = it.next();

            Itens += "<li><a href=\"#\">"+ notificacoes.getNm_nome() + "</a> <i>" + notificacoes.getDescricao() + "</i> " + notificacoes.getDt_notificacoes() + "</li>";
            vTotal = notificacoes.getTotal();
        }

        Itens += "|"+ vTotal;
 
        return Itens;
    }
}
