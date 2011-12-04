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
public class CategoriaService {
    public static List<Categoria> listar(){
        return CategoriaDao.listarDal();
    }
    public static boolean incluir(Categoria _obj){
        return CategoriaDao.incluirCategoria(_obj);
    }
    public static boolean alterar(Categoria _obj){
        return CategoriaDao.alteraCategoria(_obj);
    }
    public static boolean excluir(int _id){
        return CategoriaDao.excluiCategoria(_id);
    }
     public static Categoria unico(int id) {

        List<Categoria> lObjec = CategoriaDao.listarDal();

        Categoria retorno = new Categoria();
        for (Iterator<Categoria> it = lObjec.iterator(); it.hasNext();) {
            Categoria categoria = it.next();

            if (categoria.getId_categoria() == id)
                retorno = categoria;
        }
        return retorno;
    }

}
