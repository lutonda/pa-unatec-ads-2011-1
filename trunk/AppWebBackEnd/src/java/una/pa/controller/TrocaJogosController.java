/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import una.pa.model.*;
import una.pa.service.*;

import java.util.*;

/**
 *
 * @author Tiago
 */
public class TrocaJogosController extends MultiActionController {

   public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        List<TrocaJogos> objTr;

        try {

            objTr = TrocaJogosService.listar();

        } catch (Exception e) {
            return new ModelAndView("trocajogos/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("trocajogos/listagem", "Trocajogos", objTr);
    }
}
