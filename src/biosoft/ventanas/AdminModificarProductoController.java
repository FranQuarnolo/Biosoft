package biosoft.ventanas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

/**
 *
 * @author Wayne
 */
public class AdminModificarProductoController {
    
    
    
    
    @FXML
    private void apretarSalir(ActionEvent event){
         ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
