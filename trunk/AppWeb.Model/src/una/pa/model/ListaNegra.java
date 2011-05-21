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
public class ListaNegra extends AmigoUsuario{
    private int id_lista_negra;
    private String descricao;
    private Date dt_inclusao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDt_inclusao() {
        return dt_inclusao;
    }

    public void setDt_inclusao(Date dt_inclusao) {
        this.dt_inclusao = dt_inclusao;
    }

    public int getId_lista_negra() {
        return id_lista_negra;
    }

    public void setId_lista_negra(int id_lista_negra) {
        this.id_lista_negra = id_lista_negra;
    }
    
}
