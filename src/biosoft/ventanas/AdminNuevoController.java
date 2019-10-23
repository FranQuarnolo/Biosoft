
package biosoft.ventanas;

import biosoft.modelo.ControladorProducto;
import biosoft.modelo.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author Wayne
 */
public class AdminNuevoController {
    
    @FXML
    private TextField tNombre;
    @FXML
    private TextField tTipo;   
    
    ControladorProducto controladorProducto = new ControladorProducto();
    Producto producto = new Producto();
    @FXML
    private void apretarSalir(ActionEvent event){
        System.exit(0); 
    }
    
    @FXML
    private void apretarNuevo(ActionEvent event){
        if (siEsInvalido()) {
            try{
           
               // producto.setDni(Integer.parseInt(tDni.getText()));
                producto.setNombre(tNombre.getText());                
                producto.setTipo(tTipo.getText());
                
                controladorProducto.insertarSQL(producto);
                
            }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Esta ingresando valores no numericos en campos numericos\n "+e); 
            }
        }
    }
    
      public boolean siEsInvalido() {
        String errorMessage = "";

        if (tNombre.getText() == null || tNombre.getText().length() == 0) {
            errorMessage += "Nombre no valido!\n";
        }
        if (tTipo.getText() == null || tTipo.getText().length() == 0) {
            errorMessage += "Tipo Invalido!\n";
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Muestra el mensaje de error
            Dialogs.create()
                .title("Campo invalido")
                .masthead("Revise los campos invalidos")
                .message(errorMessage)
                .showError();
            return false;
        }
    }
}
