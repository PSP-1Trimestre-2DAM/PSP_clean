package ejer6_Boletin;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SinHilo {
private List<Integer>vector=new ArrayList<Integer>();
	
	public SinHilo(List<Integer>vector) {
		this.vector = vector;
	}
	
	public int vector() {
		
		Date tiempo1 = new Date();
		int mayor=0;
		long demora =0l;
		
		System.out.println();
		mayor = Collections.max(this.vector); //Rescato el mayor
		
		Date tiempo2 = new Date();
		demora = tiempo2.getTime() - tiempo1.getTime();
		
		System.out.println("el valor mayor de todo el Vector es: "+mayor);
		System.out.println("Sin Hilo a demorado: "+demora+" milisegundos");
		
		return mayor;
	}
}
