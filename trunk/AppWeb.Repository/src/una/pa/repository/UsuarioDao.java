package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sun.misc.Request;
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
                o.setSexo(rs.getString("sexo").charAt(0));
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
}
