import Clases.Producto;

import java.util.Scanner;

public class main {
    public static void main (String[] args) {
        System.out.printf(
                "====================================================================\n" +
                        "=                    SISTEMA DE GESTIÓN DE SUPER-ON-LINE           =\n" +
                        "====================================================================\n" +
                        "\n" +
                        "====================================================================\n" +
                        "=                MENU PRINCIPAL - GESTION DE INVENTARIO            =\n" +
                        "====================================================================\n" +
                        "                tecla:1  - Cargar productos                         \n" +
                        "                tecla:2  - Mostrar inventario                       \n" +
                        "                tecla:3  - Actualizar existencias                   \n" +
                        "                tecla:4  - Añadir nuevo producto                    \n" +
                        "                tecla:5  - Mostrar productos enviables              \n" +
                        "                tecla:6  - Guardar inventario                       \n" +
                        "                tecla:0  - Terminar                                 \n" +
                        "====================================================================\n");
        System.out.println("Opción? ");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        do{

            System.out.println("Opción? ");
        }while(number!="0");

        switch (number) {
            default:
                System.out.println("Saliendo...");
                break;
            case "1":
                System.out.printf(
                        "   [[Cargando productos...]]\n" +
                                "   [[...Productos cargados en inventario!]]\n");
                System.out.println("(pulsa 0 para continuar...");
                String continuar = sc.nextLine();
                break;
            }


    }
    private void MostrarMenuInventario(){}
    private int mostrarMenuActualizarInventario(){return 0;}
    private void mostrarMenuAddNuevoProducto(){}
    private int leerOpcion(int max){return 0;}
    private Producto nuevoProducto(){return null;}
    private void pause(){}
}
