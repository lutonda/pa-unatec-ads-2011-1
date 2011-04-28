package una.pa.service;
import una.pa.model.*;
import una.pa.repository.*;
import java.util.*;

public class DesenvolvedorService {
    public static List<Desenvolvedor> listar() {
        return DesenvolvedorDal.listarDesenvolvedorDal();
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
