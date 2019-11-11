package biosoft.ventanas;

import biosoft.BaseDatos.ControladorBaseDatosFx;
import biosoft.modelo.ControladorProducto;
import biosoft.modelo.DetalleVenta;
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
import javafx.scene.control.Label;
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
    private TextField nuevoNombre;
    @FXML
    private TextField nuevoTipo;
    @FXML
    private TextField nuevoPrecio;
    
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
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        nuevoNombre.setText("");
        nuevoTipo.setText("");
        nuevoPrecio.setText("");
    }

    public void señal(int a, int b) {
        int confirmar = a;
        System.out.println(confirmar);
        if (confirmar == 1) {
            ControladorProducto cp = new ControladorProducto();
            int selected = b;
            System.out.println(selected);
//            cp.borrarDatos(seleccion);
        }
    }

    
    //Boton actualizar
    @FXML
    private void apretarReload(ActionEvent event) {
        listaProducto = FXCollections.observableArrayList();
        ControladorBaseDatosFx db = new ControladorBaseDatosFx();
        db.llenarProd(db.getConexion(), listaProducto);
        listaProd.setItems(listaProducto);
        idProd.setCellValueFactory(new PropertyValueFactory<>("idProd"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
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
       producto.setPrecio(Float.parseFloat(nuevoPrecio.getText()));
       ControladorProducto cp = new ControladorProducto();
       cp.insertarSQL(producto);
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
                
                //Cargo el archivo fxml de la ventana de registro
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
    private void apretarEliminarRegistro(ActionEvent event) {
        ConfirmacionVentanaController cn = new ConfirmacionVentanaController();
        //Obtengo si hay o no un elemento seleccionado (Esto es par que continue con el if o no)
        int selectedIndex=-1;
        try {
             selectedIndex = listaProd.getSelectionModel().getSelectedItem().getIdProd();
        } catch (Exception e) {
             System.out.println("Error" + e);
        }
        

//        Asigno el id del elemento seleccionado a una variable y se la mando al metodo de eliminar de la BD
//        Producto idSeleccionado = listaProd.getItems().get(selectedIndex);
//        int seleccion = idSeleccionado.getIdProd();
//        MANDO ID AL METODO DE LA CLASE DE LA VENTANA DE CONFIRMACION
//        cn.eliminarSeleccionado(seleccion);
        //SE LO MANDO DIRECTO AL BOTON
//        cn.presionarSi(event ,seleccion);
        



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
