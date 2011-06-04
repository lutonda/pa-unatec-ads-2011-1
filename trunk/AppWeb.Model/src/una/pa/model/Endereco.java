/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author Tiago
 */
public class Endereco{
    private int id_endereco;
    private int cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String tp_logradouro;
    private String ds_estado;
    private String ds_bairro;
    private String ds_cidade;

    public String getDs_bairro() {
        return ds_bairro;
    }

    public void setDs_bairro(String ds_bairro) {
        this.ds_bairro = ds_bairro;
    }

    public String getDs_cidade() {
        return ds_cidade;
    }

    public void setDs_cidade(String ds_cidade) {
        this.ds_cidade = ds_cidade;
    }

    public String getDs_estado() {
        return ds_estado;
    }

    public void setDs_estado(String ds_estado) {
        this.ds_estado = ds_estado;
    }

    public String getTp_logradouro() {
        return tp_logradouro;
    }

    public void setTp_logradouro(String tp_logradouro) {
        this.tp_logradouro = tp_logradouro;
    }
    


    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
   
}
