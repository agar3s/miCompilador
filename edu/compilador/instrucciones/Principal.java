/*
 * Creado el 24-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.instrucciones;

import edu.recurso.lista.Lista;


public class Principal extends Instruccion {

	public Principal(Instruccion antecesor, Lista lineas, String nombre) {
		super(antecesor, lineas, nombre);
	}
	public Principal(Lista lineas){
		super(null,lineas, null);
	}
	

}
