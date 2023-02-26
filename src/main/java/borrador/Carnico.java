package borrador;

/*
 (2p) Crea dos clases llamadas Cárnico y Lácteo que hereden de Producto.

a. La clase Cárnico deberá tener:

i. Un atributo de tipo enum que sea: Cerdo, Ternera, Pollo y Cordero

ii. Un atributo privado llamado peso

b. La clase Lácteo deberá tener:

i. Un atributo llamado capacidad expresado en litros (1L = 1000g)

c. Crea los getters de tal manera que se pueda acceder a todos los valores del objeto.

d. Crea el/los setters necesario para modificar el precioPorKilo de cada clase.

e. Añade lo que consideres necesario.
 */

public class Carnico extends Producto{

    private Tipo tipo;
    private double peso;

    public Carnico(String nombre, int codigo, double precioPorKilo, Tipo tipo, double peso){
        super(nombre, codigo, precioPorKilo);
        this.tipo = tipo;
        this.peso = peso;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public double getPrecio(){
        return getPrecioPorKilo() * peso;
    }

    @Override
    public String toString(){
        return "Nombre: " + getNombre() +
                "\nCodigo: " + getCodigo() +
                "\nPrecio por kilo: " + getPrecioPorKilo() + "€" +
                "\nTipo: " + tipo +
                "\nPeso: " + peso + "kg\n";
    }
}
