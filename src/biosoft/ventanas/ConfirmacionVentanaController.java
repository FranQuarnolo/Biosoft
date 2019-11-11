package biosoft.ventanas;

import biosoft.modelo.ControladorProducto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;


/**
 *
 * @author Wayne
 */
public class ConfirmacionVentanaController {

    int indice=-1;
    @FXML
    private Button btnSi;
    
   

    public ConfirmacionVentanaController() {
    }

    //Metodo para obtener el id de Producto seleccionado
    
    public void eliminarSeleccionado(int idProd){
       //Recibe el indice q lo manda a la accion presionarSi
        this.indice = idProd;

 
    }  
    
    //Boton presionar si
    @FXML
    public void presionarSi(ActionEvent event) {
       ControladorProducto control = new ControladorProducto();
       control.borrarDatos(indice);
 
                
        System.out.println("Eliminando...");
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        ConfirmacionVentanaController sd = new ConfirmacionVentanaController();
        
        
    }

    //Boton cancelar
    @FXML
    private void presionarCancelar(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
