package Clases;

import java.util.Scanner;

public abstract class Producto {
    private double iva;
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private double peso;

    public Producto (int codigo, String descr, double precio, int cantidad, double peso){
        this.codigo = codigo;
        this.nombre = descr;
        this.precio = precio;
        this.cantidad = cantidad;
        this.peso = peso;
    }

    public Producto(Scanner in){
        while(true){
            try{
                codigo = in.nextInt();
                break;
            }catch(Exception e){
                System.out.println("El codigo introducido es erroneo");
            }
        }
    }

    public Producto(){}

    public double getPeso() {return peso;}

    public double getIva() {return iva;}

    public int getCodigo() {return codigo;}

    public double getPrecio() {return precio;}

    public int getCantidad() {return cantidad;}

    public String getNombre() {return nombre;}

    public void setIva(double iva) {this.iva = iva;}

    public void setCodigo(int codigo) {this.codigo = codigo;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setPrecio(double precio) {this.precio = precio;}

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public void setPeso(double peso) {this.peso = peso;}

    public double calcularPrecioIVA(){return 0;}

    public void imprimir(){}

    public void imprimirEnvio(){
        System.out.println("Codigo: "+codigo+" Nombre: "+nombre+" Peso: "+peso+"IVA: "+iva);
    }

    public String volcar(){return "";}

}
