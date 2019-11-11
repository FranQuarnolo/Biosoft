package biosoft.modelo;

/**
 *
 * @author Wayne
 */
public class Origen {
    private int idOrigen;
    private String nombre;
    private float descuento;
    
    public Origen() {
        this(0,null,0);
    }
    
    public Origen(int idOrigen,String nombre,  float descuento) {
        this.idOrigen = idOrigen;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    /**
     * @return the idOrigen
     */
    public int getIdOrigen() {
        return idOrigen;
    }

    /**
     * @param idOrigen the idOrigen to set
     */
    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
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
