/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.clases;


/*
 * define un objeto de tipo entero
 * Palabra reservada entero, tipo claseCompilador
 */
public class Entero extends Numerico {
	
	private int valor;

	public Entero(String nombre){
		super(nombre);
		setTipoR("entero");
	}
	//para los constantes
	public Entero(int valor){
		super(null);
		this.valor=valor;
		setTipoR("entero");
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int i) {
		valor = i;
	}

}