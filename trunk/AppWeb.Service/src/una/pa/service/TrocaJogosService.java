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

    public static List<TrocaJogos> listarUnico(int _id) {
        return TrocaJogosDao.listarUnico(_id);
    }

    public static List<TrocaJogos> jogosTrocados(int quantidePorPagina, int pagina, int _id) {
        return TrocaJogosDao.jogosTrocados(quantidePorPagina, pagina, _id);
    }

    public static boolean inserir(TrocaJogos _obj) {
        return TrocaJogosDao.incluir(_obj);
    }

    public static boolean excluir(int _id) {
        return TrocaJogosDao.excluir(_id);
    }

    public static boolean editar(TrocaJogos _obj) {
        return TrocaJogosDao.alterar(_obj);
    }
}
