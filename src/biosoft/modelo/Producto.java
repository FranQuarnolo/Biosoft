
package biosoft.modelo;


public class Producto {
    private int idProducto;
    private String tipo;
    private String nombre;
    private DetalleVenta detalleVenta;

    public Producto(int idProducto, String tipo, String nombre, DetalleVenta detalleVenta) {
        this.idProducto = idProducto;
        this.tipo = tipo;
        this.nombre = nombre;
        this.detalleVenta = detalleVenta;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
