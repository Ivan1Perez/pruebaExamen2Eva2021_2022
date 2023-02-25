package model;

public class Lacteo extends Producto{

    private double capacidad;

    public Lacteo(String nombre, int codigo, double precioPorKilo, double capacidad){
        super(nombre, codigo, precioPorKilo);
        this.capacidad = capacidad;
    }

    public double getCapacidad(){
        return capacidad;
    }

    @Override
    public String toString(){
        return "Nombre: " + getNombre() +
                "\nCodigo: " + getCodigo() +
                "\nPrecio por kilo: " + getPrecioPorKilo() + "€" +
                "\nCapacidad: " + capacidad + "L";
    }

    @Override
    public double getPrecio() {
        return 0;
    }
}
