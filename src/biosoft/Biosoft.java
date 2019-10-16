package biosoft;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import biosoft.ventanas.LoginController;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

/**
 *
 * @author Wayne
 */
public class Biosoft extends Application {
    /////
    private Stage ventana;
    public Biosoft(){
    }
    
    //Inicia
    @Override
    public void start(Stage ventanaPrincipal){
        this.ventana = ventanaPrincipal;
        this.ventana.setTitle("BIOSANO");
        System.out.println("La aplicacion se inicio correctamente");
        System.out.println("Abriendo Login...");
        //ABRE LA APP
        mostrarLogin();
        System.out.println("Login abierto correctamente!");
        System.out.println("Bienvenido");
    }

    public void mostrarLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Biosoft.class.getResource("ventanas/Login.fxml"));
            AnchorPane login = (AnchorPane) loader.load();
            Scene scene = new Scene(login);
            ventana.setScene(scene);
            //Lo hago bonito
            ventana.initStyle(StageStyle.UNDECORATED);
            ventana.getIcons().add(new Image("file:images/logo2.png"));
            ventana.setTitle("BioSano.S.A - LogIn");
            
            LoginController controlador = loader.getController();
            controlador.setMiApp(this);
            
            ventana.show();

        } catch (IOException e) {
             e.printStackTrace();
        }
    }
    
   
    public void esperar() throws InterruptedException{
        Thread.sleep(900);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
