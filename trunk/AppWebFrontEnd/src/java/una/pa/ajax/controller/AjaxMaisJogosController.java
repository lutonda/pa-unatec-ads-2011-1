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
public class AjaxMaisJogosController {

    @RequestMapping(value = "site/inicio/listaMaisJogos.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String getListaJogos(HttpServletRequest request,
            @RequestParam String tipoMais, @RequestParam int qtd, @RequestParam int pagina) {

        String Itens = "";
        List<Jogo> objJogo = null;

       if (tipoMais.equals("D"))
           objJogo = JogoService.filtroMaisDesejados(qtd, pagina);
       
       if (tipoMais.equals("T"))
           objJogo = JogoService.filtroMaisTrocados(qtd, pagina);
       
       if (tipoMais.equals("Q"))
           objJogo = JogoService.filtroMaisQualificados(qtd, pagina);

       
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
                            + "<a title=\"" + jogo.getTitulo_jogo() + " (" + jogo.getConsole() + ") " + jogo.getNivelInteresse() + "-" + jogo.getNivelDesejo() + "\" href=\"/AppWebFrontEnd/site/jogo/detalhesjogo.html?id=" + jogo.getId_jogo() + "\">"
                            + "<img width=\"80px\" src=\"/AppWebBackEnd/resources/capa/" + jogo.getImagem() + "\" alt=\"\"/></a></li>";
                }

                count++;
            }

            Itens += "<div class=\"cb\"></div>|" + objJogo.get(0).getTotal();
        }



        return Itens;
    }
}
