package Ejer4Gala;

public class HiloTarea extends Thread{
	public static final String ANSI_BLUE = "\u001B[34m";
	private Mensaje mensaje;
	
	public HiloTarea(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	
	//el synchronized se  puede poner en el bloque que queramos lo que hace es que 
	//se bloquea hasta que termine de ejecutarse
	public void run(){
		for(int i = 0; i <= 10; i++) {
			synchronized (this.mensaje) {
				System.out.println(this.getName()+ " enterado del mensaje de "+this.mensaje.getMensaje());
				this.mensaje.setMensaje(this.getName()+": MSG"+i);
			}
		}
		try {
			sleep(3000);
		} catch(InterruptedException e) { }
		if (interrupted()) {
			System.out.println("El hilo fue interrumpido");
		}
		System.out.println("Ha finalizado la creacion del:" + this.getName());
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
}
