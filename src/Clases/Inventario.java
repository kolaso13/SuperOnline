package Clases;

import Interfaces.Enviable;
import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {
    private static ArrayList<Producto> ListaProductos ;
    private static String ficheroInventario;
    private static int ultimoCodigo;
    private static Inventario instance;
    private Inventario(){
        ListaProductos = new ArrayList<Producto>();
    }

    public static Inventario getInstance() {
        if (instance == null) {
            instance = new Inventario();
        }
        return instance;
    }

    public static void cargarProductos(){
//        getInstance();
//        Producto p0 = new Herramienta(  999999,  "0",  0,  0,  0);
//        Producto p1 = new Lacteo(  1,  "Queso-Cheedar",  1.50,  14,  20 ,"21/09/2022" ,"210");
//        Producto p2 = new Lacteo(  2,  "Leche-Kaiku",  0.50,  34,  29 ,"23/09/2022" ,"111");
//        Producto p3 = new Lacteo(  3,  "Yogur-Danone ",  0.40,  10,  17,"20/09/2022" ,"421");
//        Producto p4 = new Bebida(  4,  "CocaCola",  2.50,  40,  4 ,"21/09/2022","0");
//        Producto p5 = new Bebida(  5,  "Heineken 0.0",  2.00,  40,  4 ,"21/09/2022","0");
//        Producto p6 = new Bebida(  6,  "Heineken",  2.50,  40,  4 ,"21/09/2022","4.3");
//        Producto p7 = new FrutaHortaliza(  7,  "Esparragos",  1.50,  33,  10,"21/09/2022","Peru");
//        Producto p8 = new FrutaHortaliza(  8,  "Alcachofas",  3.50,  12,  6,"21/09/2022","Tudela");
//        Producto p9 = new FrutaHortaliza(  9,  "Acelgas",  2.50,  65,  25,"21/09/2022","La Rioja");
//        Producto p10 = new Herramienta(  10,  "Martillo",  12.50,  35,  36);
//        Producto p11 = new Herramienta(  11,  "Destornillador",  10.50,  45,  15);
//        Producto p12 = new Herramienta(  12,  "Taladro",  68.00,  15,  40);
//
//        addNuevoProducto(p0);
//        addNuevoProducto(p1);
//        addNuevoProducto(p2);
//        addNuevoProducto(p3);
//        addNuevoProducto(p4);
//        addNuevoProducto(p5);
//        addNuevoProducto(p6);
//        addNuevoProducto(p7);
//        addNuevoProducto(p8);
//        addNuevoProducto(p9);
//        addNuevoProducto(p10);
//        addNuevoProducto(p11);
//        addNuevoProducto(p12);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("D:\\productos.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public static void guardarProductos(){}

    public static void addNuevoProducto(Producto tipo){
        getInstance();
        ListaProductos.add(tipo);
    }

    public static void mostrarProductos(){
        getInstance();

        ListaProductos.forEach(producto -> {
            if(producto != null){
                System.out.println("Código: "+producto.getCodigo()+", Nombre: " +producto.getNombre()+", Peso: "+ producto.getPeso()+", Precio: " +producto.getPrecio()+", Cantidad: "+producto.getCantidad());
            }
        });
    }

    public static Producto getProducto(int id){
        getInstance();
        return ListaProductos.get(id-1);
    }
    public static void actualizarCantidad(int codigo, int cant){
        getInstance();
        ListaProductos.get(codigo).setCantidad(cant);
    }

    public static int tamaño(){
        getInstance(); return ListaProductos.size();
    }

    public static void mostrarProductosEnviables(){
        getInstance();
        ListaProductos.forEach(producto -> {
            if(producto != null &&  producto instanceof Enviable){
                System.out.println("Código: "+producto.getCodigo()+", Nombre: "+producto.getNombre()+", Peso:  "+producto.getPeso()+",Precio: "+producto.getPrecio()+", Cantidad: "+producto.getCantidad());
            }
        });
    }

    public static void eliminarProductos(int id){
        getInstance();
        ListaProductos.remove(id);
    }


    public Iterator iterator() {
        return ListaProductos.iterator();
    }
}
