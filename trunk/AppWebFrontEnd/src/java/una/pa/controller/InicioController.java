package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import una.pa.model.*;
import una.pa.service.*;
import java.util.*;

public class InicioController extends MultiActionController {

    public ModelAndView index(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("site/inicio/index");
        try {

            DadosIniciais obj = UsuarioService.inicioPerfil("magno");
            List<Tags> objTags = TagsService.listarTags(obj.getId_usuario());
            mav.addObject("DadosIniciais", obj);
            mav.addObject("tags", objTags);

        } catch (Exception e) {
            return null;
        }
        return mav;
    }
}