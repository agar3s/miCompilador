/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.sentencia;

import edu.compilador.instrucciones.Instruccion;
import edu.compilador.sentencias.Reservada;
import edu.compilador.sentencias.Sentencia;

public class IdentificadorReservada
	extends IdentificadorSentencia {
		
	public IdentificadorReservada(Instruccion instruccion){
		super(instruccion);
		setSucesor(new IdentificadorClases(instruccion));
	}
	
	public Sentencia identificarCode(String code){
		Sentencia sentence=null;
			
		if(/*code.compareTo("importar")==0||
			code.compareTo("vacia")==0||*/
			code.compareTo("falso")==0||
			code.compareTo("verdadero")==0||
		/*	code.compareTo("nuevo")==0||
			code.compareTo("retorno")==0||
		*/	code.compareTo("clase")==0||
		/*	code.compareTo("nulo")==0||*/
			code.compareTo("entero")==0||
			code.compareTo("real")==0||
			code.compareTo("cadena")==0||
		/*	code.compareTo("caracter")==0||
			code.compareTo("extiende")==0||
		*/	code.compareTo("si")==0||
			code.compareTo("sino")==0||
			code.compareTo("mq")==0||
			code.compareTo("para")==0||
		/*	code.compareTo("paquete")==0||
		*/	code.compareTo("bool")==0||
			code.compareTo("funcion")==0||
			code.compareTo("ppal")==0||
			code.compareTo("leer")==0||
			code.compareTo("escribir")==0||
			code.compareTo("escribirln")==0){
			
			sentence= new Reservada(code);
			
		}else	
			sentence= (Sentencia)((IdentificadorClases)getSucesor()).identificarCode(code);
			
		return sentence;
	}
}
