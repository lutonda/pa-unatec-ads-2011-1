/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author ADS - FACULDADE
 */
public class Configuracao {
    
        
    protected int id_config;
    protected String serv_email;
    protected String nm_conta;
    protected String senha;
    protected boolean auto_ssl;
    protected String email_resposta;

    public boolean isAuto_ssl() {
        return auto_ssl;
    }

    public void setAuto_ssl(boolean auto_ssl) {
        this.auto_ssl = auto_ssl;
    }

    public String getEmail_resposta() {
        return email_resposta;
    }

    public void setEmail_resposta(String email_resposta) {
        this.email_resposta = email_resposta;
    }

    public int getId_config() {
        return id_config;
    }

    public void setId_config(int id_config) {
        this.id_config = id_config;
    }

    public String getNm_conta() {
        return nm_conta;
    }

    public void setNm_conta(String nm_conta) {
        this.nm_conta = nm_conta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getServ_email() {
        return serv_email;
    }

    public void setServ_email(String serv_email) {
        this.serv_email = serv_email;
    }



}
