/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.service;

import com.sun.org.apache.regexp.internal.RE;
import una.pa.model.*;
import una.pa.repository.*;
import java.util.*;

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

    public static DadosIniciais inicioPerfil() {
        return UsuarioDao.inicioPerfil("magno");
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
}
