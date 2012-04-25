/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.service;
import java.util.List;
import una.pa.model.*;
import una.pa.repository.*;

/**
 *
 * @author Tiago
 */
public class JogoUsuarioService {
    public static List<Jogousuario> listarJogoUsuario(int _id){
        return JogoUsuarioDao.listarJogoUsuario(_id);
    }
    public static boolean incluir(Jogousuario _obj){
        return JogoUsuarioDao.incluir(_obj);
    }
    public static boolean alterar(Jogousuario _obj){
        return JogoUsuarioDao.alterar(_obj);
    }
    public static boolean excluir(Jogousuario _obj){
        return JogoUsuarioDao.excluir(_obj);
    }

}
