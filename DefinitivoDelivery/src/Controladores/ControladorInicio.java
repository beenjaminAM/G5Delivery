/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import AppVista.Inicio;
import AppVista.ValoPlatillo;
import Clases.PedidoArreglo;
import Clases.ProductoArreglo;
import java.awt.event.ActionEvent;

/**
 *
 * @author user
 */
public class ControladorInicio {
    public Inicio vistaInicio;
    public ProductoArreglo modeloProductos;
    public PedidoArreglo modeloPedidos;    
    
    //public RealizarPedido vistaRealizarPerdido

    public ControladorInicio(ProductoArreglo modeloProductos, PedidoArreglo modeloPedidos) {
        this.vistaInicio = new Inicio();
        this.modeloPedidos = modeloPedidos;
        this.modeloProductos = modeloProductos;
        
        vistaInicio.ver.addActionListener((ActionEvent ae) -> {
            ControladorVer controladorVer = new ControladorVer(modeloProductos, modeloPedidos);
            controladorVer.iniciar();
            vistaInicio.dispose();
        });
        
        vistaInicio.modificar.addActionListener((ActionEvent ae) -> {
            ControladorMod controladorMod = new ControladorMod(modeloProductos, modeloPedidos);
            controladorMod.iniciar();
            vistaInicio.dispose();            
        });
        
        vistaInicio.realizar.addActionListener((ActionEvent ae) -> {
            ControladorCarta controladorCarta = new ControladorCarta(modeloProductos, modeloPedidos);
            controladorCarta.iniciar();
            vistaInicio.dispose();            
        });
            vistaInicio.botonValor.addActionListener((ActionEvent ae) -> {
            ControladorValor controladorValor = new ControladorValor(new ValoPlatillo(), modeloProductos, modeloPedidos);
            controladorValor.Iniciar();
            vistaInicio.dispose();
        });
        
        
    }
    
    public void iniciar(){
        this.vistaInicio.setVisible(true);
    }
    
    

}
