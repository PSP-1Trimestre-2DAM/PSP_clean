package ejer4_Boletin;

public class Eje4Main {

	
	/*
	 4.- Región crítica. Los métodos sincronizados en Java solo pueden tener un hilo
	ejecutándose dentro de ellos al mismo tiempo. Son necesarios cuando un
	método accede a un recurso que puede ser consumido por un único proceso.
	Para evitar que un algoritmo sea ejecutado por más de un hilo de forma
	simultánea, Java nos permite definir un método con el modificador:
	synchronized. Crear una clase HiloTarea que envie un mensaje 10 veces y entre
	mensaje y mensaje espere 3 segundos. El mensaje estará encapsulado en una
	clase Mensaje. Crear dos hilos de ejecución tal que hasta que no se envie el
	primer mensaje de uno, el otro hilo no pueda enviar otro mensaje. Haced uso de
	synchronized.
	 * */
	
	public static void main(String[] args) {
		
		Mensaje msn = new Mensaje();
		
		HiloE4 h1=new HiloE4(msn);
		HiloE4 h2=new HiloE4(msn);
		
		h1.start();
		h2.start();

	}

}
