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
public class Categoria {
    protected int id_categoria;
    protected String nm_categoria;
    protected Date dt_cadastro;

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNm_categoria() {
        return nm_categoria;
    }

    public void setNm_categoria(String nm_categoria) {
        this.nm_categoria = nm_categoria;
    }

}
