
package biosoft.modelo;


public class Producto {
    private int idProd;
    private String tipo;
    private String nombre;
    private float precio;
    
        public Producto() {
        this(0,null, null,0);
    }
    
    public Producto(int idProd, String tipo, String nombre, float precio) {
        this.idProd = idProd;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
    }
 
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
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
    
    public float getPrecio(){
        return precio;
    }
    
    public void setPrecio(float precio){
        this.precio = precio;
    }
}
