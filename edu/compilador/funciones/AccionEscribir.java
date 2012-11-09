/*
 * Creado el 24-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.funciones;
import edu.compilador.RecursoCompilador;
import edu.compilador.clases.Cadena;
import edu.compilador.clases.ClaseCompilador;
import edu.compilador.clases.Entero;
import edu.compilador.clases.Real;

/**AccionEscribir.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class AccionEscribir extends RecursoCompilador{
	private FuncionCompilador funcion;
	private ClaseCompilador clase;
	
	public AccionEscribir(){
		setTipoR("escribir");
	}
	
	public void ejecutar(){
		if(clase instanceof Entero)
			funcion.escribir((Entero)clase);
		else if(clase instanceof Real)
			funcion.escribir((Real)clase);
		else if(clase instanceof Cadena)
			funcion.escribir((Cadena)clase);
	}
	
	/**
	 * @return
	 */
	public ClaseCompilador getClase() {
		return clase;
	}

	/**
	 * @return
	 */
	public FuncionCompilador getFuncion() {
		return funcion;
	}

	/**
	 * @param compilador
	 */
	public void setClase(ClaseCompilador compilador) {
		clase = compilador;
	}

	/**
	 * @param compilador
	 */
	public void setFuncion(FuncionCompilador compilador) {
		funcion = compilador;
	}

}
