package ejercicio12_bancoUsoBloqueoObjeto;

public class BancoSinSIncronizar {

	public static void main(String[] args) {
		//Creamos el banco con 100 cu
		Banco b=new Banco();
		
		for(int i=0;i<100;i++) {
			EjecucionTransferencias r =new EjecucionTransferencias(b,i,2000.0);
	        Thread t= new Thread (r);
	        t.start();
		}

	}

}
