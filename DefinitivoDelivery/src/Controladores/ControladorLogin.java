package Controladores;

import AppVista.*;
import Clases.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author hp
 */
public class ControladorLogin {
    public Administrador admin;
    public LoginGeneral vistaLogin;
    public ProductoArreglo modeloProductos;
    public PedidoArreglo modeloPedidos;

    //private PrincipalMenu vistamenu;
    //ControladorMenuPrincipal menuprincip;

    public ControladorLogin(Administrador admin, ProductoArreglo modeloProductos, 
            PedidoArreglo modeloPedidos) {
        this.admin = admin;
        this.vistaLogin = new LoginGeneral();
        this.modeloPedidos = modeloPedidos;
        this.modeloProductos = modeloProductos;
        
        this.vistaLogin.jButtonLogin.addActionListener((ActionEvent e) -> {
            String userIn = vistaLogin.jTextLoginUsuario.getText();
            String userSave = admin.getNombre();
            
            String userPssIn = String.valueOf(vistaLogin.jPasswordFieldLogin.getPassword());
            String userPss = admin.getCodigo();
            
            if(userIn.equals(userSave) && userPssIn.equals(userPss) ){
                ControladorInicio controladorInicio = new ControladorInicio(modeloProductos, modeloPedidos);
                controladorInicio.iniciar();
                vistaLogin.dispose();
            }
        }); 
    }
    

    public void iniciar(){
        vistaLogin.setVisible(true);
    }
  
}