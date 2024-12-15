package ejer1;

public class Ejer1Main {

	public static void main(String[] args) {
		
		
		HiloE1 h1=new HiloE1();
		h1.setName("Hilo1");
		HiloE1 h2=new HiloE1();
		h2.setName("Hilo2");
		
		h1.start();
		h2.start();

	}

}
