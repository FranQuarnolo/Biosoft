
package biosoft.modelo;


public class DetalleVenta {
    private int idDetalleVenta;
    private int idProducto;
    private int idVenta;
    private int cantidad;
    private int tiempoEntrega;
    private String origenMercaderia;
    private String lugarEntrega;
    private String plazoPago;
    private boolean clienteImportante;
    private boolean DEV_Bidones;
    private boolean contratoDeAprov;

    public DetalleVenta(int idDetalleVenta, int idProducto, int idVenta, int cantidad, int tiempoEntrega, String origenMercaderia, String lugarEntrega, String plazoPago, boolean clienteImportante, boolean DEV_Bidones, boolean contratoDeAprov) {
        this.idDetalleVenta = idDetalleVenta;
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.tiempoEntrega = tiempoEntrega;
        this.origenMercaderia = origenMercaderia;
        this.lugarEntrega = lugarEntrega;
        this.plazoPago = plazoPago;
        this.clienteImportante = clienteImportante;
        this.DEV_Bidones = DEV_Bidones;
        this.contratoDeAprov = contratoDeAprov;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(int tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public String getOrigenMercaderia() {
        return origenMercaderia;
    }

    public void setOrigenMercaderia(String origenMercaderia) {
        this.origenMercaderia = origenMercaderia;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    public String getPlazoPago() {
        return plazoPago;
    }

    public void setPlazoPago(String plazoPago) {
        this.plazoPago = plazoPago;
    }

    public boolean isClienteImportante() {
        return clienteImportante;
    }

    public void setClienteImportante(boolean clienteImportante) {
        this.clienteImportante = clienteImportante;
    }

    public boolean isDEV_Bidones() {
        return DEV_Bidones;
    }

    public void setDEV_Bidones(boolean DEV_Bidones) {
        this.DEV_Bidones = DEV_Bidones;
    }

    public boolean isContratoDeAprov() {
        return contratoDeAprov;
    }

    public void setContratoDeAprov(boolean contratoDeAprov) {
        this.contratoDeAprov = contratoDeAprov;
    }
    
    
}
