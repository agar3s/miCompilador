/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y comentarios
 */
package edu.compilador.identificador.sentencia;

import edu.compilador.instrucciones.Instruccion;
import edu.compilador.sentencias.Indeterminado;
import edu.compilador.sentencias.Sentencia;

/**IdentificadorConstante.java
 * @author  Agares (Giovanny Beltr�n)
 * ekeisco@gmail.com
 **/
public class IdentificadorDefecto
	extends IdentificadorSentencia {


	public IdentificadorDefecto(Instruccion instruccion) {
		super(instruccion);
	}
	//edu.compilador.sentencias
	public Sentencia identificarCode(String code){
		Sentencia sentence= new Indeterminado(code);
		return sentence;
	}
		
		
}
