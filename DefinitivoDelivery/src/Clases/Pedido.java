/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author hp
 */
public class Pedido {
    private String nombreCliente;
    private ProductoArreglo productos;

    public Pedido(String cliente, int tamanio) {
        this.nombreCliente = cliente;
        this.productos = new ProductoArreglo(1);
    }

    public Pedido(String nombreCliente, ProductoArreglo productos) {
        this.nombreCliente = nombreCliente;
        this.productos = productos;
    }
    
    
    public boolean agregarPedido(Producto p){
        return this.productos.agregar(p);
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setCliente(String cliente) {
        this.nombreCliente = cliente;
    }
    
    public float calcularTotal(){
        int i;
        int suma=0;
        for (i=0;i<this.productos.getIndiceP();i++)
                {
                   suma= suma+this.productos.getProductos()[i].getCosto();
                }
        return suma;
    }

    @Override
    public String toString() {
        return "Pedido{" + "nombreCliente=" + nombreCliente + '}';
    }

    
}
