package biosoft.ventanas;

import biosoft.BaseDatos.ControladorBaseDatosFx;
import biosoft.Biosoft;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author Wayne
 */
public class loginController extends ControladorBaseDatosFx {
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contrasena;
    
    private Biosoft app;
    @FXML
    private Button loginboton;

    //Constructor
    public loginController() {

    }

    public void setMiApp(Biosoft app) {
        this.app = app;
    }

    //Apretar boton Login
    @FXML
    private void apretarLogin(javafx.event.ActionEvent event) throws IOException, Exception {
        ControladorBaseDatosFx control = new ControladorBaseDatosFx();
        System.out.println("Login presionado!");
        
        if(control.login(usuario.getText(), contrasena.getText())==1){
            //Que es esto???
            System.out.println("Abrir Ventana de ROOT");
        }
         //Si el usuario no ingresa nada
        if (usuario.getText().equals("") && contrasena.getText().equals("")) {
            FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("noIngresaNada.fxml"));
            Parent root4 = (Parent) FXMLLoader.load();
            Stage stage4 = new Stage();

            stage4.initModality(Modality.APPLICATION_MODAL);
            stage4.initStyle(StageStyle.UNDECORATED);

            stage4.setTitle("Precaucion...");
            stage4.setScene(new Scene(root4));

            stage4.show();
            System.out.println("Ingresar usuario y contraseña por favor");}
        else{
        try {
            //Cierro la ventana de login
            ((Node) (event.getSource())).getScene().getWindow().hide();
            System.out.println("Cargando...");
            //Cargo el fxml de la ventana de carga
            FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("pantallaCarga.fxml"));
            Parent root1 = (Parent) FXMLLoader.load();
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.getIcons().add(new Image("file:images/load.png"));

            stage.setTitle("Cargando...");
            stage.setScene(new Scene(root1));

            stage.show();

            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    stage.hide();
                    try {
                        System.out.println("Ya espere");
                        //Cargo el fxml de la ventana de carga
                        FXMLLoader FXMLLoader2 = new FXMLLoader(getClass().getResource("pricing.fxml"));
                        Parent root2 = (Parent) FXMLLoader2.load();
                        Stage stage2 = new Stage();

                        stage2.initModality(Modality.APPLICATION_MODAL);

                        stage2.getIcons().add(new Image("file:biosoft/images/load.png"));
                        stage2.setTitle("Pricing");
                        stage2.setScene(new Scene(root2));
                        stage2.show();

                    } catch (IOException ex) {
                        Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
            new Thread(sleeper).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
    //Apretar boton salir
    @FXML
    private void apretarSalir(ActionEvent event) {
        System.out.println("Saliendo...");
        System.out.println("Gracias por utilizar nuestros servicios!");
        System.out.println("Adios!");
        System.exit(0);
    }
}
