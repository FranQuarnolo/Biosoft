
package biosoft.modelo;


public class Producto {
    private int idProd;
    private String nombre;
    private String tipo;
    private String presentacion;
    private float precio;
    
        public Producto() {
        this(0,null, null, null,0);
    }
    
    public Producto(int idProd,String nombre, String tipo, String presentacion,  float precio) {
        this.idProd = idProd;
        this.tipo = tipo;
        this.nombre = nombre;
        this.presentacion = presentacion;
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

    /**
     * @return the presentacion
     */
    public String getPresentacion() {
        return presentacion;
    }

    /**
     * @param presentacion the presentacion to set
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
}
