package ejer7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HiloLee extends Thread {
	
	public static final String CYAN = "\u001b[36m";
	public static final String MAG = "\u001b[35m";
	public static final String RED = "\u001B[31m";
	
	private String palabra;
	
	public HiloLee(String palabra) {
		this.palabra=palabra.trim().toLowerCase();
	}
	
	public int lecturaTexto(String palabra) {
		
		int cuenta=0;
		String linea="";
		boolean esta = false;
		
		try {
			File f1=new File("./directorio");
			File [] contenido=f1.listFiles();
			
			
		
			for(File f:contenido) {
			
				linea = "";
				esta = false;
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				
				while(br.ready()) {
					
					linea=br.readLine();
					String[]aux = linea.split(" ");
					for(int i=0; i<aux.length; i++) {
						if(aux[i].toLowerCase().equals(palabra)) 
							esta = true;
					}
				}
				if(esta) {
					cuenta++;
				}
				
				br.close(); fr.close();
			}
		
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		return cuenta;
	}
	
	
	public void run() {
		if(this.getName().equals("H1")) {
			System.out.println(CYAN+"La palabra \""+this.palabra+"\" ha aparecido en "+lecturaTexto(this.palabra)+" archivos");
			System.out.println(CYAN+"fin del hilo: "+this.getName());
		}else {
			System.out.println(MAG+"La palabra \""+this.palabra+"\" ha aparecido en "+lecturaTexto(this.palabra)+" archivos");
			System.out.println(MAG+"fin del hilo: "+this.getName());
		}
		
	}
	
}
