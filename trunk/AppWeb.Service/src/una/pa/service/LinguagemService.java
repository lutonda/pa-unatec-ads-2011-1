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
public class LinguagemService {
    public static List<Linguagem> listar(){
        return LinguagemDao.listarDal();
    }
    public static boolean incluir(Linguagem _obj){
        return LinguagemDao.incluirLinguagem(_obj);
    }
    public static boolean alterar(Linguagem _obj){
        return LinguagemDao.alteraLinguagem(_obj);
    }
    public static boolean excluir(int _id){
        return LinguagemDao.excluiLinguagem(_id);
    }
     public static Linguagem unico(int id) {

        List<Linguagem> lObjec = LinguagemDao.listarDal();

        Linguagem retorno = new Linguagem();
        for (Iterator<Linguagem> it = lObjec.iterator(); it.hasNext();) {
            Linguagem linguagem = it.next();

            if (linguagem.getId_linguagem() == id)
                retorno = linguagem;
        }
        return retorno;
    }

}
