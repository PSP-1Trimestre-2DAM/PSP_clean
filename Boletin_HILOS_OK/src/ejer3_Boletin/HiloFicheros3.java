package ejer3_Boletin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HiloFicheros3 implements Runnable {
	private static final String CYAN= "\u001b[36m";
	private static final String RED= "\u001B[31m";
	private static final String MAG= "\u001b[35m";
	
	public HiloFicheros3() {
		
	}
	
	public void escribeFich(String ruta) {
		String nombreHilo = Thread.currentThread().getName();
		try {
			FileWriter fw = new FileWriter(ruta, true); // true es para apend
			BufferedWriter bw = new BufferedWriter(fw);

				for(int i=0; i<10; i++) {
					bw.write(i+""); // escribo
				}
				
			bw.close();
			fw.close();
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		switch(nombreHilo) {
			case "H1":			
				System.out.println(CYAN+"fin escritura HILO: "+ nombreHilo);
			break;
			case "H2":			
				System.out.println(MAG+"fin escritura HILO: "+ nombreHilo);
			break;
			case "Demonio":			
				System.out.println(RED+"fin escritura HILO: "+ nombreHilo);
			break;
		}
	}
	
	@Override
	public void run() {
		String rutaFichero1 = "./fichero1_EJ3.txt", 
			   rutaFichero2 = "./fichero2_EJ3.txt", 
			   rutaFichero3 = "./fichero3_EJ3.txt",
			   
			   nombreHilo = Thread.currentThread().getName();
	
		switch(nombreHilo) {
			case "H1":
				escribeFich(rutaFichero1);
				System.out.println(CYAN+"Fin del hilo H1");
			break;
			case "H2":
				escribeFich(rutaFichero2);
				System.out.println(MAG+"Fin del hilo H2");
			break;
			case "Demonio":
				escribeFich(rutaFichero3);
				System.out.println(RED+"Fin del Demonio");
			break;
		}
		
		
		
	}

}
