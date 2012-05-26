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
public class AjaxJogoController {

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
                if (nivelOfetas == -1) {
                    objJogo = (busca.equals("")) ? JogoService.listar(id, qtd, pagina) : JogoService.listar(id, qtd, pagina, busca);
                } else {
                    objJogo = JogoService.listar(id, qtd, pagina, null, console, nivelOfetas);
                }
            } else {
                id = 0;
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

    @RequestMapping(value = "site/inicio/listaTituloJogo.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String getAutoComplete(HttpServletRequest request) {

        String Itens = "";
        List<TituloJogo> titulosJogos = TituloJogoService.listarSimples();

        for (Iterator<TituloJogo> it = titulosJogos.iterator(); it.hasNext();) {
            TituloJogo tituloJogo = it.next();

            Itens += tituloJogo.getNm_titulo() + ",";
        }

        return Itens;
    }

    @RequestMapping(value = "site/inicio/listaMaisJogos.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String getListaJogos(HttpServletRequest request,
            @RequestParam String tipoMais, @RequestParam int qtd, @RequestParam int pagina) {

        String Itens = "";
        List<Jogo> objJogo = null;

        if (tipoMais.equals("D")) {
            objJogo = JogoService.filtroMaisDesejados(qtd, pagina);
        }

        if (tipoMais.equals("T")) {
            objJogo = JogoService.filtroMaisTrocados(qtd, pagina);
        }

        if (tipoMais.equals("Q")) {
            objJogo = JogoService.filtroMaisQualificados(qtd, pagina);
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
        }
        return Itens;
    }

    @RequestMapping(value = "site/inicio/listaFiltroJogos.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String getListaJogos(HttpServletRequest request,
            @RequestParam int idTipo, @RequestParam String tipoFiltro, @RequestParam String tipoCategoria, @RequestParam int qtd, @RequestParam int pagina) {

        String Itens = "";
        List<Jogo> objJogo = null;

        objJogo = JogoService.filtroJogosGenerico(idTipo, tipoFiltro, tipoCategoria, qtd, pagina);

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
        }



        return Itens;
    }
}
