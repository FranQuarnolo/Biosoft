
package biosoft.ventanas;

import biosoft.modelo.Cantidad;
import biosoft.modelo.ControladorCantidad;
import biosoft.modelo.ControladorDestino;
import biosoft.modelo.ControladorOrigen;
import biosoft.modelo.ControladorPlazoPago;
import biosoft.modelo.ControladorTiempoEntrega;
import biosoft.modelo.Destino;
import biosoft.modelo.Origen;
import biosoft.modelo.PlazoPago;
import biosoft.modelo.TiempoEntrega;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author Wayne
 */
public class AdminEditarDescuentosController  {
    private Cantidad cantidad;
    private Destino destino;
    private Origen origen;
    private TiempoEntrega tiempoEntrega;
    private PlazoPago plazoPago;
    @FXML
    private TextField tNombre;
    @FXML
    private TextField tMonto;

   @FXML
    public void MetodoCantidad(Cantidad cant) {
        this.cantidad = cant;
        try{
            System.out.println("1");
            tNombre.setText(cantidad.getNombre());
            tMonto.setText(Float.toString(cantidad.getDescuento()));
        } catch (Exception e) {
            System.out.println(e); 
        }
    }
    
    @FXML
    public void MetodoDestino(Destino dest) {
        this.destino = dest;
        try{
            System.out.println("1");
            tNombre.setText(destino.getNombre());
            tMonto.setText(Float.toString(destino.getDescuento()));
        } catch (Exception e) {
            System.out.println(e); 
        }
    }
    
    @FXML
    public void MetodoOrigen(Origen orig) {
        this.origen = orig;
        try{
            System.out.println("1");
            tNombre.setText(origen.getNombre());
            tMonto.setText(Float.toString(origen.getDescuento()));
        } catch (Exception e) {
            System.out.println(e); 
        }
    }
    
    @FXML
    public void MetodoTiempoEntrega(TiempoEntrega tiempoEnt) {
        this.tiempoEntrega = tiempoEnt;
        try{
            System.out.println("1");
            tNombre.setText(tiempoEntrega.getNombre());
            tMonto.setText(Float.toString(tiempoEntrega.getDescuento()));
        } catch (Exception e) {
            System.out.println(e); 
        }
    }
    
    @FXML
    public void MetodoPlazoPago(PlazoPago plazoPag) {
        this.plazoPago = plazoPag;
        try{
            System.out.println("1");
            tNombre.setText(plazoPago.getNombre());
            tMonto.setText(Float.toString(plazoPago.getDescuento()));
        } catch (Exception e) {
            System.out.println(e); 
        }
    }
    
    //Boton Guardar
    @FXML
    private void apretarGuardar(ActionEvent event){
        System.out.println("Guardando");
        ((Node) (event.getSource())).getScene().getWindow().hide();
        if(cantidad!=null){
            System.out.println(" cantidad");
            ControladorCantidad controlCant = new ControladorCantidad();
            cantidad.setNombre(tNombre.getText());
            cantidad.setDescuento(Float.parseFloat(tMonto.getText()));
            controlCant.actualizarSQL(cantidad);
        }else if(destino!=null){
            System.out.println("destino");
            ControladorDestino controlDestino = new ControladorDestino();
            destino.setNombre(tNombre.getText());
            destino.setDescuento(Float.parseFloat(tMonto.getText()));
            controlDestino.actualizarSQL(destino);
        }else if(origen!=null){
            System.out.println("origen");
            ControladorOrigen controlOrigen = new ControladorOrigen();
            origen.setNombre(tNombre.getText());
            origen.setDescuento(Float.parseFloat(tMonto.getText()));
            controlOrigen.actualizarSQL(origen);
        }else if(tiempoEntrega!=null){
            System.out.println("Tiempo Entrega");
            ControladorTiempoEntrega controlTiempoEntrega = new ControladorTiempoEntrega();
            tiempoEntrega.setNombre(tNombre.getText());
            tiempoEntrega.setDescuento(Float.parseFloat(tMonto.getText()));
            controlTiempoEntrega.actualizarSQL(tiempoEntrega);
        }else if(plazoPago!=null){
            System.out.println("Plazo Pago");
            ControladorPlazoPago controlPlazoPago = new ControladorPlazoPago();
            plazoPago.setNombre(tNombre.getText());
            plazoPago.setDescuento(Float.parseFloat(tMonto.getText()));
            controlPlazoPago.actualizarSQL(plazoPago);
        }
 
    }
    
    //Boton volver
     @FXML
    private void apretarVolver(ActionEvent event) {
      
            ((Node) (event.getSource())).getScene().getWindow().hide();
           
    }
    
}
