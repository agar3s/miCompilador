/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y comentarios
 */
package edu.compilador.clases;

import edu.compilador.RecursoCompilador;

/**ClaseCompilador.java
 * @author  Agares (Giovanny Beltr�n)
 * ekeisco@gmail.com
 **/
public abstract class ClaseCompilador extends RecursoCompilador{
	//para el caso variable
	private String nombre;
	
	public ClaseCompilador(String nombre){
		this.nombre= nombre;
		setTipoR("");
	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String string) {
		nombre = string;
	}


}
