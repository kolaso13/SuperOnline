package Clases;

import Interfaces.Enviable;

import java.util.Scanner;

public abstract class Perecedero extends Producto implements Enviable {
    private String fechaad;

    public Perecedero(int codigo, String descr, double precio, int cantidad, double peso, String fecha) {
        super(codigo, descr, precio, cantidad, peso);
        this.fechaad = fecha;
    }

    public Perecedero (Scanner in){
        super(in);
        System.out.println("Introduce la fecha de caducidad:");
        while(true){
            try{
                Scanner fecha = new Scanner(System.in);
                fechaad = fecha.nextLine();
                break;
            }catch(Exception e){
                System.out.println("La fecha introducida es erronea, introduce una valida");
                in.nextInt();
            }
        }
    }

    @Override
    public double tarifaEnvio() {
        return Enviable.super.tarifaEnvio();
    }

    public void imprimir(){
        super.imprimir();
        System.out.println("fecha de caducidad: "+ fechaad);
    }
    public String volcar(){return super.volcar();}

    public void imprimirEnvio(){
        super.imprimirEnvio();
    }

    @Override
    public boolean envioFragil() {
        return Enviable.super.envioFragil();
    }
}
