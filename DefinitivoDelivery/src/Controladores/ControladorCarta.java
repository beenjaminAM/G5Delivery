package Controladores;


import AppVista.CartaOrden;
import Clases.Pedido;
import Clases.PedidoArreglo;
import Clases.Producto;
import Clases.ProductoArreglo;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class ControladorCarta {
    public ProductoArreglo modeloProductos;
    public PedidoArreglo modeloPedidos;
    public CartaOrden vistaCarta;
    ProductoArreglo platosCliente = new ProductoArreglo(1);

    public ControladorCarta(ProductoArreglo modeloProductos, PedidoArreglo modeloPedidos) {
        this.modeloProductos = modeloProductos;
        this.modeloPedidos = modeloPedidos;
        this.vistaCarta = new CartaOrden();
        
        vistaCarta.butRegresar.addActionListener((ActionEvent ae) -> {
            ControladorInicio controladorInicio = new ControladorInicio(modeloProductos, modeloPedidos);
            controladorInicio.iniciar();
            vistaCarta.dispose();        
        });
        
        vistaCarta.actualizar.addActionListener((ActionEvent ae) -> {
            limpiarControles();     
        });     

        vistaCarta.agregar.addActionListener((ActionEvent ae) -> {
            String[] cabeceraPlato = {"Platillo", "Descripcion", "Costo"};
            String nombrePlato = this.vistaCarta.nombrePlatillo.getText();
            Producto plato = this.modeloProductos.buscar(nombrePlato);
            
            this.platosCliente.agregar(plato);
            
            limpiarControlesCliente();
            
        }); 
        
        vistaCarta.confirmarPedido.addActionListener((ActionEvent ae) -> {
            String cliente = this.vistaCarta.clienteNombre.getText();
            
            Pedido pedido = new Pedido(cliente, this.platosCliente);
            this.modeloPedidos.agregar(pedido);
            System.out.println(this.modeloPedidos);
            ControladorInicio controladorInicio = new ControladorInicio(modeloProductos, modeloPedidos);
            controladorInicio.iniciar();
            vistaCarta.dispose();
            
        });
        
        
        
        
        
        
    }
    
    public void iniciar(){
        vistaCarta.setVisible(true);
    }
    
    public void obtenerPedido(){
        
    }
    
    private void limpiarControles(){
        String[] cabecera = {"Tipo Producto", "Nombre", "Precio"};
        String[][] datos = new String[this.modeloProductos.getIndiceP()][3];
        
        for (int i = 0; i < this.modeloProductos.getIndiceP(); i++) {
            Producto p = this.modeloProductos.getProductos()[i];
            datos[i][0] = p.getTipo();
            datos[i][1] = p.getDescripcion();
            datos[i][2] = String.valueOf(p.getCosto());
        }
        
        DefaultTableModel tabla = new DefaultTableModel(datos, cabecera);
        this.vistaCarta.tblCarta.setModel(tabla);
    }
    
    private void limpiarControlesCliente(){
        String[] cabecera = {"Tipo Producto", "Nombre", "Precio"};
        String[][] datos = new String[this.platosCliente.getIndiceP()][3];
        
        for (int i = 0; i < this.platosCliente.getIndiceP(); i++) {
            Producto p = this.platosCliente.getProductos()[i];
            datos[i][0] = p.getTipo();
            datos[i][1] = p.getDescripcion();
            datos[i][2] = String.valueOf(p.getCosto());
        }
        
        DefaultTableModel tabla = new DefaultTableModel(datos, cabecera);
        this.vistaCarta.clientePedido.setModel(tabla);
    }    

}
