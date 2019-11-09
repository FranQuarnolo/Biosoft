package biosoft.BaseDatos;

import biosoft.modelo.ControladorProducto;
import biosoft.modelo.Producto;
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
                listaProducto.add(new Producto(rs.getInt("idProd"), rs.getString("nombre"), rs.getString("tipo"), rs.getFloat("idProd")));
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
                listaProducto.add(new Producto(rs.getInt("idProd"), rs.getString("nombre"), rs.getString("tipo"), rs.getFloat("idProd")));
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
            ResultSet rs = ps.executeQuery("SELECT nombre FROM producto WHERE `tipo` LIKE '%" + tipo + "%' ");
            while (rs.next()) {
                listaTipo.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return listaTipo;
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
    
    public float llenarPrecio(Connection connection, String nombreprod) {
        ArrayList<String> listaPrecio = new ArrayList<String>();
       float precio=0;
        try {
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT precio FROM producto WHERE nombre = '"+nombreprod+"'");
            while (rs.next()) {
               listaPrecio.add(rs.getString("precio"));
            }
            precio=Float.parseFloat(listaPrecio.get(0));
        } catch (SQLException e) {
            System.out.println("Error aca metodo precio");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
        return precio;
    }

}
