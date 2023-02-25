package model;

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

    public String getNombre(){
        return nombre;
    }

    protected int getCodigo(){
        return codigo;
    }

    public double getPrecioPorKilo(){
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo){
        this.precioPorKilo = precioPorKilo;
    }



}
