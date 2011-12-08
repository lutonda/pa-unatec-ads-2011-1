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
public class AvaliacaoUsuarioService {
    public static boolean incluir(AvaliacaoUsuario _obj){
            return AvaliacaoUsuarioDao.incluir(_obj);
    }
    public static boolean alterar(AvaliacaoUsuario _obj){
        return AvaliacaoUsuarioDao.alterar(_obj);
    }
    public static boolean excluir(int _id){
        return AvaliacaoUsuarioDao.excluir(_id);
    }

}
