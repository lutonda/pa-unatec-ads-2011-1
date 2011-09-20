/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.service;

import una.pa.model.*;
import una.pa.repository.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tiago
 */
public class UsuarioService {

    public static List<Usuario> listar() {
        return UsuarioDao.listarPrincipal();
    }

    public static Usuario listarUnico(int _id) {
        return UsuarioDao.listarTodos(_id);
    }

    public static List<Usuario> usuarioJogos(int _id, boolean _cod, int quantidePorPagina, int pagina, int tipo) {
        return UsuarioDao.jogoUsuario(_id, _cod, quantidePorPagina, pagina, tipo);
    }

    public static DadosIniciais inicioPerfil(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return UsuarioDao.inicioPerfil(session.getAttribute("usuario").toString());
    }

    public static DadosIniciais inicioPerfil(int _id) {
        return UsuarioDao.inicioPerfil(_id);
    }

    public static int verificaEmail(String _email) {
        return UsuarioDao.validaEmail(_email);
    }

    public static boolean updatePasso1(Usuario _obj) {
        return UsuarioDao.updatePasso1(_obj);
    }

    public static boolean updatePasso2(Usuario _objU, Endereco _objE) {
        return UsuarioDao.updatePasso2(_objU, _objE);
    }
    public static AmigoUsuario inicioAmigo(HttpServletRequest request, int _idAmigo){
        HttpSession session = request.getSession();
        return UsuarioDao.inicioAmigo(Integer.parseInt(session.getAttribute("id").toString()), _idAmigo);
    }

    public static boolean updateEditarDados (Usuario objU, Endereco objE){
        return UsuarioDao.updateEditarDados(objU, objE);
    }
}
