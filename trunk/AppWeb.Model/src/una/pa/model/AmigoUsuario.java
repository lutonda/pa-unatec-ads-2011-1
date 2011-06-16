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
public class AmigoUsuario  extends Usuario{
    private int id_amigo_usuario;
    private int id_usuario_amigo;
    private Date dt_convite;
    private String ds_convite;
    private Date dt_aceite;
    private int sn_aceite;
    private int qtd_jogo;
    private int qtd_desejo;
    private int pontos;
    private int ignorado;
    private String solitante;

    public String getSolitante() {
        return solitante;
    }

    public void setSolitante(String solitante) {
        this.solitante = solitante;
    }

    public int getIgnorado() {
        return ignorado;
    }

    public void setIgnorado(int ignorado) {
        this.ignorado = ignorado;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getQtd_desejo() {
        return qtd_desejo;
    }

    public void setQtd_desejo(int qtd_desejo) {
        this.qtd_desejo = qtd_desejo;
    }

    public int getQtd_jogo() {
        return qtd_jogo;
    }

    public void setQtd_jogo(int qtd_jogo) {
        this.qtd_jogo = qtd_jogo;
    }

    public String getDs_convite() {
        return ds_convite;
    }

    public void setDs_convite(String ds_convite) {
        this.ds_convite = ds_convite;
    }

    public Date getDt_aceite() {
        return dt_aceite;
    }

    public void setDt_aceite(Date dt_aceite) {
        this.dt_aceite = dt_aceite;
    }

    public Date getDt_convite() {
        return dt_convite;
    }

    public void setDt_convite(Date dt_convite) {
        this.dt_convite = dt_convite;
    }

    public int getId_amigo_usuario() {
        return id_amigo_usuario;
    }

    public void setId_amigo_usuario(int id_amigo_usuario) {
        this.id_amigo_usuario = id_amigo_usuario;
    }

    public int getId_usuario_amigo() {
        return id_usuario_amigo;
    }

    public void setId_usuario_amigo(int id_usuario_amigo) {
        this.id_usuario_amigo = id_usuario_amigo;
    }

    public int getSn_aceite() {
        return sn_aceite;
    }

    public void setSn_aceite(int sn_aceite) {
        this.sn_aceite = sn_aceite;
    }

//    private int id_usuario_amigo;
//    private String nm_usuario;
//    private String nm_sobrenome;

}
