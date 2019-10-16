
package biosoft.modelo;

import java.util.ArrayList;


public class ListaProducto {
    private ArrayList listaProducto;
    private Producto producto;

    public ListaProducto(ArrayList listaProducto, Producto producto) {
        this.listaProducto = listaProducto;
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    public ArrayList getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ArrayList listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    
}
