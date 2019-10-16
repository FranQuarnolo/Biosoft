
package biosoft.modelo;

import java.util.Date;


public class Venta {
    private int idVenta;
    private float total;
    private Date fecha;
    private DetalleVenta detalleVenta;

    public Venta(int idVenta, float total, Date fecha, DetalleVenta detalleVenta) {
        this.idVenta = idVenta;
        this.total = total;
        this.fecha = fecha;
        this.detalleVenta = detalleVenta;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

   
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
}
