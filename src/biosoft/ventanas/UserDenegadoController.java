package biosoft.ventanas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Wayne
 */
public class UserDenegadoController  {

    @FXML
    private Button btnaceptar;
    
    
    @FXML
    private void apretarAceptar(ActionEvent event){
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    

    
}
