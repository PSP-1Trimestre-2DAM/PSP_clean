package CorrecionEjer2MJ;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Clase que representa una tabla de caracteres. Tiene como atributos:
 * - el array, 
 * - un índice del elemento al que se esté accediendo,
 * - y dos booleanos que rrecogen cuándo la tabla está llena o vacía
 * 
 * La clase se entrega sin terminar para que se añada lo que corresponda según el enunciado.
 * 
 * public class Tabla {

    private char[] tabla;
    private int siguiente;
    private boolean estaVacia;
    private boolean estaLlena;
    
    public Tabla(int tamanio){
        this.tabla = new char[tamanio];
        this.siguiente = 0;
        this.estaVacia = true;
        this.estaLlena = false;
    }
    
    public char leeDeTabla(){
        //si la tabla está vacía tiene que esperar para poder leer y mostrar el elemento de la tabla.
    	
        //cuando llega aquí la tabla tiene elementos
        siguiente--;
        this.estaLlena = false;
        if(siguiente == 0){
            this.estaVacia = true;
        }
        
        //devuelve el elemento de esa posición
        return this.tabla[this.siguiente];
    }
    
    public void annadirATabla(char c){
       //no se pueden añadir elementos si la tabla está llena
        
        tabla[siguiente] = c;
        siguiente++;
        this.estaVacia = false;
        if(siguiente == this.tabla.length){
            this.estaLlena = true;
        }
        
      
    }
    
}
 la tabla se lee desde el final al principio
 * 
 */
public class Tabla {

    private char[] tabla;
    private int siguiente; //es la posición del siguiente elemento a leer (puntero del array)
    private boolean estaVacia;
    private boolean estaLlena;
    
    public Tabla(int tamanio){
        this.tabla = new char[tamanio];
        this.siguiente = 0;
        this.estaVacia = true;
        this.estaLlena = false;
    }
     //devuelve el elemento de la posición que indique el atributo siguiente
    public synchronized char leeDeTabla(){
        //si la tabla está vacía tiene que esperar para poder leer y mostrar el elemento de la tabla.
    	while(this.estaVacia){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //cuando llega aquí la tabla tiene elementos
        siguiente--;
        this.estaLlena = false;
        if(siguiente == 0){
            this.estaVacia = true;
        }
        
        recorreTabla();
        
        
        notifyAll();
        //devuelve el elemento de esa posición
        return this.tabla[this.siguiente];
    }
    
    
    /*añade un valor en la posición indicada por el puntero si el array tiene caracteres y 
     * actualiza el puntero para la prçoxima inserción
     * La tabla se va llenando con caracteres y al añadir contenido en una posición de la tabla se incrementa el puntero y 
     * al leer un elemento de la tabla se decrementa el puntero de la tabla. Es decir añadir lo hace hacia la derecha y leer lo hace h
     * hacia la izquierda, en función del retardo aleatorio escribe y lee en una posición o en otra del array. */
    public synchronized void annadirATabla(char c){
        while(this.estaLlena){
            try {
                wait();
              //Hace que el subproceso actual espere hasta que otro subproceso 
			  //invoque el método  notifyAll();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        tabla[siguiente] = c;
        siguiente++;
        this.estaVacia = false;
        if(siguiente == this.tabla.length){
            this.estaLlena = true;
        }
      //de la clase Object. Despierta todos los hilos que están esperando porque la tabla estaba llena
	    notifyAll();
	    recorreTabla();
    }

	public char[] getTabla() {
		return tabla;
	}

	public void setTabla(char[] tabla) {
		this.tabla = tabla;
	}
	
	public void recorreTabla() {
		 for(int i=0;i<this.getTabla().length;i++) {
				System.out.print("elementos: "+this.getTabla()[i]+"  ");
			}
		
		
	}
    
}
