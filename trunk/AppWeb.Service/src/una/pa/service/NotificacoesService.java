/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.service;
import una.pa.model.*;
import una.pa.repository.*;
import java.util.List;
import una.pa.util.*;
import javax.rmi.CORBA.Util;

/**
 *
 * @author ALEXANDRE
 */
public class NotificacoesService {
    public static List<Notificacoes> listar (){
        return NotificacoesDao.listarDao();
        //
    }
    public static enum numeraNotificacao{
        TROCA,
        FALA,
        ADICIONA,
        ENTRA,
        DESEJA,
        TEM,
        OFERTA,
        AVALIADO
    }

    public static List<Notificacoes> listarUnico(int _id){
        return NotificacoesDao.listarUnico(_id);
    }
    public static List<Notificacoes> listarNotPerfil(int pId_usuario, int quantidePorPagina, int pagina){
        return NotificacoesDao.listarNotPerfil(pId_usuario, quantidePorPagina, pagina);
    }
    public static boolean enviaNotificacao(Notificacoes objct){
        return NotificacoesDao.enviaNotificacao(objct);
    }
    
    public static boolean enviaNotificacao(numeraNotificacao hh,
           String _msg,
           int _idUser,
           int _idUserDestino,
           String _nomeUserDestino,
           int idJogoOrg,
           String _nmJogoOrg,
           int idJogoDst,
           String _nmJogoDst,
           int _pts){
        
        String descricao = "" ;

        switch(hh){
            case TROCA:
                descricao = " trocou o jogo " + _nmJogoOrg + " por " + _nmJogoDst + " com " + _nomeUserDestino;
                break;
            case FALA:
                descricao = " fala com " + _nomeUserDestino+ " "+ _msg ;
                break;
            case ADICIONA:
                descricao =  " adicionou " +_nomeUserDestino +" ao amigos " ;
                break;
            case ENTRA:
                descricao = " Entrou no Jogatroca " ;
                break;
            case DESEJA:
                descricao = " Desejou ter o jogo "+ _nmJogoDst ;
                break;
            case TEM:
                descricao = "  Tem o jogo " + _nmJogoDst;
                break;
            case OFERTA:
                descricao = " Ofertou o jogo ";
                break;
            case AVALIADO:
                descricao = "Foi avaliado com " + _pts + " pts por " + _nomeUserDestino;
                break;
        }

        Notificacoes objNot = new Notificacoes();
        objNot.setId_usuario(_idUser);
        objNot.setBroadcast((false)? 1:0);
        objNot.setDescricao(descricao);
        return NotificacoesDao.enviaNotificacao(objNot);
    }
}
