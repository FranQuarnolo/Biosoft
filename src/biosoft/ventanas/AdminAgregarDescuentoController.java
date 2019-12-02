package biosoft.ventanas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Wayne
 */
public class AdminAgregarDescuentoController implements Initializable {

    @FXML
    private TextField tipoDesc;
    @FXML
    private TextField montoDesc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void apretarGuardar(ActionEvent event) {
    }

    @FXML
    private void apretarVolver(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("Cerrando ventana de agregar Descuento");
    }
    
}
