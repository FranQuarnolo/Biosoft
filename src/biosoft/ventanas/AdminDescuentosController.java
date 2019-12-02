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
import javafx.scene.control.TextField;
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
    
    @FXML
    private TextField clienteImportante;
    @FXML
    private TextField devolucion;
    @FXML
    private TextField contrato;
    

    public AdminDescuentosController() {

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
        
        
        //Aca carga los descuentos de los Check
        clienteImportante.setText(Float.toString(db.descuentoClienteImpor(db.getConexion())));
        devolucion.setText(Float.toString(db.descuentoDevolBidones(db.getConexion())));
        contrato.setText(Float.toString(db.descuentoContratoAprov(db.getConexion())));
    }
    
    public void actualizar(){
            
                    listaCant.getItems().clear();
                    ControladorBaseDatosFx db = new ControladorBaseDatosFx();
                    db.llenarCantidad(db.getConexion(), listaCantidad);
                    listaCant.setItems(listaCantidad);
                
                    listaDest.getItems().clear();
                    ControladorBaseDatosFx db1 = new ControladorBaseDatosFx();
                    db1.llenarDestino(db1.getConexion(), listaDestino);
                    listaDest.setItems(listaDestino);
                
                
                    listaOrig.getItems().clear();
                    ControladorBaseDatosFx db2 = new ControladorBaseDatosFx();
                    db2.llenarOrigen(db2.getConexion(), listaOrigen);
                    listaOrig.setItems(listaOrigen);
                
                
                    listaTiempo.getItems().clear();
                    ControladorBaseDatosFx db3 = new ControladorBaseDatosFx();
                    db3.llenarTiempoEntrega(db3.getConexion(), listaTiempoEntrega);
                    listaTiempo.setItems(listaTiempoEntrega);
                
                
                    listaPlazo.getItems().clear();
                    ControladorBaseDatosFx db4 = new ControladorBaseDatosFx();
                    db4.llenarPlazoPago(db4.getConexion(), listaPlazoPago);
                    listaPlazo.setItems(listaPlazoPago);
            
    }
    
    //Boton Editar
    @FXML
    private void apretarEditar(ActionEvent event) {
        try {
            int VerificadorDeDescuento = 0;
            if (listaCant.getSelectionModel().getSelectedItem() != null) {
                VerificadorDeDescuento = 1;

            } else if (listaDest.getSelectionModel().getSelectedItem() != null) {
                VerificadorDeDescuento = 2;

            } else if (listaOrig.getSelectionModel().getSelectedItem() != null) {
                VerificadorDeDescuento = 3;

            } else if (listaTiempo.getSelectionModel().getSelectedItem() != null) {
                VerificadorDeDescuento = 4;

            } else if (listaPlazo.getSelectionModel().getSelectedItem() != null) {
                VerificadorDeDescuento = 5;
            }else{
                 try {
                    //Cargo el archivo fxml
                    FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("SeleccioneElemento.fxml"));
                    Parent root8 = (Parent) FXMLLoader3.load();
                    Stage seleccion = new Stage();
                    seleccion.setScene(new Scene(root8));
                    seleccion.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/alert1.png")));
                    seleccion.setTitle("No Seleccion!");
                    seleccion.initStyle(StageStyle.UNDECORATED);
                    seleccion.initModality(Modality.APPLICATION_MODAL);
                    System.out.println("Seleccione un elemento por favor");
                    //Inicio la ventana
                    seleccion.showAndWait();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println(VerificadorDeDescuento);
            if(VerificadorDeDescuento!=0){
                
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
            AdminEditarDescuentosController editarDes = FXMLLoader7.getController();
            switch (VerificadorDeDescuento) {
                case 1:
                    
                    editarDes.MetodoCantidad(listaCant.getSelectionModel().getSelectedItem());
                    listaCant.getItems().clear();
                    ControladorBaseDatosFx db = new ControladorBaseDatosFx();
                    db.llenarCantidad(db.getConexion(), listaCantidad);
                    listaCant.setItems(listaCantidad);
                    break;
                case 2:
                    editarDes.MetodoDestino(listaDest.getSelectionModel().getSelectedItem());
                    listaDest.getItems().clear();
                    ControladorBaseDatosFx db1 = new ControladorBaseDatosFx();
                    db1.llenarDestino(db1.getConexion(), listaDestino);
                    listaDest.setItems(listaDestino);
                    break;
                case 3:
                    editarDes.MetodoOrigen(listaOrig.getSelectionModel().getSelectedItem());
                    listaOrig.getItems().clear();
                    ControladorBaseDatosFx db2 = new ControladorBaseDatosFx();
                    db2.llenarOrigen(db2.getConexion(), listaOrigen);
                    listaOrig.setItems(listaOrigen);
                    break;
                case 4:
                    editarDes.MetodoTiempoEntrega(listaTiempo.getSelectionModel().getSelectedItem());
                    listaTiempo.getItems().clear();
                    ControladorBaseDatosFx db3 = new ControladorBaseDatosFx();
                    db3.llenarTiempoEntrega(db3.getConexion(), listaTiempoEntrega);
                    listaTiempo.setItems(listaTiempoEntrega);
                    break;
                case 5:
                    editarDes.MetodoPlazoPago(listaPlazo.getSelectionModel().getSelectedItem());
                    listaPlazo.getItems().clear();
                    ControladorBaseDatosFx db4 = new ControladorBaseDatosFx();
                    db4.llenarPlazoPago(db4.getConexion(), listaPlazoPago);
                    listaPlazo.setItems(listaPlazoPago);
                    break;
            }
            editar.showAndWait();
            actualizar();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
