/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y comentarios
 */
package edu.compilador.instrucciones;

import edu.recurso.lista.Lista;


/**Funcion.java
 * @author  Agares (Giovanny Beltr�n)
 * ekeisco@gmail.com
 **/
public class Funcion extends Instruccion {
	
	private Object retorno;//que puede ser Clase compilador � clase usuario
	private Lista parametros;//que son sentencias tipo declaraci�n;
	//cada declaraci�n es de solo una variable, por que los parametros 
	//estan divididos por separadores tipo ',';

	public Funcion(Instruccion antecesor, Lista lineas, String nombre) {
		super(antecesor, lineas, nombre);
	}


}
