package Interfaces;

public interface Enviable {
    default double getPeso(){return 0;}
    default boolean envioFragil(){return false;}
    default double tarifaEnvio(){return 0;}
}
