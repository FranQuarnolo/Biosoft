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



public class ControladorPlazoPago extends ControladorBaseDatosFx {
    private String insertarSQL = "INSERT INTO `plazodepago`(`nombre`, `descuento`) VALUES('%s', %s)";
    private String buscarPorIdSQL = "SELECT * FROM plazodepago WHERE idPlazoDePago = %s";
    private String buscarTodosSQL = "SELECT * FROM plazodepago";
    private String actualizarSQL= "UPDATE `plazodepago` SET nombre = '%s' , descuento =%s WHERE idPlazoDePago = %s "; 
    private String eliminarSQL= "DELETE FROM `plazodepago` WHERE `idPlazoDePago`=%s";

    public ControladorPlazoPago() {
        super();
    }
    
        public boolean insertarSQL(PlazoPago pp) {

        try {
            
            String SQL = String.format(insertarSQL, pp.getNombre(), pp.getDescuento());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPlazoPago.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorPlazoPago.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    
    }
    
    public boolean actualizarSQL(PlazoPago pp){
        try {
            System.out.println(pp.getIdPlazoDePago());
            
            String SQL = String.format(actualizarSQL,pp.getNombre(),pp.getDescuento());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            System.out.println(SQL);
            System.out.println(sentencia);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPlazoPago.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    

    public PlazoPago buscarPorIdSQL(int idPlazoDePago) {

        try {
            String SQL = String.format(buscarPorIdSQL, idPlazoDePago);
            PreparedStatement sentencia = getConexion().prepareStatement(SQL);
            ResultSet rs = sentencia.executeQuery(SQL);

            if (rs != null) {
                while (rs.next()) {
                    PlazoPago plazo = new PlazoPago();
                    plazo.setIdPlazoDePago(rs.getInt(1));
                    plazo.setNombre(rs.getString(2));
                    plazo.setDescuento(rs.getFloat(3));
                                      
                    return plazo;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorPlazoPago.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public List<PlazoPago> buscarTodos() {
        try {
            String SQL = buscarTodosSQL;
            Statement sentencia = getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery(SQL);

            List<PlazoPago> plazos = new ArrayList<>();
            
            if (rs != null) {
                while (rs.next()) {
                    PlazoPago plazo = new PlazoPago();
                    plazo.setIdPlazoDePago(rs.getInt(1));
                    plazo.setNombre(rs.getString(2));
                    plazo.setDescuento(rs.getFloat(3));
                                      
                    
                    plazos.add(plazo);
                }
                
            }  
            return plazos;

        } catch (SQLException ex) {
            Logger.getLogger(ControladorPlazoPago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   

}
