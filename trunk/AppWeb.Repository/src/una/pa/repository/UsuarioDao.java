package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import una.pa.model.*;

/**
 *
 * @author Tiago
 */
public class UsuarioDao {

    public static Usuario listarTodos(int _id) {
        //List<Usuario> objC = new ArrayList<Usuario>();
        String sql = " select id_usuario,nm_usuario,nm_sobrenome,email, "
                + " dt_nascimento,dt_cadastro,sn_ativo,tel_usuario, "
                + " usuario,email_notificacoes,email_parceiro, "
                + " aceite_acordo,descricao_usuario,sexo, "
                + " pref_em_maos,pref_correios,pref_transp "
                + " from usuario where id_usuario = ? ";
        Object[] vetor = {_id};

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);
            Usuario o = new Usuario();
            //rs.getObject("")
            if (rs.next()) {
                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setNm_usuario(rs.getString("nm_usuario"));
                o.setNm_sobrenome(rs.getString("nm_sobrenome"));
                o.setEmail(rs.getString("email"));
                o.setDt_nascimento(rs.getDate("dt_nascimento"));
                o.setDt_cadastro(rs.getDate("dt_cadastro"));
                if (rs.getString("SN_ATIVO").equals("1")) {
                    o.setSn_ativo(true);
                } else {
                    o.setSn_ativo(false);
                }
                o.setTel_usuario(rs.getString("tel_usuario"));
                o.setUsuario(rs.getString("usuario"));
                if (rs.getString("email_notificacoes").equals("1")) {
                    o.setSn_ativo(true);
                } else {
                    o.setSn_ativo(false);
                }
                if (rs.getString("email_parceiro").equals("1")) {
                    o.setSn_ativo(true);
                } else {
                    o.setSn_ativo(false);
                }
                if (rs.getString("aceite_acordo").equals("1")) {
                    o.setSn_ativo(true);
                } else {
                    o.setSn_ativo(false);
                }
                o.setDescricao_usuario(rs.getString("descricao_usuario"));
                o.setSexo((rs.getString("sexo") != null)? rs.getString("sexo").charAt(0): ' ');
                if (rs.getString("pref_em_maos").equals("1")) {
                    o.setSn_ativo(true);
                } else {
                    o.setSn_ativo(false);
                }
                if (rs.getString("pref_correios").equals("1")) {
                    o.setSn_ativo(true);
                } else {
                    o.setSn_ativo(false);
                }
                if (rs.getString("pref_transp").equals("1")) {
                    o.setSn_ativo(true);
                } else {
                    o.setSn_ativo(false);
                }
            }
            rs.close();
            c.close();
            return o;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Usuario> listarPrincipal() {
        List<Usuario> objc = new ArrayList<Usuario>();

        String sql = " select id_usuario,nm_usuario,nm_sobrenome,email, "
                + " dt_nascimento ,"
                + " cidade.ds_cidade,estado.ds_estado "
                + " from usuario "
                + " inner join endereco on usuario.id_endereco = endereco.id_endereco "
                + " inner join bairro   on endereco.id_bairro  = bairro.id_bairro "
                + " inner join cidade   on	bairro.id_cidade  = cidade.id_cidade "
                + " inner join estado   on	estado.id_estado  = cidade.id_estado ";
        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                Usuario o = new Usuario();
                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setNm_usuario(rs.getString("nm_usuario"));
                o.setNm_sobrenome(rs.getString("nm_sobrenome"));
                o.setEmail(rs.getString("email"));
                o.setDt_nascimento(rs.getDate("dt_nascimento"));
                o.setDs_cidade(rs.getString("ds_cidade"));
                o.setDs_Estado(rs.getString("ds_estado"));
                objc.add(o);
            }
            rs.close();
            c.close();
            return objc;

        } catch (Exception e) {
            return null;
        }
    }
    public static List<Usuario> jogoUsuario (int _id, int _cod){
        
        List<Usuario> objct = new ArrayList<Usuario>();

        String sql = " SELECT	ID_USUARIO, NM_USUARIO, " +
                     " NM_SOBRENOME, " +
                     " STATUS, " +
                     " ID " +
                     " FROM( " +
                     "      SELECT USUARIO.ID_USUARIO,	" +
                     "        USUARIO.NM_USUARIO, " +
		     "		USUARIO.NM_SOBRENOME, " +
		     "  	'Proprietario' status, " +
                     "          1 ID " +
                     " FROM JOGO_USUARIO, USUARIO " +
                     " where id_jogo = ? " +
                     " AND JOGO_USUARIO.ID_USUARIO = USUARIO.ID_USUARIO " +

                    " UNION ALL " +

                    " SELECT USUARIO.ID_USUARIO, " +
                    " USUARIO.NM_USUARIO, " +
                    "	USUARIO.NM_SOBRENOME, " +
                    "		'Interessado' status, " +
		    "   	2 ID " +
                    " FROM	JOGO_DESEJADO, USUARIO " +
                    " WHERE ID_JOGO = ? " +
                    "	AND JOGO_DESEJADO.ID_USUARIO = USUARIO.ID_USUARIO " +
                    " UNION ALL " +
                    " SELECT	USUARIO.ID_USUARIO, USUARIO.NM_USUARIO, " +
                    "		USUARIO.NM_SOBRENOME, " +
                    "   	'Oferta' STATUS, " +
                    "		3 ID " +
                    " FROM JOGO_USUARIO, USUARIO " +
                    " WHERE JOGO_USUARIO.ID_USUARIO = USUARIO.ID_USUARIO" +
                    " AND NIVEL_INTERESSE = 0 " +
                    " AND ID_JOGO = ? " +
                    " )A " +
                    " WHERE ID  = case when ? = 0 then ID else ? end " ;

        Object[] vetor = {_id, _id,_id, _cod, _cod};
        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);
            while(rs.next()){
                Usuario o = new Usuario();
                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setNm_usuario(rs.getString("nm_usuario"));
                o.setNm_sobrenome(rs.getString("nm_sobrenome"));
                o.setStatus(rs.getString("status"));
                objct.add(o);
            }
            return objct;

        }catch(Exception e){
            return null;
        }
    }
    public static DadosIniciais inicioPerfil(String username) {

        String sql = "select u.id_usuario "
                + ", u.nm_usuario "
                + ", u.nm_sobrenome "
                + ", u.imagem "
                + ", isnull((select avg(pontos) from avaliacao_usuario where id_usuario = u.id_usuario),0) as pontos "
                + ", isnull((select count(*) from (select * from troca t inner join jogo_usuario juo on t.id_jogo_origem = juo.id_jogo_usuario union "
                + "select * from troca t inner join jogo_usuario jud on t.id_jogo_destino = jud.id_jogo_usuario) tabela "
                + "where id_usuario = u.id_usuario and status_troca = 'F'),0) as trocas "
                + ", isnull((select count(*) from (select * from troca t inner join jogo_usuario juo on t.id_jogo_origem = juo.id_jogo_usuario union "
                + "select * from troca t inner join jogo_usuario jud on t.id_jogo_destino = jud.id_jogo_usuario) tabela "
                + "where id_usuario = u.id_usuario and status_troca = 'A'),0) as trocas_pendentes "
                + ", isnull((select count(*) from (select * from troca t inner join jogo_usuario juo on t.id_jogo_origem = juo.id_jogo_usuario union "
                + "select * from troca t inner join jogo_usuario jud on t.id_jogo_destino = jud.id_jogo_usuario) tabela "
                + "where id_usuario = u.id_usuario and status_troca = 'P'),0) as propostas "
                + ", isnull((select count(*) from jogo_usuario ju where ju.id_usuario = u.id_usuario and nivel_interesse = 0),0) as oferta "
                + ", isnull((select count(*) from jogo_usuario ju where ju.id_usuario = u.id_usuario),0) as jogos "
                + ", isnull((select count(*) from jogo_desejado jd where jd.id_usuario = u.id_usuario),0) as desejo "
                + ", isnull((select count(*) from avaliacao_usuario au left join replica_avaliacao ra on au.id_avaliacao_usuario = ra.id_avaliacao_usuario where au.id_usuario = u.id_usuario and ra.id_replica is null),0) as replica_pendente "
                + ", isnull((select count(id_usuario) from amigo_usuario where id_usuario_amigo = u.id_usuario and sn_aceite = 0 and ignorado = 0),0) as amigos_pendentes "
                + " from usuario u "
                + "where u.usuario = ?";

        Object[] vetor = {username};

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);
            DadosIniciais o = new DadosIniciais();

            if (rs.next()) {
                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setNm_usuario(rs.getString("nm_usuario"));
                o.setNm_sobrenome(rs.getString("nm_sobrenome"));
                o.setPontos(Integer.parseInt(rs.getString("pontos")));
                o.setTrocas(Integer.parseInt(rs.getString("trocas")));
                o.setTrocas_pendentes(Integer.parseInt(rs.getString("trocas_pendentes")));
                o.setPropostas(Integer.parseInt(rs.getString("propostas")));
                o.setOferta(Integer.parseInt(rs.getString("oferta")));
                o.setJogos(Integer.parseInt(rs.getString("jogos")));
                o.setDesejo(Integer.parseInt(rs.getString("desejo")));
                o.setReplica_pendente(Integer.parseInt(rs.getString("replica_pendente")));
                o.setAmigos_pendentes(Integer.parseInt(rs.getString("amigos_pendentes")));

            }
            rs.close();
            c.close();
            return o;
        } catch (Exception e) {
            return null;
        }
    }

    public static int validaEmail(String _email){
        String sql = "select id_usuario from usuario where email like ?";
        Object[] vetor = {_email};

        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql,vetor);

            if(rs.next()){
                return Integer.parseInt(rs.getString("id_usuario"));
            }else{
                return -1;
            }

        }catch(Exception e){
            return -1;
        }
    }

    public static boolean updatePasso1(Usuario obj){
        String sql = "UPDATE USUARIO SET "
                + "NM_USUARIO = ?, "
                + "NM_SOBRENOME = ?, "
                + "USUARIO = ?, "
                + "DT_CADASTRO = GETDATE(), "
                + "SEHHA = ?,"
                + "EMAIL_NOTIFICACOES = ?,"
                + "EMAIL_PARCEIRO = ?, "
                + "ACEITE_ACORDO = ? "
                + " WHERE ID_USUARIO = ?";
        Object[] vetor = {obj.getNm_usuario(), obj.getNm_sobrenome(), obj.getUsuario(), obj.getSenha(), 
                            obj.isEmail_notificacoes(), obj.isEmail_parceiro(), obj.isAceite_acordo(), obj.getId_usuario()};

        try{
            Connection c = Data.openConnection();
            Data.executeUpdate(c, sql,vetor);
            return true;

        }catch(Exception e){
            return false;
        }
    }
    
        public static boolean updatePasso2(Usuario objU, Endereco objE){
        String sql = "update from usuario"
                + "set DT_NASCIMENTO = getdate(),"
                + "	SEXO = ?,"
                + "	ACEITE_ACORDO = ?,"
                + "	EMAIL_PARCEIRO = ?,"
                + "	EMAIL_NOTIFICACOES = ?"
                + "     WHERE ID_USUARIO = ? ";
        
        Object[] vetor = {objU.getSexo(), objU.isAceite_acordo(), objU.isEmail_parceiro(),
                            objU.isPref_correios(), objU.isEmail_notificacoes(), objU.getId_usuario()};

        String sql2 = "insert into endereco (id_usuario,tp_logradouro, cep, "
                + "logradouro, numero, complemento, "
                + "ds_bairro, ds_cidade, ds_estado)"
                + "values (?,?,?,?,?,?,?,?,?)";
        
        Object[] vetor2 = {objU.getId_usuario(), objE.getTp_logradouro(), objE.getCep(), objE.getLogradouro(), objE.getNumero(),
                            objE.getComplemento(), objE.getDs_bairro(), objE.getDs_cidade(), objE.getDs_estado()};
        try{
            Connection c = Data.openConnection();
            Data.executeUpdate(c, sql,vetor);
            Data.executeUpdate(c, sql2,vetor2);
            return true;

        }catch(Exception e){
            return false;
        }
    }


    
}
