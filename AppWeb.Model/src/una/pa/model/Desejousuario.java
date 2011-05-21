/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

import javax.xml.crypto.Data;

/**
 *
 * @author Tiago
 */
public class Desejousuario extends Jogo{
    private int id_jogo_desejado;
    private int id_usuario;
    private Data dt_solicitacao;
    private int nivel_desejo;
    private String ds_console;

    public String getDs_console() {
        return ds_console;
    }

    public void setDs_console(String ds_console) {
        this.ds_console = ds_console;
    }

    public Data getDt_solicitacao() {
        return dt_solicitacao;
    }

    public void setDt_solicitacao(Data dt_solicitacao) {
        this.dt_solicitacao = dt_solicitacao;
    }

    public int getId_jogo_desejado() {
        return id_jogo_desejado;
    }

    public void setId_jogo_desejado(int id_jogo_desejado) {
        this.id_jogo_desejado = id_jogo_desejado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getNivel_desejo() {
        return nivel_desejo;
    }

    public void setNivel_desejo(int nivel_desejo) {
        this.nivel_desejo = nivel_desejo;
    }

  
}
