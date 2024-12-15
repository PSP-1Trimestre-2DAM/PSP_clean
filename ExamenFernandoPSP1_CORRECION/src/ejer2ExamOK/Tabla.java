package ejer2ExamOK;

public class Tabla {
	private char[] tabla;
	private int siguiente;
	private boolean estaVacia;
	private boolean estaLlena;
	public static final String YEL = "\u001b[33m";

	public Tabla() {
		this.tabla = new char[1];
		this.siguiente = 0;
		this.estaVacia = true;
		this.estaLlena = false;
	}

	public synchronized char leeDeTabla(String nombreHilo) {
		char encuentra = ' ';

		while (this.estaVacia) {
			try {
				wait();
				System.out.println(YEL+"En espera: "+nombreHilo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		siguiente--;
		this.estaLlena = false;
		encuentra = tabla[siguiente];

		if (siguiente == 0)
			this.estaVacia = true;

		notifyAll();
		return encuentra;
	}

	public synchronized void anadirAtabla(char c, String nombreHilo) {

		while (this.estaLlena) {
			try {
				wait();
				System.out.println(YEL+"En espera: "+nombreHilo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.tabla[siguiente] = c;
		siguiente++;
		this.estaVacia = false;
		if (siguiente == this.tabla.length)
			this.estaLlena = true;

		notifyAll();

	}

	public boolean isEstaVacia() {
		return estaVacia;
	}

	public void setEstaVacia(boolean estaVacia) {
		this.estaVacia = estaVacia;
	}

	public boolean isEstaLlena() {
		return estaLlena;
	}

	public void setEstaLlena(boolean estaLlena) {
		this.estaLlena = estaLlena;
	}

	// solo para prueba
	public void muestra() {

		for (char c : this.tabla) {

			System.out.println(c);
		}
	}

}
