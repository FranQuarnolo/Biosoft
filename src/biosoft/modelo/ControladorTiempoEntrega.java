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



public class ControladorTiempoEntrega extends ControladorBaseDatosFx {
    private String insertarSQL = "INSERT INTO `tiempodeentrega`(`nombre`, `descuento`) VALUES('%s', %s)";
    private String buscarPorIdSQL = "SELECT * FROM tiempodeentrega WHERE idPlazoDePago = %s";
    private String buscarTodosSQL = "SELECT * FROM tiempodeentrega";
    private String actualizarSQL= "UPDATE `tiempodeentrega` SET nombre = '%s' , descuento =%s WHERE idTiempodeEntrega = %s "; 
    private String eliminarSQL= "DELETE FROM `tiempodeentrega` WHERE `idTiempodeEntrega`=%s";

    public ControladorTiempoEntrega() {
        super();
    }
    
        public boolean insertarSQL(TiempoEntrega te) {

        try {
            
            String SQL = String.format(insertarSQL, te.getNombre(), te.getDescuento());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorTiempoEntrega.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorTiempoEntrega.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    
    }
    
    public boolean actualizarSQL(TiempoEntrega te){
        try {
            System.out.println(te.getIdTiempodeEntrega());
            
            String SQL = String.format(actualizarSQL,te.getNombre(),te.getDescuento());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            System.out.println(SQL);
            System.out.println(sentencia);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorTiempoEntrega.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    

    public TiempoEntrega buscarPorIdSQL(int idTiempodeEntrega) {

        try {
            String SQL = String.format(buscarPorIdSQL, idTiempodeEntrega);
            PreparedStatement sentencia = getConexion().prepareStatement(SQL);
            ResultSet rs = sentencia.executeQuery(SQL);

            if (rs != null) {
                while (rs.next()) {
                    TiempoEntrega tiempo = new TiempoEntrega();
                    tiempo.setIdTiempodeEntrega(rs.getInt(1));
                    tiempo.setNombre(rs.getString(2));
                    tiempo.setDescuento(rs.getFloat(3));
                                      
                    return tiempo;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorTiempoEntrega.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public List<TiempoEntrega> buscarTodos() {
        try {
            String SQL = buscarTodosSQL;
            Statement sentencia = getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery(SQL);

            List<TiempoEntrega> tiempos = new ArrayList<>();
            
            if (rs != null) {
                while (rs.next()) {
                    TiempoEntrega tiempo = new TiempoEntrega();
                    tiempo.setIdTiempodeEntrega(rs.getInt(1));
                    tiempo.setNombre(rs.getString(2));
                    tiempo.setDescuento(rs.getFloat(3));
                                      
                    
                    tiempos.add(tiempo);
                }
                
            }  
            return tiempos;

        } catch (SQLException ex) {
            Logger.getLogger(ControladorTiempoEntrega.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   

}
