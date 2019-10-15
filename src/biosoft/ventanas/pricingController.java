/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosoft.ventanas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Wayne
 */
public class pricingController  {

    public pricingController() {
    }

    
    //Declaro botones
    @FXML
    private Button btnstock;
    @FXML
    private Button btnbooking;
    @FXML
    private Button btnfinance;
    @FXML
    private Button btncobranza;
    @FXML
    private Button btnpagos;
    @FXML
    private Button btncontabilidad;
    @FXML
    private Button btncrm;

    //Metodo para mostrar la ventana de acceso denegado
    public void accesoDenegado(ActionEvent event) throws IOException {
        
        System.out.println("Acceso Denegado!!");
        //Cargo el fxml de la ventana de carga
        FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("userDenegado.fxml"));
        Parent root3 = (Parent) FXMLLoader.load();
        Stage stage3 = new Stage();

        stage3.initStyle(StageStyle.UNDECORATED);
        stage3.setTitle("Acceso Denegado!");
        stage3.setScene(new Scene(root3));

        stage3.show();
    }

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
    

   

}
