package AppVista;

import Clases.Administrador;
import Clases.PedidoArreglo;
import Clases.ProductoArreglo;
import Controladores.ControladorLogin;



/**
 *
 * @author hp
 */
public class Principal {

    public static void main(String[] args) {
        
        Administrador administrador = new Administrador("123", "admi");
        PedidoArreglo pedidoArreglo = new PedidoArreglo(1);
        ProductoArreglo productoArreglo = new ProductoArreglo(1);
        
        ControladorLogin controladorLogin = new ControladorLogin(administrador, productoArreglo, pedidoArreglo);
        
        controladorLogin.iniciar();
        
 
    }
    
}