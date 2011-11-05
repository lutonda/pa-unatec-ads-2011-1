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
public class AjaxController {

    @RequestMapping(value = "site/inicio/listaJogos.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String getListaJogos(HttpServletRequest request,
            @RequestParam int id, @RequestParam int qtd, @RequestParam int pagina, @RequestParam String busca, @RequestParam boolean desejo, @RequestParam int console, @RequestParam int nivelOfetas) {

        String Itens = "";
        List<Jogo> objJogo;


        if (desejo) {
            objJogo = DesejoUsuarioService.listaJogosDesejados(id, qtd, pagina);
        } else {
            if (console == 0) {
                if (nivelOfetas == -1)
                    objJogo = (busca.equals("")) ? JogoService.listar(id, qtd, pagina) : JogoService.listar(id, qtd, pagina, busca);
                else
                    objJogo = JogoService.listar(id, qtd, pagina, null, console, nivelOfetas);
            } else {
                objJogo = JogoService.listar(id, qtd, pagina, null, console);
            }          
        }

        if (!objJogo.isEmpty()) {
            int count = 0;
            String stiloLinha = "";
            for (Iterator<Jogo> it = objJogo.iterator(); it.hasNext();) {
                Jogo jogo = it.next();
                if (((count + 1) % 5 == 0)) {
                    stiloLinha = "";
                } else {
                    stiloLinha = "margin-right: 25px;";
                }

                if (jogo.getImagem() == null) {
                    Itens += "<li style=\"float: left; height: 130px; " + stiloLinha + "\"><img width=\"80px\" src=\"/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg\" alt=\"\"/></li>";
                } else {
                    Itens += "<li style=\"float: left; height: 130px; " + stiloLinha + "\">"
                            + "<a tooltip=\"" + jogo.getTitulo_jogo() + "\" ttConsole=\"" + jogo.getConsole() + "\" href=\"/AppWebFrontEnd/site/jogo/detalhesjogo.html?id=" + jogo.getId_jogo() + "\">"
                            + "<img width=\"80px\" src=\"/AppWebBackEnd/resources/capa/" + jogo.getImagem() + "\" alt=\"\"/></a></li>";
                }

                count++;
            }

            Itens += "<div class=\"cb\"></div>|" + objJogo.get(0).getTotal();
        } else {
            Itens += "<li>Nenhum Jogo Encontrado" + ((busca != "") ? " para " : "!") + "<i>" + busca + "</i></li>|0";
        }


        return Itens;
    }
}
