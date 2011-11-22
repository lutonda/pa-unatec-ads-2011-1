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
public class AvaliacaoJogoService {
    public static boolean incluir(AvaliacaoJogo _obj){
        return AvaliacaoJogoDao.incluir(_obj);
    }
    public static boolean alterar(AvaliacaoJogo _obj){
        return AvaliacaoJogoDao.alterar(_obj);
    }
    public static boolean excluir(int _id){
        return AvaliacaoJogoDao.excluir(_id);
    }
    public static List<AvaliacaoJogo> retorna(int _id){
        return AvaliacaoJogoDao.listar(_id);
    }

}
