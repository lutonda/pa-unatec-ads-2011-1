/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.service;
import una.pa.model.*;
import una.pa.repository.*;
import java.util.List;

/**
 *
 * @author ALEXANDRE
 */
public class NotificacoesService {
    public static List<Notificacoes> listar (){
        return NotificacoesDao.listarDao();
    }
}
