package biosoft.BaseDatos;

import biosoft.modelo.Cantidad;
import biosoft.modelo.Destino;
import biosoft.modelo.Origen;
import biosoft.modelo.PlazoPago;
import biosoft.modelo.Producto;
import biosoft.modelo.TiempoEntrega;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class ControladorBaseDatosFx {

    private String nombreBaseDatos = "biosoftdb";
    private String urlServidor = "jdbc:mysql://localhost:3306/" + nombreBaseDatos + "?useUnicode=true&useJDBCCompiantTimezoneShift=true&useLegancyDatetimeCode=false&serverTimezone=UTC";
    private String usuario = "root";
    private String password = ""; // cambiar la pass a la q tienen ""
    private Connection conexion;

    public ControladorBaseDatosFx() {

        try {
            //Driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Nombre del servidor. localhost:3306 es la ruta y el puerto de la conexión MySQL
            //El root es el nombre de usuario por default. No hay contraseña
            //Se inicia la conexión
            conexion = DriverManager.getConnection(urlServidor, usuario, password);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            // JOptionPane.showMessageDialog(null, "Conexión a la Base de Datos Exitosa");
            System.out.println("Conexión a la Base de Datos Exitosa");
            System.out.println("Actualizando...");
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    //Metodo para obtener el usuario y contraseña de la base de datos
    public int login(String usuario, String contrasena) {
        int resultado = 0;
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE usuario='" + usuario + "' AND contrasena='" + contrasena + "'");
            if (rs.next()) {
                resultado = 1;
            } else {
                resultado = 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }

    //Metodo para llenar la table view de productos
    public void llenarProd(Connection connection, ObservableList<Producto> listaProducto) {
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM producto");
            while (rs.next()) {
                listaProducto.add(new Producto(rs.getInt("idProd"), rs.getString("nombre"), rs.getString("tipo"), rs.getString("presentacion"), rs.getFloat("precio")));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    //Metodo para busqueda filtrada de producto
    public void busquedaProd(Connection connection, ObservableList<Producto> listaProducto, String producto) {
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM `producto` WHERE `nombre` LIKE '%" + producto + "%' "
                    + " or `nombre` LIKE '%" + producto + "' "
                    + "or `nombre` LIKE '" + producto + "%'");
            while (rs.next()) {
                listaProducto.add(new Producto(rs.getInt("idProd"), rs.getString("nombre"), rs.getString("tipo"),  rs.getString("presentacion"), rs.getFloat("precio")));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    //Metodo para llenar combo box por Tipo
    public ArrayList<String> llenarComboboxTipo(Connection connection) {
        ArrayList<String> listaTipo = new ArrayList<String>();
        // String q="SELECT tipo FROM `producto`";
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT DISTINCT tipo FROM producto ");
            while (rs.next()) {
                listaTipo.add(rs.getString("tipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return listaTipo;
    }
    //Metodo para llenar combo box por Nombre
    public ArrayList<String> llenarComboboxNombre(Connection connection, String tipo) {
        ArrayList<String> listaTipo = new ArrayList<String>();
        // String q="SELECT tipo FROM `producto`";
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT DISTINCT nombre FROM producto WHERE `tipo` LIKE '%" + tipo + "%' ");
            while (rs.next()) {
                listaTipo.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return listaTipo;
    }
    
     //Metodo para llenar combo box por Presentacion
    public ArrayList<String> llenarComboboxPresentacion(Connection connection, String tipo,String nombre) {
        ArrayList<String> listaPresentacion = new ArrayList<String>();
        // String q="SELECT tipo FROM `producto`";
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT DISTINCT presentacion FROM producto WHERE `tipo` LIKE '%" + tipo + "%' AND `nombre` LIKE '%" + nombre + "%' ");
            while (rs.next()) {
                listaPresentacion.add(rs.getString("presentacion"));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return listaPresentacion;
    }
    
    //Metodo para llenar combo box por Origen
    public ArrayList<String> llenarComboboxOrigen(Connection connection) {
        ArrayList<String> listaTipo = new ArrayList<String>();

        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT DISTINCT nombre FROM origen ");
            while (rs.next()) {
                listaTipo.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return listaTipo;
    }
    //Metodo para llenar combo box por Plazo pago
    public ArrayList<String> llenarComboboxPlazoDePago(Connection connection) {
        ArrayList<String> listaTipo = new ArrayList<String>();

        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT DISTINCT nombre FROM plazodepago ");
            while (rs.next()) {
                listaTipo.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return listaTipo;
    }
    //Metodo para llenar combo box por Cantidad
    public ArrayList<String> llenarComboboxCantidad(Connection connection) {
        ArrayList<String> listaTipo = new ArrayList<String>();

        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT DISTINCT nombre FROM cantidad ");
            while (rs.next()) {
                listaTipo.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return listaTipo;
    }
    //Metodo para llenar combo box por Tiempo de Entrega
    public ArrayList<String> llenarComboboxTiempoDeEntrega(Connection connection) {
        ArrayList<String> listaTipo = new ArrayList<String>();

        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT DISTINCT nombre FROM tiempodeentrega ");
            while (rs.next()) {
                listaTipo.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return listaTipo;
    }
    //Metodo para llenar combo box por Destino
    public ArrayList<String> llenarComboboxDestino(Connection connection) {
        ArrayList<String> listaTipo = new ArrayList<String>();

        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT DISTINCT nombre FROM destino ");
            while (rs.next()) {
                listaTipo.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return listaTipo;
    }
    // Metodo para llenar precio
    public float llenarPrecio(Connection connection,String tipo ,String nombreprod,String presentacion) {
        ArrayList<String> listaPrecio = new ArrayList<String>();
        float precio = 0;
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT precio FROM producto WHERE `tipo` LIKE '%" + tipo + "%' AND `nombre` LIKE '%" + nombreprod + "%' AND `presentacion` LIKE '%" + presentacion + "%' ");
            while (rs.next()) {
                listaPrecio.add(rs.getString("precio"));
            }
            precio = Float.parseFloat(listaPrecio.get(0));
        } catch (SQLException e) {
            System.out.println("Error aca metodo precio");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return precio;
    }
    
    //Descuentos
    public float descuentoFormaDePago(Connection connection, int formaDePago) {
        ArrayList<String> formaDePagos = new ArrayList<String>();
        System.out.println("aca");
        float descuento = 0;
        try {
            System.out.println("1");
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT descuento FROM plazodepago WHERE idPlazoDePago = '" + formaDePago + "'");
            System.out.println("2");
            while (rs.next()) {
                formaDePagos.add(rs.getString("descuento"));
            }
            System.out.println("33");
            System.out.println(formaDePagos.get(0));
            System.out.println("34");
            descuento = Float.parseFloat(formaDePagos.get(0));

        } catch (SQLException e) {
            System.out.println("Error metodo descuentoFormaDePago");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return descuento;
    }

    public float descuentoCantidad(Connection connection, int cantidad) {
        ArrayList<String> cantidades = new ArrayList<String>();
        System.out.println("aca");
        float descuento = 0;
        try {
            System.out.println("1");
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT descuento FROM cantidad WHERE idCantidad = '" + cantidad + "'");
            System.out.println("2");
            while (rs.next()) {
                cantidades.add(rs.getString("descuento"));
            }
            System.out.println("13");
           
            descuento = Float.parseFloat(cantidades.get(0));

        } catch (SQLException e) {
            System.out.println("Error metodo descuentoCantidad");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return descuento;
    }
    
    public float descuentoTiempoEntrega(Connection connection, int tiempoEntrega) {
        ArrayList<String> tiempoEntregas = new ArrayList<String>();
        System.out.println("aca");
        float descuento = 0;
        try {
            System.out.println("1");
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT descuento FROM tiempodeentrega WHERE IdTiempodeEntrega = '" + tiempoEntrega + "'");
            System.out.println("2");
            while (rs.next()) {
                tiempoEntregas.add(rs.getString("descuento"));
            }
            System.out.println("3");
            descuento = Float.parseFloat(tiempoEntregas.get(0));

        } catch (SQLException e) {
            System.out.println("Error metodo descuentoCantidad");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return descuento;
    }
    
    public float descuentolugarEntrega(Connection connection, int lugarEntrega) {
        ArrayList<String> lugarEntregas = new ArrayList<String>();
        System.out.println("aca");
        float descuento = 0;
        try {
            System.out.println("1");
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT descuento FROM Destino WHERE idDestino = '" + lugarEntrega + "'");
            System.out.println("2");
            while (rs.next()) {
                lugarEntregas.add(rs.getString("descuento"));
            }
            System.out.println("3");
            descuento = Float.parseFloat(lugarEntregas.get(0));

        } catch (SQLException e) {
            System.out.println("Error metodo descuentoCantidad");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return descuento;
    }

    public float descuentoOrigen(Connection connection, int lugarOrigen) {
        ArrayList<String> origenes = new ArrayList<String>();
        System.out.println("aca");
        float descuento = 0;
        try {
            System.out.println("1");
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT descuento FROM origen WHERE idOrigen = '" + lugarOrigen + "'");
            System.out.println("2");
            while (rs.next()) {
                origenes.add(rs.getString("descuento"));
            }
            System.out.println("3");
            descuento = Float.parseFloat(origenes.get(0));

        } catch (SQLException e) {
            System.out.println("Error metodo descuentoorigenes");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return descuento;
    }
    
    //Descuento Cliente Importante
    public float descuentoClienteImpor(Connection connection) {
        ArrayList<String> lista = new ArrayList<String>();        
        float descuento = 0;
        try {            
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT clienteimportante FROM descuentoitems ");
            while (rs.next()) {
                lista.add(rs.getString("clienteimportante"));
            }           
            descuento = Float.parseFloat(lista.get(0));
        } catch (SQLException e) {
            System.out.println("Error metodo descuentoClienteImport");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return descuento;
    }
    
    //Metodo Descuento Devolucion de bidones
    public float descuentoDevolBidones(Connection connection) {
        ArrayList<String> lista = new ArrayList<String>();        
        float descuento = 0;
        try {            
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT devolucionbidones FROM descuentoitems ");
            while (rs.next()) {
                lista.add(rs.getString("devolucionbidones"));
            }           
            descuento = Float.parseFloat(lista.get(0));
        } catch (SQLException e) {
            System.out.println("Error metodo descuentodevolucionbidones");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return descuento;
    }
    
    //Metodo Descuento Contrato de Aprovicionamiento
    
    public float descuentoContratoAprov(Connection connection) {
        ArrayList<String> lista = new ArrayList<String>();        
        float descuento = 0;
        try {            
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT contratoaprov FROM descuentoitems ");
            while (rs.next()) {
                lista.add(rs.getString("contratoaprov"));
            }           
            descuento = Float.parseFloat(lista.get(0));
        } catch (SQLException e) {
            System.out.println("Error metodo descuentodevolucionbidones");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return descuento;
    }
    
    //Metodo para llenar  Table view Cantidad
    public void llenarCantidad(Connection connection, ObservableList<Cantidad> listaCantidad) {
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM cantidad");
            while (rs.next()) {
                listaCantidad.add(new Cantidad(rs.getInt("idCantidad"), rs.getString("nombre"), rs.getFloat("descuento")));
            }
        } catch (SQLException e) {
            System.out.println("Error en llenarCantidad");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    //Metodo para llenar  Table view Destino
    public void llenarDestino(Connection connection, ObservableList<Destino> listaDestino) {
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM destino");
            while (rs.next()) {
                listaDestino.add(new Destino(rs.getInt("idDestino"), rs.getString("nombre"), rs.getFloat("descuento")));
            }
        } catch (SQLException e) {
            System.out.println("Error en llenar Destino");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    //Metodo para llenar  Table view Origen
    public void llenarOrigen(Connection connection, ObservableList<Origen> listaOrigen) {
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM origen");
            while (rs.next()) {
                listaOrigen.add(new Origen(rs.getInt("idOrigen"), rs.getString("nombre"), rs.getFloat("descuento")));
            }
        } catch (SQLException e) {
            System.out.println("Error en llenar Origen");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    } 
    //Metodo para llenar  Table view Tiempo de Entrega
    public void llenarTiempoEntrega(Connection connection, ObservableList<TiempoEntrega> listaTiempoEntrega) {
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM tiempodeentrega");
            while (rs.next()) {
                listaTiempoEntrega.add(new TiempoEntrega(rs.getInt("IdTiempodeEntrega"), rs.getString("nombre"), rs.getFloat("descuento")));
            }
        } catch (SQLException e) {
            System.out.println("Error en llenar Tiempo de entrega");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    } 
    //Metodo para llenar  Table view Plazo de Pago
    public void llenarPlazoPago(Connection connection, ObservableList<PlazoPago> listaPlazoPago) {
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM plazodepago");
            while (rs.next()) {
                listaPlazoPago.add(new PlazoPago(rs.getInt("idPlazoDePago"), rs.getString("nombre"), rs.getFloat("descuento")));
            }
        } catch (SQLException e) {
            System.out.println("Error en llenar Plazo de Pago");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Metodo Update Cliente Importante
    public void editarClienteImpor(Connection connection,Float valor){
        try {
            String SQL = "UPDATE descuentoitems SET clienteimportante = "+valor;
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    //Metodo Update Cliente Importante
    public void editarDevolucionBidones(Connection connection,Float valor){
        try {
            String SQL = "UPDATE descuentoitems SET devolucionbidones = "+valor;
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    //Metodo Update Cliente Importante
    public void editarContratoAprov(Connection connection,Float valor){
        try {
            String SQL = "UPDATE descuentoitems SET contratoaprov = "+valor;
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    public int contador1(Connection connection, ObservableList<Producto> listaproductos) {
        try {
            int n = 0;
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT count(*) FROM producto");
            if(rs.next()) {
                //Si hay resultados obtengo el valor.
             n = rs.getInt(1);
            }
            
            return n;
        } catch (SQLException e) {
            System.out.println("Error en llenar Plazo de Pago");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    } 
}
