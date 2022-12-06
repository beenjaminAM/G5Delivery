package Clases;

/**
 *
 * @author hp
 */
public class ProductoArreglo {
    private Producto[] productos;
    private int indiceP;

    public ProductoArreglo(int tam) {
        this.productos = new Producto[tam];
        this.indiceP = 0;
    }
    
    public boolean agregar(Producto p){
        boolean result = false;
        if(lleno()){
            crecer();
        }
        this.productos[this.indiceP] = p;
        this.indiceP++;
        result = true;
        
        return result;
    }
    
    public Producto buscar (String  descripcion){
        Producto result = null;
        for (int i = 0; i < this.indiceP; i++) {
            if(productos[i].getDescripcion().equals(descripcion)){
                result = productos[i];
            }
            
        }
        return result;
    }
    
    public void crecer(){
        Producto[] nuevo = new Producto[this.productos.length*2];
        int i=0;
        for(Producto obj: this.productos ){
            nuevo[i]= obj;
            i++;
        }
        this.productos = nuevo;
    }
    
    private  boolean vacio(){
        boolean result = false;
        
        return result;
    }
    
    private  boolean lleno(){
        boolean result = false;
        if(this.indiceP == this.productos.length){
            result = true;
        }
        return result;
    }

    public int getIndiceP() {
        return indiceP;
    }

    public Producto[] getProductos() {
        return productos;
    }



    
    
    
    
}
