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
 * @author Magno
 */
public class TituloJogoService {

    public static List<TituloJogo> listar() {
        return TituloJogoDao.listarDao();
    }

    public static List<TituloJogo> listarSimples() {
        return TituloJogoDao.listarDao(false);
    }

    public static TituloJogo unico(int id) {

        List<TituloJogo> lObjec = TituloJogoDao.listarDao();

        TituloJogo retorno = new TituloJogo();
        for (Iterator<TituloJogo> it = lObjec.iterator(); it.hasNext();) {
            TituloJogo obj = it.next();

            if (obj.getId_titulo_jogo() == id) {
                retorno = obj;
            }
        }
        return retorno;
    }

    public static boolean alterar(TituloJogo _obj) {
        return TituloJogoDao.altera(_obj);
    }

    public static boolean incluir(TituloJogo _obj) {
        return TituloJogoDao.inclui(_obj);
    }

    public static boolean excluir(int id) {
        return TituloJogoDao.exclui(id);
    }
}
