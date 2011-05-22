/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author Tiago
 */
public class TrocaJogos {
    private int id_usuario;
    private String dt_troca;
    private String dt_solicitacao;
    private String status_troca;
    private String nm_usuario_origem;
    private String nm_titulo_origem;
    private String ds_console_origem;
    private String dt_avaliacao_origem;
    private int    pontos_origem;
    private String nm_usuario_destino;
    private String nm_titulo_destino;
    private String ds_console_destino;
    private String dt_avaliacao_destino;
    private int pontos_destino;

    public String getDs_console_destino() {
        return ds_console_destino;
    }

    public void setDs_console_destino(String ds_console_destino) {
        this.ds_console_destino = ds_console_destino;
    }
    public int getId_usuario(){
        return id_usuario;
    }
    public void setId_usuario(int id_usuario){
        this.id_usuario = id_usuario;
    }

    public String getDs_console_origem() {
        return ds_console_origem;
    }

    public void setDs_console_origem(String ds_console_origem) {
        this.ds_console_origem = ds_console_origem;
    }

    public String getDt_avaliacao_destino() {
        return dt_avaliacao_destino;
    }

    public void setDt_avaliacao_destino(String dt_avaliacao_destino) {
        this.dt_avaliacao_destino = dt_avaliacao_destino;
    }

    public String getDt_avaliacao_origem() {
        return dt_avaliacao_origem;
    }

    public void setDt_avaliacao_origem(String dt_avaliacao_origem) {
        this.dt_avaliacao_origem = dt_avaliacao_origem;
    }

    public String getDt_solicitacao() {
        return dt_solicitacao;
    }

    public void setDt_solicitacao(String dt_solicitacao) {
        this.dt_solicitacao = dt_solicitacao;
    }

    public String getDt_troca() {
        return dt_troca;
    }

    public void setDt_troca(String dt_troca) {
        this.dt_troca = dt_troca;
    }

    public String getNm_titulo_destino() {
        return nm_titulo_destino;
    }

    public void setNm_titulo_destino(String nm_titulo_destino) {
        this.nm_titulo_destino = nm_titulo_destino;
    }

    public String getNm_titulo_origem() {
        return nm_titulo_origem;
    }

    public void setNm_titulo_origem(String nm_titulo_origem) {
        this.nm_titulo_origem = nm_titulo_origem;
    }

    public String getNm_usuario_destino() {
        return nm_usuario_destino;
    }

    public void setNm_usuario_destino(String nm_usuario_destino) {
        this.nm_usuario_destino = nm_usuario_destino;
    }

    public String getNm_usuario_origem() {
        return nm_usuario_origem;
    }

    public void setNm_usuario_origem(String nm_usuario_origem) {
        this.nm_usuario_origem = nm_usuario_origem;
    }

    public int getPontos_destino() {
        return pontos_destino;
    }

    public void setPontos_destino(int pontos_destino) {
        this.pontos_destino = pontos_destino;
    }

    public int getPontos_origem() {
        return pontos_origem;
    }

    public void setPontos_origem(int pontos_origem) {
        this.pontos_origem = pontos_origem;
    }

    public String getStatus_troca() {
        return status_troca;
    }

    public void setStatus_troca(String status_troca) {
        this.status_troca = status_troca;
    }



}
