/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import una.pa.service.UsuarioSistemaService;
import javax.servlet.http.HttpSession;

import java.util.*;
import una.pa.repository.Criptografia;

public class LoginController extends MultiActionController {

    public ModelAndView login(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    public ModelAndView logout(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        session.setAttribute("usuario", null);
        response.sendRedirect("login.htm");
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    public ModelAndView loginForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView("login");
        HttpSession session = request.getSession();

        String user = request.getParameter("txtUser");
        String pass = Criptografia.md5(request.getParameter("txtPassword"));

        if (UsuarioSistemaService.aut(user, pass)) {
            session.setAttribute("usuario", user);
            response.sendRedirect("index.htm");
        } else {
            session.setAttribute("usuario", null);
            mav.addObject("msgErro", "Usuário e/ou senha inválidos!");
            response.sendRedirect("login.htm");
        }

        return mav;
    }
}
