
package biosoft.modelo;


public class Producto {
    private int idProducto;
    private String tipo;
    private String nombre;

    public Producto(int idProducto, String tipo, String nombre) {
        this.idProducto = idProducto;
        this.tipo = tipo;
        this.nombre = nombre;
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
