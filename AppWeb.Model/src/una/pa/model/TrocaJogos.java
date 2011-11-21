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
public class TrocaJogos {
    public static enum statusTroca {
        aberto,andamento,finalizado
    }
    private int id_troca;
    private int id_usuario;//id usuario origem;
    private Date dt_troca;
    private Date dt_solicitacao;
    private String status_troca;
    private String nm_usuario_origem;
    private int    id_jogo_origem;
    private String nm_titulo_origem;
    private String ds_console_origem;
    private Date dt_avaliacao_origem;
    private int    pontos_origem;
    private String imagem_origem;
    private int    id_usuario_destino;
    private String nm_usuario_destino;
    private String sobrenome_destino;
    private int    id_jogo_destino;
    private String nm_titulo_destino;
    private String ds_console_destino;
    private Date dt_avaliacao_destino;
    private int pontos_destino;
    private String imagem_destino;
    private String tipo;
    private boolean avaliacao;
    private String tel_usuario;
    private String email;
    private String cidade;
    private String estado;
    private Date data_final_usu_origem;
    private Date data_final_usu_destino;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(boolean avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getData_final_usu_destino() {
        return data_final_usu_destino;
    }

    public void setData_final_usu_destino(Date data_final_usu_destino) {
        this.data_final_usu_destino = data_final_usu_destino;
    }

    public Date getData_final_usu_origem() {
        return data_final_usu_origem;
    }

    public void setData_final_usu_origem(Date data_final_usu_origem) {
        this.data_final_usu_origem = data_final_usu_origem;
    }

    public String getDs_console_destino() {
        return ds_console_destino;
    }

    public void setDs_console_destino(String ds_console_destino) {
        this.ds_console_destino = ds_console_destino;
    }

    public String getDs_console_origem() {
        return ds_console_origem;
    }

    public void setDs_console_origem(String ds_console_origem) {
        this.ds_console_origem = ds_console_origem;
    }

    public Date getDt_avaliacao_destino() {
        return dt_avaliacao_destino;
    }

    public void setDt_avaliacao_destino(Date dt_avaliacao_destino) {
        this.dt_avaliacao_destino = dt_avaliacao_destino;
    }

    public Date getDt_avaliacao_origem() {
        return dt_avaliacao_origem;
    }

    public void setDt_avaliacao_origem(Date dt_avaliacao_origem) {
        this.dt_avaliacao_origem = dt_avaliacao_origem;
    }

    public Date getDt_solicitacao() {
        return dt_solicitacao;
    }

    public void setDt_solicitacao(Date dt_solicitacao) {
        this.dt_solicitacao = dt_solicitacao;
    }

    public Date getDt_troca() {
        return dt_troca;
    }

    public void setDt_troca(Date dt_troca) {
        this.dt_troca = dt_troca;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_jogo_destino() {
        return id_jogo_destino;
    }

    public void setId_jogo_destino(int id_jogo_destino) {
        this.id_jogo_destino = id_jogo_destino;
    }

    public int getId_jogo_origem() {
        return id_jogo_origem;
    }

    public void setId_jogo_origem(int id_jogo_origem) {
        this.id_jogo_origem = id_jogo_origem;
    }

    public int getId_troca() {
        return id_troca;
    }

    public void setId_troca(int id_troca) {
        this.id_troca = id_troca;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_usuario_destino() {
        return id_usuario_destino;
    }

    public void setId_usuario_destino(int id_usuario_destino) {
        this.id_usuario_destino = id_usuario_destino;
    }

    public String getImagem_destino() {
        return imagem_destino;
    }

    public void setImagem_destino(String imagem_destino) {
        this.imagem_destino = imagem_destino;
    }

    public String getImagem_origem() {
        return imagem_origem;
    }

    public void setImagem_origem(String imagem_origem) {
        this.imagem_origem = imagem_origem;
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

    public String getSobrenome_destino() {
        return sobrenome_destino;
    }

    public void setSobrenome_destino(String sobrenome_destino) {
        this.sobrenome_destino = sobrenome_destino;
    }

    public String getStatus_troca() {
        return status_troca;
    }

    public void setStatus_troca(String status_troca) {
        this.status_troca = status_troca;
    }

    public String getTel_usuario() {
        return tel_usuario;
    }

    public void setTel_usuario(String tel_usuario) {
        this.tel_usuario = tel_usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
}
