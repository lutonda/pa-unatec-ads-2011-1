/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import una.pa.model.*;
import java.util.List;

/**
 *
 * @author ALEXANDRE
 */
public class NotificacoesDao {

    public static List<Notificacoes> listarDao() {

        List<Notificacoes> objc = new ArrayList<Notificacoes>();

        String sql = "select "
                + " notificacoes.id_notificacao,"
                + " usuario.id_usuario,"
                + " usuario.nm_usuario,"
                + "	notificacoes.descricao,"
                + "	notificacoes.broadcast,"
                + "	notificacoes.dt_notificacao "
                + "     from  usuario"
                + "	inner join amigo_usuario on usuario.id_usuario = amigo_usuario.id_usuario"
                + "	inner join notificacoes	on amigo_usuario.id_amigo_usuario = notificacoes.id_usuario"
                + "      order by notificacoes.dt_notificacao";

        try {

            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Notificacoes o = new Notificacoes();
                o.setId_notificacao(Integer.parseInt(rs.getString("id_notificacao")));
                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setNm_nome(rs.getString("nm_usuario"));
                o.setDescricao(rs.getString("descricao"));
                o.setBroadcast(Integer.parseInt(rs.getString("broadcast")));
                String data = ConvData.parseDataBra(rs.getString("dt_notificacao"));
                o.setDt_notificacoes(data);
                objc.add(o);
            }
            c.close();
            rs.close();
            return objc;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Notificacoes> listarUnico(int _id) {
        List<Notificacoes> objct = new ArrayList<Notificacoes>();

        String sql = "select "
                + " notificacoes.id_notificacao, "
                + " usuario.id_usuario, "
                + " usuario.nm_usuario, "
                + "	notificacoes.descricao, "
                + "	notificacoes.broadcast, "
                + "	notificacoes.dt_notificacao "
                + " from  usuario "
                + "	inner join amigo_usuario on usuario.id_usuario = amigo_usuario.id_usuario "
                + "	inner join notificacoes	on amigo_usuario.id_amigo_usuario = notificacoes.id_amigo_usuario "
                + " where usuario.id_usuario = ? ";

        Object[] vetor = {_id};

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while (rs.next()) {
                Notificacoes o = new Notificacoes();
                o.setId_notificacao(Integer.parseInt(rs.getString("id_notificacao")));
                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setNm_nome(rs.getString("nm_usuario"));
                o.setDescricao(rs.getString("descricao"));
                o.setBroadcast(Integer.parseInt(rs.getString("broadcast")));
                String data = ConvData.parseDataBra(rs.getString("dt_notificacao"));
                o.setDt_notificacoes(data);
                objct.add(o);
            }
            rs.close();
            c.close();
            return objct;

        } catch (Exception e) {
            return null;
        }

    }

    public static List<Notificacoes> listarNotPerfil() {
        return listarNotPerfil(0, 0, 0);
    }

    public static List<Notificacoes> listarNotPerfil(int pId_usuario, int quantidePorPagina, int pagina) {


        List<Notificacoes> objct = new ArrayList<Notificacoes>();
        int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }

        String sql = "select top " + quantidePorPagina + " * from ("
                + "select row_number() over (order by n.dt_notificacao desc) as linha, n.ID_USUARIO ID_USUARIO_NOT,ID_NOTIFICACAO, DESCRICAO,BROADCAST, DT_NOTIFICACAO,u.ID_USUARIO,NM_USUARIO ,NM_SOBRENOME,EMAIL,"
                + " DT_NASCIMENTO,DT_CADASTRO,SEHHA, SN_ATIVO, TEL_USUARIO,USUARIO,EMAIL_NOTIFICACOES,EMAIL_PARCEIRO,ACEITE_ACORDO,"
                + " DESCRICAO_USUARIO,SEXO, PREF_EM_MAOS, PREF_CORREIOS, PREF_TRANSP, IMAGEM,"
                + " (select count(*) "
                + " from notificacoes "
                + " where notificacoes.id_usuario in(select id_usuario_amigo "
                + " from amigo_usuario "
                + " where id_usuario = ? and ignorado = 0 "
                + " union "
                + " select id_usuario as id_usuario_amigo "
                + " from amigo_usuario"
                + " where id_usuario_amigo = ?"
                //+ " and sn_aceite = 1"
                + " and ignorado = 0 )"
                + " or id_usuario = ? )TOTAL"
                + " from notificacoes n inner join usuario u on u.id_usuario = n.id_usuario"
                + " where n.id_usuario in (select *"
                + " from(select id_usuario_amigo"
                + " from amigo_usuario"
                + " where id_usuario = ? and ignorado = 0"
                + " union"
                + " select id_usuario as id_usuario_amigo"
                + " from amigo_usuario"
                + " where id_usuario_amigo = ?"
                //+ " and sn_aceite = 1"
                + "  and ignorado = 0"
                + " ) tabela"
                + " )or n.id_usuario = ? "
                + ") AS TABELA"
                + " where linha > " + inicio + " and linha <= " + fim;
                //+ " order by DT_NOTIFICACAO";


        Object[] vetor = {pId_usuario, pId_usuario, pId_usuario, pId_usuario, pId_usuario, pId_usuario};

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while (rs.next()) {
                Notificacoes o = new Notificacoes();
                o.setId_notificacao(Integer.parseInt(rs.getString("id_notificacao")));
                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setNm_nome(rs.getString("nm_usuario"));
                o.setDescricao(rs.getString("descricao"));
                o.setBroadcast(Integer.parseInt(rs.getString("broadcast")));
                String data = ConvData.parseDataBra(rs.getString("dt_notificacao"));
                o.setDt_notificacoes(data);
                o.setTotal(Integer.parseInt(rs.getString("total")));
                objct.add(o);
            }
            rs.close();
            c.close();
            return objct;

        } catch (Exception e) {
            return null;
        }

    }

    public static boolean enviaNotificacao(Notificacoes objct) {
        try {
            Connection c = Data.openConnection();
            String sql = "INSERT INTO NOTIFICACOES(ID_USUARIO, DESCRICAO, BROADCAST,DT_NOTIFICACAO)VALUES(?,?,?,getdate())";
            Object[] vetor = {objct.getId_usuario(), objct.getDescricao(), objct.getBroadcast()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
