package ejer6_boletin2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HiloE52 extends Thread {
	
	public static final String CYAN = "\u001b[36m";
	public static final String MAG = "\u001b[35m";
	public static final String RED = "\u001B[31m";
	
	private int[] vector;
	
	public HiloE52(int[] vector) {
		this.vector = vector;
	}
	
	
	public void run() {
		Date tiempo1 = new Date();

		long demora =0l;
		
		if(this.getName().equals("H1")) {
			
			//Hilo1 Primera Parte
			System.out.println();
			
			//Rescato el mayor de la primera Parte
			int max=this.vector[0];
			for(int i=0; i<this.vector.length/2; i++) {
				if (this.vector[i] > max)
					max=this.vector[i];
			}
			
			System.out.println(CYAN+this.getName()+" el valor mayor de la PRIMERA parte es: "+max);
			
		}else {
			
			//Hilo2 Segunda Parte
			System.out.println();
			
			//Rescato el mayor de la segunda Parte
			int max=this.vector[this.vector.length/2];
			for(int i=this.vector.length/2; i<this.vector.length; i++) {
				if (this.vector[i] > max)
					max=this.vector[i];
			}
			System.out.println(MAG+this.getName()+" el valor mayor de la SEGUNDA parte es: "+max);
		}
		
		Date tiempo2 = new Date();
		demora = tiempo2.getTime() - tiempo1.getTime();
		
		if( this.getName().equals("H1") )
			System.out.println(CYAN+"el hilo: "+this.getName()+" a demorado: "+demora+" milisegundos");
		else
			System.out.println(MAG+"el hilo: "+this.getName()+" a demorado: "+demora+" milisegundos");
		
	}
	
}
