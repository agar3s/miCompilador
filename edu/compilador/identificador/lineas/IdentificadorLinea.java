/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.lineas;

import edu.compilador.identificador.Identificador;
import edu.compilador.instrucciones.Instruccion;

/**IdentificadorLinea.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public abstract class IdentificadorLinea extends Identificador {
	private IdentificadorLinea sucesor;
	
	public IdentificadorLinea(Instruccion instruccion){
		super(instruccion);
	}
	
/*	public Linea identificarCodigo(Lista sentencias){
		
		return (((IdentificadorDeclaracion)getSucesor()).identificarCode(sentencias)) ;	
	}*/
	

	public IdentificadorLinea getSucesor() {
		return sucesor;
	}

	public void setSucesor(IdentificadorLinea linea) {
		sucesor = linea;
	}

}
