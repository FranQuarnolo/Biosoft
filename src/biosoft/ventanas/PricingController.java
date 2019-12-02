package biosoft.ventanas;

import biosoft.BaseDatos.ControladorBaseDatosFx;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Wayne
 */
public class PricingController extends ControladorBaseDatosFx implements Initializable {

    ObservableList listaTipoComboBox = FXCollections.observableArrayList();
    ObservableList listaNombreComboBox = FXCollections.observableArrayList();
    ObservableList listaPresentacionComboBox = FXCollections.observableArrayList();
    ObservableList listaOrigenComboBox = FXCollections.observableArrayList();
    ObservableList listaPlazoPagoComboBox = FXCollections.observableArrayList();
    ObservableList listaCantidadComboBox = FXCollections.observableArrayList();
    ObservableList listaTiempoEntregaComboBox = FXCollections.observableArrayList();
    ObservableList listaDestinoComboBox = FXCollections.observableArrayList();
    ControladorBaseDatosFx baseDatos = new ControladorBaseDatosFx();
    @FXML
    private CheckBox clienteImportante;

    @FXML
    private CheckBox DEV_Bidones;

    @FXML
    private CheckBox contratoDeAprov;

    @FXML
    private ComboBox<String> tipoProducto;

    @FXML
    private ComboBox<String> nombre;

    @FXML
    private ComboBox<String> origenMercaderia;

    @FXML
    private ComboBox<String> plazoPago;

    @FXML
    private ComboBox<String> cantidad;

    @FXML
    private ComboBox<String> tiempoEntrega;

    @FXML
    private ComboBox<String> lugarEntrega;
    
    @FXML
    private ComboBox<String> presentacion;

    @FXML
    private Label precioAnterior;

    @FXML
    private Label monto;

    public PricingController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ControladorBaseDatosFx ct = new ControladorBaseDatosFx();

