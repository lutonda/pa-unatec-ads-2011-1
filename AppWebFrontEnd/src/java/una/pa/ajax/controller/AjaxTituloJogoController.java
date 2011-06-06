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
public class AjaxTituloJogoController {

    @RequestMapping(value = "site/inicio/listaTituloJogo.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String getAutoComplete(HttpServletRequest request) {

        String Itens = "";
        List<TituloJogo> titulosJogos = TituloJogoService.listar();

        for (Iterator<TituloJogo> it = titulosJogos.iterator(); it.hasNext();) {
            TituloJogo tituloJogo = it.next();

            Itens += tituloJogo.getNm_titulo() + ",";
        }

        return Itens;
    }
}
