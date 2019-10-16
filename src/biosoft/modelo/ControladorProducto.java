package biosoft.modelo;


import biosoft.BaseDatos.ControladorBaseDatosFx;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Andres
 */
public class ControladorProducto extends ControladorBaseDatosFx {
    private String borrarTablaSQL = "DROP TABLE IF EXISTS producto";
    private String crearTablaSQL = "CREATE TABLE IF NOT EXISTS `producto`(`idProd` int(11) NOT NULL , `nombre` varchar(50) DEFAULT NULL, `tipo` varchar(50) DEFAULT NULL)";
    private String insertarSQL = "INSERT INTO `producto`(`idProd`, `nombre`, `apellido`, `tipo`) VALUES(%s,'%s', '%s')";
    private String buscarPorIdSQL = "SELECT * FROM producto WHERE idProd = %s";
    private String buscarTodosSQL = "SELECT * FROM producto";
    private String actualizarSQL= "UPDATE `persona` SET `nombre`='Fran' WHERE id=1 "; //arreglar
    private String eliminarSQL= "DELETE FROM `producto` WHERE `id`=%s";

    public ControladorProducto() {
        super();
    }
    
    
    public boolean borrarDatos(int id){
        try {
            String SQL = String.format(eliminarSQL, id);
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    
    }
    

    public boolean borrarTabla() {

        try {
            String SQL = borrarTablaSQL;
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean crearTabla() {

        try {
            String SQL = crearTablaSQL;
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

        
    public boolean insertarSQL(Producto p) {

        try {
            
            String SQL = String.format(insertarSQL, p.getIdProducto(), p.getNombre(), p.getTipo());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    public boolean actualizarSQL(){
        try {
            
            String SQL = String.format(actualizarSQL);
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
                
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    

    public Producto buscarPorIdSQL(int idProd) {

        try {
            String SQL = String.format(buscarPorIdSQL, idProd);
            PreparedStatement sentencia = getConexion().prepareStatement(SQL);
            ResultSet rs = sentencia.executeQuery(SQL);

            if (rs != null) {
                while (rs.next()) {
                    Producto prodNuevo = new Producto();
                    prodNuevo.setIdProducto(rs.getInt(1));
                    prodNuevo.setNombre(rs.getString(2));
                    prodNuevo.setTipo(rs.getString(3));
                                      
                    return prodNuevo;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public List<Producto> buscarTodos() {
        try {
            String SQL = buscarTodosSQL;
            Statement sentencia = getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery(SQL);

            List<Producto> productos = new ArrayList<>();
            
            if (rs != null) {
                while (rs.next()) {
                    Producto prodNuevo = new Producto();
                    prodNuevo.setIdProducto(rs.getInt(1));
                    prodNuevo.setNombre(rs.getString(2));
                    prodNuevo.setTipo(rs.getString(3));
                    
                    productos.add(prodNuevo);
                }
                
            }  
            return productos;

        } catch (SQLException ex) {
            Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   

}


