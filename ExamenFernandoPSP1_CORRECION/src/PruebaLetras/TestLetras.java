package PruebaLetras;

import java.util.Scanner;

public class TestLetras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner tecTxt = new Scanner(System.in);
		
		String mensaje ="";
		
		mensaje = tecTxt.nextLine();
		
		char car = mensaje.toUpperCase().charAt(0);
		
		if(car >= 'A' && car <='Z' || car == 'Ñ') {
			System.out.println("el primer caracter es letra");
		}else {
			System.out.println("No es letra");
		}

	}

}
