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
        System.out.println("Introduce el origen:");
        while(true){
            try{
                origen = String.valueOf(in.nextInt());
                break;
            }catch(Exception e){
                System.out.println("El origen introducido es erroneo");
                in.nextLine();
            }
        }
    }
    public String volcar(){return super.volcar();}
    public void imprimir(){
        super.imprimir();
        System.out.println("Origen: "+origen);
    }

    @Override
    public boolean envioFragil() {
        return super.envioFragil();
    }
    public void calcularPrecioEnvio(){
        Double precioEnvio = super.tarifaEnvio();
    }
}
