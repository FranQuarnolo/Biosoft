package biosoft.ventanas;

import biosoft.BaseDatos.ControladorBaseDatosFx;
import biosoft.modelo.Cantidad;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Wayne
 */
public class AdminDescuentosController extends ControladorBaseDatosFx implements Initializable {
    
    @FXML
    private TableView<Cantidad> listaCant;
    @FXML
    private TableColumn<Cantidad, Integer> idCant;
    @FXML
    private TableColumn<Cantidad, String> nombre;
    @FXML
    private TableColumn<Cantidad, String> descuentoCant;
    
    private ObservableList<Cantidad> listaCantidad;
    
    
    @Override
    public void initialize(URL location, ResourceBundle rb) {
        System.out.println("estoy aca");
        listaCantidad = FXCollections.observableArrayList();
        ControladorBaseDatosFx db = new ControladorBaseDatosFx();
        db.llenarCantidad(db.getConexion(), listaCantidad);
        listaCant.setItems(listaCantidad);
//        idCant.setCellValueFactory(new PropertyValueFactory<>("idCantidad"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descuentoCant.setCellValueFactory(new PropertyValueFactory<>("descuento"));
      //  System.out.println(idCant.getText());
    }
    
    
    //Boton Cerrar Sesion
    @FXML
    private void apretarAtras(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("Cerrando ventana de administrador");
        Parent root = FXMLLoader.load(getClass().getResource("AdminPrincipal.fxml"));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
    }
    
    
}
