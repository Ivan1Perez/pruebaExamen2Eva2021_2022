package model;

public class Carnico extends Producto{

    private Tipo tipo;
    private double peso;

    public Carnico(String nombre, int codigo, double precioPorKilo, Tipo tipo, double peso){
        super(nombre, codigo, precioPorKilo);
        this.tipo = tipo;
        this.peso = peso;
    }

    public Tipo getTipo(){
        return tipo;
    }

    public double getPeso(){
        return peso;
    }

    @Override
    public String toString(){
        return "Nombre: " + getNombre() +
                "\nCodigo: " + getCodigo() +
                "\nPrecio por kilo: " + getPrecioPorKilo() + "€" +
                "\nTipo: " + tipo +
                "\nPeso: " + peso + "kg";
    }

    @Override
    public double getPrecio() {
        return 0;
    }
}
