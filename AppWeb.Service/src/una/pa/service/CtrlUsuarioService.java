package una.pa.service;

import una.pa.repository.*;

public class CtrlUsuarioService {
    public static boolean aceitaUsuario(int _id){
        return CtrlUsuarioDao.aceita(_id);
    }
    public static boolean  recusaUsuario(int _id){
        return CtrlUsuarioDao.recusa(_id);
    }

}
