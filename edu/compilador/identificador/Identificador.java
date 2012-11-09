/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y comentarios
 */
package edu.compilador.identificador;

import edu.compilador.instrucciones.Instruccion;

/**Identificador.java
 * @author  Agares (Giovanny Beltr�n)
 * ekeisco@gmail.com
 **/
public abstract class Identificador {
	
	private Instruccion instruccion;
	
	public Identificador(Instruccion instruccion){
		this.instruccion= instruccion;
	}

	public Instruccion getInstruccion() {
		return instruccion;
	}
	public void setInstruccion(Instruccion instruccion) {
		this.instruccion = instruccion;
	}
	

}
