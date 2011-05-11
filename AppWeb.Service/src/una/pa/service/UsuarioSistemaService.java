/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.service;

import una.pa.model.*;
import una.pa.repository.*;
import java.util.List;
import java.util.Iterator;

/**
 *
 * @author ALEXANDRE
 */
public class UsuarioSistemaService {

        public static List<UsuarioSistema> listar() {
        return UsuarioSistemaDao.listarDao();
    }
    public static UsuarioSistema unico(int id) {

        List<UsuarioSistema> lObjec = UsuarioSistemaDao.listarDao();

        UsuarioSistema retorno = new UsuarioSistema();
        for (Iterator<UsuarioSistema> it = lObjec.iterator(); it.hasNext();) {
            UsuarioSistema userSistema = it.next();

            if (userSistema.getId_user_sistema() == id)
                retorno = userSistema;
        }
        return retorno;
    }

    public static boolean alterar(UsuarioSistema _obj){
        return UsuarioSistemaDao.altera(_obj);
    }
    public static boolean incluir(UsuarioSistema _obj){
        return UsuarioSistemaDao.inclui(_obj);
    }
    public static boolean excluir(int id){
        return UsuarioSistemaDao.exclui(id);
    }
    public static boolean aut(String user, String pass){
        return UsuarioSistemaDao.autenticar(user, pass);
    }
}