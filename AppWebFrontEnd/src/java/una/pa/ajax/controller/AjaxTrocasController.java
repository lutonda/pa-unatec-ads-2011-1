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
public class AjaxTrocasController {

    @RequestMapping(value = "site/inicio/listaTrocasJogos.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String getListaTrocasJogos(HttpServletRequest request,
            @RequestParam int id, @RequestParam String tipo, @RequestParam int qtd, @RequestParam int pagina) {

        String Itens = "";
        List<TrocaJogos> objTrocaJogos = TrocaJogosService.jogosTrocados(qtd, pagina, id);

        if (!objTrocaJogos.isEmpty()) {
            for (Iterator<TrocaJogos> it = objTrocaJogos.iterator(); it.hasNext();) {
                TrocaJogos trocaJogos = it.next();
                
                Itens += "<li>" + trocaJogos.getTipo() + " - " + trocaJogos.getNm_usuario_destino() + " " + trocaJogos.getCidade()+"/"+ trocaJogos.getEstado()  + " - " + trocaJogos.getNm_titulo_origem()  + " POR " + trocaJogos.getNm_titulo_destino()  + " - "+ trocaJogos.getStatus_troca() +"</li>";

            }

            Itens += "|" + objTrocaJogos.get(0).getTotal();

        }
        return Itens;
    }
}
