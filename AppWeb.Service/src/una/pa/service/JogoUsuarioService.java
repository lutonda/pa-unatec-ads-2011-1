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

}
