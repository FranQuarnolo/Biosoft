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



public class ControladorOrigen extends ControladorBaseDatosFx {
    private String insertarSQL = "INSERT INTO `origen`(`nombre`, `descuento`) VALUES('%s', %s)";
    private String buscarPorIdSQL = "SELECT * FROM origen WHERE idOrigen = %s";
    private String buscarTodosSQL = "SELECT * FROM origen";
    private String actualizarSQL= "UPDATE `origen` SET nombre = '%s' , descuento =%s WHERE idOrigen = %s "; 
    private String eliminarSQL= "DELETE FROM `origen` WHERE `idOrigen`=%s";

    public ControladorOrigen() {
        super();
    }
    
        public boolean insertarSQL(Origen o) {

        try {
            
            String SQL = String.format(insertarSQL, o.getNombre(), o.getDescuento());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorOrigen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
        
        public boolean borrarDatos(int id){
        try {
            String SQL = String.format(eliminarSQL, id);
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorOrigen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    
    }
    
    public boolean actualizarSQL(Origen o){
        try {
            System.out.println(o.getIdOrigen());
            
            String SQL = String.format(actualizarSQL,o.getNombre(),o.getDescuento(),o.getIdOrigen());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            System.out.println(SQL);
            System.out.println(sentencia);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorOrigen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    

    public Origen buscarPorIdSQL(int idOrigen) {

        try {
            String SQL = String.format(buscarPorIdSQL, idOrigen);
            PreparedStatement sentencia = getConexion().prepareStatement(SQL);
            ResultSet rs = sentencia.executeQuery(SQL);

            if (rs != null) {
                while (rs.next()) {
                    Origen origen = new Origen();
                    origen.setIdOrigen(rs.getInt(1));
                    origen.setNombre(rs.getString(2));
                    origen.setDescuento(rs.getFloat(3));
                                      
                    return origen;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorOrigen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public List<Origen> buscarTodos() {
        try {
            String SQL = buscarTodosSQL;
            Statement sentencia = getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery(SQL);

            List<Origen> origenes = new ArrayList<>();
            
            if (rs != null) {
                while (rs.next()) {
                    Origen origen = new Origen();
                    origen.setIdOrigen(rs.getInt(1));
                    origen.setNombre(rs.getString(2));
                    origen.setDescuento(rs.getFloat(3));
                    
                    origenes.add(origen);
                }
                
            }  
            return origenes;

        } catch (SQLException ex) {
            Logger.getLogger(ControladorOrigen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   

}
