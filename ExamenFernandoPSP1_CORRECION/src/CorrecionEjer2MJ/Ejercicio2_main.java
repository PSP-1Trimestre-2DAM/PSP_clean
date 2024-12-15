package CorrecionEjer2MJ;



public class Ejercicio2_main {

    public static void main(String[] args) {
        Tabla t = new Tabla(1);
        HiloLeeTabla hl = new HiloLeeTabla(t);
        
        HiloEscribeTabla he = new HiloEscribeTabla(t);
        
        hl.start();
        he.start();
       
    }
}