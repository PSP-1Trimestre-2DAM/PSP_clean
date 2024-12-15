package ejer6_boletin2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ejer52Main {

	public static void main(String[] args) {
		
		
		Long demora = 0l;
		
		int[] ve = new int[500000000];
		
		int ale = 0, mayor = 0;
		
		//creamos el vector
		for(int i=0; i<500000000; i++) {
			ale = (int)( Math.random()*500000000 );
			ve[i]=ale;
		}

		SinHilo2 sh= new SinHilo2(ve);
		sh.vector();
		
		
		HiloE52 h1=new HiloE52(ve);
		h1.setName("H1");
		h1.start();
		
		HiloE52 h2=new HiloE52(ve);
		h2.setName("H2");
		h2.start();
		

	}

}
