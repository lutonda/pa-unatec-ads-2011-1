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
public class AjaxNivelController {

    @RequestMapping(value = "site/jogo/setDesejo.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String setIncDesejo(HttpServletRequest request,
            @RequestParam int idUsuario, @RequestParam int idJogo, @RequestParam String tipoPar) {

        try {
            Desejousuario desejousuario = new Desejousuario();
            desejousuario.setId_usuario(idUsuario);
            desejousuario.setId_jogo(idJogo);
            desejousuario.setNivelDesejo(0);
            if(tipoPar.equals("I"))
                DesejoUsuarioService.incluir(desejousuario);
            else if (tipoPar.equals("E"))
                DesejoUsuarioService.excluir(desejousuario);
        } catch (Exception e) {
            return String.valueOf(false);
        }

        return tipoPar;
    }

    @RequestMapping(value = "site/jogo/setTenho.do", method = {RequestMethod.GET,
        RequestMethod.POST})
    @ResponseBody
    public String setTenho(HttpServletRequest request,
            @RequestParam int idUsuario, @RequestParam int idJogo, @RequestParam String tipoPar) {

        try {
            Jogousuario jogousuario = new Jogousuario();
            jogousuario.setId_usuario(idUsuario);
            jogousuario.setId_jogo(idJogo);
            jogousuario.setNivelInteresse(0);
            jogousuario.setEst_midia(0);
            jogousuario.setEst_manual(0);
            jogousuario.setEst_capa(0);
            jogousuario.setRegiao_jogo(0);
            jogousuario.setDescricao("");


            if(tipoPar.equals("I"))
                JogoUsuarioService.incluir(jogousuario);
            else if (tipoPar.equals("A"))
                JogoUsuarioService.alterar(jogousuario);
            else if (tipoPar.equals("E"))
                JogoUsuarioService.excluir(jogousuario);
        } catch (Exception e) {
            return String.valueOf(false);
        }

        return tipoPar;
    }
}
