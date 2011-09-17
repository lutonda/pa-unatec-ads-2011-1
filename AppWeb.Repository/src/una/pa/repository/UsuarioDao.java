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
                + " pref_em_maos,pref_correios,pref_transp, imagem "
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
                    o.setEmail_notificacoes(true);
                } else {
                    o.setEmail_notificacoes(false);
                }
                if (rs.getString("email_parceiro").equals("1")) {
                    o.setEmail_parceiro(true);
                } else {
                    o.setEmail_parceiro(false);
                }
                if (rs.getString("aceite_acordo").equals("1")) {
                    o.setAceite_acordo(true);
                } else {
                    o.setAceite_acordo(false);
                }
                o.setDescricao_usuario(rs.getString("descricao_usuario"));
                o.setSexo((rs.getString("sexo") != null) ? rs.getString("sexo").charAt(0) : ' ');
                if (rs.getString("pref_em_maos").equals("1")) {
                    o.setPref_em_maos(true);
                } else {
                    o.setPref_em_maos(false);
                }
                if (rs.getString("pref_correios").equals("1")) {
                    o.setPref_correios(true);
                } else {
                    o.setPref_correios(false);
                }
                if (rs.getString("pref_transp").equals("1")) {
                    o.setPref_transp(true);
                } else {
                    o.setPref_transp(false);
                }
                o.setImagem(rs.getString("imagem"));
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

        String sql = "select USUARIO.ID_USUARIO,USUARIO.NM_USUARIO,USUARIO.NM_SOBRENOME,"
  +"  USUARIO.email,USUARIO.dt_nascimento,"
  +"  ENDERECO.DS_CIDADE,ENDERECO.DS_ESTADO"
  +"  from USUARIO inner join ENDERECO on "
  +"  USUARIO.ID_USUARIO = ENDERECO.ID_USUARIO;";
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

    public static List<Usuario> jogoUsuario(int _id, boolean _oferta, int quantidePorPagina, int pagina, int tipo) {

        List<Usuario> objct = new ArrayList<Usuario>();

        String sqlWhere = "";

        if(tipo != 0 && !_oferta)
            sqlWhere = "and id = " + tipo;

        int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }

        String sql = "select top " + quantidePorPagina + " *"
                + "from (select row_number() over (order by id_usuario) as linha "
                + ", (select count(*) from " + ((!_oferta) ? "usuarios_jogo" : "usuarios_jogos_ofertados") + " where id_jogo = ? " + sqlWhere + ") as totalregistros"
                + ", id_usuario, nm_usuario, nm_sobrenome, status, id "
                + "from " + ((!_oferta) ? "usuarios_jogo" : "usuarios_jogos_ofertados") + " where id_jogo = ? " + sqlWhere + ") as buscapaginada "
                + "where linha > " + inicio + " and linha <= " + fim;


        Object[] vetor = {_id, _id};
        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);
            while (rs.next()) {
                Usuario o = new Usuario();
                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setNm_usuario(rs.getString("nm_usuario"));
                o.setNm_sobrenome(rs.getString("nm_sobrenome"));
                o.setStatus(rs.getString("status"));
                o.setTotalderegistros(Integer.parseInt(rs.getString("totalregistros")));
                objct.add(o);
            }
            return objct;

        } catch (Exception e) {
            return null;
        }
    }

    public static DadosIniciais inicioPerfil(String username) {
        return inicioPerfil(username, 0);
    }

    public static DadosIniciais inicioPerfil(int _idUsuario) {
        return inicioPerfil(null, _idUsuario);
    }

    public static DadosIniciais inicioPerfil(String username, int _idUsuario) {

        String sql = "select u.id_usuario "
                + ", u.nm_usuario "
                + ", u.nm_sobrenome "
                + ", u.descricao_usuario"
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
                + " from usuario u ";

        sql += (username != null) ? "where u.usuario = ?" : "";
        sql += (_idUsuario != 0) ? "where u.id_usuario = ?" : "";

        // + "where u.usuario = ?";

        Object[] vetor = {((username != null) ? username : _idUsuario)};

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);
            DadosIniciais o = new DadosIniciais();

            if (rs.next()) {
                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setNm_usuario(rs.getString("nm_usuario"));
                o.setNm_sobrenome(rs.getString("nm_sobrenome"));
                o.setDescricao_usuario(rs.getString("descricao_usuario"));
                o.setImagem(rs.getString("imagem"));
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

    public static int validaEmail(String _email) {
        String sql = "select id_usuario from usuario where email like ?";
        Object[] vetor = {_email};

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            if (rs.next()) {
                return Integer.parseInt(rs.getString("id_usuario"));
            } else {
                return -1;
            }

        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean updatePasso1(Usuario obj) {
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

        try {
            Connection c = Data.openConnection();
            Data.executeUpdate(c, sql, vetor);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean updatePasso2(Usuario objU, Endereco objE) {
        String sqlPasso2 = "update usuario "
                + "set DT_NASCIMENTO = getdate(), "
                //+ "	SEXO = ?,"
                + "ACEITE_ACORDO = ?, "
                + "EMAIL_PARCEIRO = ?, "
                + "PREF_CORREIOS = ?, "
                + "PREF_EM_MAOS = ?, "
                + "PREF_TRANSP = ?, "
                + "EMAIL_NOTIFICACOES = ? "
                + "WHERE ID_USUARIO = ? ";

        Object[] vetorDados2 = {objU.isAceite_acordo(), objU.isEmail_parceiro(), objU.isPref_correios(),
            objU.isPref_em_maos(), objU.isPref_transp(), objU.isEmail_notificacoes(), objU.getId_usuario()};

        String sqlEndereco = "insert into endereco "
                + "(id_usuario, tp_logradouro, cep, logradouro, numero, complemento, ds_bairro, ds_cidade, ds_estado) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] vetorEndereco = {objU.getId_usuario(), objE.getTp_logradouro(), objE.getCep(), objE.getLogradouro(), objE.getNumero(),
            objE.getComplemento(), objE.getDs_bairro(), objE.getDs_cidade(), objE.getDs_estado()};
        try {
            Connection c = Data.openConnection();
            Data.executeUpdate(c, sqlPasso2, vetorDados2);
            Data.executeUpdate(c, sqlEndereco, vetorEndereco);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static AmigoUsuario inicioAmigo(int _id, int _idAmigo) {


        String sql = "select aua.id_usuario, aua.id_usuario_amigo, sn_aceite, aua.ignorado, case when aua.id_usuario_amigo = ? then 'S' else 'N'  end as solitante "
                + "from amigo_usuario aua inner join usuario ua on aua.id_usuario_amigo = ua.id_usuario "
                + "where aua.id_usuario = ? and aua.id_usuario_amigo = ? union "
                + "select aua.id_usuario_amigo as id_usuario, aua.id_usuario as id_usuario_amigo, sn_aceite, aua.ignorado, case when aua.id_usuario_amigo = ? then 'S' else 'N'  end as solitante "
                + "from amigo_usuario aua inner join usuario ua on aua.id_usuario = ua.id_usuario "
                + "where aua.id_usuario_amigo = ? and aua.id_usuario = ?";

        Object[] vetor = {_id, _id, _idAmigo, _id, _id, _idAmigo};

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);
            AmigoUsuario o = new AmigoUsuario();

            if (rs.next()) {
                o.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setId_amigo_usuario(Integer.parseInt(rs.getString("id_usuario_amigo")));
                o.setSn_aceite(Integer.parseInt(rs.getString("sn_aceite")));
                o.setIgnorado(Integer.parseInt(rs.getString("ignorado")));
                o.setSolitante(rs.getString("solitante"));
            }
            rs.close();
            c.close();
            return o;
        } catch (Exception e) {
            return null;
        }

    }
}
