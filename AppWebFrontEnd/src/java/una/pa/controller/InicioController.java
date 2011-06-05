package una.pa.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import una.pa.model.*;
import una.pa.service.*;
import java.util.*;
import una.pa.util.*;


public class InicioController extends MultiActionController {

    public ModelAndView index(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("site/inicio/index");
        try {

            DadosIniciais obj = UsuarioService.inicioPerfil();
            List<Tags> objTags = TagsService.listarTags(obj.getId_usuario());
            List<Notificacoes> objNot = NotificacoesService.listarNotPerfil(obj.getId_usuario());

            mav.addObject("DadosIniciais", obj);
            mav.addObject("tags", objTags);
            mav.addObject("notificacoes", objNot);

        } catch (Exception e) {
            return null;
        }
        return mav;
    }

    public ModelAndView processoCadastro(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {
            String email = request.getParameter("email");
            if (email != null) {
                if (Validacao.validaEmail(email)) {
                    int _id = UsuarioService.verificaEmail(email);
                    if (_id != -1) {
                        //StringEncryptor ec = new StringEncryptor();
                       // ec.encrypt((String)_id);
                        response.sendRedirect("passo1.html?id=" + _id);
                        

                    } else {
                        response.sendRedirect("../ajuda/orientacao.html");
                    }
                } else {
                    response.sendRedirect("../ajuda/orientacao.html");
                }
            }else
                response.sendRedirect("../ajuda/orientacao.html");
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public ModelAndView passo1(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("inicio/cadastro/passo1");
        try {
            StringEncryptor ec = new StringEncryptor();
            Usuario obj = new Usuario();

            obj = UsuarioService.listarUnico(Integer.parseInt(request.getParameter("id")));

            mav.addObject("Usuario", obj);

        } catch (Exception e) {
            response.sendRedirect("../ajuda/orientacao.html");
            return null;
        }
        return mav;
    }

    public ModelAndView passo2(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("inicio/cadastro/passo2");
        try {

            Usuario objU = new Usuario();
            Endereco objE = new Endereco();

            //objU.setDt_nascimento(Date.(request.getParameter("dt_nascimento")));
            if (request.getParameterValues("sexo").equals("M")){
                objU.setSexo('M');
            }else{
                objU.setSexo('F');
            }
            objE.setCep(Integer.parseInt(request.getParameter("cep")));
            objE.setTp_logradouro(request.getParameter("tp_logradouro"));
            objE.setLogradouro(request.getParameter("logradouro"));
            objE.setComplemento(request.getParameter("complemento"));
            objE.setNumero(Integer.parseInt(request.getParameter("numero")));
            objE.setDs_bairro(request.getParameter("ds_bairro"));
            objE.setDs_cidade(request.getParameter("ds_cidade"));
            objE.setDs_estado(request.getParameter("ds_estado"));
            objU.setPref_em_maos(request.getParameter("pref_maos").equals("checked"));
            objU.setPref_correios(request.getParameter("pref_correio").equals("checked"));
            objU.setPref_transp(request.getParameter("pref_transportadora").equals("checked"));

            UsuarioService.updatePasso2(objU, objE);
            

        } catch (Exception e) {
            return null;
        }
        return mav;
    }

    public ModelAndView cadastroPasso1Form(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("inicio/cadastro/passo1");
        try {

            Usuario obj = new Usuario();
            obj.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
            obj.setNm_usuario(request.getParameter("nm_usuario"));
            obj.setNm_sobrenome(request.getParameter("nm_sobrenome"));
            obj.setEmail(request.getParameter("email"));
            obj.setNm_usuario(request.getParameter("nm_usuario"));
            obj.setUsuario(request.getParameter("usuario"));
            obj.setSenha(request.getParameter("senha"));
            obj.setAceite_acordo(request.getParameter("aceiteTermos").equals("0"));
            obj.setEmail_notificacoes(request.getParameter("aceiteNotificacoes").equals("0"));
            obj.setEmail_parceiro(request.getParameter("aceiteParceiros").equals("0"));
            


            if (UsuarioService.updatePasso1(obj)){
                response.sendRedirect("passo2.html?id="+obj.getId_usuario());
                return null;
            }else{
                obj.setSenha("");
                mav.addObject("Usuario", obj);
                return mav;
            }


            

        } catch (Exception e) {
            return null;
        }
        
    }

    public ModelAndView cadastroPasso2Form(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("inicio/cadastro/passo2");
        try {

            response.sendRedirect("/AppWebFrontEnd/site/inicio/index.html");

        } catch (Exception e) {
            return null;
        }
        return mav;
    }
}
