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

    protected String editora;
    protected int id_editora;
    protected String genero;
    protected int id_genero;
    protected String desenv;
    protected int id_desenv;
    protected int id_categoria;
    protected String nm_categoria;
    protected int id_linguagem;
    protected String nm_linguagem;
    
    protected List<Editora> listaEditora;
    protected List<Genero> listaGenero;
    protected List<Desenvolvedor> listaDesenv;
    protected List<Categoria> listaCategoria;
    protected List<Linguagem> listaLinguagem;

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

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_desenv() {
        return id_desenv;
    }

    public void setId_desenv(int id_desenv) {
        this.id_desenv = id_desenv;
    }

    public int getId_editora() {
        return id_editora;
    }

    public void setId_editora(int id_editora) {
        this.id_editora = id_editora;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public int getId_linguagem() {
        return id_linguagem;
    }

    public void setId_linguagem(int id_linguagem) {
        this.id_linguagem = id_linguagem;
    }

    public int getId_titulo_jogo() {
        return id_titulo_jogo;
    }

    public void setId_titulo_jogo(int id_titulo_jogo) {
        this.id_titulo_jogo = id_titulo_jogo;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public List<Desenvolvedor> getListaDesenv() {
        return listaDesenv;
    }

    public void setListaDesenv(List<Desenvolvedor> listaDesenv) {
        this.listaDesenv = listaDesenv;
    }

    public List<Editora> getListaEditora() {
        return listaEditora;
    }

    public void setListaEditora(List<Editora> listaEditora) {
        this.listaEditora = listaEditora;
    }

    public List<Genero> getListaGenero() {
        return listaGenero;
    }

    public void setListaGenero(List<Genero> listaGenero) {
        this.listaGenero = listaGenero;
    }

    public List<Linguagem> getListaLinguagem() {
        return listaLinguagem;
    }

    public void setListaLinguagem(List<Linguagem> listaLinguagem) {
        this.listaLinguagem = listaLinguagem;
    }

    public String getNm_categoria() {
        return nm_categoria;
    }

    public void setNm_categoria(String nm_categoria) {
        this.nm_categoria = nm_categoria;
    }

    public String getNm_linguagem() {
        return nm_linguagem;
    }

    public void setNm_linguagem(String nm_linguagem) {
        this.nm_linguagem = nm_linguagem;
    }

    public String getNm_titulo() {
        return nm_titulo;
    }

    public void setNm_titulo(String nm_titulo) {
        this.nm_titulo = nm_titulo;
    }
    

}
