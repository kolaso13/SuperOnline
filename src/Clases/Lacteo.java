package Clases;

import java.util.Scanner;

public class Lacteo extends Perecedero{
    private String lote;
    private double VALOR_IVA= 0.04;

    public Lacteo(int codigo, String descr, double precio, int cantidad, double peso, String fecha, String lote) {
        super(codigo, descr, precio, cantidad, peso, fecha);
        this.lote = lote;
    }

    public Lacteo(Scanner in) {
        super(in);
        System.out.println("Introduce el lote:");
        while(true){
            try{
                lote = String.valueOf(in.nextInt());
                break;
            }catch(Exception e){
                System.out.println("El lote introducido es erroneo");
                in.nextLine();
            }
        }
    }
    public String volcar(){return "";}

    @Override
    public boolean envioFragil() {
        return super.envioFragil();
    }
    public void imprimir(){
        super.imprimir();

        System.out.println("Lote: "+ lote);
    }
}
