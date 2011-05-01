

package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import una.pa.model.*;
import una.pa.service.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

public class EditoraController extends AbstractController {

    public EditoraController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
            List<Editora> objC;
        try {

            objC = EditoraService.listar();

        } catch (Exception e) {
            return new ModelAndView("editora/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("editora/listagem", "editoras", objC);
    }

}