package ejer6_Boletin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HiloE5 extends Thread {
	
	public static final String CYAN = "\u001b[36m";
	public static final String MAG = "\u001b[35m";
	public static final String RED = "\u001B[31m";
	private List<Integer>vector=new ArrayList<Integer>();
	
	public HiloE5(List<Integer>vector) {
		this.vector = vector;
	}
	
	
	public void run() {
		Date tiempo1 = new Date();
		int mayor=0;
		long demora =0l;
		List<Integer>primeraP = new ArrayList<Integer>();
		List<Integer>segundaP = new ArrayList<Integer>();
		
		for(int i=0; i<this.vector.size()/2; i++) {
			primeraP.add(this.vector.get(i));
		}
		
		for(int i=this.vector.size()/2+1; i<this.vector.size(); i++) {
			segundaP.add(this.vector.get(i));
		}
		
		if(this.getName().equals("H1")) {
			
			//Hilo1 Primera Parte
			System.out.println();
			mayor = Collections.max(primeraP); //Rescato el mayor dela primera Parte
			System.out.println(CYAN+this.getName()+" el valor mayor de la PRIMERA parte es: "+mayor);
		}else {
			
			//Hilo2 Segunda Parte
			System.out.println();
			mayor = Collections.max(segundaP); //Rescato el mayor dela primera Parte
			System.out.println(MAG+this.getName()+" el valor mayor de la SEGUNDA parte es: "+mayor);
		}
		
		Date tiempo2 = new Date();
		demora = tiempo2.getTime() - tiempo1.getTime();
		
		if( this.getName().equals("H1") )
			System.out.println(CYAN+"Con Hilo a demorado: "+demora+" milisegundos");
		else
			System.out.println(MAG+"Con Hilo a demorado: "+demora+" milisegundos");
		
	}
	
}
