/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.model;

/**
 *
 * @author Felipe
 */
public class Jogo extends TituloJogo{
        
    protected int id_jogo;
    protected int id_console;
    protected String imagem;
    private String descricao;
    private int pontos;
    
    protected String console;
    protected String titulo_jogo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public int getId_console() {
        return id_console;
    }

    public void setId_console(int id_console) {
        this.id_console = id_console;
    }

    public int getId_jogo() {
        return id_jogo;
    }

    public void setId_jogo(int id_jogo) {
        this.id_jogo = id_jogo;
    }



    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTitulo_jogo() {
        return titulo_jogo;
    }

    public void setTitulo_jogo(String titulo_jogo) {
        this.titulo_jogo = titulo_jogo;
    }
}
