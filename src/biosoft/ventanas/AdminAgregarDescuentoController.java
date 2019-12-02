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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Wayne
 */
public class AdminAgregarDescuentoController implements Initializable {

    @FXML
    private TextField tipoDesc;
    @FXML
    private TextField montoDesc;

    private int identificadorDeDescuento;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void recibirValor(int valor){
        this.identificadorDeDescuento = valor;
    }
    
    @FXML
    private void apretarGuardar(ActionEvent event) {
        switch(identificadorDeDescuento){
            case 1:
              Cantidad cantidad = new  Cantidad();
              cantidad.setNombre(tipoDesc.getText());
              cantidad.setDescuento(Float.parseFloat(montoDesc.getText()));
              ControladorCantidad cc = new ControladorCantidad();
              cc.insertarSQL(cantidad);
              break;
            case 2:
              Destino destino = new  Destino();
              destino.setNombre(tipoDesc.getText());
              destino.setDescuento(Float.parseFloat(montoDesc.getText()));
              ControladorDestino cd = new ControladorDestino();
              cd.insertarSQL(destino);
              break;
            case 3:
              Origen origen = new  Origen();
              origen.setNombre(tipoDesc.getText());
              origen.setDescuento(Float.parseFloat(montoDesc.getText()));
              ControladorOrigen co = new ControladorOrigen();
              co.insertarSQL(origen);
              break;
            case 4:
              TiempoEntrega tiempoEntrega = new  TiempoEntrega();
              tiempoEntrega.setNombre(tipoDesc.getText());
              tiempoEntrega.setDescuento(Float.parseFloat(montoDesc.getText()));
              ControladorTiempoEntrega cte = new ControladorTiempoEntrega();
              cte.insertarSQL(tiempoEntrega);
              break;
            case 5:
              PlazoPago plazoPago = new  PlazoPago();
              plazoPago.setNombre(tipoDesc.getText());
              plazoPago.setDescuento(Float.parseFloat(montoDesc.getText()));
              ControladorPlazoPago cpp = new ControladorPlazoPago();
              cpp.insertarSQL(plazoPago);
              break;
        }
            
         ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void apretarVolver(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("Cerrando ventana de agregar Descuento");
    }
    
}
