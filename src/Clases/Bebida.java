package Clases;

import java.util.Scanner;

public class Bebida extends Perecedero{
    private String graduacion;
    private double VALOR_IVA=0.16;

    public Bebida(int codigo, String descr, double precio, int cantidad, double peso, String fecha, String graduacion) {
        super(codigo, descr, precio, cantidad, peso, fecha);
        this.graduacion = graduacion;
    }

    public Bebida(Scanner in) {
        super(in);
    }
    public String volcar(){return "";}
    public void imprimir(){}

    @Override
    public boolean envioFragil() {
        return super.envioFragil();
    }
}
