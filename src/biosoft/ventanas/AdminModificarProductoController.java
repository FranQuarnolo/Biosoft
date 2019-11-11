package biosoft.ventanas;

import biosoft.modelo.ControladorProducto;
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
    public void initialize(Producto product) {
         this.producto = product;
         
         
        try{
            System.out.println(producto.getNombre());
            System.out.println(producto.getTipo());
            System.out.println(producto.getPrecio());
            tTipo.setText(producto.getTipo());
            System.out.println("1");
            tNombre.setText(producto.getNombre());
            tPrecio.setText(Float.toString(producto.getPrecio()));

        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
    
    @FXML
    private void apretarSalir(ActionEvent event){
         ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
     @FXML
    private void apretarGuardar(ActionEvent event){
         System.out.println("iniciando guardado");
         Producto prod = new Producto();
         prod.setIdProd(producto.getIdProd());
         prod.setNombre(tNombre.getText());
         prod.setTipo(tTipo.getText());
         prod.setPrecio(Float.parseFloat(tPrecio.getText()));
         ControladorProducto controlP = new ControladorProducto();
         controlP.actualizarSQL(prod);
         ((Node) (event.getSource())).getScene().getWindow().hide();
         
    }
    
    
}
