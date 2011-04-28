package una.pa.service;

import una.pa.model.*;
import una.pa.repository.*;
import java.util.*;

public class EditoraService {

     public static List<Editora> listar() {
        return EditoraDal.listarEditora();
    }
    public static boolean alterar(Editora _obj){
        return EditoraDal.alteraEditora(_obj);
    }
    public static boolean incluir(Editora _obj){
        return EditoraDal.incluiEditora(_obj);
    }
    public static boolean excluir(int id){
        return EditoraDal.excluiEditora(id);
    }

}
