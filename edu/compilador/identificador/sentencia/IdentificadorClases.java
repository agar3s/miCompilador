/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y comentarios
 */
package edu.compilador.identificador.sentencia;

import edu.compilador.instrucciones.Instruccion;
import edu.compilador.sentencias.Sentencia;

/**IdentificadorUsuario.java
 * @author  Agares (Giovanny Beltr�n)
 * ekeisco@gmail.com
 **/
public class IdentificadorClases
	extends IdentificadorSentencia {
		
	public IdentificadorClases(Instruccion instruccion){
		super(instruccion);
		setSucesor(new IdentificadorFuncion(instruccion));
	}
	//identifica clases creadas por el usuario
	public Sentencia identificarCode(String code){
		Sentencia sentence=null;
		//if()
		sentence= ((IdentificadorFuncion)getSucesor()).identificarCode(code);
		
		return sentence;
	}
}
