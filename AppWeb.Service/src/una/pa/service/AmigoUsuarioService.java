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
public class AmigoUsuarioService {
    public static List<AmigoUsuario> listarAmigo(int _id){
        return  AmigoUsuarioDao.listarAmigo(_id);
    }

}
