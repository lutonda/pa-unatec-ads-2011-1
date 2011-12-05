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
                + " from titulo_jogo tj"
                + " left join editora_titulo et on tj.id_titulo_jogo = et.id_titulo_jogo"
                + " left join editora e on  e.id_editora = et.id_editora"
                + " left join genero_titulo gt on gt.id_titulo_jogo = tj.id_titulo_jogo"
                + " left join genero g on g.id_genero = gt.id_genero"
                + " left join desenvolvedor_titulo dt on dt.id_titulo_jogo = tj.id_titulo_jogo"
                + " left join desenvolvedor d on d.id_desenv = dt.id_desenv"
                + " left join categoria_titulo ct on ct.id_titulo_jogo = tj.id_titulo_jogo"
		+ " left join categoria c on c.id_categoria = ct.id_categoria"
                + " left join linguagem_titulo lt on tj.id_titulo_jogo = lt.id_titulo_jogo"
                + " left join linguagem l on l.id_linguagem = lt.id_linguagem";


        try {
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                TituloJogo o = new TituloJogo();
                List<Categoria> cat = new ArrayList<Categoria>();

                o.setId_titulo_jogo(Integer.parseInt(rs.getString("ID_TITULO_JOGO").toString()));
                o.setNm_titulo(rs.getString("NM_TITULO"));
                
                while (rs.next()){
                    Categoria ca = new Categoria();
                    ca.setNm_categoria(rs.getString("NM_CATEGORIA"));
                    cat.add(ca);
                    o.setListaCategoria(cat);
                }
                
//                o.setNm_categoria(rs.getString("nm_categoria"));
//                o.setEditora(rs.getString("NM_EDITORA"));
//                o.setGenero(rs.getString("DS_GENERO"));
//                o.setDesenv(rs.getString("DS_DESENV"));
//                o.setNm_linguagem(rs.getString("nm_linguagem"));
//                if (rs.getString("ID_EDITORA") != null) {
//                    o.setId_editora(Integer.parseInt(rs.getString("ID_EDITORA")));
//                }
//                if (rs.getString("ID_GENERO") != null) {
//                    o.setId_genero(Integer.parseInt(rs.getString("ID_GENERO")));
//                }
//                if (rs.getString("ID_DESENV") != null) {
//                    o.setId_desenv(Integer.parseInt(rs.getString("ID_DESENV")));
//                }

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
                //(!_obj.getTipo().equals("0")) ? _obj.getTipo() : null,
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
                //(!_obj.getTipo().equals("0")) ? _obj.getTipo() : null
            };

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
