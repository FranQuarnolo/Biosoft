package biosoft.ventanas;

import biosoft.BaseDatos.ControladorBaseDatosFx;
import biosoft.modelo.ControladorProducto;
import biosoft.modelo.Producto;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Wayne
 */
public class adminPrincipalController extends ControladorBaseDatosFx{

    private adminPrincipalController admin;
    private Producto producto;
    @FXML
    private TableView<Producto> listaProd;
    @FXML
    private TableColumn<Producto, Integer> idProd;
    @FXML
    private TableColumn<Producto, String> tipo;
    @FXML
    private TableColumn<Producto, String> nombre;
    @FXML
    private TextField buscadorProducto;

    private ObservableList<Producto> listaProducto;

    public adminPrincipalController() {
    }

    
    public void initialize() {

        listaProducto = FXCollections.observableArrayList();
        ControladorBaseDatosFx db = new ControladorBaseDatosFx();
        db.llenarProd(db.getConexion(), listaProducto);
        listaProd.setItems(listaProducto);
        
        idProd.setCellValueFactory(new PropertyValueFactory<>("idProd"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("tipo"));

    }

    //Boton agregar
    @FXML
    private void apretarAgregar(ActionEvent event) {
        try {
            //Cargo el archivo fxml de la ventana de registro
            FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("adminNuevo.fxml"));
            Parent root8 = (Parent) FXMLLoader3.load();
            Stage nuevo = new Stage();
            nuevo.setScene(new Scene(root8));
            //La hago bonita
//            modificar.getIcons().add(new Image("file:src/imagenes/registro.png"));
            nuevo.setTitle("Nuevo");
            nuevo.initStyle(StageStyle.UNDECORATED);
            System.out.println("Iniciando la ventana de agregar nuevo...");
            //Inicio la ventana
            nuevo.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Boton modificar
    @FXML
    private void apretarModificar(ActionEvent event) {
        try {
            Producto selectedInscripcion = listaProd.getSelectionModel().getSelectedItem();
            if (selectedInscripcion != null) {
                //Cargo el archivo fxml de la ventana de registro
                FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("adminModificar.fxml"));
                Parent root2 = (Parent) FXMLLoader3.load();
                Stage modificar = new Stage();
                modificar.setScene(new Scene(root2));
                //La hago bonita
//                modificar.getIcons().add(new Image("file:src/imagenes/registro.png"));
                modificar.setTitle("Modificacion");
                modificar.initStyle(StageStyle.UNDECORATED);
                System.out.println("Iniciando la ventana de modificacion...");
                //Inicio la ventana
                modificar.show();
            } else {
                try {
                    //Cargo el archivo fxml
                    FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("seleccioneElemento.fxml"));
                    Parent root8 = (Parent) FXMLLoader3.load();
                    Stage nuevo = new Stage();
                    nuevo.setScene(new Scene(root8));
                    //La hago bonita
//           modificar.getIcons().add(new Image("file:src/imagenes/registro.png"));
                    nuevo.setTitle("No Seleccion!");
                    nuevo.initStyle(StageStyle.UNDECORATED);
                    System.out.println("Seleccione un elemento por favor");
                    //Inicio la ventana
                    nuevo.show();
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
    private void apretarEliminarRegistro(ActionEvent event) {
//        ControladorBaseDatosFx control = new ControladorBaseDatosFx();
        confirmacionVentanaController cn = new confirmacionVentanaController();
        //Obtengo si hay o no un elemento seleccionado (Esto es par que continue con el if o no)
        int selectedIndex = listaProd.getSelectionModel().getSelectedIndex();
        
        //Asigno el id del elemento seleccionado a una variable y se la mando al metodo de eliminar de la BD
        Producto idSeleccionado = listaProd.getItems().get(selectedIndex);
        int seleccion = idSeleccionado.getIdProd();
        
        
        
        //MANDO ID AL METODO DE LA CLASE DE LA VENTANA DE CONFIRMACION
        cn.eliminarSeleccionado(seleccion); 
        
        //SE LO MANDO DIRECTO AL BOTON
//        cn.presionarSi(event ,seleccion);
        
        //Control de ventanas
        if (selectedIndex >= 0) {
            try {
                //Cargo el archivo fxml
                FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("confirmacionVentana.fxml"));
                Parent root8 = (Parent) FXMLLoader3.load();
                Stage nuevo = new Stage();
                nuevo.setScene(new Scene(root8));
                //La hago bonita
//           modificar.getIcons().add(new Image("file:src/imagenes/registro.png"));
                nuevo.setTitle("Estas Seguro?");
                nuevo.initStyle(StageStyle.UNDECORATED);
                System.out.println("Iniciando la ventana de confirmacion...");
                //Inicio la ventana
                nuevo.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                //Cargo el archivo fxml
                FXMLLoader FXMLLoader3 = new FXMLLoader(getClass().getResource("seleccioneElemento.fxml"));
                Parent root8 = (Parent) FXMLLoader3.load();
                Stage nuevo = new Stage();
                nuevo.setScene(new Scene(root8));
                //La hago bonita
//           modificar.getIcons().add(new Image("file:src/imagenes/registro.png"));
                nuevo.setTitle("No Seleccion!");
                nuevo.initStyle(StageStyle.UNDECORATED);
                System.out.println("Seleccione un elemento por favor");
                //Inicio la ventana
                nuevo.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    
     //Metodo para busqueda filtrada de producto
    public void busquedaProducto() {
        String busqueda = buscadorProducto.getText();

        if(busqueda!=null){
        listaProducto = FXCollections.observableArrayList();
        ControladorBaseDatosFx db = new ControladorBaseDatosFx();
        db.busquedaProd(db.getConexion(), listaProducto, busqueda);
        listaProd.setItems(listaProducto);
        
        idProd.setCellValueFactory(new PropertyValueFactory<>("idProd"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        }else{
            admin.initialize();
        }

    }

    //Boton Cerrar Sesion
    @FXML
    private void apretarCerrarSesion(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("Cerrando ventana de administrador");
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
    }
}
