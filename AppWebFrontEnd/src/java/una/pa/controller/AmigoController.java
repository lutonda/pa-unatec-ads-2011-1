/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import una.pa.model.*;
import una.pa.service.*;

/**
 *
 * @author Tiago
 */
public class AmigoController extends MultiActionController {

    public ModelAndView amigos(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("site/amigo/amigos");
        
        try{
            
            DadosIniciais obj = UsuarioService.inicioPerfil(request);
            List<Tags> objTags = TagsService.listarTags(obj.getId_usuario());
            List<AmigoUsuario> objListAmigos = AmigoUsuarioService.listarAmigos(obj.getId_usuario());
            List<AmigoUsuario> objListAmigosPendetes = AmigoUsuarioService.listarAmigosPendentes(obj.getId_usuario());

            mav.addObject("DadosIniciais", obj);
            mav.addObject("tags", objTags);
            mav.addObject("amigos", objListAmigos);
            mav.addObject("amigosPendentes", (objListAmigosPendetes.isEmpty())? null: objListAmigosPendetes);
            mav.addObject("qtdSolic", objListAmigosPendetes.size());
            mav.addObject("qtdAmigos", objListAmigos.size());


            return mav;
        }catch(Exception e){
            return null;
        }
    }

}