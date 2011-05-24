package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class IncludeController extends MultiActionController {

    public ModelAndView inc_topo_padrao(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        return new ModelAndView("site/inc_topo_padrao", "msg", "teste");
    }
}
