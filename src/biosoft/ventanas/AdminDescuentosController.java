package biosoft.ventanas;

import biosoft.BaseDatos.ControladorBaseDatosFx;
import biosoft.modelo.Cantidad;
import biosoft.modelo.Destino;
import biosoft.modelo.Origen;
import biosoft.modelo.PlazoPago;
import biosoft.modelo.TiempoEntrega;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Wayne
 */
public class AdminDescuentosController extends ControladorBaseDatosFx implements Initializable {

    //Declaraciones Lista Cantidad
    @FXML
    private TableView<Cantidad> listaCant;
    @FXML
    private TableColumn<Cantidad, Integer> idCant;
    @FXML
    private TableColumn<Cantidad, String> nombreCant;
    @FXML
    private TableColumn<Cantidad, String> descuentoCant;
    
    //Declaraciones Lista Destino
    @FXML
    private TableView<Destino> listaDest;
    @FXML
    private TableColumn<Destino, Integer> idDest;
    @FXML
    private TableColumn<Destino, String> nombreDest;
    @FXML
    private TableColumn<Destino, String> descuentoDest;
    
    //Declaraciones Lista Origen
    @FXML
    private TableView<Origen> listaOrig;
    @FXML
    private TableColumn<Origen, Integer> idOrig;
    @FXML
    private TableColumn<Origen, String> nombreOrig;
    @FXML
    private TableColumn<Origen, String> descuentoOrig;
    
    //Declaraciones Lista TiempoEntrega
    @FXML
    private TableView<TiempoEntrega> listaTiempo;
    @FXML
    private TableColumn<TiempoEntrega, Integer> idTiempoEntrega;
    @FXML
    private TableColumn<TiempoEntrega, String> nombreTiempoEntrega;
    @FXML
    private TableColumn<TiempoEntrega, String> descuentoTiempoEntrega;
    
    //Declaraciones Lista Plazo de Pago
    @FXML
    private TableView<PlazoPago> listaPlazo;
    @FXML
    private TableColumn<PlazoPago, Integer> idPlazo;
    @FXML
    private TableColumn<PlazoPago, String> nombrePlazo;
    @FXML
    private TableColumn<PlazoPago, String> descuentoPlazo;
    
    private ObservableList<Cantidad> listaCantidad;
    private ObservableList<Destino> listaDestino;
    private ObservableList<Origen> listaOrigen;
    private ObservableList<TiempoEntrega> listaTiempoEntrega;
    private ObservableList<PlazoPago> listaPlazoPago;
    
    public AdminDescuentosController(){
        
    }
    //INICIALIZANDO CAMPOS
    @Override
    public void initialize(URL location, ResourceBundle rb) {
        //Aca carga los de la lista de CANTIDAD
        listaCantidad = FXCollections.observableArrayList();
        ControladorBaseDatosFx db = new ControladorBaseDatosFx();
        db.llenarCantidad(db.getConexion(), listaCantidad);
        listaCant.setItems(listaCantidad);
        idCant.setCellValueFactory(new PropertyValueFactory<>("idCantidad"));
        nombreCant.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descuentoCant.setCellValueFactory(new PropertyValueFactory<>("descuento"));
        
        //Aca carga los de la lista de DESTINO
        listaDestino = FXCollections.observableArrayList();
        db.llenarDestino(db.getConexion(), listaDestino);
        listaDest.setItems(listaDestino);
        idDest.setCellValueFactory(new PropertyValueFactory<>("idDestino"));
        nombreDest.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descuentoDest.setCellValueFactory(new PropertyValueFactory<>("descuento"));
        
        //Aca carga los de la lista de ORIGEN
        listaOrigen = FXCollections.observableArrayList();
        db.llenarOrigen(db.getConexion(), listaOrigen);
        listaOrig.setItems(listaOrigen);
        idOrig.setCellValueFactory(new PropertyValueFactory<>("idOrigen"));
        nombreOrig.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descuentoOrig.setCellValueFactory(new PropertyValueFactory<>("descuento"));
        
        //Aca carga los de la lista de TIEMPO DE ENTREGA
        listaTiempoEntrega = FXCollections.observableArrayList();
        db.llenarTiempoEntrega(db.getConexion(), listaTiempoEntrega);
        listaTiempo.setItems(listaTiempoEntrega);
        idTiempoEntrega.setCellValueFactory(new PropertyValueFactory<>("idTiempodeEntrega"));
        nombreTiempoEntrega.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descuentoTiempoEntrega.setCellValueFactory(new PropertyValueFactory<>("descuento"));
        
         //Aca carga los de la lista de PLAZO DE PAGO
        listaPlazoPago = FXCollections.observableArrayList();
        db.llenarPlazoPago(db.getConexion(), listaPlazoPago);
        listaPlazo.setItems(listaPlazoPago);
        idPlazo.setCellValueFactory(new PropertyValueFactory<>("idPlazoDePago"));
        nombrePlazo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descuentoPlazo.setCellValueFactory(new PropertyValueFactory<>("descuento"));
    }
    
    //Metodo para abrir ventana editar
    public void ventanaEditar (ActionEvent event){
         try {
            //Cargo el archivo fxml
            FXMLLoader FXMLLoader7 = new FXMLLoader(getClass().getResource("AdminEditarDescuentos.fxml"));
            Parent root8 = (Parent) FXMLLoader7.load();
            Stage editar = new Stage();
            editar.setScene(new Scene(root8));
            editar.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/edit.png")));
            editar.setTitle("Editar");
            editar.initStyle(StageStyle.UNDECORATED);
            editar.initModality(Modality.APPLICATION_MODAL);
            System.out.println("Editando campo seleccionado");
            //Inicio la ventana
            editar.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Boton Editar
    @FXML
    private void apretarEditar(ActionEvent event) {
        System.out.println("Hola me apretaste");
//        AdminDescuentosController adc = new AdminDescuentosController();
//        adc.apretarEditar(event);
    }

//Boton Cerrar Sesion
    @FXML
    private void apretarAtras(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("Cerrando ventana de administrador");
        Parent root = FXMLLoader.load(getClass().getResource("AdminPrincipal.fxml"));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
    }

}
