/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.sentencias;

/**Sentencia.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/

/*
 * Las sentencias son aquellas que conforman una linea de codigo
 * que son de tipo: Asignacion, Inicio de instruccion,
 * llamado de instruccion, operacion y declaracion de variables.
 * 
 * las sentencias son: operadores, palabras reservadas, nombres de 
 * funciones, nombres de variables, comparadores y separadores.
 */
public abstract class Sentencia {
	private String tipo;
	
	public Sentencia(String tipo){
		this.tipo= tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String string) {
		tipo = string;
	}

}
