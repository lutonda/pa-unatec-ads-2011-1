package una.pa.model;

/**
 *
 * @author Tiago
 */
public class Estado {
    private int id_estado;
    private int id_pais;
    private String ds_estado;

    public String getDs_estado() {
        return ds_estado;
    }

    public void setDs_estado(String ds_estado) {
        this.ds_estado = ds_estado;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

}
