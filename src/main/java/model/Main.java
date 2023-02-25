package model;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
         Crea un programa principal que:

            a. Crea una lista genérica del ejercicio anterior

            b. Crea 4 productos cárnicos de cada tipo y añádelos a la lista por el principio

            c. Crea 3 lácteos y añádelos a la lista por el final

            d. Crea un método que reciba una lista de productos y devuelva un Map donde la K es el código de producto y V el producto (NO SE PUEDE UTILIZAR TREEMAP)

            e. Sobrescribe los métodos necesarios para el correcto funcionamiento.
         */

        GenericList<Producto> list = new GenericList<>();

        Producto p1 = new Carnico("Hamburguesas La Gordura", 456465, 4.59, Tipo.CERDO, 0.8);
        Producto p2 = new Carnico("Pechugas El Fiti", 33265, 3.29, Tipo.POLLO, 1);
        Producto p3 = new Carnico("Salchichas La Gordura", 455549, 2.50, Tipo.CERDO, 0.6);
        Producto p4 = new Carnico("Carne de la buena", 553241, 5.15, Tipo.TERNERA, 1.6);

        list.addHead(p1);
        list.addHead(p2);
        list.addHead(p3);
        list.addHead(p4);

        Producto p5 = new Lacteo("Leche Entera", 11231, 1.5, 1);
        Producto p6 = new Lacteo("Leche Desnatada", 55614, 1.25, 1.5);
        Producto p7 = new Lacteo("Leche Semidesnatada", 12333, 1.40, 2);

        list.addHead(p5);
        list.addHead(p6);
        list.addHead(p7);

        Map<Integer, Producto> mapa = crearMapa((List<Producto>) list);

    }

    //d. Crea un método que reciba una lista de productos y devuelva un Map donde la K es el código de producto y
    // V el producto (NO SE PUEDE UTILIZAR TREEMAP)

    public static Map<Integer, Producto> crearMapa(List<Producto> list){
        Map<Integer, Producto> mapaProductos = new HashMap<>();

        for(Producto producto : list){
            mapaProductos.put(producto.getCodigo(), producto);
        }

        return mapaProductos;
    }

    //    (1p) A partir del Map<K,V> con la estructura del ejercicio anterior, obtén una lista con los productos cárnicos ordenados por precio.

    public static List<Producto> prodCarnicosOrdenadosPorPrecio(Map<Integer, Producto> mapaProductos) {
        List<Producto> productosCarnicos = new ArrayList<>();

        // Recorrer todos los productos del mapa y añadir los productos cárnicos a la lista
        productosCarnicos.addAll(mapaProductos.values());

        // Ordenar la lista de productos cárnicos por precio
        Collections.sort(productosCarnicos, Comparator.comparing(Producto::getPrecio));

        return productosCarnicos;
    }



}