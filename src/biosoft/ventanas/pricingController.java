package biosoft.ventanas;

import biosoft.BaseDatos.ControladorBaseDatosFx;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Wayne
 */
public class pricingController implements Initializable {

    @FXML
    private CheckBox clienteImportante;

    @FXML
    private CheckBox DEV_Bidones;

    @FXML
    private CheckBox contratoDeAprov;

    @FXML
    private ComboBox<?> tipoProducto;

    @FXML
    private ComboBox<?> nombre;

    @FXML
    private ComboBox<?> origenMercaderia;

    @FXML
    private ComboBox<?> plazoPago;

    @FXML
    private ComboBox<?> cantidad;

    @FXML
    private ComboBox<?> tiempoEntrega;

    @FXML
    private ComboBox<?> lugarEntrega;

    @FXML
    private Label precioAnterior;

    @FXML
    private Label monto;
    
    public pricingController() {
    }

     @Override
    public void initialize(URL url, ResourceBundle rb) {
       ControladorBaseDatosFx ct = new ControladorBaseDatosFx();
       
       
       
    }
    
    //Metodo para mostrar la ventana de acceso denegado
    public void accesoDenegado(ActionEvent event) throws IOException {

        System.out.println("Acceso Denegado!!");
        //Cargo el fxml de la ventana de carga
        FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("userDenegado.fxml"));
        Parent root3 = (Parent) FXMLLoader.load();
        Stage stage3 = new Stage();
        stage3.initStyle(StageStyle.UNDECORATED);
        stage3.centerOnScreen();
        stage3.setTitle("Acceso Denegado!");
        stage3.setScene(new Scene(root3));
        stage3.show();
    }
    
    //Metodo para limpiar registros
     private void limpiar() {
        clienteImportante.setSelected(false);
        DEV_Bidones.setSelected(false);
        contratoDeAprov.setSelected(false);
         
        tipoProducto.setValue(null);
        nombre.setValue(null);
        origenMercaderia.setValue(null);
        plazoPago.setValue(null);
        cantidad.setValue(null);
        tiempoEntrega.setValue(null);
        lugarEntrega.setValue(null);
        
        precioAnterior.setText("");
        monto.setText("");
    }
    
     
     
     
    //Pestañas
    @FXML
    private void apretarStock(ActionEvent event) throws IOException {
        pricingController cn = new pricingController();
        cn.accesoDenegado(event);
    }
    @FXML
    private void apretarBookin(ActionEvent event) throws IOException {
        pricingController cn = new pricingController();
        cn.accesoDenegado(event);
    }
    @FXML
    private void apretarFinance(ActionEvent event) throws IOException {
        pricingController cn = new pricingController();
        cn.accesoDenegado(event);
    }
    @FXML
    private void apretarCobranza(ActionEvent event) throws IOException {
        pricingController cn = new pricingController();
        cn.accesoDenegado(event);
    }
    @FXML
    private void apretarPagos(ActionEvent event) throws IOException {
        pricingController cn = new pricingController();
        cn.accesoDenegado(event);
    }
    @FXML
    private void apretarContabilidad(ActionEvent event) throws IOException {
        pricingController cn = new pricingController();
        cn.accesoDenegado(event);
    }
    @FXML
    private void apretarCrm(ActionEvent event) throws IOException {
        pricingController cn = new pricingController();
        cn.accesoDenegado(event);
    }
    
    //Botones inferiores
    //Boton Realizar otra venta o presupuesto
    @FXML
    private void apretarRealizarOtra(ActionEvent event){
        //Aca deberia guardar lo ingresado en algun lado, limpiar la pantalla y asi poder ingresar otros datos
    }
    //Boton finalizar
    @FXML
    private void apretarFinalizar(ActionEvent event){
        //Y aca nose, guardar o tirar para que imprima el precio o algo asi.
        //CHARLARRR
        //!!!
    }
    //Boton Cancelar
    @FXML
    private void apretarCancelar(ActionEvent event) throws IOException {
//        Aqui va el metodo limpiar
         
    }
    

}
