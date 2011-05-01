package una.pa.service;
import una.pa.model.*;
import una.pa.repository.*;
import java.util.*;

public class GeneroService {
     public static List<Genero> listar() {
        return GeneroDal.listarGeneroDal();
    }
     public static Genero unico(int id) {

        List<Genero> lObjec = GeneroDal.listarGeneroDal();
        Genero retorno = new Genero();
        for (Iterator<Genero> it = lObjec.iterator(); it.hasNext();) {
            Genero genero = it.next();

            if (genero.getId_genero() == id)
                retorno = genero;
        }
        return retorno;
    }
     public static boolean alterar(Genero _obj){
        return GeneroDal.alteraGenero(_obj);
    }
    public static boolean incluir(Genero _obj){
        return GeneroDal.incluiGenero(_obj);
    }
    public static boolean excluir(int id){
        return GeneroDal.excluiGenero(id);
    }

}
