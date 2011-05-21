/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author Tiago
 */
public class Desejousuario extends Jogo{
    private String nm_titulo;
    private String ds_console;
    private int nivel_desejo;

    public String getDs_console() {
        return ds_console;
    }

    public void setDs_console(String ds_console) {
        this.ds_console = ds_console;
    }

    public int getNivel_desejo() {
        return nivel_desejo;
    }

    public void setNivel_desejo(int nivel_desejo) {
        this.nivel_desejo = nivel_desejo;
    }

    public String getNm_titulo() {
        return nm_titulo;
    }

    public void setNm_titulo(String nm_titulo) {
        this.nm_titulo = nm_titulo;
    }

}
