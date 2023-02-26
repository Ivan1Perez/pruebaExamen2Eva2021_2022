package borrador;

public class Lacteo extends Producto{

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

    private double capacidad;

    public Lacteo(String nombre, int codigo, double precioPorKilo, double capacidad){
        super(nombre, codigo, precioPorKilo);
        this.capacidad = capacidad;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public double getPrecio(){
        return getPrecioPorKilo() * capacidad;
    }

    @Override
    public String toString(){
        return "Nombre: " + getNombre() +
                "\nCodigo: " + getCodigo() +
                "\nPrecio por kilo: " + getPrecioPorKilo() + "€" +
                "\nCapacidad: " + capacidad + "L\n";
    }
}




