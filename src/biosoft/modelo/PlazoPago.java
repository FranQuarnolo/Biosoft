package biosoft.modelo;

/**
 *
 * @author Wayne
 */
public class PlazoPago {
    private int idPlazoDePago;
    private String nombre;
    private float descuento;
    
    public PlazoPago() {
        this(0,null,0);
    }
    
    public PlazoPago(int idPlazoDePago,String nombre,  float descuento) {
        this.idPlazoDePago = idPlazoDePago;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    /**
     * @return the idPlazoDePago
     */
    public int getIdPlazoDePago() {
        return idPlazoDePago;
    }

    /**
     * @param idPlazoDePago the idPlazoDePago to set
     */
    public void setIdPlazoDePago(int idPlazoDePago) {
        this.idPlazoDePago = idPlazoDePago;
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
