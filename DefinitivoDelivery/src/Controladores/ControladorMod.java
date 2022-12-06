package Controladores;


import AppVista.Mod;
import Clases.PedidoArreglo;
import Clases.Producto;
import Clases.ProductoArreglo;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class ControladorMod {
    public Mod vistaMod;
    public ProductoArreglo modeloProductos;
    public PedidoArreglo modeloPedidos;

    public ControladorMod(ProductoArreglo modeloProductos, PedidoArreglo modeloPedidos) {
        this.modeloProductos = modeloProductos;
        this.modeloPedidos = modeloPedidos;
        this.vistaMod = new Mod();
        
        vistaMod.butonRegresar.addActionListener((ActionEvent ae) -> {
            ControladorInicio controladorInicio = new ControladorInicio(modeloProductos, modeloPedidos);
            controladorInicio.iniciar();
            vistaMod.dispose();
        });
        
        vistaMod.agregar.addActionListener((ActionEvent ae) -> {
            String tipo = vistaMod.tipoPlato.getText();
            String descripcion = vistaMod.descripcion.getText(); 
            int precio = Integer.parseInt(vistaMod.costoPlato.getText());
                 
            Producto producto = new Producto(descripcion,tipo, precio);
            modeloProductos.agregar(producto);
            limpiarControles();
                          
        });        
        
        
        
    }
    
    public void iniciar(){
        vistaMod.setVisible(true);
    }
    
    private void limpiarControles(){
        String[] cabecera = {"Tipo","Costo","Descripcion"};
        String[][] datos = new String[this.modeloProductos.getIndiceP()][3];
        for (int i=0; i < this.modeloProductos.getIndiceP();i++){
            Producto p = this.modeloProductos.getProductos()[i];
            datos[i][0]= p.getTipo();
            datos[i][1]= p.getDescripcion();
            datos[i][2]= String.valueOf(p.getCosto());        
        }
        
        DefaultTableModel modeloTabla = new DefaultTableModel(datos,cabecera);
        this.vistaMod.table.setModel(modeloTabla);
    }     
    
      
}
