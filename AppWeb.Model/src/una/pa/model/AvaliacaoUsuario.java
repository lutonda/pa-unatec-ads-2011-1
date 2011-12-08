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
public class AvaliacaoUsuario extends TrocaJogos {
    protected int id_avaliacao_usuario;
    protected int id_usuario;
    protected Date dt_avaliacao;
    protected int pontos;
    protected String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDt_avaliacao() {
        return dt_avaliacao;
    }

    public void setDt_avaliacao(Date dt_avaliacao) {
        this.dt_avaliacao = dt_avaliacao;
    }

    public int getId_avaliacao_usuario() {
        return id_avaliacao_usuario;
    }

    public void setId_avaliacao_usuario(int id_avaliacao_usuario) {
        this.id_avaliacao_usuario = id_avaliacao_usuario;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    

}
