package ejer1Exam;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorN {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_CYAN = "\u001b[36m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	
	public static void main(String[] args) {
		ServerSocket servidor = null;

		String mensajeCli = "", mensajeServ = "";
		Scanner tecTxt = new Scanner(System.in);
		// Se abre un puente de comunicacion entre el servidor y el cliente
		Socket socket = null;

		final int PUERTO = 5000;

		DataInputStream in;
		DataOutputStream out;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println(ANSI_CYAN + "Servidor iniciado");
			/*
			 * El sevidor se mantiene a la escucha hasta que le llega a través del socket un
			 * mensaje
			 */
			socket = servidor.accept();
			System.out.println(ANSI_CYAN + "Cliente conectado");
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			
			System.out.println("* SERVIDOR*");
			Integer edad=0;
			String nombre="";
			boolean nombreOk = false;
			boolean edadOk = false;
			
			while (!mensajeCli.equals("fin")) {
				
					
					mensajeCli = in.readUTF();
					nombreOk = false;
					edadOk = false;
				
				// Si el mensaje cliente es "fin" salimos...
			    if (!mensajeCli.equals("fin")) {
			    	
			        System.out.println(ANSI_PURPLE+"Cliente: " + mensajeCli);
			        System.out.print(ANSI_CYAN + "Servidor-> ");
			        //tratamiento del mensaje
			        
			        int coma = mensajeCli.indexOf(",");
			        nombre= mensajeCli.substring(0,coma);
			        
			        // 1 comprobacion de nombre
			        char caracter1 = nombre.toUpperCase().charAt(0);
			        if(caracter1 >= 'A' && caracter1 <='Z' || caracter1 == 'Ñ') {
			        	nombreOk=true;
					}else {
						nombreOk=false;
					}
			        
			        // comprobacion del nombre
			        edad = Integer.valueOf( mensajeCli.substring(coma+1, mensajeCli.length()) );
			        
			        //String aux = edad.toString();
			        //System.out.println("edad: "+aux);
			        if (edad<18) {
			        	mensajeServ ="Necesitas tener mas de 18 años";
			        	edadOk = false;
			        }else {
			        	edadOk = true;
			        }
			        
			        if(!nombreOk && !edadOk) {
			        	mensajeServ ="El nombre tiene que comenzar por una letra \n y Necesitas tener mas de 18 años ***";
			        }else if(!nombreOk && edadOk) {
			        	mensajeServ ="El nombre tiene que comenzar por una letra";
			        }else if( nombreOk && !edadOk) {
			        	mensajeServ ="Necesitas tener mas de 18 años";
			        }else if(nombreOk && edadOk) {
			        	
			        // si todo esta bien envio mensaje correcto y guardo en fichero	
			        	mensajeServ = "recibo "+nombre+" "+edad+" DATOS CORRECTOS Guardado en Fichero";
			        	String guarda = "nombre: "+nombre+" edad "+edad+"\n";
			        	try {
			    			FileWriter fw = new FileWriter("./ejer1.txt", true);
			    			BufferedWriter bw = new BufferedWriter(fw);
			    				bw.write(guarda); //guarda
			    			bw.close(); fw.close();
			    		} catch(IOException e) {
			    			System.out.println(e.getMessage());
			    		}
			        }
			        	
			        if(!mensajeServ.equals("fin"))
			        	out.writeUTF(mensajeServ); // Enviar respuesta //CUIDADO SIN ANSIS
			    }
				
			
			}
			
			socket.close();
			System.out.println(ANSI_CYAN + "Se cierra la conexión: Servidor desconectado");
			servidor.close();
			tecTxt.close();
		
		} catch (EOFException e1) {
			System.out.println(ANSI_PURPLE+"Cierra cliente Conexión");
		} catch (Exception e1) {
			Logger.getLogger(ServidorN.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			tecTxt.close();
		}

	}
}
