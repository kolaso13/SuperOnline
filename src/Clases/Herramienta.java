package Clases;

import Interfaces.Enviable;

import java.util.Scanner;

public class Herramienta extends NoPerecedero implements Enviable {
    private double VALOR_IVA= 0.4;

    public Herramienta(int codigo, String descr, double precio, int cantidad, double peso) {
        super(codigo, descr, precio, cantidad, peso);
    }

    public Herramienta(Scanner in) {
        super(in);
    }

    @Override
    public boolean envioFragil() {
        return Enviable.super.envioFragil();
    }
    @Override
    public double tarifaEnvio() {
        return Enviable.super.tarifaEnvio();
    }
    public String volcar(){return super.volcar();}
    public void imprimir(){super.imprimir();}
    public void imprimirEnvio(){super.imprimirEnvio();}
}
