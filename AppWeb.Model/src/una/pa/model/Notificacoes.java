/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author ALEXANDRE
 */
public class Notificacoes {

        private int id_notificacao;
        private int id_usuario;
        private String nm_nome;
        private String descricao;
        private String broadcast;
        private String dt_notificacoes;
        private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDt_notificacoes() {
        return dt_notificacoes;
    }

    public void setDt_notificacoes(String dt_notificacoes) {
        this.dt_notificacoes = dt_notificacoes;
    }

    public int getId_notificacao() {
        return id_notificacao;
    }

    public void setId_notificacao(int id_notificacao) {
        this.id_notificacao = id_notificacao;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNm_nome() {
        return nm_nome;
    }

    public void setNm_nome(String nm_nome) {
        this.nm_nome = nm_nome;
    }



}
