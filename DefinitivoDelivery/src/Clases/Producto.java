package Clases;

/**
 *
 * @author hp
 */
public class Producto{
    private String descripcion;
    private String tipo;
    private int costo;

    public Producto(String descripcion, String tipo, int costo) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
 

}