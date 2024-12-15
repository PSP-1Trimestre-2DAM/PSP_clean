package ejer6_boletin2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SinHilo2 {
private int[] vector;
	
	public SinHilo2(int[] vector) {
		this.vector = vector;
	}
	
	public void vector() {
		
		Date tiempo1 = new Date();
		int mayor=0;
		long demora =0l;
		
		System.out.println();
		//Rescato el mayor
		int max=this.vector[0];
		for(int i=0; i<this.vector.length; i++) {
			if (this.vector[i] > max)
				max=this.vector[i];
		}
		
		Date tiempo2 = new Date();
		demora = tiempo2.getTime() - tiempo1.getTime();
		
		System.out.println("el valor mayor de todo el Vector es: "+max);
		System.out.println("Sin Hilo a demorado: "+demora+" milisegundos");
		
	}
}
