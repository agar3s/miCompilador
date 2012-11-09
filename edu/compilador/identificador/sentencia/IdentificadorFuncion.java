/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.sentencia;

import edu.compilador.instrucciones.Instruccion;
import edu.compilador.sentencias.Sentencia;

/**IdentificadorFuncion.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class IdentificadorFuncion
	extends IdentificadorSentencia {
		
	public IdentificadorFuncion(Instruccion instruccion){
		super(instruccion);
		setSucesor(new IdentificadorSeparador(instruccion));
	}
	//identifica funciones creadas por el usuario
	public Sentencia identificarCode(String code){
		Sentencia sentence=null;
		//if()
		sentence= ((IdentificadorSeparador)getSucesor()).identificarCode(code);
		
		return sentence;
	}
}
