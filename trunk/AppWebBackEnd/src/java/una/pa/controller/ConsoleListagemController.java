/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import una.pa.model.Console;
import una.pa.service.ConsoleService;

import java.sql.Connection;
import java.sql.ResultSet;

import java.util.*;

/**
 *
 * @author Magno
 */
public class ConsoleListagemController extends AbstractController {

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        List<Console> objC;
        try {

            objC = ConsoleService.listar();

        } catch (Exception e) {
            return new ModelAndView("console/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("console/listagem", "consoles", objC);
    }
}
