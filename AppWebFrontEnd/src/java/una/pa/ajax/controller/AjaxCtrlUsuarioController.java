/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.ajax.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import una.pa.model.*;
import una.pa.service.*;

/** 
 *
 * @author Tiago
 */
@Controller
public class AjaxCtrlUsuarioController {

    @RequestMapping(value = "site/inicio/ctrlUsuario.do", method = {RequestMethod.GET,
        RequestMethod.POST})

    @ResponseBody
    public String  postCtrlUsuario(HttpServletRequest request,
            @RequestParam int idAmigoUsuario, @RequestParam int aceite) {

        boolean flag = false;
       // CtrlUsuarioService.aceitaUsuario(idAmigoUsuario);
        if(aceite != -1){
        try{
            if(aceite == 1){
                flag = CtrlUsuarioService.aceitaUsuario(idAmigoUsuario);

            }else if(aceite == 0){
                flag = CtrlUsuarioService.recusaUsuario(idAmigoUsuario);
            }
        }catch(Exception e){
            return String.valueOf(false);
        }
       }
        return String.valueOf(flag);
    }


}