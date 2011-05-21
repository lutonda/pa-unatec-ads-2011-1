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
    private int id_jogo_usuario ;
    private int id_usuario;
    private int qtd_jogo;
    private int est_capa;
    private int est_midia;
    private int est_manual;
    private String dt_cadastro_jogo;
    private int regiao_jogo;
    private String descricao;
    private String ds_console;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDs_console() {
        return ds_console;
    }

    public void setDs_console(String ds_console) {
        this.ds_console = ds_console;
    }

    public String getDt_cadastro_jogo() {
        return dt_cadastro_jogo;
    }

    public void setDt_cadastro_jogo(String dt_cadastro_jogo) {
        this.dt_cadastro_jogo = dt_cadastro_jogo;
    }

    public int getEst_capa() {
        return est_capa;
    }

    public void setEst_capa(int est_capa) {
        this.est_capa = est_capa;
    }

    public int getEst_manual() {
        return est_manual;
    }

    public void setEst_manual(int est_manual) {
        this.est_manual = est_manual;
    }

    public int getEst_midia() {
        return est_midia;
    }

    public void setEst_midia(int est_midia) {
        this.est_midia = est_midia;
    }

    public int getId_jogo_usuario() {
        return id_jogo_usuario;
    }

    public void setId_jogo_usuario(int id_jogo_usuario) {
        this.id_jogo_usuario = id_jogo_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getQtd_jogo() {
        return qtd_jogo;
    }

    public void setQtd_jogo(int qtd_jogo) {
        this.qtd_jogo = qtd_jogo;
    }

    public int getRegiao_jogo() {
        return regiao_jogo;
    }

    public void setRegiao_jogo(int regiao_jogo) {
        this.regiao_jogo = regiao_jogo;
    }

      

}
