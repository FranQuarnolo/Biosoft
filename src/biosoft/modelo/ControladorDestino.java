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



public class ControladorDestino extends ControladorBaseDatosFx {
    private String insertarSQL = "INSERT INTO `destino`(`nombre`, `descuento`) VALUES('%s', %s)";
    private String buscarPorIdSQL = "SELECT * FROM destino WHERE idDestino = %s";
    private String buscarTodosSQL = "SELECT * FROM destino";
    private String actualizarSQL= "UPDATE `destino` SET nombre = '%s' , descuento =%s WHERE idDestino = %s "; 
    private String eliminarSQL= "DELETE FROM `destino` WHERE `idDestino`=%s";

    public ControladorDestino() {
        super();
    }
    
        public boolean insertarSQL(Destino d) {

        try {
            
            String SQL = String.format(insertarSQL, d.getNombre(), d.getDescuento());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDestino.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorDestino.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    
    }
    
    public boolean actualizarSQL(Destino d){
        try {
            System.out.println(d.getIdDestino());
            
            String SQL = String.format(actualizarSQL,d.getNombre(),d.getDescuento());
            Statement sentencia = getConexion().createStatement();
            sentencia.execute(SQL);
            System.out.println(SQL);
            System.out.println(sentencia);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDestino.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    

    public Destino buscarPorIdSQL(int idDestino) {

        try {
            String SQL = String.format(buscarPorIdSQL, idDestino);
            PreparedStatement sentencia = getConexion().prepareStatement(SQL);
            ResultSet rs = sentencia.executeQuery(SQL);

            if (rs != null) {
                while (rs.next()) {
                    Destino destino = new Destino();
                    destino.setIdDestino(rs.getInt(1));
                    destino.setNombre(rs.getString(2));
                    destino.setDescuento(rs.getFloat(3));
                                      
                    return destino;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorDestino.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public List<Destino> buscarTodos() {
        try {
            String SQL = buscarTodosSQL;
            Statement sentencia = getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery(SQL);

            List<Destino> destinos = new ArrayList<>();
            
            if (rs != null) {
                while (rs.next()) {
                    Destino destino = new Destino();
                    destino.setIdDestino(rs.getInt(1));
                    destino.setNombre(rs.getString(2));
                    destino.setDescuento(rs.getFloat(3));
                    
                    destinos.add(destino);
                }
                
            }  
            return destinos;

        } catch (SQLException ex) {
            Logger.getLogger(ControladorDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   

}
