/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.service;

import java.util.List;
import una.pa.model.Jogo;
import una.pa.repository.JogoDal;
//import una.pa.util.upload.uploadServices;

/**
 *
 * @author Felipe
 */
public class JogoService {

    public static List<Jogo> listar() {
        return JogoDal.listaDal();
    }

    public static boolean excluir(int id) {
        return JogoDal.exclui(id);
    }
}
