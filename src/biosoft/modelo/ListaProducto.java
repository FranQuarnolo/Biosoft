
package biosoft.modelo;

import java.util.ArrayList;


public class ListaProducto {
    private ArrayList listaProducto;
    private Producto producto;

    public ListaProducto(ArrayList listaProducto) {
        this.listaProducto = listaProducto;
    }

    public ArrayList getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ArrayList listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    
}
