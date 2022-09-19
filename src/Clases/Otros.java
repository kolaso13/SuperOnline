package Clases;

import java.util.Scanner;

public class Otros extends NoPerecedero{
    private String categoria;
    private double VALOR_IVA = 0.16;

    public Otros(int codigo, String descr, double precio, int cantidad, double peso, String Categoria) {
        super(codigo, descr, precio, cantidad, peso);
        this.categoria = Categoria;
    }
    public void Otros(Scanner in){}
    public String volcar(){return "";}
    public void imprimir(){}
}
