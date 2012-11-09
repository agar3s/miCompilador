/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.sentencias;

import edu.compilador.clases.ClaseCompilador;

/**Variable.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/

/*
 * las sentencias de tipo variable, son las que se han creado por
 * el usuario, estas se detectan en un conjunto de variables que
 * deben ser guardadas en compilacion.
 * Ejemplo:	entero A2, uno, Xi;	//Variables A2, uno y Xi	//nueva Linea Declaracion
 * 			A2.Sumar(b);		//Variables A2 y b			//nueva Linea Llamado de funcion
 */
public class Variable extends Sentencia{
	
	private ClaseCompilador clase;

	//en este caso clase es el tipo de variable que se utiliza
	//el primer parametro es el nombre de dicha variable
	public Variable(String nombre, ClaseCompilador clase) {
		super(nombre);
		this.clase= clase;
	}

	public ClaseCompilador getClase() {
		return clase;
	}

	public void setClase(ClaseCompilador compilador) {
		clase = compilador;
	}

}
