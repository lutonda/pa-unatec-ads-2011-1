package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import una.pa.model.*;

/**
 *
 * @author Magno
 */
public class TituloJogoDao {
    
    public static List<TituloJogo> listarDao() {
        List<TituloJogo> objC = new ArrayList<TituloJogo>();

        String sql = "select *"
                + " from titulo_jogo tj";

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                TituloJogo o = new TituloJogo();
                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO").toString()));
                o.setNm_titulo(rs.getString("NM_TITULO"));
                o.setDt_cadastro(rs.getString("DT_CADASTRO"));
                o.setDt_lancamento(rs.getString("DT_LANCAMENTO"));
                o.setDescricao(rs.getString("DESCRICAO"));
                
                o.setListaCategoria(CategoriaDao.listarDal(o.getId_titulo_jogo()));
                o.setListaEditora(EditoraDal.listarEditora(o.getId_titulo_jogo()));
                o.setListaGenero(GeneroDal.listarGeneroDal(o.getId_titulo_jogo()));
                o.setListaDesenv(DesenvolvedorDal.listarDesenvolvedorDal(o.getId_titulo_jogo()));
                o.setListaLinguagem(LinguagemDao.listarDal(o.getId_titulo_jogo()));
                objC.add(o);
            }
            rs.close();
            c.close();

            return objC;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<TituloJogo> listarSimplesDao() {
        List<TituloJogo> objC = new ArrayList<TituloJogo>();

        String sql = "select *"
                + " from titulo_jogo tj";

        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                TituloJogo o = new TituloJogo();

                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO").toString()));
                o.setNm_titulo(rs.getString("NM_TITULO"));
                o.setDt_cadastro(rs.getString("DT_CADASTRO"));
                o.setDt_lancamento(rs.getString("DT_LANCAMENTO"));
                o.setDescricao(rs.getString("DESCRICAO"));

                objC.add(o);
            }

            rs.close();
            c.close();

            return objC;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean altera(TituloJogo _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "UPDATE TITULO_JOGO "
                    + "SET DESCRICAO = ? "
                    + ",DT_LANCAMENTO = ? "
                    + ",DT_CADASTRO = ? "
                    + ",NM_TITULO = ? "
                    + "WHERE ID_TITULO_JOGO = ?";

            Object[] vetor = {_obj.getDescricao(), _obj.getDt_lancamento(), _obj.getDt_cadastro(), _obj.getNm_titulo(), _obj.getId_titulo_jogo()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean inclui(TituloJogo _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "INSERT INTO TITULO_JOGO "
                    + "(DESCRICAO "
                    + ",DT_LANCAMENTO "
                    + ",DT_CADASTRO "
                    + ",NM_TITULO ) VALUES (?,?,getdate(),?)";
            Object[] vetor = {_obj.getDescricao(), _obj.getDt_lancamento(), _obj.getNm_titulo()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean exclui(int _id) {

        try {
            Connection c = Data.openConnection();
            String sql = "DELETE FROM TITULO_JOGO WHERE ID_TITULO_JOGO = ?";
            Object[] vetor = {_id};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
