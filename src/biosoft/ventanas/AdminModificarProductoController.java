package biosoft.ventanas;

import biosoft.modelo.Producto;
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
    private TextField tNombre;
    @FXML
    private TextField tTipo;
    @FXML
    private TextField tPrecio;
    
    private Producto producto;
    
    
    
    @FXML
    public void initialize(Producto producto) {
         this.producto = producto;
         String a = producto.getNombre();
        try{
            
            System.out.println(a);
            tTipo.setText(producto.getTipo());
            System.out.println("1");
            tNombre.setText(producto.getNombre());
            tPrecio.setPromptText(Float.toString(producto.getPrecio()));
            
        
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    @FXML
    private void apretarSalir(ActionEvent event){
         ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
