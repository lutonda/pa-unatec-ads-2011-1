/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.service;
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



}
