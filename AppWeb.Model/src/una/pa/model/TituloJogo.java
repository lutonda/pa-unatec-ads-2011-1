/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

import java.util.*;

/**
 *
 * @author Magno
 */
public class TituloJogo {
    protected int id_titulo_jogo;
    protected String nm_titulo;
    protected Date dt_cadastro;
    protected String tipo;

    protected String editora;
    protected int id_editora;
    protected String genero;
    protected int id_genero;
    protected String desenv;
    protected int id_desenv;

    public int getId_desenv() {
        return id_desenv;
    }

    public void setId_desenv(int id_desenv) {
        this.id_desenv = id_desenv;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public int getId_editora() {
        return id_editora;
    }

    public void setId_editora(int id_editora) {
        this.id_editora = id_editora;
    }

    public String getDesenv() {
        return desenv;
    }

    public void setDesenv(String desenv) {
        this.desenv = desenv;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId_titulo_jogo() {
        return id_titulo_jogo;
    }

    public void setId_titulo_jogo(int id) {
        this.id_titulo_jogo = id;
    }

    public String getNm_titulo() {
        return nm_titulo;
    }

    public void setNm_titulo(String nm_titulo) {
        this.nm_titulo = nm_titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
