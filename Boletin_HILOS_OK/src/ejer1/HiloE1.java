package ejer1;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class HiloE1 extends Thread {
	public static final String CYAN = "\u001b[36m";
	public static final String RED = "\u001B[31m";
	
	
	public HiloE1() {
		
	}
	
	
	public void tareaHilo1() {
		int num=0;
		
		for(int i=0; i<=20; i++) {
			num+=i;
			System.out.print(CYAN+num+",");
		}
		
	}
	
	public void tareaHilo2() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy: HH:mm:ss");
		Date fecha = new Date();
		Long fecha2 = (long) (fecha.getTime() / 1000 + 5);
		
		while(fecha.getTime()/1000 != fecha2) {
			System.out.println(RED+sdf.format(fecha));
			
			fecha = new Date(); // IMPORTANTE ACTUALIZA LA FECHA PARA SALIR DEL BUCLE
			
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public void run() {
		if(this.getName().equals("Hilo1")) {
			tareaHilo1();
			System.out.println(CYAN+"fin"+this.getName());
		}else {
			tareaHilo2();
			System.out.println(RED+"fin"+this.getName());
		}
		
	}
	
	
}
