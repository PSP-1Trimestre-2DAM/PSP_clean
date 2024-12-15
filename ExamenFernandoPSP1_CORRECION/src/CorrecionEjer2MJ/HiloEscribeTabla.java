package CorrecionEjer2MJ;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloEscribeTabla extends Thread {
    
    private Tabla tabla;
    private final String letras = "abcdefghijklmnopqrstuvxyz";

    public HiloEscribeTabla(Tabla b){
        this.tabla = b;
    }
    
    public void run(){
        while(true){
            try {
                char c = letras.charAt((int) (Math.random() * letras.length()));
                tabla.annadirATabla(c);
                System.out.println("Insertado el caracter " + c + " de la tabla");
             
                            
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloEscribeTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
