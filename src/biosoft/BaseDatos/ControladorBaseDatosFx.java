package biosoft.BaseDatos;

import biosoft.modelo.ControladorProducto;
import biosoft.modelo.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class ControladorBaseDatosFx {
    private String nombreBaseDatos = "biosoftdb";
    private String urlServidor = "jdbc:mysql://localhost:3306/" + nombreBaseDatos+"?useUnicode=true&useJDBCCompiantTimezoneShift=true&useLegancyDatetimeCode=false&serverTimezone=UTC";
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
                listaProducto.add(new Producto(rs.getInt("idProd"), rs.getString("nombre"), rs.getString("tipo")));
            }
        } catch (SQLException e) {
            System.out.println("Error aca");
            JOptionPane.showMessageDialog(null, e, "Error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    

}
