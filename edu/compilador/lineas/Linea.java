/*
 * Creado el 11-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */

/* cada linea esta compuesta por varias sentencias. 
 * las linea pueden ser vacias, en este caso no se toman
 * en cuenta, las demas lineas deben terminar en ";", aquellas
 * que terminan en { y } se deben evaluar despues.pero los que se
 * encuentran dentro de las llaves ({}) son otras lineas de codigo
 * que tambien pueden ser de instrucción, es decir las sentencias
 * de instrucción deben estar compuestas por otras lineas, que
 * tambien pueden ser instrucciones
 */
package edu.compilador.lineas;

import edu.compilador.funciones.FuncionCompilador;
import edu.compilador.instrucciones.Instruccion;
import edu.compilador.sentencias.Sentencia;
import edu.recurso.lista.Lista;

public abstract class Linea {

	private Lista sentencias;
	private int linea;
	private String error;
	private boolean ejecutada;
	private Object siguiente;
	private FuncionCompilador consola;
	private boolean ultimaLinea;
	
	public Linea(Lista sentencias){
		this.sentencias= sentencias;
	}

	public Lista getSentencias() {
		return sentencias;
	}

	public void setSentencias(Lista vector) {
		sentencias = vector;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int i) {
		linea = i;
	}

	public String getFormaCodigo() {
		String codigo="";
		for(int i=0; i<sentencias.tamanio(); i++){
			if(sentencias.elementoEn(i) instanceof Sentencia)
				codigo= codigo+((Sentencia)sentencias.elementoEn(i)).getTipo()+" ";
			else if(sentencias.elementoEn(i) instanceof Operacion)
				codigo= codigo+"="+((Operacion)sentencias.elementoEn(i)).getFormaCodigo();
			else if(sentencias.elementoEn(i) instanceof Linea)
				codigo= codigo+((Linea)sentencias.elementoEn(i)).getFormaCodigo();

		}
		if(!(this instanceof Operacion)){
			codigo=codigo+";";
		}
		return codigo;
	}

	public String getError() {
		return error;
	}

	public void setError(String string) {
		error = string;
	}

	public abstract void ejecutar();

	public boolean isEjecutada() {
		return ejecutada;
	}

	public void setEjecutada(boolean b) {
		if(b){
			if(getSiguiente() instanceof Instruccion){
				if(ultimaLinea)
					((Instruccion)getSiguiente()).setEjecutada(true);
				else
					((Instruccion)getSiguiente()).ejecutar(); 
			} 
			else if(getSiguiente() instanceof Linea){
				if(getSiguiente() instanceof FuncionSistema)
					((FuncionSistema)getSiguiente()).setConsola(consola);
				((Linea)getSiguiente()).ejecutar(); 
			} 
			
		}
	}

	public Object getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Object object) {
		siguiente = object;
	}

	public FuncionCompilador getConsola() {
		return consola;
	}


	public void setConsola(FuncionCompilador compilador) {
		consola = compilador;
	}

	/**
	 * @return
	 */
	public boolean isUltimaLinea() {
		return ultimaLinea;
	}

	/**
	 * @param b
	 */
	public void setUltimaLinea(boolean b) {
		ultimaLinea = b;
	}

}
