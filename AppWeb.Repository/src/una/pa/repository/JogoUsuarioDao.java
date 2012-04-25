/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class JogoUsuarioDao {

    public static List<Jogousuario> listarJogoUsuario(int _id){
        List<Jogousuario> objct = new ArrayList<Jogousuario>();

        String sql = " SELECT	JOGO_USUARIO.ID_JOGO_USUARIO, " +
                     " TITULO_JOGO.NM_TITULO, " +
                     " CONSOLE.DS_CONSOLE, " +
                     " JOGO_USUARIO.DT_CADASTRO, " +
                     " JOGO_USUARIO.DESCRICAO " +
                     " FROM JOGO_USUARIO " +
                     " INNER JOIN USUARIO     ON JOGO_USUARIO.ID_USUARIO = USUARIO.ID_USUARIO " +
                     " INNER JOIN JOGO	      ON JOGO_USUARIO.ID_JOGO	 = JOGO.ID_JOGO " +
                     " INNER JOIN TITULO_JOGO ON JOGO.ID_TITULO_JOGO	 =  TITULO_JOGO.ID_TITULO_JOGO " +
                     " INNER JOIN CONSOLE     ON JOGO.ID_CONSOLE	 = CONSOLE.ID_CONSOLE " +
                     " where usuario.id_usuario = ?";
        Object[] vetor = {_id};

        try{
            Connection c = Data.openConnection();
            ResultSet rs = Data.executeQuery(c, sql, vetor);

            while(rs.next()){
                Jogousuario o = new Jogousuario();
                o.setNm_titulo(rs.getString("nm_titulo"));
                o.setDs_console(rs.getString("ds_console"));
                String data = ConvData.parseDataBra(rs.getString("dt_cadastro"));
                o.setDt_cadastro_jogo(data);
                o.setDescricao(rs.getString("descricao"));
                objct.add(o);

            }
            rs.close();
            c.close();
            return objct;
        }catch(Exception e){
            return null;
        }
    }
    public static boolean incluir(Jogousuario _obj){
        try{
            Connection c = Data.openConnection();
            String sql = "insert into dbo.JOGO_USUARIO(id_usuario,id_jogo,est_capa,est_midia,est_manual,dt_cadastro,regiao_jogo,descricao,nivel_interesse)"
                        +"values(?,?,?,?,?,getdate(),?,?,?)";
            Object[] vetor = {_obj.getId_usuario(),_obj.getId_jogo(),_obj.getEst_capa(),_obj.getEst_midia(),_obj.getEst_manual(),_obj.getRegiao_jogo(),_obj.getDescricao(),_obj.getNivelInteresse()};
            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        }catch(Exception e){
            return false;
        }
    }
    public static boolean alterar(Jogousuario _obj){
        try{
            Connection c = Data.openConnection();
            String sql = "update dbo.JOGO_USUARIO set id_usuario = ?,id_jogo = ?,est_capa = ?,est_midia = ?,est_manual = ?,dt_cadastro = getdate(),regiao_jogo = ?,descricao = ?,nivel_interesse = ? where id_jogo_usuario = ?";
            Object[] vetor = {_obj.getId_usuario(),_obj.getId_jogo(),_obj.getEst_capa(),_obj.getEst_midia(),_obj.getEst_manual(),_obj.getRegiao_jogo(),_obj.getDescricao(),_obj.getNivelInteresse()};

            Data.executeQuery(c, sql, vetor);
            c.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
     public static boolean excluir(Jogousuario _obj) {

        try {
            Connection c = Data.openConnection();
            String sql = "delete dbo.JOGO_USUARIO where where id_usuario = ? and id_jogo = ?";
            Object[] vetor = {_obj.getId_usuario(),_obj.getId_jogo()};

            Data.executeUpdate(c, sql, vetor);
            c.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
