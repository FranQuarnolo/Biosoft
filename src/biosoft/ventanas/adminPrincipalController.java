package biosoft.ventanas;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Wayne
 */
public class adminPrincipalController {

    public adminPrincipalController() {
    }
    
    
    
    
    @FXML
    private void apretarAgregar(ActionEvent event){
         try {
            //Cargo el archivo fxml de la ventana de registro
            FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("adminNuevo.fxml"));
            Parent root8 = (Parent) FXMLLoader3.load();
            Stage nuevo = new Stage();
            nuevo.setScene(new Scene(root8));

            //La hago bonita
//            modificar.getIcons().add(new Image("file:src/imagenes/registro.png"));
            nuevo.setTitle("Nuevo");
            nuevo.initStyle(StageStyle.UNDECORATED);
            System.out.println("Iniciando la ventana de agregar nuevo...");
            //Inicio la ventana
            nuevo.show();
    

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void apretarModificar(ActionEvent event){
        try {
            //Cargo el archivo fxml de la ventana de registro
            FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("adminModificar.fxml"));
            Parent root2 = (Parent) FXMLLoader3.load();
            Stage modificar = new Stage();
            modificar.setScene(new Scene(root2));

            //La hago bonita
//            modificar.getIcons().add(new Image("file:src/imagenes/registro.png"));
            modificar.setTitle("Modificacion");
            modificar.initStyle(StageStyle.UNDECORATED);
            System.out.println("Iniciando la ventana de modificacion...");
            //Inicio la ventana
            modificar.show();
    

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
//Boton Cerrar Sesion
    @FXML
    private void apretarCerrarSesion(ActionEvent event) throws IOException{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("Cerrando ventana de administrador");
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
    }
}
