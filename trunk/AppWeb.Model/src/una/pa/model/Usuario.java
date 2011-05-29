package una.pa.model;

import java.util.Date;



/**
 *
 * @author Tiago
 */
public class Usuario {
    private int id_usuario;
    private String nm_usuario;
    private String nm_sobrenome;
    private String email;
    private Date dt_nascimento;
    private Date dt_cadastro;
    private boolean sn_ativo;
    private String tel_usuario;
    private String usuario;
    private boolean email_notificacoes;
    private boolean email_parceiro;
    private boolean aceite_acordo;
    private String descricao_usuario;
    private char sexo;
    private boolean pref_em_maos;
    private boolean pref_correios;
    private boolean pref_transp;
    private String ds_cidade;
    private String ds_Estado;
    private String status;
    private String imagem;

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAceite_acordo() {
        return aceite_acordo;
    }

    public void setAceite_acordo(boolean aceite_acordo) {
        this.aceite_acordo = aceite_acordo;
    }

    public String getDescricao_usuario() {
        return descricao_usuario;
    }

    public void setDescricao_usuario(String descricao_usuario) {
        this.descricao_usuario = descricao_usuario;
    }

    public String getDs_Estado() {
        return ds_Estado;
    }

    public void setDs_Estado(String ds_Estado) {
        this.ds_Estado = ds_Estado;
    }

    public String getDs_cidade() {
        return ds_cidade;
    }

    public void setDs_cidade(String ds_cidade) {
        this.ds_cidade = ds_cidade;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmail_notificacoes() {
        return email_notificacoes;
    }

    public void setEmail_notificacoes(boolean email_notificacoes) {
        this.email_notificacoes = email_notificacoes;
    }

    public boolean isEmail_parceiro() {
        return email_parceiro;
    }

    public void setEmail_parceiro(boolean email_parceiro) {
        this.email_parceiro = email_parceiro;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNm_sobrenome() {
        return nm_sobrenome;
    }

    public void setNm_sobrenome(String nm_sobrenome) {
        this.nm_sobrenome = nm_sobrenome;
    }

    public String getNm_usuario() {
        return nm_usuario;
    }

    public void setNm_usuario(String nm_usuario) {
        this.nm_usuario = nm_usuario;
    }

    public boolean isPref_correios() {
        return pref_correios;
    }

    public void setPref_correios(boolean pref_correios) {
        this.pref_correios = pref_correios;
    }

    public boolean isPref_em_maos() {
        return pref_em_maos;
    }

    public void setPref_em_maos(boolean pref_em_maos) {
        this.pref_em_maos = pref_em_maos;
    }

    public boolean isPref_transp() {
        return pref_transp;
    }

    public void setPref_transp(boolean pref_transp) {
        this.pref_transp = pref_transp;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public boolean isSn_ativo() {
        return sn_ativo;
    }

    public void setSn_ativo(boolean sn_ativo) {
        this.sn_ativo = sn_ativo;
    }

    public String getTel_usuario() {
        return tel_usuario;
    }

    public void setTel_usuario(String tel_usuario) {
        this.tel_usuario = tel_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

   

}
