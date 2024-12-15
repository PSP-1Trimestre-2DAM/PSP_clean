package ejer2ExamOK;

public class Hilo2 extends Thread {

	public static final String CYAN = "\u001b[36m";
	public static final String MAG = "\u001B[35m";
	

	private Tabla tabla;

	public Hilo2(Tabla tabla) {
		this.tabla = tabla;
	}

	public void run() {
		char[] data = { 'A', 'B', 'C', 'D', 'E', 'F', 'H', 'I', 'J', 'K' };
		int ale = 0;

		try {

			while (true) {

				if (this.getName().equals("H1")) {

					ale = (int) (Math.random() * data.length);
					tabla.anadirAtabla(data[ale],this.getName());
					System.out.println(CYAN+"Insertado el caracter " + data[ale]);	
					Thread.sleep((int) (Math.random() * 4000) + 1000);
					
				}
				
				
				if (this.getName().equals("H2")) {
					char c= ' ';
					c = tabla.leeDeTabla(this.getName());
					System.out.println(MAG+"Recogido el caracter: " + c);
					Thread.sleep((int) (Math.random() * 4000) + 1000);
				}
				

			}

			// tabla.muestra();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (this.getName().equals("H1"))
			System.out.println(CYAN + "FIN DE" + this.getName());
		else if (this.getName().equals("H2"))
			System.out.println(MAG + "FIN DE" + this.getName());

	}
}
