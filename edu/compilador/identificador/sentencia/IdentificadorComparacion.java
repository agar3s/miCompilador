/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.sentencia;

import edu.compilador.instrucciones.Instruccion;
import edu.compilador.sentencias.Comparador;
import edu.compilador.sentencias.OperadorLogico;
import edu.compilador.sentencias.Sentencia;


public class IdentificadorComparacion
	extends IdentificadorSentencia {
		
	public IdentificadorComparacion(Instruccion instruccion){
		super(instruccion);
		setSucesor(new IdentificadorOperador(instruccion));
	}
	
	public Sentencia identificarCode(String code){
		Sentencia sentence=null;
		if(	code.compareTo("&&")==0||
			code.compareTo("||")==0||
			code.compareTo("!")==0)
			sentence= new OperadorLogico(code);
		else if(
			code.compareTo("==")==0||
			code.compareTo(">=")==0||
			code.compareTo("<=")==0||
			code.compareTo("!=")==0||
			code.compareTo(">")==0||
			code.compareTo("<")==0
			)
			sentence= new Comparador(code);
		else
		sentence= ((IdentificadorOperador)getSucesor()).identificarCode(code);
		
		return sentence;
	}
}
