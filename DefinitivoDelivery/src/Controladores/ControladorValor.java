/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import AppVista.ValoPlatillo;
import Clases.PedidoArreglo;
import Clases.ProductoArreglo;
import java.awt.event.ActionEvent;


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
    }
 
    public void Iniciar()
    {
    v.setVisible(true);
    
    }
    
    
}
