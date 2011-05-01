package una.pa.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import una.pa.model.*;
import java.util.Date;

/**
 *
 * @author Magno
 */
public class TituloJogoDao {

    public static List<TituloJogo> listarDao() {

        List<TituloJogo> objC = new ArrayList<TituloJogo>();

        String sql = "select * "
                + "from titulo_jogo left join editora on titulo_jogo.id_editora = editora.id_editora "
                + "left join genero on titulo_jogo.id_genero = genero.id_genero "
                + "left join desenvolvedor on titulo_jogo.id_desenv = desenvolvedor.id_desenv";


        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                TituloJogo o = new TituloJogo();

                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO").toString()));
                o.setNm_titulo(rs.getString("NM_TITULO"));
                //o.setDt_cadastro(data); rs.getString("DT_CADASTRO")
                o.setTipo(rs.getString("TIPO"));
                o.setEditora(rs.getString("NM_EDITORA"));
                o.setGenero(rs.getString("DS_GENERO"));
                o.setDesenv(rs.getString("DS_DESENV"));
                if (rs.getString("ID_EDITORA") != null) {
                    o.setId_editora(Integer.parseInt(rs.getString("ID_EDITORA")));
                }
                if (rs.getString("ID_GENERO") != null) {
                    o.setId_genero(Integer.parseInt(rs.getString("ID_GENERO")));
                }
                if (rs.getString("ID_DESENV") != null) {
                    o.setId_desenv(Integer.parseInt(rs.getString("ID_DESENV")));
                }

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
                    + "SET ID_EDITORA = ? "
                    + ",ID_GENERO = ? "
                    + ",ID_DESENV = ? "
                    + ",NM_TITULO = ? "
                    + ",TIPO = ? "
                    + "WHERE ID_TITULO_JOGO = ?";

            Object[] vetor = {(_obj.getId_editora() != 0) ? _obj.getId_editora() : null,
                (_obj.getId_genero() != 0) ? _obj.getId_genero() : null,
                (_obj.getId_desenv() != 0) ? _obj.getId_desenv() : null,
                _obj.getNm_titulo(),
                (!_obj.getTipo().equals("0")) ? _obj.getTipo() : null,
                _obj.getId_titulo_jogo()};

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
                    + "(ID_EDITORA "
                    + ",ID_GENERO "
                    + ",ID_DESENV "
                    + ",NM_TITULO "
                    + ",DT_CADASTRO "
                    + ",TIPO) VALUES (?,?,?,?,getdate(),?)";
            Object[] vetor = {(_obj.getId_editora() != 0) ? _obj.getId_editora() : null,
                (_obj.getId_genero() != 0) ? _obj.getId_genero() : null,
                (_obj.getId_desenv() != 0) ? _obj.getId_desenv() : null,
                _obj.getNm_titulo(),
                (!_obj.getTipo().equals("0")) ? _obj.getTipo() : null};

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
