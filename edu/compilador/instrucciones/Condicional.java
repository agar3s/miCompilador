/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y comentarios
 */
package edu.compilador.instrucciones;

import edu.recurso.lista.Lista;


/**Condicional.java
 * @author  Agares (Giovanny Beltr�n)
 * ekeisco@gmail.com
 **/
public class Condicional extends Instruccion {
	
	private Lista condiciones;//lista dinamica de todas las posibles
	//condiciones, cada condicion debe ir separada por operadores
	//logicos && y/o ||
	//cada condicion puede tener dentro, otra condicion.
	
	public Condicional(Instruccion antecesor, Lista lineas, String nombre) {
		super(antecesor, lineas, nombre);
	}


}
