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
public class Linguagem {
    protected int id_linguagem;
    protected String nm_linguagem;
    protected Date dt_cadastro;

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public int getId_linguagem() {
        return id_linguagem;
    }

    public void setId_linguagem(int id_linguagem) {
        this.id_linguagem = id_linguagem;
    }

    public String getNm_linguagem() {
        return nm_linguagem;
    }

    public void setNm_linguagem(String nm_linguagem) {
        this.nm_linguagem = nm_linguagem;
    }
    
}
