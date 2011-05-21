/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author Tiago
 */
public class Jogousuario extends Jogo{
    private int id_jogo_usuario;
    private String nm_titulo;
    private String ds_console;

    public String getDs_console() {
        return ds_console;
    }

    public void setDs_console(String ds_console) {
        this.ds_console = ds_console;
    }

    public int getId_jogo_usuario() {
        return id_jogo_usuario;
    }

    public void setId_jogo_usuario(int id_jogo_usuario) {
        this.id_jogo_usuario = id_jogo_usuario;
    }

    public String getNm_titulo() {
        return nm_titulo;
    }

    public void setNm_titulo(String nm_titulo) {
        this.nm_titulo = nm_titulo;
    }

}
