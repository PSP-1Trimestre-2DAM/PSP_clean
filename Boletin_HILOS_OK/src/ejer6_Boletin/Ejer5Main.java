package ejer6_Boletin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ejer5Main {

	public static void main(String[] args) {
		
		
		Long demora = 0l;
		List<Integer> vector = new ArrayList<Integer>();
		int ale = 0, mayor = 0;
		
		//creamos el vector
		for(int i=0; i<50000000; i++) {
			ale = (int)( Math.random()*2000000000 );
			vector.add(ale);
		}
		/*		
		for(Integer num: vector) {
			System.out.print(num+", ");
		}*/
		
		SinHilo sh= new SinHilo(vector);
		sh.vector();
		
		
		HiloE5 h1=new HiloE5(vector);
		h1.setName("H1");
		h1.start();
		
		HiloE5 h2=new HiloE5(vector);
		h2.setName("H2");
		h2.start();
		

	}

}
