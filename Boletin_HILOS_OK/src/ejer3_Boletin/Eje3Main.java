package ejer3_Boletin;

public class Eje3Main {

	public static void main(String[] args) {
		
		
		HiloFicheros3 t1=new HiloFicheros3();
		Thread h1=new Thread(t1);
		h1.setName("H1");
		
		HiloFicheros3 t2=new HiloFicheros3();
		Thread h2=new Thread(t2);
		h2.setName("H2");
		
		HiloFicheros3 t3=new HiloFicheros3();
		Thread h3=new Thread(t3);
		h3.setName("Demonio");
		h3.setDaemon(true);
		
		
		
		h1.start();
		try {
			h1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		h2.start();
		
		h3.start();

	}

}
