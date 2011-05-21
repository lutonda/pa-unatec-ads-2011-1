/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import una.pa.model.Tags;
import una.pa.service.*;

/**
 *
 * @author Tiago
 */
public class TagsController extends MultiActionController {

 public ModelAndView visualizar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        int _id = Integer.parseInt(request.getParameter("id"));
        List<Tags> tag;

        try{
            tag = TagsService.listarTags(_id);
       }catch(Exception e){
           return new ModelAndView("tags/visualizar", "msg", e.getMessage());
       }
        return new ModelAndView("tags/visualizar", "tags", tag);
   }

}