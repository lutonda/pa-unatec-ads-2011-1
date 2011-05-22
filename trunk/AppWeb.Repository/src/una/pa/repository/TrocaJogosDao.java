package una.pa.repository;
import com.sun.org.apache.xpath.internal.operations.Equals;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import una.pa.model.*;

/**
 *
 * @author Tiago
 */
public class TrocaJogosDao {
    public static List<TrocaJogos> listarDao(){

        List<TrocaJogos> objc = new ArrayList<TrocaJogos>();

        String sql = "SELECT DISTINCT " +
                     " convert(char(10),DT_TROCA,103) DT_TROCA, " +
                     " convert(char(10),DT_SOLICITACAO,103) DT_SOLICITACAO, " +
                     " STATUS_TROCA , " +
                     " NM_USUARIO_ORIGEM, " +
                     " NM_TITULO_ORIGEM, " +
                     " DS_CONSOLE_ORIGEM, " +
                     " convert(char(10),DT_AVALIACAO_ORIGEM,103) DT_AVALIACAO_ORIGEM, " +
                     " PONTOS_ORIGEM , " +
                     " NM_USUARIO_DESTINO, " +
                     " NM_TITULO_DESTINO, " +
                     " DS_CONSOLE_DESTINO, " +
                     " convert(char(10),DT_AVALIACAO_DESTINO,103)DT_AVALIACAO_DESTINO, " +
                     " PONTOS_DESTINO " +
                     " FROM dbo.JOGOS_TROCADOS ";
        try{
            Connection c =  Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while(rs.next()){
                TrocaJogos o = new TrocaJogos();
                o.setDt_troca(rs.getString("dt_troca"));
                o.setDt_solicitacao(rs.getString("dt_solicitacao"));
                o.setStatus_troca(rs.getString("status_troca"));
                o.setNm_usuario_origem(rs.getString("nm_usuario_origem"));
                o.setNm_titulo_origem(rs.getString("nm_titulo_origem"));
                o.setDs_console_origem(rs.getString("ds_console_origem"));
                o.setDt_avaliacao_origem(rs.getString("dt_avaliacao_origem"));
                if(rs.getString("pontos_origem")!= null){
                    o.setPontos_origem(Integer.parseInt(rs.getString("pontos_origem")));
                }
                o.setNm_usuario_destino(rs.getString("nm_usuario_destino"));
                o.setNm_titulo_destino(rs.getString("nm_titulo_destino"));
                o.setDs_console_destino(rs.getString("ds_console_destino"));
                o.setDt_avaliacao_destino(rs.getString("dt_avaliacao_destino"));
                if(rs.getString("pontos_destino")!= null){
                     o.setPontos_destino(Integer.parseInt(rs.getString("pontos_destino")));
                }
                objc.add(o);
            }
            rs.close();
            c.close();
            return objc;
        }catch(Exception e){
            return null;
        }
    }
    public static List<TrocaJogos> listarUnico(int _id){
        List<TrocaJogos> objct = new ArrayList<TrocaJogos>();

         String sql = "SELECT DISTINCT " +
                     " convert(char(10),DT_TROCA,103) DT_TROCA, " +
                     " convert(char(10),DT_SOLICITACAO,103) DT_SOLICITACAO, " +
                     " STATUS_TROCA , " +
                     " NM_USUARIO_ORIGEM, " +
                     " NM_TITULO_ORIGEM, " +
                     " DS_CONSOLE_ORIGEM, " +
                     " convert(char(10),DT_AVALIACAO_ORIGEM,103) DT_AVALIACAO_ORIGEM, " +
                     " PONTOS_ORIGEM , " +
                     " NM_USUARIO_DESTINO, " +
                     " NM_TITULO_DESTINO, " +
                     " DS_CONSOLE_DESTINO, " +
                     " convert(char(10),DT_AVALIACAO_DESTINO,103)DT_AVALIACAO_DESTINO, " +
                     " PONTOS_DESTINO " +
                     " FROM dbo.JOGOS_TROCADOS " +
                     " where id_usuario = ? ";
         Object[] vetor = {_id};

         try{
             Connection c = Data.openConnection();
             ResultSet rs = Data.executeQuery(c, sql, vetor);

             while(rs.next()){
                TrocaJogos o = new TrocaJogos();
                o.setDt_troca(rs.getString("dt_troca"));
                o.setDt_solicitacao(rs.getString("dt_solicitacao"));
                o.setStatus_troca(rs.getString("status_troca"));
                o.setNm_usuario_origem(rs.getString("nm_usuario_origem"));
                o.setNm_titulo_origem(rs.getString("nm_titulo_origem"));
                o.setDs_console_origem(rs.getString("ds_console_origem"));
                o.setDt_avaliacao_origem(rs.getString("dt_avaliacao_origem"));
                if(rs.getString("pontos_origem")!= null){
                    o.setPontos_origem(Integer.parseInt(rs.getString("pontos_origem")));
                }
                o.setNm_usuario_destino(rs.getString("nm_usuario_destino"));
                o.setNm_titulo_destino(rs.getString("nm_titulo_destino"));
                o.setDs_console_destino(rs.getString("ds_console_destino"));
                o.setDt_avaliacao_destino(rs.getString("dt_avaliacao_destino"));
                if(rs.getString("pontos_destino")!= null){
                     o.setPontos_destino(Integer.parseInt(rs.getString("pontos_destino")));
                }
                 objct.add(o);
             }
             rs.close();
             c.close();
             return objct;

         }catch(Exception e){
             return null;
         }
    }

}
