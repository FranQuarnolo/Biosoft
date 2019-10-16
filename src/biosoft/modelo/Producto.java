
package biosoft.modelo;


public class Producto {
    private int idProd;
    private String tipo;
    private String nombre;
    
        public Producto() {
        this(0,null, null);
    }
    
    public Producto(int idProd, String tipo, String nombre) {
        this.idProd = idProd;
        this.tipo = tipo;
        this.nombre = nombre;
        
    }
 
    public int getIdProducto() {
        return idProd;
    }

    public void setIdProducto(int idProd) {
        this.idProd = idProd;
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
