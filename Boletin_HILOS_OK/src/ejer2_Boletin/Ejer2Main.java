package ejer2_Boletin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejer2Main {
	public static final String RED = "\u001B[31m";
	public static final String CYAN = "\u001b[36m";
	
	public static int[] pideNumeros() {
		int[] numeros = new int[2];
		// boolean letras = false;
		Scanner tecInt = new Scanner(System.in);

		int cuenta = 0;
		while (cuenta < 2) {

			try {
				
				System.out.println(CYAN+"Inserta 2 números Naturales el 1ero menor y 2do mayor");				 
				numeros[cuenta] = tecInt.nextInt();
				cuenta++;
			} catch (InputMismatchException e) {
				System.out.println(RED+"Sólo Números ..... no letras");
				tecInt = new Scanner(System.in);
			}
		}

		return numeros;
	}
	
	
	public static void main(String[] args) {
		int[] numeros = new int[2];
		numeros = Ejer2Main.pideNumeros();
		
		
		HilosE2 t1=new HilosE2(numeros[0], numeros[1]);
		Thread h1=new Thread(t1);
		
		h1.setName("Hilo");
		
		HilosE2 t2=new HilosE2(numeros[0], numeros[1]);
		Thread h2=new Thread(t2);
		
		h2.setName("Demonio");
		h2.setDaemon(true);
		
		h1.start();
		h2.start();
		

	}

}
