package una.pa.service;
import una.pa.model.*;
import una.pa.repository.*;
import java.util.*;

public class DesenvolvedorService {
    public static List<Desenvolvedor> listar() {
        return DesenvolvedorDal.listarDesenvolvedorDal();
    }
    public static Desenvolvedor unico(int id) {

        List<Desenvolvedor> lObjec = DesenvolvedorDal.listarDesenvolvedorDal();

        Desenvolvedor retorno = new Desenvolvedor();
        for (Iterator<Desenvolvedor> it = lObjec.iterator(); it.hasNext();) {
            Desenvolvedor obj = it.next();

            if (obj.getId_desenv() == id)
                retorno = obj;
        }
        return retorno;
    }
    public static boolean alterar(Desenvolvedor _obj){
        return DesenvolvedorDal.alteraDesenvolvedor(_obj);
    }
    public static boolean incluir(Desenvolvedor _obj){
        return DesenvolvedorDal.incluiDesenvolvedor(_obj);
    }
    public static boolean excluir(int id){
        return DesenvolvedorDal.excluiDesenvolvedor(id);
    }

}
