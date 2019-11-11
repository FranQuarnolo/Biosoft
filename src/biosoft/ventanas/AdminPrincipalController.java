package biosoft.ventanas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Wayne
 */
public class AdminPrincipalController {

    //Boton Listado Productos 
    @FXML
    private void apretarProductos(ActionEvent event) throws IOException {
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            //Cargo el fxml de la ventana de admin
            FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("AdminProductos.fxml"));
            Parent root2 = (Parent) FXMLLoader3.load();
            Stage stage11 = new Stage();

            stage11.initModality(Modality.APPLICATION_MODAL);
            stage11.initStyle(StageStyle.UNDECORATED);
            stage11.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/logosinletras.png")));
            stage11.setTitle("Administrador");
            stage11.setScene(new Scene(root2));
            stage11.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void apretarDescuentos(ActionEvent event) throws IOException{
         try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            //Cargo el fxml de la ventana de admin
            FXMLLoader FXMLLoader2 = new FXMLLoader(getClass().getResource("AdminDescuentos.fxml"));
            Parent root2 = (Parent) FXMLLoader2.load();
            Stage stage8 = new Stage();

            stage8.initModality(Modality.APPLICATION_MODAL);
            stage8.initStyle(StageStyle.UNDECORATED);
//            stage8.setMaximized(true);
            stage8.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/logosinletras.png")));
            stage8.setTitle("Administrador");
            stage8.setScene(new Scene(root2));
            stage8.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     //Boton Cerrar Sesion
    @FXML
    private void apretarCerrarSesion(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("Cerrando ventana de administrador");
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
    }
      
}
