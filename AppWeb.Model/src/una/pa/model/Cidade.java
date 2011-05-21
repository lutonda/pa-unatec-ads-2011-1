/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author Tiago
 */
public class Cidade extends Estado{
    private int id_cidade;
    private String ds_cidade;

    public String getDs_cidade() {
        return ds_cidade;
    }

    public void setDs_cidade(String ds_cidade) {
        this.ds_cidade = ds_cidade;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

}
