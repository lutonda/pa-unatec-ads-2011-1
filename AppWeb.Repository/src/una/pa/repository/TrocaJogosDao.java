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
                     " where id_usuario_origem = ? ";
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
    public static List<TrocaJogos> jogosTrocados(int quantidePorPagina, int pagina, int _id, String _retorno ){
         String sql;
         int inicio = 0;
        int fim = quantidePorPagina;

        if (pagina > 1) {
            fim = (quantidePorPagina * pagina);
            inicio = fim - quantidePorPagina;
        }
         List<TrocaJogos> objc = new ArrayList<TrocaJogos>();
         sql =  "select top " + quantidePorPagina + " * from ("
                + "select	troca.id_usuario_origem,"
		+ "troca.id_jogo_origem,"
                + " troca.id_jogo_destino,"
                + " titulo_jogo.nm_titulo nm_titulo_destino,"
                + " jo.imagem imagem_destino,"
                + " tj.nm_titulo nm_titulo_origem,"
                + " jo.imagem imagem_origem,"
                + " c.id_console id_console_origem,"
                + " c.ds_console ds_console_origem,"
                + " troca.id_usuario_destino,"
                + " u.nm_usuario nm_usuario_destino,"
                + " u.nm_sobrenome sobrenome_destino,"
                + " console.id_console,"
                + " console.ds_console,"
                + " troca.tipo,"
                + " troca.status_troca,"
                + " troca.avaliacao,"
                + " u.tel_usuario,"
                + " u.email,"
                + " endereco.ds_cidade,"
                + " endereco.ds_estado, "
                + "row_number() over (order by troca.tipo asc) as linha,"
                + " dbo.fnc_retornaTotalRegistros(3,?,'" + _retorno + "' " + " ) totalregistros"
                + " from("
                + "  select	case when ju.id_usuario = ? then ju.id_usuario else jud.id_usuario end as id_usuario_origem,"
                + " case when jud.id_usuario = ? then ju.id_usuario else jud.id_usuario end as id_usuario_destino,"
                + " ju.id_jogo id_jogo_origem,"
                + " jud.id_jogo  as id_jogo_destino,"
                + " case when ju.id_usuario = 5 then 'E'"
                + " else 'R' end as tipo,"
                + " case when t.data_aceito is null then 'aberto'  "
                + " when t.data_aceito is not null "
                + " and data_final_usu_origem is null"
                + " and data_final_usu_destino is null then 'andamento'	"
                + " when data_final_usu_origem is not null "
                + " and data_final_usu_destino is  null then 'andamento'"
                + " when data_final_usu_destino is not null "
                + " and data_final_usu_origem is  null then 'andamento'"
                + " when t.data_aceito is not null "
                + " and data_final_usu_origem is not null "
                + " and data_final_usu_destino is not null then 'finalizado'"
                + " end as status_troca,"
                + " --case when ju.id_usuario = au.id_usuario then 'true' else 'false' end as avaliacao  "
                + " case when au.id_avaliacao_usuario is not null then 'true' else 'false' end as avaliacao  "
                + " from	troca t"
                + " inner join jogo_usuario ju	on ju.id_jogo_usuario = t.id_jogo_origem"
                + " inner join jogo_usuario jud	on jud.id_jogo_usuario = t.id_jogo_destino"
                + " left join avaliacao_usuario au on t.id_troca = au.id_troca"
                + " where  (ju.id_usuario = ? or jud.id_usuario = ?)"
                + " ) troca"
                + "	--- informacoes usuario destino"
                + " inner join usuario u on troca.id_usuario_destino = u.id_usuario"
                + " inner join jogo on jogo.id_jogo = troca.id_jogo_destino"
                + " inner join titulo_jogo on jogo.id_titulo_jogo = titulo_jogo.id_titulo_jogo"
                + " inner join console on console.id_console = jogo.id_console"
                + "  left join endereco on endereco.id_usuario = u.id_usuario"
                + "--- dados jogos origem"
                + " inner join jogo jo on jo.id_jogo = troca.id_jogo_origem"
                + " inner join titulo_jogo tj on jo.id_titulo_jogo = tj.id_titulo_jogo"
                + " inner join console c on c.id_console = jo.id_console "
                + ") a"
                + " where linha > " + inicio + " and linha <= " + fim;

         Object[] vetor = {_id};

         try{
             Connection c = Data.openConnection();
             ResultSet rs = Data.executeQuery(c, sql, vetor);

             while(rs.next()){
                TrocaJogos o = new TrocaJogos();
                 /// Dados Origem
                 o.setId_usuario(Integer.parseInt(rs.getString("id_usuario_origem")));
                 o.setId_jogo_origem(Integer.parseInt(rs.getString("id_jogo_origem")));
                 o.setNm_titulo_origem(rs.getString("nm_titulo_origem"));
                 o.setImagem_origem(rs.getString("imagem_origem"));
                 o.setDs_console_origem(rs.getString("ds_console_origem"));
                 // Dados Destino
                 o.setId_usuario(Integer.parseInt(rs.getString("id_usuario_destino")));
                 o.setNm_usuario_destino(rs.getString("nm_usuario_destino"));
                 o.setSobrenome_destino(rs.getString("sobrenome_destino"));
                 o.setId_jogo_origem(Integer.parseInt(rs.getString("id_jogo_destino")));
                 o.setNm_titulo_origem(rs.getString("nm_titulo_destino"));
                 o.setImagem_origem(rs.getString("imagem_destino"));
                 o.setDs_console_origem(rs.getString("ds_console"));
                 o.setTipo(rs.getString("tipo"));
                 o.setStatus_troca(rs.getString("status_troca"));
                 o.setAvaliacao(rs.getString("avaliacao").equals("1")? true : false);
                 o.setTel_usuario(Integer.parseInt(rs.getString("tel_usuario")));
                 o.setEmail(rs.getString("email"));
                 o.setCidade(rs.getString("ds_cidade"));
                 o.setEstado(rs.getString("ds_estado"));

                 objc.add(o);
             }
             rs.close();
             c.close();
             return objc;
         }catch(Exception e){
             return null;
         }
    }
}
