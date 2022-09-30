package Clases;

import Interfaces.Enviable;
import sun.rmi.runtime.Log;

import java.io.*;
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
        getInstance();
        String [] productosEntrantes;
        try {
        FileReader fr = new FileReader("D:\\productos.txt");
        BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null){
                try {
                    productosEntrantes = linea.split(" ");
                    switch (productosEntrantes[productosEntrantes.length-1]) {
                        case "Lacteo":
                            Producto  p = new Lacteo(Integer.parseInt(productosEntrantes[0]), /*codigo*/
                                    productosEntrantes[1], /*descr*/
                                    Double.parseDouble(productosEntrantes[2]), /*precio*/
                                    Integer.parseInt(productosEntrantes[3]), /*cantidad*/
                                    Double.parseDouble(productosEntrantes[4]),/*peso*/
                                    productosEntrantes[5], /*fecha*/
                                    productosEntrantes[6]); /*lote*/

                            addNuevoProducto(p);
                            break;
                        case "FrutaHortaliza":
                            p = new FrutaHortaliza(Integer.parseInt(productosEntrantes[0]), /*codigo*/
                                    productosEntrantes[1], /*descr*/
                                    Double.parseDouble(productosEntrantes[2]), /*precio*/
                                    Integer.parseInt(productosEntrantes[3]), /*cantidad*/
                                    Double.parseDouble(productosEntrantes[4]),/*peso*/
                                    productosEntrantes[5], /*fecha*/
                                    productosEntrantes[6]); /*origen*/

                            addNuevoProducto(p);
                            break;
                        case "Bebida":
                            p = new Bebida(Integer.parseInt(productosEntrantes[0]), /*codigo*/
                                    productosEntrantes[1], /*descr*/
                                    Double.parseDouble(productosEntrantes[2]), /*precio*/
                                    Integer.parseInt(productosEntrantes[3]), /*cantidad*/
                                    Double.parseDouble(productosEntrantes[4]),/*peso*/
                                    productosEntrantes[5], /*fecha*/
                                    productosEntrantes[6]); /*graduacion*/

                            addNuevoProducto(p);
                            break;

                        case "Herramienta":
                            p = new Herramienta(Integer.parseInt(productosEntrantes[0]), /*codigo*/
                                    productosEntrantes[1], /*descr*/
                                    Double.parseDouble(productosEntrantes[2]), /*precio*/
                                    Integer.parseInt(productosEntrantes[3]), /*cantidad*/
                                    Double.parseDouble(productosEntrantes[4]));/*peso*/

                            addNuevoProducto(p);
                            break;
                        case "Otros":
                            p = new Otros(Integer.parseInt(productosEntrantes[0]), /*codigo*/
                                    productosEntrantes[1], /*descr*/
                                    Double.parseDouble(productosEntrantes[2]), /*precio*/
                                    Integer.parseInt(productosEntrantes[3]), /*cantidad*/
                                    Double.parseDouble(productosEntrantes[4]),
                                    productosEntrantes[5]);/*peso*/

                            addNuevoProducto(p);
                            break;
                    }

                }catch (Exception e){}
            }
        }catch (Exception e){}
    }
    public static void guardarProductos(){}

    public static void addNuevoProducto(Producto tipo){
        getInstance();
        ListaProductos.add(tipo);
    }

    public static void mostrarProductos(){
        getInstance();
        for(int i = 1; i <= ListaProductos.size(); i++){
            Inventario.getProducto(i).imprimir();
        }
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
