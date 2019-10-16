package biosoft.ventanas;

import biosoft.BaseDatos.ControladorBaseDatosFx;
import biosoft.modelo.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 *
 * @author Wayne
 */
public class confirmacionVentanaController {

    @FXML
    private Button btnSi;
    
    
    
    public confirmacionVentanaController() {
    }
    
    
    @FXML
    private void presionarSi(ActionEvent event) {
        int resultadoBusqueda = 0;
        ControladorBaseDatosFx control = new ControladorBaseDatosFx();
        
        System.out.println("Eliminando...");
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
           
    }
    
    //Boton cancelar
    @FXML
    private void presionarCancelar(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    

}
