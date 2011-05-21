/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.service;

import java.util.List;
import una.pa.model.ListaNegra;
import una.pa.repository.ListaNegraDao;

/**
 *
 * @author Tiago
 */
public class ListaNegraService {
    public static List<ListaNegra> listar(int _id){
        return ListaNegraDao.listaNegra(_id) ;
    }

}
