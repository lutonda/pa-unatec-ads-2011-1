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

        TrocaJogos.statusTroca st = null;

        if (tipo.equals("F")) {
            st = TrocaJogos.statusTroca.finalizado;
        } else if (tipo.equals("P")) {
            st = TrocaJogos.statusTroca.aberto;
        } else if (tipo.equals("A")) {
            st = TrocaJogos.statusTroca.andamento;
        }

        String Itens = "";
        int Count = 0;
        List<TrocaJogos> objTrocaJogos = TrocaJogosService.jogosTrocados(qtd, pagina, id);

        if (!objTrocaJogos.isEmpty()) {
            for (Iterator<TrocaJogos> it = objTrocaJogos.iterator(); it.hasNext();) {
                TrocaJogos trocaJogos = it.next();

                if (trocaJogos.getStatus_troca().equals(st.toString())) {
                    Itens += listItem(trocaJogos);
                    Count++;
                }
            }
            Itens += "|" + Count;
        }
        return Itens;
    }

    private String listItem(TrocaJogos trocaJogos) {
        String Itens = "";
        return Itens += "<li>" + trocaJogos.getTipo() + " - " + trocaJogos.getNm_usuario_destino() + " " + trocaJogos.getCidade() + "/" + trocaJogos.getEstado() + " - " + trocaJogos.getNm_titulo_origem() + " POR " + trocaJogos.getNm_titulo_destino() + " - " + trocaJogos.getStatus_troca() + "</li>";
    }
}
