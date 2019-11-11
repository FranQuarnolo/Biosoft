package biosoft.modelo;

/**
 *
 * @author Wayne
 */
public class TiempoEntrega {
     private int idTiempodeEntrega;
    private String nombre;
    private float descuento;
    
    public TiempoEntrega() {
        this(0,null,0);
    }
    
    public TiempoEntrega(int idTiempodeEntrega,String nombre,  float descuento) {
        this.idTiempodeEntrega = idTiempodeEntrega;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    /**
     * @return the idTiempodeEntrega
     */
    public int getIdTiempodeEntrega() {
        return idTiempodeEntrega;
    }

    /**
     * @param idTiempodeEntrega the idTiempodeEntrega to set
     */
    public void setIdTiempodeEntrega(int idTiempodeEntrega) {
        this.idTiempodeEntrega = idTiempodeEntrega;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descuento
     */
    public float getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    
    
    
}
