/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.controller;

import una.pa.model.*;
import una.pa.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.sql.Connection;
import java.sql.ResultSet;

import java.util.*;
/**
 *
 * @author Tiago
 */
public class DesenvolvedorListagemController extends AbstractController {

    public DesenvolvedorListagemController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
             List<Desenvolvedor> objC;
             try {

            objC = DesenvolvedorService.listar();

        } catch (Exception e) {
            return new ModelAndView("desenvolvedor/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("desenvolvedor/listagem", "desenvolvedores", objC);
        
    }

}