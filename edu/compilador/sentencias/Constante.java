/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.sentencias;

import edu.compilador.clases.ClaseCompilador;

/**Constantes.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/

/*
 * las sentencias de este tipo solo son valores constantes que no
 * cambian, estas sentencia pueden ser solo de los tipo basicos de
 * objetos que estan predefinidos para el compilador: enteros, reales,
 * caracteres y cadenas; el compilador debera reconocer de que tipo
 * es la constante ingresada.
 * Ejemplo: Entero x= 3*a; 	//3 constante de tipo entera
 * 			Cadena nombre= "Carlos"; //Carlos constante de tipo cadena
 */
public class Constante extends Sentencia {
	
	private ClaseCompilador valor;

	public Constante(String tipo,ClaseCompilador valor) {
		super(tipo);
		this.valor= valor;
	}

	public ClaseCompilador getValor() {
		return valor;
	}

}
