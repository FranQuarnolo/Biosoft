package biosoft.ventanas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author Wayne
 */
public class seleccioneElementoController  {

   @FXML
    private void apretarOK(ActionEvent event){
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    
}
