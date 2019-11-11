/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosoft.modelo;

/**
 *
 * @author Andres
 */
public class Cantidad {
    private int idCantidad;
    private String nombre;
    private float descuento;
    
    public Cantidad() {
        this(0,null,0);
    }
    
    public Cantidad(int idCantidad,String nombre,  float descuento) {
        this.idCantidad = idCantidad;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    /**
     * @return the id
     */
    public int getIdCantidad() {
        return idCantidad;
    }

    /**
     * @param id the id to set
     */
    public void setIdCantidad(int idCantidad) {
        this.idCantidad = idCantidad;
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
