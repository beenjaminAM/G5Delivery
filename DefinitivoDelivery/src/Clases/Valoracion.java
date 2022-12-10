

package Clases;


public class Valoracion {
    public int[] valor;
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
    
    public void calcularValorPuntos(int valor){
        switch(valor){
            case 1:
                this.valor[0]++;
                break;
            case 2:
                this.valor[1]++;
                break;
            case 3:
                this.valor[2]++;
                break;
            case 4:
                this.valor[3]++;
                break;
            case 5:
                this.valor[4]++;
                break;
            default:
                break;          
        }
    }
            
}
