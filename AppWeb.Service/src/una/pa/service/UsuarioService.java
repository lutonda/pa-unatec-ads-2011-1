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
    public static Usuario listarUnico (int _id){
        return UsuarioDao.listarTodos(_id);
    }
    public static List<Usuario> usuarioJogos(int _id, int _cod){
       return UsuarioDao.jogoUsuario(_id,_cod);
    }
    public static DadosIniciais inicioPerfil(){
        return UsuarioDao.inicioPerfil("magno");
    }
    public static boolean verificaEmail(String _email){
        return UsuarioDao.validaEmail(_email);
    }
    
}
