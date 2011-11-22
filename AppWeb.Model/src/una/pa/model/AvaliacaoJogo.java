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
public class AvaliacaoJogo extends Jogo {
    private int id_Avaliacao;
    private int id_Usuario;
    private String ds_Avaliacao;
    private int pontos;
    private Date dt_Avaliacao;
    private String nm_usuario;
    private String nm_sobrenome;
    private String ds_console;

    public String getDs_Avaliacao() {
        return ds_Avaliacao;
    }

    public void setDs_Avaliacao(String ds_Avaliacao) {
        this.ds_Avaliacao = ds_Avaliacao;
    }

    public String getDs_console() {
        return ds_console;
    }

    public void setDs_console(String ds_console) {
        this.ds_console = ds_console;
    }

    public Date getDt_Avaliacao() {
        return dt_Avaliacao;
    }

    public void setDt_Avaliacao(Date dt_Avaliacao) {
        this.dt_Avaliacao = dt_Avaliacao;
    }

    public int getId_Avaliacao() {
        return id_Avaliacao;
    }

    public void setId_Avaliacao(int id_Avaliacao) {
        this.id_Avaliacao = id_Avaliacao;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNm_sobrenome() {
        return nm_sobrenome;
    }

    public void setNm_sobrenome(String nm_sobrenome) {
        this.nm_sobrenome = nm_sobrenome;
    }

    public String getNm_usuario() {
        return nm_usuario;
    }

    public void setNm_usuario(String nm_usuario) {
        this.nm_usuario = nm_usuario;
    }

    
}
