/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.model;

/**
 *
 * @author Magno
 */
public class DadosIniciais extends Usuario {
    protected int pontos, trocas, trocas_pendentes, propostas, oferta, jogos, desejo, replica_pendente, amigos_pendentes,media_qualificacao;

    public int getAmigos_pendentes() {
        return amigos_pendentes;
    }

    public void setAmigos_pendentes(int amigos_pendentes) {
        this.amigos_pendentes = amigos_pendentes;
    }

    public int getDesejo() {
        return desejo;
    }

    public void setDesejo(int desejo) {
        this.desejo = desejo;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getMedia_qualificacao() {
        return media_qualificacao;
    }

    public void setMedia_qualificacao(int media_qualificacao) {
        this.media_qualificacao = media_qualificacao;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getPropostas() {
        return propostas;
    }

    public void setPropostas(int propostas) {
        this.propostas = propostas;
    }

    public int getReplica_pendente() {
        return replica_pendente;
    }

    public void setReplica_pendente(int replica_pendente) {
        this.replica_pendente = replica_pendente;
    }

    public int getTrocas() {
        return trocas;
    }

    public void setTrocas(int trocas) {
        this.trocas = trocas;
    }

    public int getTrocas_pendentes() {
        return trocas_pendentes;
    }

    public void setTrocas_pendentes(int trocas_pendentes) {
        this.trocas_pendentes = trocas_pendentes;
    }

    
}
