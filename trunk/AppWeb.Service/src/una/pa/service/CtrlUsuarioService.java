package una.pa.service;

import una.pa.repository.*;

public class CtrlUsuarioService {
    public static boolean aceitaUsuario(int _id){
        return CtrlUsuarioDao.aceita(_id);
    }
    public static boolean ignorarUsuario(int _id, int _ign){
        return CtrlUsuarioDao.ignorar(_id, _ign);
    }
    public static boolean  recusaUsuario(int _id){
        return CtrlUsuarioDao.recusa(_id);
    }
    public static boolean  adicionarUsuario(int _id, int _idUserVisit){
        return CtrlUsuarioDao.adicionar(_id, _idUserVisit);
    }

}
