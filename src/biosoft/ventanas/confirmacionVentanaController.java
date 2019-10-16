package biosoft.ventanas;

import biosoft.modelo.ControladorProducto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 *
 * @author Wayne
 */
public class confirmacionVentanaController {

    @FXML
    private Button btnSi;
    
   

    public confirmacionVentanaController() {
    }

    //Metodo para obtener el id de Producto seleccionado
    
    public void eliminarSeleccionado(int idProd){
        int id = idProd;
        System.out.println(id);
        ControladorProducto cn = new ControladorProducto();
        //METODO BORRADO
//        cn.borrarDatos(id);   
    }  
    
    //Boton presionar si
    @FXML
    private void presionarSi(ActionEvent event) {
       
        /*
                Probando y probando: si hago este metodo publico y le mando el id como parametro
                desde la otra clase lo recibe y hasta me lo imprime bien. Pero por alguna razon me
                tira un error de que no puede encontrar la accion o algo asi, como que es problema del
                FX o algo asi.
        
                Mas arriba esta el metodo "eliminarSeleccionado" que recibe bien el id de el elemento 
                seleccionado en la ventana anterior y lo carga a una variable listo para mandarle ese id
                al metodo borrar del la clase de "Producto controllador". 
                El problema con esto es que despues no se como llamar el metodo cuando se presiona el boton
                "Si". Me pide si o si que le entregue un parametro, el cual si lo hago me cambia completamente
                el valor del id que venia desde la otra clase.
        
                Por lo demas eso es todo. Anda bien y es lo que habria que solucionar.
                Mañana hago la ventana de modificar. Aunque sea el visual nomas porque de todas formas
                necesito campos cargados en la BD para poder inicializar los textfield con los campos y valores
                del elemento seleccionado.
    
         */
        
        
//        System.out.println(id);
                
        System.out.println("Eliminando...");
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    //Boton cancelar
    @FXML
    private void presionarCancelar(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
