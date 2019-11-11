package biosoft.modelo;

/**
 *
 * @author Wayne
 */
public class Destino {
    private int idDestino;
    private String nombre;
    private float descuento;
    
    public Destino() {
        this(0,null,0);
    }
    
    public Destino(int idDestino,String nombre,  float descuento) {
        this.idDestino = idDestino;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    /**
     * @return the idDestino
     */
    public int getIdDestino() {
        return idDestino;
    }

    /**
     * @param idDestino the idDestino to set
     */
    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
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
