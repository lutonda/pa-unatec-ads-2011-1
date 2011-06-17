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
public class AjaxUsuarioController {

    @RequestMapping(value = "site/jogo/listaUsuarioJogo.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String getListaUsuarioJogo(HttpServletRequest request,
            @RequestParam int id, @RequestParam int qtd, @RequestParam int pagina, @RequestParam boolean ofertados, @RequestParam int tipo) {

        String Itens = "";

        List<Usuario> objUs = UsuarioService.usuarioJogos(id, ofertados, qtd, pagina, tipo);

        if (!objUs.isEmpty()) {
        for (Iterator<Usuario> it = objUs.iterator(); it.hasNext();) {
            Usuario usuario = it.next();

            Itens +=  "<li style=\"float: left; height: 80px; width: 255px;\">"
                    + "<img src=\"/AppWebFrontEnd/resources/img/usuarioSemFoto.jpg\" style=\"float: left; width: 50px; height: 50px; margin-right: 10px;\" alt=\"\"/>"
                    + "<div><a href=\"/AppWebFrontEnd/site/inicio/perfil.html?id=" + usuario.getId_usuario() + "\"><b>" + usuario.getNm_usuario() + " " + usuario.getNm_sobrenome() + "</b></a><br/>" + usuario.getStatus() + "<br/><br/>Oferta de Troca</div></li>";

        }
        Itens += "<div class=\"cb\"></div>|" + objUs.get(0).getTotalderegistros();
        }else {
            Itens += "<li>Nenhuma Pessoa Encontrada!|0";
        }

        return Itens;
    }
}