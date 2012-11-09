/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.clases;


public class Bool extends Logico {
	
	private boolean valor;

	public Bool(String nombre) {
		super(nombre);
		setTipoR("bool");
	}
	//para los constantes
	public Bool(boolean valor){
		super(null);
		this.valor=valor;
		setTipoR("bool");
	}

	public boolean getValor() {
		return valor;
	}

	public void setValor(boolean b) {
		valor = b;
	}

}