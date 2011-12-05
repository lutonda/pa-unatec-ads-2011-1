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
    protected String dt_cadastro;
    protected String dt_lancamento;
    protected String descricao;
    
    protected List<Editora> listaEditora;
    protected List<Genero> listaGenero;
    protected List<Desenvolvedor> listaDesenv;
    protected List<Categoria> listaCategoria;
    protected List<Linguagem> listaLinguagem;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(String dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public String getDt_lancamento() {
        return dt_lancamento;
    }

    public void setDt_lancamento(String dt_lancamento) {
        this.dt_lancamento = dt_lancamento;
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

    public String getNm_titulo() {
        return nm_titulo;
    }

    public void setNm_titulo(String nm_titulo) {
        this.nm_titulo = nm_titulo;
    }
    
}
