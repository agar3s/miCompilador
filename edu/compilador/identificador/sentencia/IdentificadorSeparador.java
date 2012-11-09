/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.sentencia;

import edu.compilador.instrucciones.Instruccion;
import edu.compilador.sentencias.Sentencia;
import edu.compilador.sentencias.Separador;

/**IdentificadorSeparador.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class IdentificadorSeparador
	extends IdentificadorSentencia {
		
	public IdentificadorSeparador(Instruccion instruccion){
		super(instruccion);
		setSucesor(new IdentificadorVariable(instruccion));
	}
	
	//identifica y crea la sentencia
	public Sentencia identificarCode(String code){
		Sentencia sentence=null;
		if(	code.compareTo(",")==0||
			code.compareTo(".")==0||
			code.compareTo("(")==0||
			code.compareTo(")")==0||
			code.compareTo("\"")==0){
			sentence= new Separador(code);			
		}
		else
		sentence= ((IdentificadorVariable)getSucesor()).identificarCode(code);
			
		return sentence;
	}
	
	
}
