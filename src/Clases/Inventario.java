package Clases;

import Interfaces.Enviable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {
    private static ArrayList<Producto> ListaProductos ;
    private static String ficheroInventario;
    private static int ultimoCodigo;
    private static Path pathArchivo = Path.of("src/file/productos.txt");
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
        File archivo = null;
        try {
            archivo = new File(pathArchivo.toUri());
            FileReader fr = new FileReader(archivo);
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
    public static void guardarProductos(){
        try {
            Files.writeString(pathArchivo, "");
            ListaProductos.forEach(producto -> {
                try {
                    Files.writeString(pathArchivo, producto.volcar() + System.lineSeparator(), StandardOpenOption.APPEND);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

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
                if(!((Enviable) producto).envioFragil()){
                    System.out.printf("Id: %d, Nombre: %s, peso: %.1f, IVA (%.2f%s), tarifa de envío: %.2f, PRECIO-TOTAL: %.2f\n", producto.getCodigo(), producto.getNombre(), producto.getPeso(), producto.getIva(), new String(new char[] { 37 }), ((Enviable) producto).tarifaEnvio(), (producto.calcularPrecioIVA() + ((Enviable) producto).tarifaEnvio()));
                }else{
                    System.out.printf("Id: %d, Nombre: %s, peso: %.1f, IVA (%.2f%s), tarifa de envío: %.2f, Producto frágil, PRECIO-TOTAL: %.2f\n", producto.getCodigo(), producto.getNombre(), producto.getPeso(), producto.getIva(), new String(new char[] { 37 }), ((Enviable) producto).tarifaEnvio(), (producto.calcularPrecioIVA() + ((Enviable) producto).tarifaEnvio()));
                }

            }
        });
    }

    public static void eliminarProductos(int id){
        getInstance();
        ListaProductos.remove(id);
    }
}
