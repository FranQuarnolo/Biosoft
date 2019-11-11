
package biosoft.ventanas;

import biosoft.modelo.Cantidad;
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
    
    @FXML
    private void apretarVolver(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
}
