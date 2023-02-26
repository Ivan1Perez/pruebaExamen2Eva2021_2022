package borrador;

import model.Carnico;
import model.Lacteo;
import model.Tipo;

import java.util.*;

public class Main {

    /*
    4. (2,5p) Crea un programa principal que:

        e. Sobrescribe los métodos necesarios para el correcto funcionamiento.
     */

    public static void main(String[] args) {
//        a. Crea una lista genérica del ejercicio anterior

        GenericList<Producto> productos = new GenericList<>();

//        b. Crea 4 productos cárnicos de cada tipo y añádelos a la lista por el principio

        borrador.Producto p1 = new borrador.Carnico("Hamburguesas La Gordura", 456465, 4.59, borrador.Tipo.Cerdo, 0.8);
        borrador.Producto p2 = new borrador.Carnico("Pechugas El Fiti", 33265, 3.29, borrador.Tipo.Pollo, 1);
        borrador.Producto p3 = new borrador.Carnico("Salchichas La Gordura", 455549, 2.50, borrador.Tipo.Cerdo, 0.6);
        borrador.Producto p4 = new borrador.Carnico("Carne de la buena", 553241, 5.15, borrador.Tipo.Ternera, 1.6);

        productos.addHead(p1);
        productos.addHead(p2);
        productos.addHead(p3);
        productos.addHead(p4);

//        c. Crea 3 lácteos y añádelos a la lista por el final

        borrador.Producto p5 = new borrador.Lacteo("Leche Entera", 11231, 1.5, 1);
        borrador.Producto p6 = new borrador.Lacteo("Leche Desnatada", 55614, 1.25, 1.5);
        borrador.Producto p7 = new borrador.Lacteo("Leche Semidesnatada", 12333, 1.40, 2);

        productos.addHead(p5);
        productos.addHead(p6);
        productos.addHead(p7);

        Map<Integer, Producto> mapa = crearMapa(productos);

        System.out.println();
        System.out.println();

        System.out.println(obtenerProdCarnicosPorPrecio(mapa));


    }

//        d. Crea un método que reciba una lista de productos y
//        devuelva un Map donde la K es el código de producto y
//        V el producto (NO SE PUEDE UTILIZAR TREEMAP)

    public static Map<Integer, Producto> crearMapa(GenericList<Producto> listaProductosInicial){
        List<Producto> listaProductosFinal = new ArrayList<>();
        GenericList<Producto> aux = listaProductosInicial;
        int size = listaProductosInicial.size();

        for(int i = 0 ; i < size ; i++){
            listaProductosFinal.add(aux.remove(0));
        }
//        System.out.println(listaProductosFinal);

        Map<Integer, Producto> mapa = new HashMap<>();

        for(Producto producto : listaProductosFinal){
            mapa.put(producto.getCodigo(), producto);
        }

        return mapa;
    }

//    A partir del Map<K,V> con la estructura del ejercicio anterior,
//    obtén una lista con los productos cárnicos ordenados por precio.

    public static List<Producto> obtenerProdCarnicosPorPrecio(Map<Integer, Producto> mapa){
        List<Producto> prodCarnicos= new ArrayList<>();

        for(Producto producto : mapa.values()){
            if(producto instanceof borrador.Carnico){
                prodCarnicos.add(producto);
            }
        }

        Collections.sort(prodCarnicos, ((o1, o2) -> Double.compare(o2.getPrecio(),o1.getPrecio())));

        return prodCarnicos;
    }

}
