package biosoft.ventanas;

import biosoft.modelo.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 *
 * @author Wayne
 */
public class AdminModificarProductoController {
    
    
    @FXML
    private TextField Nombre;
    @FXML
    private TextField Tipo;
    @FXML
    private TextField Precio;
    
    private Producto producto;
    
    @FXML
    public void initialize(Producto producto) {
        this.producto = producto;
        System.out.println(producto.getIdProd()+producto.getNombre());
        try {
            
        Nombre.setText(producto.getNombre());
        Tipo.setText(producto.getTipo());
        Precio.setText(Float.toString(producto.getPrecio()));
        
        } catch (Exception e) {
            System.out.println("error initialize");
        }
    }
    @FXML
    private void apretarSalir(ActionEvent event){
         ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
