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

        String sql =  "select "
                + "      notificacoes.id_notificacao, "
                + "      usuario.id_usuario, "
                + "      usuario.nm_usuario, "
                + "      notificacoes.descricao, "
                + "      notificacoes.broadcast, "
                + "      notificacoes.dt_notificacao"
                + "      from  usuario "
                + "     inner join notificacoes	on usuario.id_usuario = notificacoes.id_usuario "
                + "      where usuario.id_usuario = ? "
                + "       and tipo_notificacao = 'SYS'";

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
    public static List<Notificacoes> listarUnico(int _id, int quantidePorPagina, int pagina,boolean valida) {
        List<Notificacoes> objct = new ArrayList<Notificacoes>();
        int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }
        String sqlWhare = " and tipo_notificacao = 'SYS'";
        String sql = "select top " + quantidePorPagina + " * from ("
                + " select row_number() over (order by dt_notificacao desc) as linha,"
                + "      notificacoes.id_notificacao, "
                + "      usuario.id_usuario, "
                + "      usuario.nm_usuario, "
                + "      notificacoes.descricao, "
                + "      notificacoes.broadcast, "
                + "      notificacoes.dt_notificacao, notificacoes.tipo_notificacao,"
                + "	  (select count(*) from notificacoes where id_usuario = ?)total_registros "
                + "      from  usuario "
                + "     	inner join notificacoes	on usuario.id_usuario = notificacoes.id_usuario "
                + "      where usuario.id_usuario = ? )AS TABELA"
                + " where linha > " + inicio+ " and linha <= " + fim ;
        if(! valida){
            sql += sqlWhare;
        }

        Object[] vetor = {_id,_id};

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
                o.setTotal(Integer.parseInt(rs.getString("total_registros")));
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

        String sql = "select top   " + quantidePorPagina +"  *"
                + "  from (select row_number() over (order by dt_notificacao desc) as linha,"
                + " id_notificacao,broadcast,id_usuario,nm_usuario,nm_sobrenome,descricao,dt_notificacao,"
                + " dbo.fnc_retornaTotalRegistros(4,?)TOTAL"
                + " from(select id_notificacao,broadcast,u.id_usuario, u.nm_usuario, u.nm_sobrenome,"
                + " n.descricao,dt_notificacao from usuario u inner join notificacoes n on n.id_usuario  = u.id_usuario "
                + " where u.id_usuario = ? "
                + " union all select id_notificacao, broadcast,	"
                + " u.id_usuario, u.nm_usuario, u.nm_sobrenome,"
                + " n.descricao, dt_notificacao  from	usuario u inner join notificacoes n on n.id_usuario  = u.id_usuario "
                + " where n.id_usuario in (select id_usuario_amigo from amigo_usuario"
                + " where id_usuario = ? and ignorado = 0 and sn_Aceite = 1"
                + " union  select id_usuario as id_usuario_amigo  "
                + " from amigo_usuario where id_usuario_amigo = ?"
                + " and ignorado = 0 and sn_Aceite = 1 )"
                + " ) a "
                + "    )t where linha >  " +inicio + "  and linha <= " + fim ;


        Object[] vetor = {pId_usuario, pId_usuario, pId_usuario, pId_usuario};

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

    public static boolean enviaNotificacao(Notificacoes objct, Notificacoes.numeraNotificacao hh) {
        try {
            Connection c = Data.openConnection();
            String sql = "INSERT INTO NOTIFICACOES(ID_USUARIO, DESCRICAO, BROADCAST,DT_NOTIFICACAO,TIPO_NOTIFICACAO)VALUES(?,?,?,getdate(),?)";
            Object[] vetor = {objct.getId_usuario(), objct.getDescricao(), objct.getBroadcast(), (hh == Notificacoes.numeraNotificacao.FALA)? "SMS":"SYS"};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
