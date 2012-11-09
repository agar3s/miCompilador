/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.instrucciones;

import edu.recurso.lista.Lista;


/**MientrasQue.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class MientrasQue extends Instruccion {
	
	private Lista condiciones;
	//esta instruccion se debe llamar a si misma cada vez que termina
	//si las condiciones son verdaderas;
	
	public MientrasQue(Instruccion antecesor, Lista lineas, String nombre) {
		super(antecesor, lineas, nombre);
	}

}
