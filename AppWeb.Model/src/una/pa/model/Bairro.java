/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author Tiago
 */
public class Bairro extends Cidade{
    private int id_bairro;
    private String ds_bairro;

    public String getDs_bairro() {
        return ds_bairro;
    }

    public void setDs_bairro(String ds_bairro) {
        this.ds_bairro = ds_bairro;
    }

    public int getId_bairro() {
        return id_bairro;
    }

    public void setId_bairro(int id_bairro) {
        this.id_bairro = id_bairro;
    }

}
