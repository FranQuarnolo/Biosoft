package biosoft.ventanas;

import biosoft.BaseDatos.ControladorBaseDatosFx;
import biosoft.modelo.ControladorProducto;
import biosoft.modelo.DetalleVenta;
import biosoft.modelo.Producto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Wayne
 */
public class AdminProductosController extends ControladorBaseDatosFx implements Initializable {

    private Producto producto;
    private DetalleVenta detalle;

    @FXML
    private TableView<Producto> listaProd;
    @FXML
    private TableColumn<Producto, Integer> idProd;
    @FXML
    private TableColumn<Producto, String> tipo;
    @FXML
    private TableColumn<Producto, String> nombre;
    @FXML
    private TableColumn<Producto, String> precio;
    @FXML
    private TableColumn<Producto, String> presentacion;
    
    @FXML
    private TextField nuevoNombre;
    @FXML
    private TextField nuevoTipo;
    @FXML
    private TextField nuevoPrecio;
    @FXML
    private TextField nuevaPresentacion;

    private ObservableList<Producto> listaProducto;

    public AdminProductosController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle rb) {

        listaProducto = FXCollections.observableArrayList();
        ControladorBaseDatosFx db = new ControladorBaseDatosFx();
        db.llenarProd(db.getConexion(), listaProducto);
        listaProd.setItems(listaProducto);
        idProd.setCellValueFactory(new PropertyValueFactory<>("idProd"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        presentacion.setCellValueFactory(new PropertyValueFactory<>("presentacion"));
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        nuevoNombre.setText("");
        nuevoTipo.setText("");
        nuevoPrecio.setText("");

    }

    //Boton agregar
    @FXML
    private void apretarAgregar(ActionEvent event) throws IOException {

        try {
            Producto producto = new Producto();
            producto.setNombre(nuevoNombre.getText());
            producto.setTipo(nuevoTipo.getText());
            producto.setPresentacion(nuevaPresentacion.getText());
            producto.setPrecio(Float.parseFloat(nuevoPrecio.getText()));
            ControladorProducto cp = new ControladorProducto();
            nuevoNombre.setText("");
            nuevoTipo.setText("");
            nuevaPresentacion.setText("");
            nuevoPrecio.setText("");
            cp.insertarSQL(producto);
            //VENTANA 
            FXMLLoader FXMLLoader9 = new FXMLLoader(getClass().getResource("AgregadoExitosamente.fxml"));
            Parent root2 = (Parent) FXMLLoader9.load();
            Stage exitosa = new Stage();
            exitosa.setScene(new Scene(root2));
            exitosa.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/new.png")));
            exitosa.setTitle("Exito!");
            exitosa.initStyle(StageStyle.UNDECORATED);
            exitosa.initModality(Modality.APPLICATION_MODAL);
            exitosa.showAndWait();
            System.out.println("Producto agregado correctamente!");
            //Refresca la lista
            listaProd.getItems().clear();
            ControladorBaseDatosFx db = new ControladorBaseDatosFx();
            db.llenarProd(db.getConexion(), listaProducto);
            listaProd.setItems(listaProducto);
        } catch (Exception e) {
            //Cargo el archivo fxml
            FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("NoIngresaNada.fxml"));
            Parent root8 = (Parent) FXMLLoader3.load();
            Stage nuevo = new Stage();
            nuevo.setScene(new Scene(root8));
            nuevo.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/alert1.png")));
            nuevo.setTitle("No Seleccion!");
            nuevo.initStyle(StageStyle.UNDECORATED);
            nuevo.initModality(Modality.APPLICATION_MODAL);
            System.out.println("Seleccione un elemento por favor");
            //Inicio la ventana
            nuevo.showAndWait();

        }

    }

    //Boton modificar
    @FXML
    public void apretarModificar(ActionEvent event) {

        try {
            Producto selectedProducto = listaProd.getSelectionModel().getSelectedItem();
            if (selectedProducto != null) {

                //Cargo el archivo fxml de la ventana de modificar
                FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("AdminModificarProducto.fxml"));
                Parent root2 = (Parent) FXMLLoader3.load();
                Stage modificar = new Stage();
                modificar.setScene(new Scene(root2));
                modificar.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/edit.png")));
                modificar.setTitle("Modificacion");
                modificar.initStyle(StageStyle.UNDECORATED);
                modificar.initModality(Modality.APPLICATION_MODAL);
                System.out.println("Iniciando la ventana de modificacion...");
                //Inicio la ventana
                AdminModificarProductoController modif = FXMLLoader3.getController();
                modif.initialize(selectedProducto);
                modificar.showAndWait();
                //Refresca la lista
                listaProd.getItems().clear();
                ControladorBaseDatosFx db = new ControladorBaseDatosFx();
                db.llenarProd(db.getConexion(), listaProducto);
                listaProd.setItems(listaProducto);
            } else {
                try {
                    //Cargo el archivo fxml
                    FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("SeleccioneElemento.fxml"));
                    Parent root8 = (Parent) FXMLLoader3.load();
                    Stage nuevo = new Stage();
                    nuevo.setScene(new Scene(root8));
                    nuevo.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/alert1.png")));
                    nuevo.setTitle("No Seleccion!");
                    nuevo.initStyle(StageStyle.UNDECORATED);
                    nuevo.initModality(Modality.APPLICATION_MODAL);
                    System.out.println("Seleccione un elemento por favor");
                    //Inicio la ventana
                    nuevo.showAndWait();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Boton Eliminar
    @FXML
    private void apretarEliminarRegistro(ActionEvent event) throws SQLException {
        ConfirmacionVentanaController cn = new ConfirmacionVentanaController();
        //Obtengo si hay o no un elemento seleccionado (Esto es par que continue con el if o no)
        int selectedIndex = -1;
        try {
            selectedIndex = listaProd.getSelectionModel().getSelectedItem().getIdProd();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

//Control de ventanas
        if (selectedIndex >= 0) {
            try {
                //Cargo el archivo fxml
                FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("ConfirmacionVentana.fxml"));
                Parent root8 = (Parent) FXMLLoader3.load();
                Stage nuevo = new Stage();
                nuevo.setScene(new Scene(root8));
                nuevo.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/noAlert.png")));
                nuevo.setTitle("Estas Seguro?");
                nuevo.initStyle(StageStyle.UNDECORATED);
                nuevo.initModality(Modality.APPLICATION_MODAL);
                System.out.println("Iniciando la ventana de confirmacion...");
                //Inicio la ventana
                ConfirmacionVentanaController confirm = FXMLLoader3.getController();
                confirm.eliminarSeleccionado(selectedIndex);
                nuevo.showAndWait();
                //Refresca la lista
                listaProd.getItems().clear();
                ControladorBaseDatosFx db = new ControladorBaseDatosFx();
                db.llenarProd(db.getConexion(), listaProducto);
                listaProd.setItems(listaProducto);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                //Cargo el archivo fxml
                FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("SeleccioneElemento.fxml"));
                Parent root8 = (Parent) FXMLLoader3.load();
                Stage nuevo = new Stage();
                nuevo.setScene(new Scene(root8));
                nuevo.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("biosoft/images/alert1.png")));
                nuevo.setTitle("No Seleccion!");
                nuevo.initStyle(StageStyle.UNDECORATED);
                nuevo.initModality(Modality.APPLICATION_MODAL);
                System.out.println("Seleccione un elemento por favor");
                //Inicio la ventana
                nuevo.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ControladorBaseDatosFx db = new ControladorBaseDatosFx();
        int n = db.contador1(db.getConexion(), listaProducto);
        if (n == 0) {
            ControladorProducto cp = new ControladorProducto();
            cp.truncate();
        } else {
            System.out.println("continue");
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
