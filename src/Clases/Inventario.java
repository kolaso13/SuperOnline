package Clases;

import java.util.ArrayList;

public class Inventario {
    private static ArrayList<Producto> ListaProductos;
    private static String ficheroInventario;
    private static int ultimoCodigo;
    private static Inventario instance;
    private Inventario(){
        ListaProductos = new ArrayList();
    }

    public static Inventario getInstance() {
        if (instance == null) {
            instance = new Inventario();
        }
        return instance;
    }

    public static void cargarProductos(){}

    public static void guardarProductos(){}

    public static void addNuevoProducto(Producto tipo){
        ListaProductos.add(tipo);
    }

    public static void mostrarProductos(){}

    public static Producto getProducto(int id){
        return ListaProductos.get(id);
    }
    public static void actualizarCantidad(int codigo, double cant){}

    public static int tamaño(){
        return ListaProductos.size();
    }

    public static void mostrarProductosEnviables(){}

    public static void eliminarProductos(int id){
        ListaProductos.remove(id);
    }
}
