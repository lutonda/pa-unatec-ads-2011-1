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
 * @author ADS - FACULDADE
 */
public class ConfiguracaoController extends MultiActionController {

    public ModelAndView editar (HttpServletRequest request,
            HttpServletResponse response) throws Exception{

        Configuracao objC = ConfiguracaoService.unico(3);

        return new ModelAndView("configuracao/editar", "Configuracao", objC);
    }
    public ModelAndView editarForm  (HttpServletRequest request,
            HttpServletResponse response) throws Exception{
        boolean flag;
        Configuracao objC = new Configuracao();
        objC.setId_config(Integer.parseInt(request.getParameter("id_config")));
        objC.setServ_email(request.getParameter("serv_email"));
        objC.setNm_conta(request.getParameter("nm_conta"));
        objC.setSenha(request.getParameter("senha"));
         if (request.getParameter("auto_ssl").equals("true")){
            objC.setAuto_ssl(true);
        }else{
            objC.setAuto_ssl(false);
        }
        objC.setEmail_resposta(request.getParameter("email_resposta"));

        try{
            flag = ConfiguracaoService.alterar(objC);
        }catch (Exception e){
            return new ModelAndView ("configuracao/editar", "msg", e.getMessage());
        }
        if (flag){
            response.sendRedirect("editar.htm");
        }
        return new ModelAndView("configuracao/editar", "Configuracao", objC);
    }
    public ModelAndView incluir (HttpServletRequest request,
            HttpServletResponse response) throws Exception{
        return new ModelAndView("configuracao/incluir", "msg", "" );
    }
    public ModelAndView incluirForm (HttpServletRequest request,
            HttpServletResponse response) throws Exception{
        boolean flag;
        Configuracao objC = new Configuracao();

        objC.setId_config(Integer.parseInt(request.getParameter("id_config")));
        objC.setServ_email(request.getParameter("serv_email"));
        objC.setNm_conta(request.getParameter("nm_conta"));
        objC.setSenha(request.getParameter("senha"));
         if (request.getParameter("auto_ssl").equals("true")){
            objC.setAuto_ssl(true);
        }else{
            objC.setAuto_ssl(false);
        }try{

            flag = ConfiguracaoService.incluir(objC);
        }catch(Exception e){
            return new ModelAndView("configuracao/incluir", "msg", e.getMessage());
        }

        if(flag){
            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("configuracao/incluir", "configuracao", objC);
    }

    public ModelAndView remove (HttpServletRequest request,
            HttpServletResponse response) throws Exception{
        boolean flag;

        try{

            flag = ConfiguracaoService.excluir(Integer.parseInt(request.getParameter("id")));
        }catch (Exception e){
            return new ModelAndView("configuracao/listagem", "msg", e.getMessage());
        }

        if (flag){

            response.sendRedirect("listar.htm");
        }

        return new ModelAndView("configuracao/listagem", "mgg", "Erro ao excluir o item");
    }

}
