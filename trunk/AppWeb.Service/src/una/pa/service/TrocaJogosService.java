package una.pa.service;
import una.pa.model.*;
import una.pa.repository.*;
import java.util.*;

/**
 *
 * @author Tiago
 */
public class TrocaJogosService {
    public static List<TrocaJogos> listar() {
           return TrocaJogosDao.listarDao();
    }
    public static List<TrocaJogos> listarUnico(int _id){
           return TrocaJogosDao.listarUnico(_id);
       }
    public static List<TrocaJogos> jogosTrocados(int quantidePorPagina, int pagina, int _id, String _retorno)   {
        return TrocaJogosDao.jogosTrocados(quantidePorPagina, pagina, _id, _retorno);
    }

}
