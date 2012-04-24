/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.service;

import una.pa.model.*;
import una.pa.repository.*;
import java.util.*;

/**
 *
 * @author Felipe
 */
public class JogoService {

    public static List<Jogo> listar() {
        return JogoDal.listaDal();
    }

    public static List<Jogo> listar(int pId_usuario, int quantidePorPagina, int pagina) {
        return JogoDal.listaDal(pId_usuario, quantidePorPagina, pagina);
    }

    public static List<Jogo> listar(int pId_usuario, int quantidePorPagina, int pagina, String buscar) {
        return JogoDal.listaDal(pId_usuario, quantidePorPagina, pagina, buscar, 0, -1);
    }

    public static List<Jogo> listar(int pId_usuario, int quantidePorPagina, int pagina, String buscar, int console) {
        return JogoDal.listaDal(pId_usuario, quantidePorPagina, pagina, buscar, console, -1);
    }

    public static List<Jogo> listar(int pId_usuario, int quantidePorPagina, int pagina, String buscar, int console, int nivelOferta) {
        return JogoDal.listaDal(pId_usuario, quantidePorPagina, pagina, buscar, console, nivelOferta);
    }

    public static Jogo unico(int id) {

        List<Jogo> lObjec = JogoDal.listaDal();

        Jogo retorno = new Jogo();
        for (Iterator<Jogo> it = lObjec.iterator(); it.hasNext();) {
            Jogo obj = it.next();

            if (obj.getId_jogo() == id) {
                retorno = obj;
            }
        }
        return retorno;
    }

    public static boolean alterar(Jogo _obj) {
        return JogoDal.altera(_obj);
    }

    public static boolean incluir(Jogo _obj) {
        return JogoDal.incluir(_obj);
    }

    public static boolean excluir(int id) {
        return JogoDal.excluir(id);
    }

    public static Jogo detalheJogo(int _id) {
        return JogoDal.detalhesJogo(_id);
    }

    public static Jogo.enNivelUsuarioJogo nivelUsuarioJogo (int _idUsuario, int _idjogo) {
        return JogoDal.nivelUsuarioJogo(_idUsuario, _idjogo);
    }

    public static List<Jogo> filtroJogosGenerico(int _idTipo, String _tipoFiltro, String tipoCategoria, int quantidePorPagina, int pagina) {
        return JogoDal.filtroJogosGenerico(_idTipo, _tipoFiltro, tipoCategoria, quantidePorPagina, pagina);
    }

    public static List<Jogo> filtroMaisDesejados(int quantidePorPagina, int pagina) {
        return JogoDal.FiltroJogoDesejado(quantidePorPagina, pagina);
    }

    public static List<Jogo> filtroMaisTrocados(int quantidePorPagina, int pagina) {
        return JogoDal.FiltroJogosTrocados(quantidePorPagina, pagina);
    }

    public static List<Jogo> filtroMaisQualificados(int quantidePorPagina, int pagina) {
        return JogoDal.FiltroMaisQualificados(quantidePorPagina, pagina);
    }
}
