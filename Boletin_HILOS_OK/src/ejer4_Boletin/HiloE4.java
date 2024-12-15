package ejer4_Boletin;

public class HiloE4 extends Thread {
	
	private Mensaje mensaje;
	
	public HiloE4(Mensaje mensaje) {
		this.mensaje=mensaje;
	}
	
	
	public void run() {
		String aux = "";

		for (int i = 0; i < 10; i++) {

			synchronized (this.mensaje) {
				System.out.println(this.getName() + " enterado del mensaje de: " + this.mensaje.getMensaje());
				this.mensaje.setMensaje(this.getName()+" MSG "+ i);
			}
			
			//saliendo del synchronized dentro del for
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		

	}

}
