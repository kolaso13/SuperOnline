package Clases;

import Interfaces.Enviable;

import java.util.Scanner;

public abstract class Perecedero extends Producto implements Enviable {
    private String fechaad;

    public Perecedero(int codigo, String descr, double precio, int cantidad, double peso, String fecha) {
        super(codigo, descr, precio, cantidad, peso);
        this.fechaad = fecha;
    }

    public Perecedero (Scanner in){super(in);}

    @Override
    public double tarifaEnvio() {
        return Enviable.super.tarifaEnvio();
    }

    public void imprimir(){}
    public String volcar(){return "";}
    public void imprimirEnvio(){}

    @Override
    public boolean envioFragil() {
        return Enviable.super.envioFragil();
    }
}
