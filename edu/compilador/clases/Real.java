/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.clases;

public class Real extends Numerico {

	private double valor;
	
	public Real(String nombre) {
		super(nombre);
		setTipoR("real");
	}
	//para los constantes
	public Real(double valor){
		super(null);
		this.valor=valor;
		setTipoR("real");
	}
	public double getValor() {
		return valor;
	}
	
	public void setValor(double d) {
		valor = d;
	}

}