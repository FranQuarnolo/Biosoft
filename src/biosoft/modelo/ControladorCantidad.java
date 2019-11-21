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



public class ControladorCantidad extends ControladorBaseDatosFx {
    private String insertarSQL = "INSERT INTO `cantidad`(`nombre`, `descuento`) VALUES('%s', %s)";
    private String buscarPorIdSQL = "SELECT * FROM cantidad WHERE idCantidad = %s";
    private String buscarTodosSQL = "SELECT * FROM cantidad";
    private String actualizarSQL= "UPDATE `cantidad` SET nombre = '%s' , descuento =%s WHERE idCantidad = %s "; 
    private String eliminarSQL= "DELETE FROM `cantidad` WHERE `idCantidad`=%s";

    public ControladorCantidad() {
        super();
    }
    
        public boolean insertarSQL(Cantidad c) {

        try {
            
            String SQL = String.format(insertarSQL, c.getNombre(), c.getDescuento());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCantidad.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorCantidad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    
    }
    
    public boolean actualizarSQL(Cantidad c){
        try {
            System.out.println(c.getIdCantidad());
            
            String SQL = String.format(actualizarSQL,c.getNombre(),c.getDescuento(),c.getIdCantidad());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            System.out.println(SQL);
            System.out.println(sentencia);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCantidad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    

    public Cantidad buscarPorIdSQL(int idCantidad) {

        try {
            String SQL = String.format(buscarPorIdSQL, idCantidad);
            PreparedStatement sentencia = getConexion().prepareStatement(SQL);
            ResultSet rs = sentencia.executeQuery(SQL);

            if (rs != null) {
                while (rs.next()) {
                    Cantidad cant = new Cantidad();
                    cant.setIdCantidad(rs.getInt(1));
                    cant.setNombre(rs.getString(2));
                    cant.setDescuento(rs.getFloat(3));
                                      
                    return cant;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorCantidad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public List<Cantidad> buscarTodos() {
        try {
            String SQL = buscarTodosSQL;
            Statement sentencia = getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery(SQL);

            List<Cantidad> cantidades = new ArrayList<>();
            
            if (rs != null) {
                while (rs.next()) {
                    Cantidad cant = new Cantidad();
                    cant.setIdCantidad(rs.getInt(1));
                    cant.setNombre(rs.getString(2));
                    cant.setDescuento(rs.getFloat(3));
                    
                    cantidades.add(cant);
                }
                
            }  
            return cantidades;

        } catch (SQLException ex) {
            Logger.getLogger(ControladorCantidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   

}
