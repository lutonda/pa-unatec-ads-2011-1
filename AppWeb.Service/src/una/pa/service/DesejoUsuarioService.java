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
public class DesejoUsuarioService {

    public static List<Desejousuario> listarDesejo(int _id) {
        return DesejoUsuarioDao.listarDesejo(_id);
    }

    public static List<Jogo> listaJogosDesejados(int pId_usuario, int quantidePorPagina, int pagina) {
        return DesejoUsuarioDao.listaJogosDesejados(pId_usuario, quantidePorPagina, pagina);
    }
    public static boolean  incluir(Desejousuario _obj){
        return DesejoUsuarioDao.incluir(_obj);
    }
    public static boolean alterar(Desejousuario _obj){
        return DesejoUsuarioDao.alterar(_obj);
    }
    public static boolean excluir(int _id){
        return DesejoUsuarioDao.excluir(_id);
    }
}
