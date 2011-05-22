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
 * @author Tiago
 */
public class UsuarioController extends MultiActionController {

   public ModelAndView listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        List<Usuario> objTr;

        try {

            objTr = UsuarioService.listar();

        } catch (Exception e) {
            return new ModelAndView("usuario/listagem", "msg", e.getMessage());
        }
        return new ModelAndView("usuario/listagem", "usuarios", objTr);
    }
   public ModelAndView visualizar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       int _id = Integer.parseInt(request.getParameter("id"));

         ModelAndView mav = new ModelAndView("usuario/visualizar");

        //Usuario usuario = new Usuario();

        try {

            Usuario usuario = UsuarioService.listarUnico(_id);
            List<AmigoUsuario>  amigoUsuario = AmigoUsuarioService.listarAmigo(_id);
            Endereco endereco = EnderecoService.listarEndereco(_id);
            List<Tags> tag = TagsService.listarTags(_id);
            List<ListaNegra> listaNegra = ListaNegraService.listar(_id);
            List<Desejousuario> desejoUsuario = DesejoUsuarioService.listarDesejo(_id);
            List<Jogousuario> jogoUsuario = JogoUsuarioService.listarJogoUsuario(_id);
            List<Notificacoes> notificacao = NotificacoesService.listarUnico(_id);
            List<TrocaJogos> trocajogo  =   TrocaJogosService.listarUnico(_id);

            mav.addObject("Usuario", usuario);
            mav.addObject("amigoUsuarios", amigoUsuario);
            mav.addObject("Endereco", endereco);
            mav.addObject("tags", tag);
            mav.addObject("listasNegras", listaNegra);
            mav.addObject("desejosUsuarios", desejoUsuario);
            mav.addObject("jogosusuarios", jogoUsuario);
            mav.addObject("notificacoes", notificacao);
            mav.addObject("trocajogos", trocajogo);

        } catch (Exception e) {
            return new ModelAndView("usuario/visualizar", "msg", e.getMessage());
        }
        return mav; //ModelAndView("usuario/visualizar", "Usuario", usuario);
    }

}