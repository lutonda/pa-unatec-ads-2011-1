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
        return JogoDal.listaDal(pId_usuario, quantidePorPagina, pagina, buscar, 0);
    }

    public static List<Jogo> listar(int pId_usuario, int quantidePorPagina, int pagina, String buscar, int console) {
        return JogoDal.listaDal(pId_usuario, quantidePorPagina, pagina, buscar, console);
    }
    
    public static List<Jogo> listar(int pId_usuario, int quantidePorPagina, int pagina, String buscar, int console, int nivelOferta) {
        List<Jogo> objJogos = JogoDal.listaDal(pId_usuario, quantidePorPagina, pagina, buscar, console);
        List<Jogo> objJogosLs = new ArrayList<Jogo>();
        for (Iterator<Jogo> it = objJogos.iterator(); it.hasNext();) {
            Jogo jogo = it.next();
            if (Integer.parseInt(jogo.getNivelInteresse()) == nivelOferta)
                objJogosLs.add(jogo);
        }
        
        
        return objJogosLs;
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
        return JogoDal.exclui(id);
    }

    public static Jogo detalheJogo(int _id) {
        return JogoDal.detalesJogo(_id);
    }
}
