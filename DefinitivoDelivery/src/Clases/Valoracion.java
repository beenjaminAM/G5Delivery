

package Clases;


public class Valoracion {
    private int[] valor;
    private double[] valorPorcentaje;
    
    public Valoracion(){
        
        
        valor = new int[5];
        valorPorcentaje = new double [5];
        int i;
        for (i=0;i<5;i++){
            valor[i]=0;
        }
         for (i=0;i<5;i++){
            valorPorcentaje[i]=0;
        }   
        
    }
            
}
