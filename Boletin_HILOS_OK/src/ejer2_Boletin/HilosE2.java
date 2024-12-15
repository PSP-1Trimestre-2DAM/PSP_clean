package ejer2_Boletin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HilosE2 implements Runnable {

	public static final String CYAN = "\u001b[36m";
	public static final String MAG = "\u001b[35m";
	public static final String RED = "\u001B[31m";

	public int[] numeros = new int[2];

	public HilosE2(int num1, int num2) {
		this.numeros[0] = num1;
		this.numeros[1] = num2;
	}

	/*
	 * 2.- Diseñar un programa en modo consola que pida dos números naturales por
	 * teclado. Debe crear una tarea que muestre en pantalla el valor del primer
	 * número siempre y cuando sea menor que el del segundo. A posteriori incrementa
	 * ese primer número. Finaliza cuando el valor incrementado es igual al segundo
	 * número. Crea otra tarea que realice lo mismo pero que sea un Daemon de tal
	 * forma que no termine nunca de ejecutarse. (el primer número será mayor que el
	 * segundo). Mostrar en pantalla si la tarea es una aplicación o un Daemon. Y
	 * cuando finalice la tarea debe aparecer también un mensaje indicando que tarea
	 * ha terminado.
	 */

	public void tarea1(int[] numeritos) {

		if (numeritos[0] < numeritos[1]) {

			for (int i = numeritos[0]; i <= numeritos[1]; i++) {
				System.out.println(CYAN + i);
			}

		} else {
			System.out.println(RED + "El primer numero es mayor que el segundo");
		}

	}

	public void demonio(int[] numeritos) {
		System.out.println(MAG + "Demonio");
		
		// bucle infinito y le sumas 1
		int i= numeritos[1];
		while(true)
			System.out.println(MAG+i++);

	}

	@Override
	public void run() {

		String nombreHilo = Thread.currentThread().getName();
		if (nombreHilo.equals("Hilo"))
			tarea1(this.numeros);
		else
			demonio(this.numeros);
		
	}

}
