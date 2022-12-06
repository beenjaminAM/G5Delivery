package Clases;

/**
 *
 * @author hp
 */
public class PedidoArreglo {
    private Pedido[] pedidos;
    private int indiceP;

    public PedidoArreglo(int tam) {
        this.pedidos = new Pedido[tam];
        this.indiceP = 0;
    }
    
    public boolean agregar(Pedido p){
        boolean result = false;
        if(lleno()){
            crecer();
        }
        this.pedidos[this.indiceP] = p;
        this.indiceP++;
        result = true;
        
        return result;
    }
    
    public Pedido buscarPorNombreCliente (String  nombre){
        Pedido result = null;
        for (int i = 0; i < this.indiceP; i++) {
            if(pedidos[i].getNombreCliente().equals(nombre));
            result = pedidos[i];
        }
        return result;
    }
    
    public void crecer(){
        Pedido[] nuevo = new Pedido[this.pedidos.length*2];
        int i=0;
        for(Pedido obj: this.pedidos ){
            nuevo[i]= obj;
            i++;
        }
        this.pedidos = nuevo;
    }
    
    private  boolean vacio(){
        boolean result = false;
        
        return result;
    }
    
    private  boolean lleno(){
        boolean result = false;
        if(this.indiceP == this.pedidos.length){
            result = true;
        }
        return result;
    }

    public int getIndiceP() {
        return indiceP;
    }

    @Override
    public String toString() {
        String r = "";
        for (int i = 0; i < this.indiceP; i++) {
            r += this.pedidos[i] + "\n";
        }
        
        return r;
    }

    public Pedido[] getPedidos() {
        return pedidos;
    }
    
    
    
    
    
}
