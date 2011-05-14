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
public class ConviteService {
    public static List<Convite> listar(){
        return ConviteDal.listarDAL();
    }

     public static Convite unico(int id) {
        List<Convite> lObjec = ConviteDal.listarDAL();

        Convite retorno = new Convite();
        for (Iterator<Convite> it = lObjec.iterator(); it.hasNext();) {
            Convite convite = it.next();

            if (convite.getId_convite() == id)
                retorno = convite;
        }
        return retorno;
    }

     public static boolean alterar(Convite _obj){
        return ConviteDal.alteraConvite(_obj);
    }
      public static boolean incluir(Convite _obj){
        return ConviteDal.incluiConvite(_obj);
    }
    public static boolean excluir(int id){
        return ConviteDal.excluiConvite(id);
    }

}
