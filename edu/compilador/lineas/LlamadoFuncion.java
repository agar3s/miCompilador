/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.lineas;

import edu.recurso.lista.Lista;

/*
 * la linea de este tipo, es la que llama a una funcion, ya sea
 * de un objeto o del sistema, una linea de llamado de funcion esta
 * compuesta por las siguientes sentencias:
 * 		Variable separadorPunto nombreFuncion separadorParentesisA ParametroA separadorComa ParametroB separadorComa ... separadorComa ParametroN separadorParentesisC
 * 		para una funcion de n parametros de una variable
 * 		a.funcion(b,c,d,e)
 */
public class LlamadoFuncion extends Linea{

	public LlamadoFuncion(Lista sentencias) {
		super(sentencias);
	}

	//esta linea esta en capacidad de buscar una funcion y ejecutarla
	public void ejecutar() {
		setEjecutada(true);
	}
}
