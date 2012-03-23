package una.pa.ajax.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import una.pa.model.*;
import una.pa.repository.Data;
import una.pa.service.*;
import una.pa.util.DateTime;

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
                    String Item = "";
                    Item += "<li>" + trocaJogos.getTipo() + " - "
                            + trocaJogos.getNm_usuario_destino() + " " + trocaJogos.getCidade() + "/"
                            + trocaJogos.getEstado() + " - " + trocaJogos.getNm_titulo_destino()
                            + " POR " + trocaJogos.getNm_titulo_origem() + " - "
                            + trocaJogos.getStatus_troca();
                            if(st.equals(TrocaJogos.statusTroca.andamento) && trocaJogos.getData_final_usu_origem() == null)
                                Item += " <span id=btn_" + trocaJogos.getId_troca() + "><a href=\"javascript:void(0);\" class=btnFimTroca id=" + trocaJogos.getId_troca() + ">Finalizar Troca</a></span></li>";
                            else if(st.equals(TrocaJogos.statusTroca.andamento))
                                Item += " (Qualificar Usuário)</li>";
                            else                           
                                Item += " </li>";

                    Itens += Item;
                    Count++;
                }
            }
            Itens += "|" + Count;
        }
        return Itens;
    }

    @RequestMapping(value = "site/inicio/trocaJogo.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String getTrocaJogo(HttpServletRequest request,
            @RequestParam int idTroca) {

        TrocaJogos trocajogos = new TrocaJogos();
        trocajogos.setId_troca(idTroca);
        trocajogos.setData_final_usu_origem(DateTime.now().getDate());
        
        if(TrocaJogosService.editar(trocajogos))
            NotificacoesService.enviaNotificacao(Notificacoes.numeraNotificacao.TROCA, "", 5, 0, "nome destino", 0, "nome jogo 1", 0, "nome jogo 2", 0);
        
        

        return "";
    }
}
