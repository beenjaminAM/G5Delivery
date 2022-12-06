package Controladores;


import AppVista.Ver;
import Clases.Pedido;
import Clases.PedidoArreglo;
import Clases.ProductoArreglo;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class ControladorVer {
    public ProductoArreglo modeloProductos;
    public PedidoArreglo modeloPedidos;
    public Ver verpedido;

    public ControladorVer(ProductoArreglo modeloProductos, PedidoArreglo modeloPedidos) {
        this.modeloProductos = modeloProductos;
        this.modeloPedidos = modeloPedidos;
        this.verpedido = new Ver();
        
        verpedido.butonRegresar.addActionListener((ActionEvent ae) -> {
            ControladorInicio controladorInicio = new ControladorInicio(modeloProductos, modeloPedidos);
            controladorInicio.iniciar();
            verpedido.dispose();        
        });     
        
        verpedido.actualizar.addActionListener((ActionEvent ae) -> {
            
            limpiarControles();
        });         
        
        
        
        
    }
    
    public void iniciar(){
        verpedido.setVisible(true);
    }
    
    private void limpiarControles(){

        String[] cabecera = {"Numero","Descripcion"};
        String[][] datos = new String[this.modeloPedidos.getIndiceP()][2];
        for (int i=0; i < this.modeloPedidos.getIndiceP();i++){
            Pedido p = this.modeloPedidos.getPedidos()[i];
            int j = i + 1;
            datos[i][0]= j + "";
            datos[i][1]= p.getNombreCliente();
        }
        
        DefaultTableModel modeloTabla = new DefaultTableModel(datos,cabecera);
        this.verpedido.table.setModel(modeloTabla);
    }     
    
    
    
}