        cargarComboBoxTipo();
        cargarComboBoxOrigen();
        cargarComboBoxPlazoDePago();
        cargarComboBoxCantidad();
        cargarComboBoxTiempoDeEntrega();
        cargarComboBoxDestino();
    }

    //Metodo para cargar el combo box de tipo
    public void cargarComboBoxTipo() {
        listaTipoComboBox.removeAll(listaTipoComboBox);
        ArrayList<String> listaTipo = new ArrayList<String>();
        listaTipo = baseDatos.llenarComboboxTipo(baseDatos.getConexion());
        System.out.println(listaTipo);
        for (int i = 0; i < listaTipo.size(); i++) {
            tipoProducto.getItems().addAll(listaTipo.get(i));
        }

    }

    //Metodo para cargar el combo box de nombre 
    public void cargarComboBoxNombre(ActionEvent event) {
        String selectedTipo = tipoProducto.getSelectionModel().getSelectedItem();

        listaNombreComboBox.removeAll(listaNombreComboBox);
        nombre.getItems().clear();
        ArrayList<String> listaNombre = new ArrayList<String>();
        listaNombre = baseDatos.llenarComboboxNombre(baseDatos.getConexion(), selectedTipo);
        System.out.println(listaNombre);
        for (int i = 0; i < listaNombre.size(); i++) {
            nombre.getItems().addAll(listaNombre.get(i));
        }

    }
    
    //Carga la presentacion
    public void cargarComboBoxPresentacion(ActionEvent event) {
        String selectedTipo = tipoProducto.getSelectionModel().getSelectedItem();
        String selectedNombre = nombre.getSelectionModel().getSelectedItem();

        listaPresentacionComboBox.removeAll(listaPresentacionComboBox);
        presentacion.getItems().clear();
        ArrayList<String> listaNombre = new ArrayList<String>();
        listaNombre = baseDatos.llenarComboboxPresentacion(baseDatos.getConexion(), selectedTipo,selectedNombre);
        System.out.println(listaNombre);
        for (int i = 0; i < listaNombre.size(); i++) {
            presentacion.getItems().addAll(listaNombre.get(i));
        }

    }
    
    // Metodo para cargar precio mas caro
    public void cargarPrecios(ActionEvent event) {
        String selectedTipo = tipoProducto.getSelectionModel().getSelectedItem();
        String selectedNombre = nombre.getSelectionModel().getSelectedItem();
        String selectedPresentacion = presentacion.getSelectionModel().getSelectedItem();
        float precio;

        precio = baseDatos.llenarPrecio(baseDatos.getConexion(), selectedTipo,selectedNombre,selectedPresentacion);

        precioAnterior.setText(Float.toString(precio));
    }
    // Metodo para cargar origen
    public void cargarComboBoxOrigen() {
        listaOrigenComboBox.removeAll(listaOrigenComboBox);
        ArrayList<String> listaOrigen = new ArrayList<String>();
        listaOrigen = baseDatos.llenarComboboxOrigen(baseDatos.getConexion());
        System.out.println(listaOrigen);
        for (int i = 0; i < listaOrigen.size(); i++) {
            origenMercaderia.getItems().addAll(listaOrigen.get(i));
        }

    }
    // Metodo para cargar Plazo de pago
    public void cargarComboBoxPlazoDePago() {
        listaPlazoPagoComboBox.removeAll(listaPlazoPagoComboBox);
        ArrayList<String> listaPlazoDePago = new ArrayList<String>();
        listaPlazoDePago = baseDatos.llenarComboboxPlazoDePago(baseDatos.getConexion());
        System.out.println(listaPlazoDePago);
        for (int i = 0; i < listaPlazoDePago.size(); i++) {
            plazoPago.getItems().addAll(listaPlazoDePago.get(i));
        }

    }
    // Metodo para cargar Cantidad
    public void cargarComboBoxCantidad() {
        listaCantidadComboBox.removeAll(listaCantidadComboBox);
        ArrayList<String> listaCantidad = new ArrayList<String>();
        listaCantidad = baseDatos.llenarComboboxCantidad(baseDatos.getConexion());
        System.out.println(listaCantidad);
        for (int i = 0; i < listaCantidad.size(); i++) {
            cantidad.getItems().addAll(listaCantidad.get(i));
        }

    }
    // Metodo para cargar Tiempo de entrega
    public void cargarComboBoxTiempoDeEntrega() {
        listaTiempoEntregaComboBox.removeAll(listaTiempoEntregaComboBox);
        ArrayList<String> listaTiempoDeEntrega = new ArrayList<String>();
        listaTiempoDeEntrega = baseDatos.llenarComboboxTiempoDeEntrega(baseDatos.getConexion());
        System.out.println(listaTiempoDeEntrega);
        for (int i = 0; i < listaTiempoDeEntrega.size(); i++) {
            tiempoEntrega.getItems().addAll(listaTiempoDeEntrega.get(i));
        }

    }
    // Metodo para cargar Destino
    public void cargarComboBoxDestino() {
        listaDestinoComboBox.removeAll(listaDestinoComboBox);
        ArrayList<String> listaDestino = new ArrayList<String>();
        listaDestino = baseDatos.llenarComboboxDestino(baseDatos.getConexion());
        System.out.println(listaDestino);
        for (int i = 0; i < listaDestino.size(); i++) {
            lugarEntrega.getItems().addAll(listaDestino.get(i));
        }

    }

    //Metodo para mostrar la ventana de acceso denegado
    public void accesoDenegado(ActionEvent event) throws IOException {

        System.out.println("Acceso Denegado!!");
        //Cargo el fxml de la ventana de carga
        FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("UserDenegado.fxml"));
        Parent root3 = (Parent) FXMLLoader.load();
        Stage stage3 = new Stage();
        stage3.initStyle(StageStyle.UNDECORATED);
        stage3.initModality(Modality.APPLICATION_MODAL);
        stage3.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/noAlert.png")));
        stage3.centerOnScreen();
        stage3.setTitle("Acceso Denegado!");
        stage3.setScene(new Scene(root3));
        stage3.showAndWait();

    }

    //Metodo para limpiar registros
    private void limpiar() {
        clienteImportante.setSelected(false);
        DEV_Bidones.setSelected(false);
        contratoDeAprov.setSelected(false);

        tipoProducto.setValue("");
        nombre.setValue("");
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
        PricingController cn = new PricingController();
        cn.accesoDenegado(event);
    }

    @FXML
    private void apretarBookin(ActionEvent event) throws IOException {
        PricingController cn = new PricingController();
        cn.accesoDenegado(event);
    }

    @FXML
    private void apretarFinance(ActionEvent event) throws IOException {
        PricingController cn = new PricingController();
        cn.accesoDenegado(event);
    }

    @FXML
    private void apretarCobranza(ActionEvent event) throws IOException {
        PricingController cn = new PricingController();
        cn.accesoDenegado(event);
    }

    @FXML
    private void apretarPagos(ActionEvent event) throws IOException {
        PricingController cn = new PricingController();
        cn.accesoDenegado(event);
    }

    @FXML
    private void apretarContabilidad(ActionEvent event) throws IOException {
        PricingController cn = new PricingController();
        cn.accesoDenegado(event);
    }

    @FXML
    private void apretarCrm(ActionEvent event) throws IOException {
        PricingController cn = new PricingController();
        cn.accesoDenegado(event);
    }

    //Botones inferiores

    //Boton Consultar
    @FXML
    private void apretarFinalizar(ActionEvent event) throws IOException {
        System.out.println("Se Apreto Finalizar");
        float anterior = 0, precio = 0;
        int selectedNombre, selectedTipo, selectedtipoPago , selectedcantidad , selectedTiempoEntrega , selectedDestino,selectedOrigen;
        try {
            anterior = Float.parseFloat(precioAnterior.getText());
            
            selectedNombre = nombre.getSelectionModel().getSelectedIndex();
            selectedTipo =tipoProducto.getSelectionModel().getSelectedIndex();
            selectedtipoPago = plazoPago.getSelectionModel().getSelectedIndex();
            selectedcantidad = cantidad.getSelectionModel().getSelectedIndex();
            selectedTiempoEntrega = tiempoEntrega.getSelectionModel().getSelectedIndex();
            selectedDestino = lugarEntrega.getSelectionModel().getSelectedIndex();
            selectedOrigen = origenMercaderia.getSelectionModel().getSelectedIndex();
            System.out.println(nombre.getSelectionModel().getSelectedIndex());
            System.out.println(tipoProducto.getSelectionModel().getSelectedIndex());
            System.out.println(plazoPago.getSelectionModel().getSelectedIndex());
            System.out.println(lugarEntrega.getSelectionModel().getSelectedItem());
            System.out.println(cantidad.getSelectionModel().getSelectedIndex());
            System.out.println(tiempoEntrega.getSelectionModel().getSelectedIndex());
            System.out.println(lugarEntrega.getSelectionModel().getSelectedIndex());
            

            if (selectedNombre<0 || selectedTipo<0 || selectedtipoPago < 0 || selectedcantidad < 0 || selectedTiempoEntrega < 0 || selectedDestino < 0 || selectedOrigen < 0) {
                //CREA LA ALERTA AMIWIN
                System.out.println("esta en el if");
                FXMLLoader FXMLLoader11 = new FXMLLoader(getClass().getResource("CamposIncompletos.fxml"));
                Parent root2 = (Parent) FXMLLoader11.load();
                Stage camposfaltantes = new Stage();
                camposfaltantes.setScene(new Scene(root2));
                camposfaltantes.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/noAlert.png")));
                camposfaltantes.setTitle("Campos Incompletos");
                camposfaltantes.initStyle(StageStyle.UNDECORATED);
                camposfaltantes.initModality(Modality.APPLICATION_MODAL);
                System.out.println("Complete los campos");
                camposfaltantes.showAndWait();
            } else {
                precio = baseDatos.descuentoFormaDePago(baseDatos.getConexion(), selectedtipoPago) + baseDatos.descuentoCantidad(baseDatos.getConexion(), selectedcantidad) + baseDatos.descuentoTiempoEntrega(baseDatos.getConexion(), selectedTiempoEntrega) + baseDatos.descuentolugarEntrega(baseDatos.getConexion(), selectedDestino)+ baseDatos.descuentoOrigen(baseDatos.getConexion(),selectedOrigen);
                System.out.println("linea 323");
                if(DEV_Bidones.isSelected()){
                    precio= precio + baseDatos.descuentoDevolBidones(getConexion());
                }
                if(contratoDeAprov.isSelected()){
                    precio= precio + baseDatos.descuentoContratoAprov(getConexion());
                }
                if(clienteImportante.isSelected()){
                    precio= precio + baseDatos.descuentoClienteImpor(getConexion());
                }
                System.out.println("linea 333");
                precio = anterior - precio;
                monto.setText(Float.toString(precio));
                System.out.println("linea 336");
            }
        } catch (Exception e) {
            System.out.println(e+" linea 339");
            FXMLLoader FXMLLoader11 = new FXMLLoader(getClass().getResource("CamposIncompletos.fxml"));
                Parent root2 = (Parent) FXMLLoader11.load();
                Stage camposfaltantes = new Stage();
                camposfaltantes.setScene(new Scene(root2));
                camposfaltantes.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/noAlert.png")));
                camposfaltantes.setTitle("Campos Incompletos");
                camposfaltantes.initStyle(StageStyle.UNDECORATED);
                camposfaltantes.initModality(Modality.APPLICATION_MODAL);
                System.out.println("Complete los campos");
                camposfaltantes.showAndWait();
            System.out.println("Seleccione el nombre del producto");

        }

    }

    //Boton Cancelar
    @FXML
    private void apretarLimpiar(ActionEvent event) throws IOException {
        limpiar();

    }

    @FXML
    private void apretarCerrarSalir(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("Cerrando ventana de administrador");
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);

        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setMaximized(false);
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
    }

}
