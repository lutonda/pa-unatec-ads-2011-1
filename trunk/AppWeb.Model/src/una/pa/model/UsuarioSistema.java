/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author ALEXANDRE
 */
public class UsuarioSistema {
   protected int id_user_sistema;
   protected String username;
   protected String password;
   protected boolean sn_ativo;
   protected String perfil;

    public int getId_user_sistema() {
        return id_user_sistema;
    }

    public void setId_user_sistema(int id_user_sistema) {
        this.id_user_sistema = id_user_sistema;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public boolean isSn_ativo() {
        return sn_ativo;
    }

    public void setSn_ativo(boolean sn_ativo) {
        this.sn_ativo = sn_ativo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
