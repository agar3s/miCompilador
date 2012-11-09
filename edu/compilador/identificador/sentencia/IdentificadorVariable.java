/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.sentencia;

import edu.compilador.instrucciones.Instruccion;
import edu.compilador.sentencias.Sentencia;

public class IdentificadorVariable
	extends IdentificadorSentencia {
		
	
	public IdentificadorVariable(Instruccion instruccion){
		super(instruccion);
		setSucesor(new IdentificadorComparacion(instruccion));
	}
	
	//identifica las variables creadas por el usuario
	public Sentencia identificarCode(String code){
		Sentencia sentence=null;
		sentence= getInstruccion().estaVariable(code);
		if(sentence==null){
			sentence= ((IdentificadorComparacion)getSucesor()).identificarCode(code);
		}	
		return sentence;
	}
}
