/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author Tiago
 */
public class Tags extends Usuario{
    private int id_tag;
    private String ds_tag;

    public String getDs_tag() {
        return ds_tag;
    }

    public void setDs_tag(String ds_tag) {
        this.ds_tag = ds_tag;
    }

    public int getId_tag() {
        return id_tag;
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }

}
