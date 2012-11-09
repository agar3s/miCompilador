/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y comentarios
 */
package edu.compilador.identificador.sentencia;

import edu.compilador.instrucciones.Instruccion;
import edu.compilador.sentencias.Operador;
import edu.compilador.sentencias.Sentencia;

/**IdentificadorOperador.java
 * @author  Agares (Giovanny Beltr�n)
 * ekeisco@gmail.com
 **/
public class IdentificadorOperador
	extends IdentificadorSentencia {
		
	public IdentificadorOperador(Instruccion instruccion){
		super(instruccion);
		setSucesor(new IdentificadorDefecto(instruccion));
	}
	
	public Sentencia identificarCode(String code){
		Sentencia sentence=null;
		if(	code.compareTo("+")==0||
			code.compareTo("-")==0||
			code.compareTo("*")==0||
			code.compareTo("/")==0||
			code.compareTo("%")==0||
			code.compareTo("=")==0||
			code.compareTo("<-")==0) 
		
			sentence= new Operador(code);
		else{
			sentence= ((IdentificadorDefecto)getSucesor()).identificarCode(code);
		}
		return sentence;
	}
}
