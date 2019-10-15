/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosoft.ventanas;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Wayne
 */
public class pricingController {

    public pricingController() {
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
    
    
    
    
    @FXML
    private void apretarCancelar(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root5 = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root5);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        appStage.setScene(scene);   
//      appStage.toFront().;
        appStage.show();
         
    }

}
