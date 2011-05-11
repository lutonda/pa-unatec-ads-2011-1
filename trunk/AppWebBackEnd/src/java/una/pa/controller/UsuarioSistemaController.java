/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import una.pa.model.UsuarioSistema;
import una.pa.service.UsuarioSistemaService;

import java.util.*;
import una.pa.repository.Criptografia;

public class UsuarioSistemaController extends MultiActionController {

    public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        UsuarioSistema objC = UsuarioSistemaService.unico(Integer.parseInt(request.getParameter("id")));
        objC.setPassword("");

        ModelAndView mav = new ModelAndView("usuariosistema/editar");
        mav.addObject("usuariosistema", objC);
        return mav;
        //return new ModelAndView("console/editar", "console", objC);
    }

    public ModelAndView editarForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag = false;
        UsuarioSistema objC = new UsuarioSistema();
        objC.setId_user_sistema(Integer.parseInt(request.getParameter("id_user_sistema")));
        objC.setUsername(request.getParameter("username"));
        if (request.getParameter("password").length() != 0)
            objC.setPassword(Criptografia.md5(request.getParameter("password")));
        
        if (request.getParameter("sn_ativo").equals("true")){
            objC.setSn_ativo(true);
        }else{
            objC.setSn_ativo(false);
        }
        objC.setPerfil(request.getParameter("perfil"));

        ModelAndView mav = new ModelAndView("usuariosistema/editar");
        try {

            flag = UsuarioSistemaService.alterar(objC);

        } catch (Exception e) {
            mav.addObject("msg", e.getMessage());
        }

        if (flag)
            response.sendRedirect("listar.htm");


        mav.addObject("usuariosistema", objC);
        return mav;
        //return new ModelAndView("titulojogo/editar", "titulojogo", objC);
    }

    public ModelAndView incluir(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        return new ModelAndView("usuariosistema/incluir", "msg", "");
    }

    public ModelAndView incluirForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        UsuarioSistema objUS = new UsuarioSistema();
        //objUS.setId_user_sistema(Integer.parseInt(request.getParameter("id_user_sistema")));
        objUS.setUsername(request.getParameter("username"));
        objUS.setPassword(Criptografia.md5(request.getParameter("password")));
        String  verifica =  request.getParameter("username");
        if (verifica.trim().equals("")){
           return new ModelAndView("usuariosistema/incluir", "msg", "Preencha todos os campos para continuar.");
        }
        verifica =  request.getParameter("password");
        if (verifica.trim().equals("")){
           return new ModelAndView("usuariosistema/incluir", "msg", "Preencha todos os campos para continuar.");
        }

        objUS.setPerfil(request.getParameter("perfil"));
        if (request.getParameter("sn_ativo").equals("true")){
            objUS.setSn_ativo(true);
        }else{
            objUS.setSn_ativo(false);
        }

        try {

            flag = UsuarioSistemaService.incluir(objUS);

        } catch (Exception e) {
            return new ModelAndView("usuariosistema/incluir", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("usuariosistema/incluir", "usuariosistema", objUS);
    }

    public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag;
        try {

            flag = UsuarioSistemaService.excluir(Integer.parseInt(request.getParameter("id")));

        } catch (Exception e) {
            return new ModelAndView("usuariosistema/listagem", "msg", e.getMessage());
        }

        if (flag) {
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("usuariosistema/listagem", "msg", "Erro ao excluir.");
    }

    public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<UsuarioSistema> objUS;
        try {

            objUS = UsuarioSistemaService.listar();

        } catch (Exception e) {
            return new ModelAndView("usuariosistema/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("usuariosistema/listagem", "usuariossistema", objUS);
    }
}

