/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import una.pa.model.AvaliacaoJogo;


public class AvaliacaoJogoDao {
    public static boolean incluir(AvaliacaoJogo _obj){
        try{
            Connection c = Data.openConnection();
            String sql = "insert into dbo.AVALIACAO_JOGO(id_usuario,id_jogo,ds_avaliacao,pontos,dt_avaliacao)"
                         +"values ?,?,?,?,?";
            Object[] vetor = {_obj.getId_Usuario(),_obj.getId_jogo(),_obj.getDs_Avaliacao(),_obj.getPontos(),_obj.getDt_Avaliacao()};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        }catch(Exception e){
            return false;
        }
    }
    public static boolean alterar(AvaliacaoJogo _obj){
        try{
            Connection c = Data.openConnection();
            String sql = "update dbo.AVALIACAO_JOGO set id_usuario = ?,id_jogo = ?,ds_avaliacao = ?,pontos = ?,dt_avaliacao = ? where id_avaliacao_jogo = ?";
            Object[] vetor = {_obj.getId_Usuario(),_obj.getId_jogo(),_obj.getDs_Avaliacao(),_obj.getPontos(),_obj.getDt_Avaliacao(),_obj.getId_Avaliacao()};

            Data.executeQuery(c, sql, vetor);
            c.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
     public static boolean excluir(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "delete dbo.AVALIACAO_JOGO where id_avaliacao = ?";
            Object[] vetor = {_id};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
     public static List<AvaliacaoJogo> listar(int _id){
         List<AvaliacaoJogo> objct = new ArrayList<AvaliacaoJogo>();

         String sql = "select	a.id_avaliacao,"
                 + " u.id_usuario,"
                 + " j.id_jogo,"
                 + " a.ds_avaliacao,"
                 + " a.pontos,"
                 + " a.dt_avaliacao,"
                 + " t.nm_titulo,"
                 + " t.tipo,"
                 + " j.imagem,"
                 + " u.nm_usuario,"
                 + " u.nm_sobrenome					"
                 + " from	avaliacao_jogo a"
                 + " inner join usuario u on a.id_usuario = u.id_usuario"
                 + " inner join jogo j on a.id_jogo = j.id_jogo"
                 + " inner join titulo_jogo t on j.id_titulo_jogo = t.id_titulo_jogo"
                 + " inner join console c on j.id_console = c.id_console"
                 + " where j.id_jogo = ?";
         Object[] vetor = {_id};
         try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while(rs.next()){
                AvaliacaoJogo o = new AvaliacaoJogo();
                o.setId_Avaliacao(Integer.parseInt(rs.getString("id_avaliacao")));
                o.setId_Usuario(Integer.parseInt(rs.getString("id_usuario")));
                o.setId_jogo(Integer.parseInt(rs.getString("id_jogo")));
                o.setDs_Avaliacao(rs.getString("ds_avaliacao"));
                o.setPontos(Integer.parseInt(rs.getString("pontos")));
                o.setDt_Avaliacao(rs.getDate("dt_avaliacao"));
                o.setNm_titulo(rs.getString("nm_titulo"));
                o.setTipo(rs.getString("tipo"));
                o.setImagem(rs.getString("imagem"));
                o.setNm_usuario(rs.getString("nm_usuario"));
                o.setNm_sobrenome(rs.getString("nm_sobrenome"));

                objct.add(o);
            }
            rs.close();c.close();
            return objct;

         }catch(Exception e){
             return null;
         }
     }
}
