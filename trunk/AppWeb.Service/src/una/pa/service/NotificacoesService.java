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
        //
    }

    public static List<Notificacoes> listarUnico(int _id){
        return NotificacoesDao.listarUnico(_id);
    }
    public static List<Notificacoes> listarNotPerfil(int pId_usuario, int quantidePorPagina, int pagina){
        return NotificacoesDao.listarNotPerfil(pId_usuario, quantidePorPagina, pagina);
    }
    public static boolean enviaNotificacao(Notificacoes objct){
        return NotificacoesDao.enviaNotificacao(objct);
    }
}
