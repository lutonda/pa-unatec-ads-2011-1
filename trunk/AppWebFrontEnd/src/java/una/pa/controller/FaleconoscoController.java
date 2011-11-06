/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import una.pa.util.SendMail;


public class FaleconoscoController extends AbstractController {
 
    private static final String titulo = "JogaTroca - Fale Conosco";
    private static final String mailFrom = "SEUEMAIL*AQUI*";
    private static final String password = "SUASENHA*AQUI*";
    
    
    @Override
    public ModelAndView handleRequestInternal(
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        String email = "none";
        
        String nome = request.getParameter("nome");
        String msg = request.getParameter("msg");
        email = request.getParameter("email");
        
        String[] sendTo = {email};
        
        try{
    	 SendMail mail = new SendMail(sendTo,titulo, msg,mailFrom,password);
        }catch(Exception e){
            nome = "ERROR";
        }
        
        
        ModelAndView mav = new ModelAndView("inicio/ajuda/faleConosco");
        mav.addObject("mensagem", "Hello World! "+nome);
        return mav;        
    }
}
