package una.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import una.pa.model.*;
import una.pa.service.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import una.pa.util.*;

public class InicioController extends MultiActionController {

    public ModelAndView logout(HttpServletRequest request,
            HttpServletResponse response) throws Exception {


        HttpSession session = request.getSession();
        session.setAttribute("usuario", null);
        response.sendRedirect("../../index.html");

        return null;
    }

    public ModelAndView autForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {


        String UserName = request.getParameter("txtUser");
        String PassWord = request.getParameter("txtPassword");

        HttpSession session = request.getSession();

        if (session.getAttribute("usuario") == null) {
            session.setAttribute("usuario", UserName);
            session.setAttribute("id", PassWord);
            response.sendRedirect("/AppWebFrontEnd/site/inicio/index.html");
        }

        return null;
    }

    public ModelAndView index(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("site/inicio/index");
        try {


            DadosIniciais obj = UsuarioService.inicioPerfil(request);
            List<Tags> objTags = TagsService.listarTags(obj.getId_usuario());
            //List<Notificacoes> objNot = NotificacoesService.listarNotPerfil(obj.getId_usuario());

            mav.addObject("DadosIniciais", obj);
            mav.addObject("tags", objTags);
            //mav.addObject("notificacoes", objNot);

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
            } else {
                response.sendRedirect("../ajuda/orientacao.html");
            }
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


            mav.addObject("Usuario", objU);
            mav.addObject("Exdereco", objE);

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
            obj.setAceite_acordo(request.getParameter("aceiteTermos") == null ? false : true);
            obj.setEmail_notificacoes(request.getParameter("aceiteNotificacoes") == null ? false : true);
            obj.setEmail_parceiro(request.getParameter("aceiteParceiros") == null ? false : true);



            if (UsuarioService.updatePasso1(obj)) {
                response.sendRedirect("passo2.html?id=" + obj.getId_usuario());
                return null;
            } else {
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

            int id = Integer.parseInt(request.getParameter("id").trim());

            Usuario objU = UsuarioService.listarUnico(id);
            Endereco objE = new Endereco();


            if (request.getParameter("cep") != null) {
                objE.setCep(Integer.parseInt(request.getParameter("cep").replace(".", "").replace("-", "")));
            }
            objE.setTp_logradouro(request.getParameter("tp_logradouro"));
            objE.setLogradouro(request.getParameter("logradouro"));
            objE.setComplemento(request.getParameter("complemento"));
            objE.setNumero(Integer.parseInt(request.getParameter("numero")));
            objE.setDs_bairro(request.getParameter("bairro"));
            objE.setDs_cidade(request.getParameter("cidade"));
            objE.setDs_estado(request.getParameter("estado"));
            objU.setPref_em_maos(request.getParameter("pref_maos") == null ? false : true);
            objU.setPref_correios(request.getParameter("pref_correio") == null ? false : true);
            objU.setPref_transp(request.getParameter("pref_tansportadora") == null ? false : true);

            if (UsuarioService.updatePasso2(objU, objE)) {
                HttpSession session = request.getSession();

                session.removeAttribute("usuario");
                session.removeAttribute("id");

                session.setAttribute("usuario", objU.getUsuario());
                session.setAttribute("id", objU.getId_usuario());

                response.sendRedirect("/AppWebFrontEnd/site/inicio/index.html");
                return null;

                //response.sendRedirect("../ajuda/orientacao.html");
            }



        } catch (Exception e) {
            return null;
        }
        return mav;
    }

    public ModelAndView perfil(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("site/inicio/perfil");
        int id = Integer.parseInt(request.getParameter("id"));
        try {

            DadosIniciais obj = UsuarioService.inicioPerfil(id);
            AmigoUsuario objUser = UsuarioService.inicioAmigo(request, id);
            List<Tags> objTags = TagsService.listarTags(id);
            Endereco objEnd = EnderecoService.listarEndereco(id);

            mav.addObject("DadosIniciais", obj);
            mav.addObject("AmigoUsuario", objUser);
            mav.addObject("tags", objTags);
            mav.addObject("Endereco", objEnd);
        } catch (Exception e) {
            return null;
        }
        return mav;
    }

    public ModelAndView editar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("site/inicio/editar");
        try {
            StringEncryptor ec = new StringEncryptor();
            Usuario obj = new Usuario();
            Endereco objE = new Endereco();

            obj = UsuarioService.listarUnico(Integer.parseInt(request.getParameter("id")));
            objE = EnderecoService.listarEndereco(Integer.parseInt(request.getParameter("id")));

            mav.addObject("Usuario", obj);
            mav.addObject("Endereco", objE);

        } catch (Exception e) {
            response.sendRedirect("../ajuda/orientacao.html");
            return null;
        }
        return mav;
    }
}
