package Clases;

import java.util.Scanner;

public class FrutaHortaliza extends Perecedero{
    private String origen;
    private double VALOR_IVA = 0.16;

    public FrutaHortaliza(int codigo, String descr, double precio, int cantidad, double peso, String fecha, String origen) {
        super(codigo, descr, precio, cantidad, peso, fecha);
        this.origen = origen;
    }

    public FrutaHortaliza(Scanner in) {
        super(in);
        while(true){
            try{
                origen = String.valueOf(in.nextInt());
                break;
            }catch(Exception e){
                System.out.println("El origen introducido es erroneo");
            }
        }
    }
    public String volcar(){return "";}
    public void imprimir(){}

    @Override
    public boolean envioFragil() {
        return super.envioFragil();
    }
    public void calcularPrecioEnvio(){}
}
