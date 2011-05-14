/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author Tiago
 */
public class Convite {
     int id_convite;
      String assunto;
      String corpo_convite;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpo_convite() {
        return corpo_convite;
    }

    public void setCorpo_convite(String corpo_convite) {
        this.corpo_convite = corpo_convite;
    }

    public int getId_convite() {
        return id_convite;
    }

    public void setId_convite(int id_convite) {
        this.id_convite = id_convite;
    }

}
