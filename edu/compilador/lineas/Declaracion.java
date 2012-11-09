/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.lineas;

import edu.recurso.lista.Lista;

/*
 * las lineas de declaracion son aquellas en las que se declaran los
 * objetos con los que vamos a trabajar, una linea de declaracion
 * esta compuesta por las siguientes sentencias:
 * 		Clase varibleA separadorComa variableB separadorComa variableC ... separadorComa VariableN;
 *
 * No se pueden crear variables y asignarles un valor inmediatamente. 
 * */
public class Declaracion extends Linea{


	public Declaracion(Lista sentencias) {
		super(sentencias);
	}


	public void ejecutar() {
		setEjecutada(true);
	}
}
