/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.service;

import java.util.*;
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
    public static List<AmigoUsuario> listarAmigos(int _id){
        List<AmigoUsuario> lObjec = AmigoUsuarioDao.listarTodosAmigos(_id, true);

        List<AmigoUsuario> retorno = new ArrayList<AmigoUsuario>();
        for (Iterator<AmigoUsuario> it = lObjec.iterator(); it.hasNext();) {
            AmigoUsuario amigoUsuario = it.next();

            if (amigoUsuario.getSn_aceite() == 1)
                retorno.add(amigoUsuario);
        }
        return retorno;
    }

    public static List<AmigoUsuario> listarAmigosPendentes(int _id){

        List<AmigoUsuario> lObjec = AmigoUsuarioDao.listarTodosAmigos(_id, false);

        List<AmigoUsuario> retorno = new ArrayList<AmigoUsuario>();
        for (Iterator<AmigoUsuario> it = lObjec.iterator(); it.hasNext();) {
            AmigoUsuario amigoUsuario = it.next();

            if (amigoUsuario.getSn_aceite() == 0)
                retorno.add(amigoUsuario);
        }
        return retorno;
    }
}
