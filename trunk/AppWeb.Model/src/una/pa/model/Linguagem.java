/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.model;

import java.util.Date;

/**
 *
 * @author Tiago
 */
public class Linguagem {

    protected int id_linguagem;
    protected String nm_linguagem;
    protected int id_titulo_jogo;

    public int getId_linguagem() {
        return id_linguagem;
    }

    public void setId_linguagem(int id_linguagem) {
        this.id_linguagem = id_linguagem;
    }

    public int getId_titulo_jogo() {
        return id_titulo_jogo;
    }

    public void setId_titulo_jogo(int id_titulo_jogo) {
        this.id_titulo_jogo = id_titulo_jogo;
    }

    public String getNm_linguagem() {
        return nm_linguagem;
    }

    public void setNm_linguagem(String nm_linguagem) {
        this.nm_linguagem = nm_linguagem;
    }
}
