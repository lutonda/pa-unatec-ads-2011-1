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
    private static final String mailFrom = "felipphe.3@gmail.com";
    private static final String password = "SUASENHA";
    
    
    @Override
    public ModelAndView handleRequestInternal(
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {

             
        String nome = request.getParameter("nome");
        String msg = request.getParameter("msg");
        String email = request.getParameter("email");
        
        String[] sendTo = {email};
        String[] sendFrom = {mailFrom};
         
        
        
        String resposta = "Caro "+nome+",\n Seu e-mail foi recebido e em breve"
                + " estaremos lhe respondendo.\n\n Atenciosamente, \n **JogaTroca**";
        resposta +="\n\n--------------------------------------------\n";
        resposta +=">\n>";
        resposta +="De: "+email+"\n";
        resposta +="Para: "+mailFrom+"\n";
        resposta +="Assunto: "+titulo+"\n";
        resposta +="\n "+msg;
              
        
        ModelAndView mav = new ModelAndView("inicio/ajuda/faleConosco");
        
        try{
    	 SendMail mail = new SendMail(sendFrom,titulo, msg,mailFrom,password);
         SendMail mail2 = new SendMail(sendTo,titulo, resposta,mailFrom,password);
         
        mav.addObject("mensagem", "Sua mensagem foi enviada!");
        }catch(Exception e){
          mav.addObject("mensagem", "Erro ao enviar, tente novamente!");
        }
                        
        return mav;        
    }
}
