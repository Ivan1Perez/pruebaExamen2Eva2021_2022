package borrador;

/*
 (2p) Crea una clase Producto que contenga:

a. Un atributo privado llamado nombre

b. Un atributo protegido llamado código

c. Un atributo privado llamado precioPorKilo

d. Crea un método abstracto llamado getPrecio();

e. Crea el constructor con todos los parámetros.
 */

public abstract class Producto {

    private String nombre;
    protected int codigo;
    private double precioPorKilo;

    public Producto(String nombre, int codigo, double precioPorKilo){
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioPorKilo = precioPorKilo;
    }

    public abstract double getPrecio();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }
}
