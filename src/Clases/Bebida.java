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
        System.out.println("Introduce la graduación:");
        while(true){
            try{
                graduacion = String.valueOf(in.nextInt());
                break;
            }catch(Exception e){
                System.out.println("La graduacion introducida es erronea");
                in.nextLine();
            }
        }
    }
    public String volcar(){return "";}
    public void imprimir(){
        super.imprimir();
        System.out.printf("Graduación: "+graduacion);
    }

    @Override
    public boolean envioFragil() {
        return super.envioFragil();
    }
}
