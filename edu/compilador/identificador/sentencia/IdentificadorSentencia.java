/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.sentencia;

import edu.compilador.identificador.Identificador;
import edu.compilador.instrucciones.Instruccion;

/**IdentificadorSentencia.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public abstract class IdentificadorSentencia extends Identificador{
	
	private IdentificadorSentencia sucesor;
	
	public IdentificadorSentencia(Instruccion instruccion){
		super(instruccion);
		//sucesor= new IdentificadorReservada(getUsuario());
	}

/*-	public Object identificarCodigo(String code) {
		return ((IdentificadorReservada)sucesor).identificarCode(code);	
	}*/

	public IdentificadorSentencia getSucesor() {
		return sucesor;
	}
	public void setSucesor(IdentificadorSentencia sentencia) {
		sucesor = sentencia;
	}

}
