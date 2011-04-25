/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
/**
 *
 * @author Tiago
 */
public class GeneroListagemController extends AbstractController {

    public GeneroListagemController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
            List<Genero> objC;
        try {

            objC = GeneroService.listar();

        } catch (Exception e) {
            return new ModelAndView("genero/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("genero/listagem", "generos", objC);
    }

}