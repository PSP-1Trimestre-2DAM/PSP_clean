package CorrecionEjer2MJ;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloLeeTabla extends Thread {

    private Tabla tabla;

    public HiloLeeTabla(Tabla b) {
        this.tabla = b;
    }

    public void run() {
        while (true) {
            try {
                char c = this.tabla.leeDeTabla();
                System.out.println("Recogido el caracter " + c + " de la tabla");

                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloLeeTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
