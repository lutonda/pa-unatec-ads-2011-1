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
public class Categoria {

    protected int id_categoria;
    protected String nm_categoria;
    protected int id_titulo_jogo;

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_titulo_jogo() {
        return id_titulo_jogo;
    }

    public void setId_titulo_jogo(int id_titulo_jogo) {
        this.id_titulo_jogo = id_titulo_jogo;
    }

    public String getNm_categoria() {
        return nm_categoria;
    }

    public void setNm_categoria(String nm_categoria) {
        this.nm_categoria = nm_categoria;
    }
}
