/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import AppVista.ValoPlatillo;
import Clases.PedidoArreglo;
import Clases.Producto;
import Clases.ProductoArreglo;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


public class ControladorValor {
    ValoPlatillo v;
    ProductoArreglo plat; 
    PedidoArreglo  ped;

    public ControladorValor(ValoPlatillo v, ProductoArreglo plat, PedidoArreglo ped) {
        this.v = v;
        this.plat = plat;
        this.ped = ped;
        v.returnValor.addActionListener((ActionEvent ae) -> {
            ControladorInicio controladorInicio = new ControladorInicio(plat, ped);
            controladorInicio.iniciar();
            v.dispose();
        });
        
        
        v.buttonValo.addActionListener((ActionEvent ae) -> {
            int fila = this.v.tablevalor.getSelectedRow();
            String name = (String) v.tablevalor.getValueAt(fila, 0);
            Producto p = this.plat.buscar(name);
            if(fila > -1){
                
                
                if(v.valo1.isSelected()){
                 p.valoracion.calcularValorPuntos(1);
                }
                if(v.valo2.isSelected()){
                    p.valoracion.calcularValorPuntos(2);
                }
                if(v.valo3.isSelected()){
                    p.valoracion.calcularValorPuntos(3);
                }
                if(v.valo4.isSelected()){
                    p.valoracion.calcularValorPuntos(4);
                }
                if(v.valo5.isSelected()){
                    p.valoracion.calcularValorPuntos(5);
                }       
            }
            
            LimpiarControlesValoracion();
            
        });        
        
    }
 
    public void Iniciar()
    {
    v.setVisible(true);
    LimpiarControlesValoracion();
    
    }
    
    public void LimpiarControlesValoracion(){
        String[] cabecera = {"Platillo","Valor 1","Valor 2", "Valor 3", "Valor 4", "Valor 5"};
        String[][] datos = new String[this.plat.getIndiceP()][6];
        for (int i=0; i < this.plat.getIndiceP();i++){
            Producto p = this.plat.getProductos()[i];
            datos[i][0]= p.getDescripcion();
            datos[i][1]= ""+p.valoracion.valor[0];
            datos[i][2]= ""+p.valoracion.valor[1];
            datos[i][3]= ""+p.valoracion.valor[2];
            datos[i][4]= ""+p.valoracion.valor[3];
            datos[i][5]= ""+p.valoracion.valor[4];
            
        }
        
        DefaultTableModel modeloTabla = new DefaultTableModel(datos,cabecera);
        this.v.tablevalor.setModel(modeloTabla);
    }
}
